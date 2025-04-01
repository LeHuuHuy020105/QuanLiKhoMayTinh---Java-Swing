package view.User.PhieuXuat;

import DAO.*;
import model.*;
import view.User.PhieuNhap.PhieuNhapForm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class KhoiPhucPhieuXuatForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table_ChiTietPhieuNhap;
    private PhieuXuatForm phieuXuatForm;
    private JLabel label_maPhieuNhap;
    private JLabel label_tenNguoiTaoPhieu;
    private JLabel label_vaiTroNguoiTaoPhieu;
    private JLabel label_thoiDiemTaoPhieu;
    private JLabel label_TongTien;
    private JLabel label_thoiDiemHuyPhieu;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public KhoiPhucPhieuXuatForm(PhieuXuatForm phieuXuatForm) {
        this.phieuXuatForm = phieuXuatForm;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 903, 580);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(144, 238, 144));
        panel.setBounds(0, 0, 887, 49);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("CHI TIẾT PHIẾU NHẬP");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(0, 0, 887, 49);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Mã phiếu :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(10, 94, 92, 28);
        contentPane.add(lblNewLabel_1);

        label_maPhieuNhap = new JLabel("PN40");
        label_maPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_maPhieuNhap.setBounds(112, 94, 92, 28);
        contentPane.add(label_maPhieuNhap);

        JLabel lblNewLabel_1_2 = new JLabel("Người tạo :");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_2.setBounds(10, 147, 92, 28);
        contentPane.add(lblNewLabel_1_2);

        label_tenNguoiTaoPhieu = new JLabel("Admin");
        label_tenNguoiTaoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_tenNguoiTaoPhieu.setBounds(112, 147, 186, 28);
        contentPane.add(label_tenNguoiTaoPhieu);

        JLabel lblNewLabel_1_3 = new JLabel("Vai trò");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_3.setBounds(446, 94, 92, 28);
        contentPane.add(lblNewLabel_1_3);

        label_vaiTroNguoiTaoPhieu = new JLabel("Admin");
        label_vaiTroNguoiTaoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_vaiTroNguoiTaoPhieu.setBounds(599, 94, 92, 28);
        contentPane.add(label_vaiTroNguoiTaoPhieu);

        JLabel lblNewLabel_1_3_1 = new JLabel("Thời gian tạo");
        lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_3_1.setBounds(446, 147, 121, 28);
        contentPane.add(lblNewLabel_1_3_1);

        label_thoiDiemTaoPhieu = new JLabel("Admin");
        label_thoiDiemTaoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_thoiDiemTaoPhieu.setBounds(599, 147, 278, 28);
        contentPane.add(label_thoiDiemTaoPhieu);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 238, 867, 226);
        contentPane.add(scrollPane);

        table_ChiTietPhieuNhap = new JTable();
        table_ChiTietPhieuNhap.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "STT", "Mã máy", "Tên máy", "Số lượng", "Đơn giá", "Thành tiền"
                }
        ));
        scrollPane.setViewportView(table_ChiTietPhieuNhap);

        JLabel lblNewLabel_2_1 = new JLabel("Tổng tiền :");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_1.setBounds(10, 480, 108, 41);
        contentPane.add(lblNewLabel_2_1);

        label_TongTien = new JLabel("0");
        label_TongTien.setHorizontalAlignment(SwingConstants.CENTER);
        label_TongTien.setForeground(Color.RED);
        label_TongTien.setFont(new Font("Tahoma", Font.BOLD, 18));
        label_TongTien.setBounds(132, 480, 197, 41);
        contentPane.add(label_TongTien);

        JButton btnXut = new JButton("Khôi phục");
        btnXut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KhoiPhucMouseClicked();
            }
        });
        btnXut.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\pdf.png"));
        btnXut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnXut.setBounds(738, 480, 139, 41);
        contentPane.add(btnXut);

        JLabel lblNewLabel_1_3_1_1 = new JLabel("Thời gian huỷ");
        lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_3_1_1.setBounds(10, 197, 121, 28);
        contentPane.add(lblNewLabel_1_3_1_1);

        label_thoiDiemHuyPhieu = new JLabel("null");
        label_thoiDiemHuyPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_thoiDiemHuyPhieu.setBounds(126, 197, 278, 28);
        contentPane.add(label_thoiDiemHuyPhieu);
        hienThiThongTinPhieuNhap();
    }
    public void hienThiThongTinPhieuNhap(){
        DecimalFormat df = new DecimalFormat("#,###");
        ExportProducts exportProduct_selected = phieuXuatForm.getExportProductsSelected();
        User user = UserDAO.getInstance().getUsetById(exportProduct_selected.getManguoidung());
        String tenNguoiTaoPhieu =user.getFullName();
        String role = UserDAO.getInstance().getRoleByIDUser(user.getIdUser());
        label_maPhieuNhap.setText(exportProduct_selected.getMaPhieuXuat()+"");
        label_tenNguoiTaoPhieu.setText(tenNguoiTaoPhieu);
        label_vaiTroNguoiTaoPhieu.setText(role);
        label_thoiDiemTaoPhieu.setText(exportProduct_selected.getNgayLenDonXuat()+"");
        ArrayList<DetailExportProducts>detailExportProducts = DetailExportProductsDAO.getInstance().selectAllByMaPhieuXuat(exportProduct_selected.getMaPhieuXuat());
        updateDataToTable(detailExportProducts);
    }
    public void updateDataToTable(ArrayList<DetailExportProducts>detailExportProducts){
        DecimalFormat df = new DecimalFormat("#,###");
        DefaultTableModel model = (DefaultTableModel) table_ChiTietPhieuNhap.getModel();
        model.setRowCount(0);
        int i = 0;
        for(DetailExportProducts detailExportProducts1 : detailExportProducts){
            i++;
            Computer computer = ProductsDAO.getInstance().searchByIDProduct(detailExportProducts1.getMaMay());
            double thanhTien = detailExportProducts1.getSoLuong()*computer.getGia();
            model.addRow(new Object[]{
                    i,
                    detailExportProducts1.getMaMay(),
                    computer.getTenMay(),
                    detailExportProducts1.getSoLuong(),
                    df.format(computer.getGia()),
                    df.format(thanhTien),
            });
        }
    }
    public void KhoiPhucMouseClicked(){
        ExportProducts exportProducts_selected = phieuXuatForm.getExportProductsSelected();
        ArrayList<DetailExportProducts>detailExportProducts = DetailExportProductsDAO.getInstance().selectAllByMaPhieuXuat(exportProducts_selected.getMaPhieuXuat());
        for(DetailExportProducts item : detailExportProducts){
            Computer computer = ProductsDAO.getInstance().searchByIDProduct(item.getMaMay());
            computer.setSoLuong(computer.getSoLuong()-item.getSoLuong());
            ProductsDAO.getInstance().update(computer);
        }
        exportProducts_selected.setTrangThai(1);
        exportProducts_selected.setNgayLenDonXuat(new Timestamp(System.currentTimeMillis()));
        exportProducts_selected.setThoiDiemHuyPhieu(null);
        ExportProductsDAO.getInstance().update(exportProducts_selected);
        this.dispose();
        phieuXuatForm.updateTableDataFormDAO();
    }
}
