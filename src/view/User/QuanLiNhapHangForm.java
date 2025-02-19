package view.User;

import model.User;
import view.User.NhaCungCap.NhaCungCapForm;
import view.User.NhapHang.NhapHangForm;
import view.User.PhieuNhap.PhieuNhapForm;
import view.User.PhieuXuat.PhieuXuatForm;
import view.User.QLTaiKhoan.QLTaiKhoanForm;
import view.User.SanPham.SanPhamForm;
import view.User.ThongKe.ThongKeForm;
import view.User.TonKho.TonKhoForm;
import view.User.XuatHang.XuatHangForm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLiNhapHangForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel cardPanel; // Panel chứa các màn hình khác nhau
    private CardLayout cardLayout; // CardLayout để chuyển đổi giữa các panel
    private JComponent side_Admin_NhapHang;
    private JComponent side_Admin_PhieuNhap;
    private JPanel panel_Admin_NhapHang;
    private JPanel panel_Admin_PhieuNhap;
    private Color selectionColor = new Color(245, 255, 250);
    private Color sideColor = new Color(135, 206, 250);
    private Color default_selectionColor = new Color(144, 238, 144);
    private Color default_sideColor = new Color(144, 238, 144);

    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public QuanLiNhapHangForm(User currentUser) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lí kho hàng máy tính");
        setBounds(100, 100, 1500, 950);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        SanPhamForm sanPham = new SanPhamForm();
        NhaCungCapForm nhaCungCapPanel = new NhaCungCapForm();
        PhieuNhapForm phieuNhapForm = new PhieuNhapForm();
        PhieuXuatForm phieuXuatForm = new PhieuXuatForm();
        ThongKeForm thongKeForm = new ThongKeForm();
        QLTaiKhoanForm qlTaiKhoanForm = new QLTaiKhoanForm();
        TonKhoForm tonKhoForm = new TonKhoForm();
        NhapHangForm nhapHangForm = new NhapHangForm();
        XuatHangForm xuatHangForm = new XuatHangForm();

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(239, 0, 1257, 911);
        contentPane.add(cardPanel);

        cardPanel.add(sanPham, "Sản phẩm");
        cardPanel.add(nhaCungCapPanel, "Nhà cung cấp");
        cardPanel.add(phieuNhapForm, "Phiếu nhập");
        cardPanel.add(phieuXuatForm, "Phiếu xuất");
        cardPanel.add(thongKeForm, "Thống kê");
        cardPanel.add(qlTaiKhoanForm, "Quản lí tài khoản");
        cardPanel.add(tonKhoForm, "Tồn kho");
        cardPanel.add(nhapHangForm, "Nhập hàng");
        cardPanel.add(xuatHangForm, "Xuất hàng");

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 239, 911);
        panel.setBackground(new Color(144, 238, 144));
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 228, 181));
        panel_1.setBounds(10, 91, 219, 46);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Hi Admin");
        lblNewLabel.setBounds(0, 0, 219, 46);
        panel_1.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel_Admin_NhapHang = new JPanel();
        panel_Admin_NhapHang.setLayout(null);
        panel_Admin_NhapHang.setBackground(selectionColor);
        panel_Admin_NhapHang.setBounds(0, 179, 239, 38);
        panel.add(panel_Admin_NhapHang);

        side_Admin_NhapHang = new JPanel();
        side_Admin_NhapHang.setBackground(sideColor);
        side_Admin_NhapHang.setBounds(0, 0, 10, 38);
        panel_Admin_NhapHang.add(side_Admin_NhapHang);

        JLabel lblNewLabel_2_2 = new JLabel("");
        lblNewLabel_2_2.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\nhaphang.png"));
        lblNewLabel_2_2.setBounds(20, 0, 31, 38);
        panel_Admin_NhapHang.add(lblNewLabel_2_2);

        JLabel btn_Admin_NhapHang = new JLabel("Nhập hàng");
        btn_Admin_NhapHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhapHangMouseClicked();
            }
        });
        btn_Admin_NhapHang.setIcon(null);
        btn_Admin_NhapHang.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_NhapHang.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_Admin_NhapHang.setBounds(0, 0, 239, 38);
        panel_Admin_NhapHang.add(btn_Admin_NhapHang);

        panel_Admin_PhieuNhap = new JPanel();
        panel_Admin_PhieuNhap.setLayout(null);
        panel_Admin_PhieuNhap.setBackground(new Color(144, 238, 144));
        panel_Admin_PhieuNhap.setBounds(0, 216, 239, 38);
        panel.add(panel_Admin_PhieuNhap);

        side_Admin_PhieuNhap = new JPanel();
        side_Admin_PhieuNhap.setBackground(new Color(144, 238, 144));
        side_Admin_PhieuNhap.setBounds(0, 0, 10, 38);
        panel_Admin_PhieuNhap.add(side_Admin_PhieuNhap);

        JLabel lblNewLabel_2_3 = new JLabel("");
        lblNewLabel_2_3.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\phieunhap.png"));
        lblNewLabel_2_3.setBounds(20, 0, 31, 38);
        panel_Admin_PhieuNhap.add(lblNewLabel_2_3);

        JLabel btn_Admin_PhieuNhap = new JLabel("Phiếu nhập");
        btn_Admin_PhieuNhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PhieuNhapMouseClicked();
            }
        });
        btn_Admin_PhieuNhap.setIcon(null);
        btn_Admin_PhieuNhap.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_PhieuNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_Admin_PhieuNhap.setBounds(0, 0, 239, 38);
        panel_Admin_PhieuNhap.add(btn_Admin_PhieuNhap);

        JPanel panel_Admin_ThongTinTK = new JPanel();
        panel_Admin_ThongTinTK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
            }
        });
        panel_Admin_ThongTinTK.setLayout(null);
        panel_Admin_ThongTinTK.setBackground(new Color(245, 255, 250));
        panel_Admin_ThongTinTK.setBounds(0, 798, 239, 38);
        panel_Admin_ThongTinTK.setBackground(new Color(144, 238, 144));
        panel.add(panel_Admin_ThongTinTK);

        JPanel side_Admin_SanPham_1 = new JPanel();
        side_Admin_SanPham_1.setBackground(new Color(144, 238, 144));
        side_Admin_SanPham_1.setBounds(0, 0, 10, 38);
        panel_Admin_ThongTinTK.add(side_Admin_SanPham_1);

        JLabel lblNewLabel_2_8 = new JLabel("");
        lblNewLabel_2_8.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\info.png"));
        lblNewLabel_2_8.setBounds(20, 0, 31, 38);
        panel_Admin_ThongTinTK.add(lblNewLabel_2_8);

        JLabel btn_Admin_SanPham_1 = new JLabel("Thông tin tài khoản");
        btn_Admin_SanPham_1.setIcon(null);
        btn_Admin_SanPham_1.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_SanPham_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_Admin_SanPham_1.setBounds(0, 0, 239, 38);
        panel_Admin_ThongTinTK.add(btn_Admin_SanPham_1);

        JLabel btn_Admin_Logout = new JLabel("Đăng xuất");
        btn_Admin_Logout.setIcon(null);
        btn_Admin_Logout.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_Logout.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_Admin_Logout.setBounds(0, 847, 239, 38);
        panel.add(btn_Admin_Logout);

        JLabel lblNewLabel_2_8_1 = new JLabel("");
        lblNewLabel_2_8_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\dangxuat.png"));
        lblNewLabel_2_8_1.setBounds(22, 847, 31, 38);
        panel.add(lblNewLabel_2_8_1);
    }

    public void resetMenu() {
       
        side_Admin_NhapHang.setBackground(default_sideColor);
        side_Admin_PhieuNhap.setBackground(default_sideColor);
        

      
        panel_Admin_NhapHang.setBackground(default_selectionColor);
        panel_Admin_PhieuNhap.setBackground(default_selectionColor);
        

    }

    public void NhapHangMouseClicked() {
        resetMenu();
        side_Admin_NhapHang.setBackground(sideColor);
        panel_Admin_NhapHang.setBackground(selectionColor);
        cardLayout.show(cardPanel, "Nhập hàng");
    }

    public void PhieuNhapMouseClicked() {
        resetMenu();
        side_Admin_PhieuNhap.setBackground(sideColor);
        panel_Admin_PhieuNhap.setBackground(selectionColor);
        cardLayout.show(cardPanel, "Phiếu nhập");
    }
}
