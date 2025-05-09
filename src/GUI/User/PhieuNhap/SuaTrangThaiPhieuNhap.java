package GUI.User.PhieuNhap;

import BLL.DetailImportProductsBLL;
import BLL.ImportProductsBLL;
import BLL.ProductsBLL;
import BLL.StatusDeliveryBLL;
import DTO.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;

public class SuaTrangThaiPhieuNhap extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox cbx_TrangThai;
    private PhieuNhapForm phieuNhapForm;
    private StatusDeliveryBLL statusDeliveryBLL;
    private DetailImportProductsBLL detailImportProductsBLL;
    private ProductsBLL productsBLL;
    private ImportProductsBLL importProductsBLL;

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */
    public SuaTrangThaiPhieuNhap(PhieuNhapForm phieuNhapForm) {
        this.phieuNhapForm = phieuNhapForm;
        this.statusDeliveryBLL = new StatusDeliveryBLL();
        this.importProductsBLL = new ImportProductsBLL();
        this.detailImportProductsBLL = new DetailImportProductsBLL();
        this.productsBLL = new ProductsBLL();
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

        setVisible(true);
    }
    public void fillData(){
        ImportProducts importProducts = phieuNhapForm.getImportProductsSelected();
        cbx_TrangThai.setSelectedItem(importProducts.getTrangThai());
        String [] trangThai = statusDeliveryBLL.selectChangeStatus(importProducts.getTrangThai()).toArray(new String[0]);
        cbx_TrangThai.setModel(new DefaultComboBoxModel<>(trangThai));
    }
    public void HuyBoMouseClicked() {
        this.dispose();
    }
    public void LuuMouseClicked() {
        String trangThai = cbx_TrangThai.getSelectedItem()+"";
        ImportProducts importProducts = phieuNhapForm.getImportProductsSelected();
        int idStatus = statusDeliveryBLL.selectByName(trangThai);
        importProducts.setTrangThai(idStatus);
        importProductsBLL.update(importProducts);
        HuyBoMouseClicked();
        phieuNhapForm.updateTableDataFormDAO();
        ArrayList<DetailImportProducts>detailImportProducts = detailImportProductsBLL.selectAllByMaPhieuNhap(importProducts.getMaphieunhap());
        if(trangThai.equals("Hoàn thành")){
            importProducts.setTrangThai(5);
            importProducts.setNgayNhanDon(new Timestamp(System.currentTimeMillis()));
            importProductsBLL.update(importProducts);
            updateDatabaseImportProducts(detailImportProducts);
        }
    }
    public void updateDatabaseImportProducts(ArrayList<DetailImportProducts>detailImportProducts){
        for(DetailImportProducts detailImportProducts1 : detailImportProducts){
            Computer computer = productsBLL.searchByIdProduct(detailImportProducts1.getMaMay());
            int soLuongMay = computer.getSoLuong()+detailImportProducts1.getSoluong();
            computer.setSoLuong(soLuongMay);
            productsBLL.update(computer);
        }
    }
}
