package view.User.PhieuXuat;

import DAO.DetailExportProductsDAO;
import DAO.ExportProductsDAO;
import DAO.InventoryDAO;
import DAO.StatusDeliveryDAO;
import model.DetailExportProducts;
import model.ExportProducts;
import model.Inventory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
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

        String [] trangThai = StatusDeliveryDAO.getInstance().selectAllChangeStatus().toArray(new String[0]);
        cbx_TrangThai = new JComboBox(trangThai);
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
    public void fillData(){
        ExportProducts exportProducts = phieuXuatForm.getExportProductsSelected();
        cbx_TrangThai.setSelectedItem(exportProducts.getTrangThai());
    }
    public void HuyBoMouseClicked() {
        this.dispose();
    }
    public void LuuMouseClicked() {
        String trangThai = cbx_TrangThai.getSelectedItem()+"";
        ExportProducts exportProducts = phieuXuatForm.getExportProductsSelected();
        int idStatus = StatusDeliveryDAO.getInstance().selectByName(trangThai);
        exportProducts.setTrangThai(idStatus);
        ExportProductsDAO.getInstance().update(exportProducts);
        HuyBoMouseClicked();
        phieuXuatForm.updateTableDataFormDAO();
        ArrayList<DetailExportProducts>detailExportProducts = DetailExportProductsDAO.getInstance().selectAllByMaPhieuXuat(exportProducts.getMaPhieuXuat());
        if(trangThai.equals("Hoàn thành")){
            for(DetailExportProducts item : detailExportProducts){
                Inventory inventory = new Inventory(exportProducts.getMaChiNhanh(),item.getMaMay(),item.getSoLuong());
                InventoryDAO.getInstance().insert(inventory);
            }
        }
    }
}
