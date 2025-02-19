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

public class QuanLiXuatHangForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel cardPanel; // Panel chứa các màn hình khác nhau
    private CardLayout cardLayout; // CardLayout để chuyển đổi giữa các panel
    private JPanel side_Admin_PhieuXuat;
    private JPanel panel_Admin_PhieuXuat;
    private Color selectionColor = new Color(245, 255, 250);
    private Color sideColor = new Color(135, 206, 250);
    private Color default_selectionColor = new Color(144, 238, 144);
    private Color default_sideColor = new Color(144, 238, 144);
	private JPanel panel_Admin_XuatHang;
	private JPanel side_Admin_XuatHang;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public QuanLiXuatHangForm(User currenUser) {
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

        panel_Admin_PhieuXuat = new JPanel();
        panel_Admin_PhieuXuat.setLayout(null);
        panel_Admin_PhieuXuat.setBackground(new Color(144, 238, 144));
        panel_Admin_PhieuXuat.setBounds(0, 210, 239, 38);
        panel.add(panel_Admin_PhieuXuat);

        side_Admin_PhieuXuat = new JPanel();
        side_Admin_PhieuXuat.setBackground(new Color(144, 238, 144));
        side_Admin_PhieuXuat.setBounds(0, 0, 10, 38);
        panel_Admin_PhieuXuat.add(side_Admin_PhieuXuat);

        JLabel lblNewLabel_2_4 = new JLabel("");
        lblNewLabel_2_4.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\phieuxuat.png"));
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
        
        panel_Admin_XuatHang = new JPanel();
        panel_Admin_XuatHang.setLayout(null);
        panel_Admin_XuatHang.setBackground(selectionColor);
        panel_Admin_XuatHang.setBounds(0, 173, 239, 38);
        panel.add(panel_Admin_XuatHang);
        
        side_Admin_XuatHang = new JPanel();
        side_Admin_XuatHang.setBackground(sideColor);
        side_Admin_XuatHang.setBounds(0, 0, 10, 38);
        panel_Admin_XuatHang.add(side_Admin_XuatHang);
        
        JLabel lblNewLabel_2_2_1 = new JLabel("");
        lblNewLabel_2_2_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\xuathang.png"));
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
    }

    public void resetMenu() {
       
        side_Admin_PhieuXuat.setBackground(default_sideColor);
       

       
        panel_Admin_PhieuXuat.setBackground(default_selectionColor);
        

    }

    public void PhieuXuatMouseClicked() {
        resetMenu();
        side_Admin_PhieuXuat.setBackground(sideColor);
        panel_Admin_PhieuXuat.setBackground(selectionColor);
        cardLayout.show(cardPanel, "Phiếu xuất");
    }
    public void XuatHangMouseClicked() {
    	resetMenu();
        side_Admin_XuatHang.setBackground(sideColor);
        panel_Admin_XuatHang.setBackground(selectionColor);
        cardLayout.show(cardPanel, "Xuất hàng");
	}
}
