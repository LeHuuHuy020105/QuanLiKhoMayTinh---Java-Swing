package view.User.PhieuXuat;

import DAO.*;
import model.Branch;
import model.DetailExportProducts;
import model.ExportProducts;
import model.Inventory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SuaTrangThaiPhieuXuat extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox cbx_TrangThai;
    private PhieuXuatForm phieuXuatForm;

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */
    public SuaTrangThaiPhieuXuat(PhieuXuatForm phieuXuatForm) {
        this.phieuXuatForm = phieuXuatForm;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 390, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(144, 238, 144));
        panel.setBounds(0, 0, 372, 49);
        contentPane.add(panel);

        JLabel lblSaTrngThi = new JLabel("SỬA TRẠNG THÁI");
        lblSaTrngThi.setHorizontalAlignment(SwingConstants.CENTER);
        lblSaTrngThi.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSaTrngThi.setBounds(0, 0, 372, 49);
        panel.add(lblSaTrngThi);


        cbx_TrangThai = new JComboBox();
        cbx_TrangThai.setBounds(10, 93, 354, 30);
        contentPane.add(cbx_TrangThai);

        JButton btn_Lưu = new JButton("Lưu");
        btn_Lưu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LuuMouseClicked();
            }
        });
        btn_Lưu.setIcon(null);
        btn_Lưu.setForeground(Color.WHITE);
        btn_Lưu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_Lưu.setBorderPainted(false);
        btn_Lưu.setBackground(new Color(60, 179, 113));
        btn_Lưu.setBounds(10, 165, 131, 41);
        contentPane.add(btn_Lưu);

        JButton btn_HuyBo = new JButton("Huỷ bỏ");
        btn_HuyBo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HuyBoMouseClicked();
            }
        });
        btn_HuyBo.setIcon(null);
        btn_HuyBo.setForeground(Color.WHITE);
        btn_HuyBo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_HuyBo.setBorderPainted(false);
        btn_HuyBo.setBackground(Color.RED);
        btn_HuyBo.setBounds(225, 165, 139, 41);
        contentPane.add(btn_HuyBo);
        fillData();
    }

    public void fillData() {
        ExportProducts exportProducts = phieuXuatForm.getExportProductsSelected();
        cbx_TrangThai.setSelectedItem(exportProducts.getTrangThai());
        String[] trangThai = StatusDeliveryDAO.getInstance().selectChangeStatus(exportProducts.getTrangThai()).toArray(new String[0]);
        cbx_TrangThai.setModel(new DefaultComboBoxModel<>(trangThai));
    }

    public void HuyBoMouseClicked() {
        this.dispose();
    }

    public void LuuMouseClicked() {
        String trangThai = cbx_TrangThai.getSelectedItem() + "";
        ExportProducts exportProducts = phieuXuatForm.getExportProductsSelected();
        int idStatus = StatusDeliveryDAO.getInstance().selectByName(trangThai);
        exportProducts.setTrangThai(idStatus);
        ExportProductsDAO.getInstance().update(exportProducts);
        HuyBoMouseClicked();
        phieuXuatForm.updateTableDataFormDAO();
        ArrayList<DetailExportProducts> detailExportProducts = DetailExportProductsDAO.getInstance().selectAllByMaPhieuXuat(exportProducts.getMaPhieuXuat());
        Branch branch = BrandDAO.getInstance().BranchByID(exportProducts.getMaChiNhanh());
        ArrayList<Inventory> inventories = InventoryDAO.getInstance().InventoryByBranch(branch);
        if (trangThai.equals("Hoàn thành")) {
            for (DetailExportProducts item : detailExportProducts) {
                Inventory inventory_Valid = isValidProduct(inventories, item);
                System.out.println(inventory_Valid);
                if (inventory_Valid != null) {
                    int soLuongKho = inventory_Valid.getSoLuong();
                    int soLuongNhap = item.getSoLuong();
                    inventory_Valid.setSoLuong(soLuongKho + soLuongNhap);
                    InventoryDAO.getInstance().updateSoLuong(inventory_Valid);
                } else {
                    Inventory inventory = new Inventory(exportProducts.getMaChiNhanh(), item.getMaMay(), item.getSoLuong());
                    InventoryDAO.getInstance().insert(inventory);
                }
            }
        }
    }

    public Inventory isValidProduct(ArrayList<Inventory> inventories, DetailExportProducts detailExportProducts) {
        for (Inventory inventory : inventories) {
            if (inventory.getMaMay() == detailExportProducts.getMaMay()) {
                return inventory;
            }
        }
        return null;
    }
}
