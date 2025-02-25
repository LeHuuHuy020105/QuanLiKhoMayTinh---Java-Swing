package view.User;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import model.User;
import view.Icon;
import view.User.NhaCungCap.NhaCungCapForm;
import view.User.NhapHang.NhapHangForm;
import view.User.PhieuNhap.PhieuNhapForm;
import view.User.PhieuXuat.PhieuXuatForm;
import view.User.QLTaiKhoan.QLTaiKhoanForm;
import view.User.SanPham.SanPhamForm;
import view.User.ThongKe.ThongKeForm;
import view.User.TonKho.TonKhoForm;
import view.User.XuatHang.XuatHangForm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminDashboard extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel cardPanel; // Panel chứa các màn hình khác nhau
    private CardLayout cardLayout; // CardLayout để chuyển đổi giữa các panel
    private JComponent side_Admin_SanPham;
    private JComponent side_Admin_NhaCungCap;
    private JComponent side_Admin_NhapHang;
    private JComponent side_Admin_PhieuNhap;
    private JPanel side_Admin_PhieuXuat;
    private JPanel side_Admin_TaiKhoan;
    private JPanel side_Admin_ThongKe;
    private JComponent panel_Admin_SanPham;
    private JPanel panel_Admin_NhapHang;
    private JPanel panel_Admin_PhieuNhap;
    private JPanel panel_Admin_PhieuXuat;
    private Container panel_Admin_TonKho;
    private JPanel panel_Admin_TaiKhoan;
    private JPanel panel_Admin_NhaCungCap;
    private Color selectionColor = new Color(245, 255, 250);
    private Color sideColor = new Color(135, 206, 250);
    private Color default_selectionColor = new Color(144, 238, 144);
    private Color default_sideColor = new Color(144, 238, 144);
    private Component side_Admin_TonKho;
    private JPanel panel_Admin_ThongKe;
	private JPanel panel_Admin_XuatHang;
	private JPanel side_Admin_XuatHang;
    private User currentUser;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public AdminDashboard(User currentUser) {
        this.currentUser = currentUser;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lí kho hàng máy tính");
        setBounds(100, 100, 1510, 764);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(239, 0, 1257, 911);
        contentPane.add(cardPanel);



        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 239, 764);
        panel.setBackground(new Color(144, 238, 144));
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 228, 181));
        panel_1.setBounds(10, 91, 219, 46);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel header_DashBoard = new JLabel(currentUser.getFullName());
        header_DashBoard.setBounds(0, 0, 219, 46);
        panel_1.add(header_DashBoard);
        header_DashBoard.setFont(new Font("Tahoma", Font.BOLD, 18));
        header_DashBoard.setHorizontalAlignment(SwingConstants.CENTER);

        panel_Admin_SanPham = new JPanel();
        panel_Admin_SanPham.setBackground(new Color(245, 255, 250));
        panel_Admin_SanPham.setBounds(0, 168, 239, 38);
        panel.add(panel_Admin_SanPham);
        panel_Admin_SanPham.setLayout(null);

        side_Admin_SanPham = new JPanel();
        side_Admin_SanPham.setBackground(new Color(135, 206, 250));
        side_Admin_SanPham.setBounds(0, 0, 10, 38);
        panel_Admin_SanPham.add(side_Admin_SanPham);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Icon.product_dark));
        lblNewLabel_2.setBounds(20, 0, 31, 38);
        panel_Admin_SanPham.add(lblNewLabel_2);

        JLabel btn_Admin_SanPham = new JLabel("Sản Phẩm");
        btn_Admin_SanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                SanPhamMouseClicked();
            }
        });
        btn_Admin_SanPham.setBounds(0, 0, 239, 38);
        panel_Admin_SanPham.add(btn_Admin_SanPham);
        btn_Admin_SanPham.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_SanPham.setIcon(null);
        btn_Admin_SanPham.setFont(new Font("Tahoma", Font.BOLD, 14));

        panel_Admin_NhaCungCap = new JPanel();
        panel_Admin_NhaCungCap.setLayout(null);
        panel_Admin_NhaCungCap.setBackground(new Color(144, 238, 144));
        panel_Admin_NhaCungCap.setBounds(0, 206, 239, 38);
        panel.add(panel_Admin_NhaCungCap);

        side_Admin_NhaCungCap = new JPanel();
        side_Admin_NhaCungCap.setBackground(new Color(144, 238, 144));
        side_Admin_NhaCungCap.setBounds(0, 0, 10, 38);
        panel_Admin_NhaCungCap.add(side_Admin_NhaCungCap);

        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon(Icon.nhacungcap));
        lblNewLabel_2_1.setBounds(20, 0, 31, 38);
        panel_Admin_NhaCungCap.add(lblNewLabel_2_1);

        JLabel btn_Admin_NhaCungCap = new JLabel("Nhà cung cấp");
        btn_Admin_NhaCungCap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhaCungCapMouseClicked();
            }
        });
        btn_Admin_NhaCungCap.setIcon(null);
        btn_Admin_NhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_NhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_Admin_NhaCungCap.setBounds(0, 0, 239, 38);
        panel_Admin_NhaCungCap.add(btn_Admin_NhaCungCap);

        panel_Admin_NhapHang = new JPanel();
        panel_Admin_NhapHang.setLayout(null);
        panel_Admin_NhapHang.setBackground(new Color(144, 238, 144));
        panel_Admin_NhapHang.setBounds(0, 244, 239, 38);
        panel.add(panel_Admin_NhapHang);

        side_Admin_NhapHang = new JPanel();
        side_Admin_NhapHang.setBackground(new Color(144, 238, 144));
        side_Admin_NhapHang.setBounds(0, 0, 10, 38);
        panel_Admin_NhapHang.add(side_Admin_NhapHang);

        JLabel lblNewLabel_2_2 = new JLabel("");
        lblNewLabel_2_2.setIcon(new ImageIcon(Icon.nhaphang));
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
        panel_Admin_PhieuNhap.setBounds(0, 282, 239, 38);
        panel.add(panel_Admin_PhieuNhap);

        side_Admin_PhieuNhap = new JPanel();
        side_Admin_PhieuNhap.setBackground(new Color(144, 238, 144));
        side_Admin_PhieuNhap.setBounds(0, 0, 10, 38);
        panel_Admin_PhieuNhap.add(side_Admin_PhieuNhap);

        JLabel lblNewLabel_2_3 = new JLabel("");
        lblNewLabel_2_3.setIcon(new ImageIcon(Icon.phieunhap));
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

        panel_Admin_PhieuXuat = new JPanel();
        panel_Admin_PhieuXuat.setLayout(null);
        panel_Admin_PhieuXuat.setBackground(new Color(144, 238, 144));
        panel_Admin_PhieuXuat.setBounds(0, 357, 239, 38);
        panel.add(panel_Admin_PhieuXuat);

        side_Admin_PhieuXuat = new JPanel();
        side_Admin_PhieuXuat.setBackground(new Color(144, 238, 144));
        side_Admin_PhieuXuat.setBounds(0, 0, 10, 38);
        panel_Admin_PhieuXuat.add(side_Admin_PhieuXuat);

        JLabel lblNewLabel_2_4 = new JLabel("");
        lblNewLabel_2_4.setIcon(new ImageIcon(Icon.phieuxuat));
        lblNewLabel_2_4.setBounds(20, 0, 31, 38);
        panel_Admin_PhieuXuat.add(lblNewLabel_2_4);

        JLabel btn_Admin_PhieuXuat = new JLabel("Phiếu xuất");
        btn_Admin_PhieuXuat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PhieuXuatMouseClicked();
            }
        });
        btn_Admin_PhieuXuat.setIcon(null);
        btn_Admin_PhieuXuat.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_PhieuXuat.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_Admin_PhieuXuat.setBounds(0, 0, 239, 38);
        panel_Admin_PhieuXuat.add(btn_Admin_PhieuXuat);

        panel_Admin_TonKho = new JPanel();
        panel_Admin_TonKho.setLayout(null);
        panel_Admin_TonKho.setBackground(new Color(144, 238, 144));
        panel_Admin_TonKho.setBounds(0, 394, 239, 38);
        panel.add(panel_Admin_TonKho);

        side_Admin_TonKho = new JPanel();
        side_Admin_TonKho.setBackground(new Color(144, 238, 144));
        side_Admin_TonKho.setBounds(0, 0, 10, 38);
        panel_Admin_TonKho.add(side_Admin_TonKho);

        JLabel lblNewLabel_2_5 = new JLabel("");
        lblNewLabel_2_5.setIcon(new ImageIcon(Icon.tonkho));
        lblNewLabel_2_5.setBounds(20, 0, 31, 38);
        panel_Admin_TonKho.add(lblNewLabel_2_5);

        JLabel btn_Admin_TonKho = new JLabel("Tồn kho");
        btn_Admin_TonKho.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TonKhoMouseClicked();
            }
        });
        btn_Admin_TonKho.setBounds(0, 0, 239, 38);
        panel_Admin_TonKho.add(btn_Admin_TonKho);
        btn_Admin_TonKho.setIcon(null);
        btn_Admin_TonKho.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_TonKho.setFont(new Font("Tahoma", Font.BOLD, 14));

        panel_Admin_TaiKhoan = new JPanel();
        panel_Admin_TaiKhoan.setLayout(null);
        panel_Admin_TaiKhoan.setBackground(new Color(144, 238, 144));
        panel_Admin_TaiKhoan.setBounds(0, 432, 239, 38);
        panel.add(panel_Admin_TaiKhoan);

        side_Admin_TaiKhoan = new JPanel();
        side_Admin_TaiKhoan.setBackground(new Color(144, 238, 144));
        side_Admin_TaiKhoan.setBounds(0, 0, 10, 38);
        panel_Admin_TaiKhoan.add(side_Admin_TaiKhoan);

        JLabel lblNewLabel_2_6 = new JLabel("");
        lblNewLabel_2_6.setIcon(new ImageIcon(Icon.userdark));
        lblNewLabel_2_6.setBounds(20, 0, 31, 38);
        panel_Admin_TaiKhoan.add(lblNewLabel_2_6);

        JLabel btn_Admin_TaiKhoan = new JLabel("Tài khoản");
        btn_Admin_TaiKhoan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TaiKhoanMouseClicked();
            }
        });
        btn_Admin_TaiKhoan.setBounds(0, 0, 239, 38);
        panel_Admin_TaiKhoan.add(btn_Admin_TaiKhoan);
        btn_Admin_TaiKhoan.setIcon(null);
        btn_Admin_TaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_TaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));

        panel_Admin_ThongKe = new JPanel();
        panel_Admin_ThongKe.setLayout(null);
        panel_Admin_ThongKe.setBackground(new Color(144, 238, 144));
        panel_Admin_ThongKe.setBounds(0, 470, 239, 38);
        panel.add(panel_Admin_ThongKe);

        side_Admin_ThongKe = new JPanel();
        side_Admin_ThongKe.setBackground(new Color(144, 238, 144));
        side_Admin_ThongKe.setBounds(0, 0, 10, 38);
        panel_Admin_ThongKe.add(side_Admin_ThongKe);

        JLabel lblNewLabel_2_7 = new JLabel("");
        lblNewLabel_2_7.setIcon(new ImageIcon(Icon.statistical_dark));
        lblNewLabel_2_7.setBounds(20, 0, 31, 38);
        panel_Admin_ThongKe.add(lblNewLabel_2_7);

        JLabel btn_Admin_ThongKe = new JLabel("Thống kê");
        btn_Admin_ThongKe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThongKeMouseClicked();
            }
        });
        btn_Admin_ThongKe.setBounds(0, 0, 239, 38);
        panel_Admin_ThongKe.add(btn_Admin_ThongKe);
        btn_Admin_ThongKe.setIcon(null);
        btn_Admin_ThongKe.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_ThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_2_8_1 = new JLabel("");
        lblNewLabel_2_8_1.setIcon(new ImageIcon(Icon.dangxuat));
        lblNewLabel_2_8_1.setBounds(22, 847, 31, 38);
        panel.add(lblNewLabel_2_8_1);
        
        panel_Admin_XuatHang = new JPanel();
        panel_Admin_XuatHang.setLayout(null);
        panel_Admin_XuatHang.setBackground(new Color(144, 238, 144));
        panel_Admin_XuatHang.setBounds(0, 319, 239, 38);
        panel.add(panel_Admin_XuatHang);
        
        side_Admin_XuatHang = new JPanel();
        side_Admin_XuatHang.setBackground(new Color(144, 238, 144));
        side_Admin_XuatHang.setBounds(0, 0, 10, 38);
        panel_Admin_XuatHang.add(side_Admin_XuatHang);
        
        JLabel lblNewLabel_2_2_1 = new JLabel("");
        lblNewLabel_2_2_1.setIcon(new ImageIcon(Icon.xuathang));
        lblNewLabel_2_2_1.setBounds(20, 0, 31, 38);
        panel_Admin_XuatHang.add(lblNewLabel_2_2_1);
        
        JLabel btn_Admin_XuatHang = new JLabel("Xuất hàng");
        btn_Admin_XuatHang.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		XuatHangMouseClicked();
        	}
        });
        btn_Admin_XuatHang.setIcon(null);
        btn_Admin_XuatHang.setHorizontalAlignment(SwingConstants.CENTER);
        btn_Admin_XuatHang.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_Admin_XuatHang.setBounds(0, 0, 239, 38);
        panel_Admin_XuatHang.add(btn_Admin_XuatHang);
        
        JPanel panel_Admin_ThongTinTK = new JPanel();
        panel_Admin_ThongTinTK.setLayout(null);
        panel_Admin_ThongTinTK.setBackground(new Color(245, 255, 250));
        panel_Admin_ThongTinTK.setBounds(0, 635, 239, 38);
        panel.add(panel_Admin_ThongTinTK);
        
        JPanel side_Admin_SanPham_1 = new JPanel();
        side_Admin_SanPham_1.setBackground(new Color(144, 238, 144));
        side_Admin_SanPham_1.setBounds(0, 0, 10, 38);
        panel_Admin_ThongTinTK.add(side_Admin_SanPham_1);
        
        JLabel lblNewLabel_2_8 = new JLabel("");
        lblNewLabel_2_8.setIcon(new ImageIcon(Icon.info));
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
        btn_Admin_Logout.setBounds(0, 672, 239, 38);
        panel.add(btn_Admin_Logout);
        
        JLabel lblNewLabel_2_7_1 = new JLabel("");
        lblNewLabel_2_7_1.setIcon(new ImageIcon(Icon.dangxuat));
        lblNewLabel_2_7_1.setBounds(22, 672, 31, 38);
        panel.add(lblNewLabel_2_7_1);

        SanPhamMouseClicked();
    }

    public void resetMenu() {
        side_Admin_SanPham.setBackground(default_sideColor);
        side_Admin_NhaCungCap.setBackground(default_sideColor);
        side_Admin_NhapHang.setBackground(default_sideColor);
        side_Admin_PhieuNhap.setBackground(default_sideColor);
        side_Admin_ThongKe.setBackground(default_sideColor);
        side_Admin_TaiKhoan.setBackground(default_sideColor);
        side_Admin_PhieuXuat.setBackground(default_sideColor);
        side_Admin_TonKho.setBackground(default_sideColor);
        side_Admin_XuatHang.setBackground(default_sideColor);

        panel_Admin_SanPham.setBackground(default_selectionColor);
        panel_Admin_NhaCungCap.setBackground(default_selectionColor);
        panel_Admin_NhapHang.setBackground(default_selectionColor);
        panel_Admin_PhieuNhap.setBackground(default_selectionColor);
        panel_Admin_ThongKe.setBackground(default_selectionColor);
        panel_Admin_TaiKhoan.setBackground(default_selectionColor);
        panel_Admin_PhieuXuat.setBackground(default_selectionColor);
        panel_Admin_TonKho.setBackground(default_selectionColor);
        panel_Admin_XuatHang.setBackground(default_selectionColor);

    }

    public void NhaCungCapMouseClicked() {
        resetMenu();
        side_Admin_NhaCungCap.setBackground(sideColor);
        panel_Admin_NhaCungCap.setBackground(selectionColor);
        NhaCungCapForm nhaCungCapPanel = new NhaCungCapForm();
        cardPanel.add(nhaCungCapPanel, "Nhà cung cấp");
        cardLayout.show(cardPanel, "Nhà cung cấp");
    }

    public void SanPhamMouseClicked() {
        resetMenu();
        side_Admin_SanPham.setBackground(sideColor);
        panel_Admin_SanPham.setBackground(selectionColor);
        SanPhamForm sanPham = new SanPhamForm();
        cardPanel.add(sanPham, "Sản phẩm");
        cardLayout.show(cardPanel, "Sản phẩm");
    }

    public void NhapHangMouseClicked() {
        resetMenu();
        side_Admin_NhapHang.setBackground(sideColor);
        panel_Admin_NhapHang.setBackground(selectionColor);
        NhapHangForm nhapHangForm = new NhapHangForm(currentUser);
        cardPanel.add(nhapHangForm, "Nhập hàng");
        cardLayout.show(cardPanel, "Nhập hàng");
    }

    public void PhieuNhapMouseClicked() {
        resetMenu();
        side_Admin_PhieuNhap.setBackground(sideColor);
        panel_Admin_PhieuNhap.setBackground(selectionColor);
        PhieuNhapForm phieuNhapForm = new PhieuNhapForm();
        cardPanel.add(phieuNhapForm, "Phiếu nhập");
        cardLayout.show(cardPanel, "Phiếu nhập");
    }

    public void PhieuXuatMouseClicked() {
        resetMenu();
        side_Admin_PhieuXuat.setBackground(sideColor);
        panel_Admin_PhieuXuat.setBackground(selectionColor);
        PhieuXuatForm phieuXuatForm = new PhieuXuatForm();
        cardPanel.add(phieuXuatForm, "Phiếu xuất");
        cardLayout.show(cardPanel, "Phiếu xuất");
    }

    public void TonKhoMouseClicked() {
        resetMenu();
        side_Admin_TonKho.setBackground(sideColor);
        panel_Admin_TonKho.setBackground(selectionColor);
        TonKhoForm tonKhoForm = new TonKhoForm();
        cardPanel.add(tonKhoForm, "Tồn kho");
        cardLayout.show(cardPanel, "Tồn kho");
    }

    public void TaiKhoanMouseClicked() {
        resetMenu();
        side_Admin_TaiKhoan.setBackground(sideColor);
        panel_Admin_TaiKhoan.setBackground(selectionColor);
        QLTaiKhoanForm qlTaiKhoanForm = new QLTaiKhoanForm();
        cardPanel.add(qlTaiKhoanForm, "Quản lí tài khoản");
        cardLayout.show(cardPanel, "Quản lí tài khoản");
    }

    public void ThongKeMouseClicked() {
        resetMenu();
        side_Admin_ThongKe.setBackground(sideColor);
        panel_Admin_ThongKe.setBackground(selectionColor);
        ThongKeForm thongKeForm = new ThongKeForm();
        cardPanel.add(thongKeForm, "Thống kê");
        cardLayout.show(cardPanel, "Thống kê");
    }
    public void XuatHangMouseClicked() {
    	resetMenu();
        side_Admin_XuatHang.setBackground(sideColor);
        panel_Admin_XuatHang.setBackground(selectionColor);
        XuatHangForm xuatHangForm = new XuatHangForm();
        cardPanel.add(xuatHangForm, "Xuất hàng");
        cardLayout.show(cardPanel, "Xuất hàng");
	}
}
