package view.User;

import DAO.UserDAO;
import model.User;
import view.User.ChiNhanh.ChiNhanhForm;
import view.User.NhaCungCap.NhaCungCapForm;
import view.User.NhanVien.BanHang;
import view.User.NhapHang.NhapHangForm;
import view.User.PhieuNhap.PhieuNhapForm;
import view.User.PhieuXuat.PhieuXuatForm;
import view.User.QLTaiKhoanAdmin.QLTaiKhoanForm;
import view.User.QuanLiChiNhanh.NhapHangBranchForm;
import view.User.QuanLiChiNhanh.PhieuNhapBranchForm;
import view.User.SanPham.SanPhamForm;
import view.User.ThongKe.ThongKeForm;
import view.User.TonKho.TonKhoForm;
import view.User.XuatHang.XuatHangForm;
import view.login.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Dashboard extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel firstPanel;
    private JPanel firstSidePanel;
    private JPanel panel_2;
    private JPanel contentPane;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private User currentUser;


    private Color selectionColor = new Color(245, 255, 250);
    private Color sideColor = new Color(135, 206, 250);
    private Color default_selectionColor = new Color(144, 238, 144);
    private Color default_sideColor = new Color(144, 238, 144);

    public Dashboard(User currentUser) {
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
        panel.setBackground(default_selectionColor);
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

        panel_2 = new JPanel();
        panel_2.setBounds(10, 162, 219, 465);
        panel.add(panel_2);
        panel_2.setLayout(new GridLayout(12, 1, 0, 0));
        panel_2.setBackground(default_selectionColor);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 650, 219, 33);
        panel.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Thông tin tài khoản");
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		ThongTinTaiKhoanMouseClicked();
        	}
        });
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 219, 33);
        panel_3.add(lblNewLabel);
        
        JPanel panel_3_1 = new JPanel();
        panel_3_1.setBounds(10, 683, 219, 33);
        panel.add(panel_3_1);
        panel_3_1.setLayout(null);
        
        JLabel lblngXut = new JLabel("Đăng xuất");
        lblngXut.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		DangXuatMouseClicked();
        	}
        });
        lblngXut.setHorizontalAlignment(SwingConstants.CENTER);
        lblngXut.setBounds(0, 0, 219, 33);
        panel_3_1.add(lblngXut);

        getRole();
        setVisible(true);
    }
    public void DangXuatMouseClicked() {
    	this.dispose();
    	Login login = new Login();
    	login.setVisible(true);
	}
public void ThongTinTaiKhoanMouseClicked() {
		ThongTinTaiKhoan thongTinTaiKhoan = new ThongTinTaiKhoan(currentUser);
		thongTinTaiKhoan.setVisible(true);
	}
    public void getRole(){
        String role = UserDAO.getInstance().getRoleByIDUser(currentUser.getIdUser());
        ArrayList<String> menuItems = UserDAO.getInstance().nameBtn_Menu(role);
        renderMenuBar(menuItems,panel_2);
    }
    public void renderMenuBar(ArrayList<String> menuItems , JPanel jPanel){
        System.out.println("arr: "+menuItems);
        // Tạo các mục menu
        for (int i = 0; i < menuItems.size(); i++) {
            String item = menuItems.get(i);
            JPanel panel_parent = new JPanel();
            panel_parent.setBackground(default_selectionColor);
            panel_parent.setLayout(null);

            JPanel side_panelParent = new JPanel();
            side_panelParent.setBackground(default_sideColor);
            panel_parent.add(side_panelParent);

            JLabel btn_panelParent= new JLabel(item);
            btn_panelParent.setBounds(50, 0, 169, 45);
            panel_parent.add(btn_panelParent);

            jPanel.add(panel_parent);

            side_panelParent.setBounds(0, 0, 10, panel_parent.getHeight());

            // Xử lý sự kiện click để đổi màu
            panel_parent.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    resetMenuColor(jPanel);

                    panel_parent.setBackground(selectionColor);
                    side_panelParent.setBackground(sideColor);

                    side_panelParent.setBounds(0, 0, 10, panel_parent.getHeight());

                    panel_parent.revalidate();
                    panel_parent.repaint();

                    Display(item);
                }
            });

            // Lưu lại panel đầu tiên (Sản Phẩm)
            if (i == 0) {
                selectDefault(panel_parent, side_panelParent);
                Display(item);
            }
        }
    }
    // Đặt lại màu cho toàn bộ menu
    private void resetMenuColor(JPanel panel_2) {
        for (Component component : panel_2.getComponents()) {
            if (component instanceof JPanel) {
                JPanel menuItem = (JPanel) component;
                menuItem.setBackground(default_selectionColor);
                JPanel sidePanel = (JPanel) menuItem.getComponent(0);
                sidePanel.setBackground(default_sideColor);
            }
        }
    }

    // Chọn mặc định mục "Sản Phẩm"
    private void selectDefault(JPanel panel, JPanel sidePanel) {
        panel.setBackground(selectionColor);
        sidePanel.setBackground(sideColor);
        panel.revalidate();
        panel.repaint();
    }
    public void Display(String item){
        System.out.println("item: "+ item);
        switch (item){
            case "Sản phẩm":
                SanPhamForm sanPhamForm = new SanPhamForm(currentUser);
                cardPanel.add(sanPhamForm,"Sản phẩm");
                cardLayout.show(cardPanel,"Sản phẩm");
                break;
            case "Nhà cung cấp":
                NhaCungCapForm nhaCungCapPanel = new NhaCungCapForm();
                cardPanel.add(nhaCungCapPanel, "Nhà cung cấp");
                cardLayout.show(cardPanel, "Nhà cung cấp");
                break;
            case "Nhập hàng":
                NhapHangForm nhapHangForm = new NhapHangForm(currentUser);
                cardPanel.add(nhapHangForm, "Nhập hàng");
                cardLayout.show(cardPanel, "Nhập hàng");
                break;
            case "Phiếu nhập":
                System.out.println("phieunhap");
                PhieuNhapForm phieuNhapForm = new PhieuNhapForm(currentUser);
                cardPanel.add(phieuNhapForm, "Phiếu nhập");
                cardLayout.show(cardPanel, "Phiếu nhập");
                break;
            case "Phiếu xuất":
                System.out.println("phieuxuat");
                PhieuXuatForm phieuXuatForm = new PhieuXuatForm(currentUser);
                cardPanel.add(phieuXuatForm, "Phiếu xuất");
                cardLayout.show(cardPanel, "Phiếu xuất");
                break;
            case "Tồn kho":
                TonKhoForm tonKhoForm = new TonKhoForm(currentUser);
                cardPanel.add(tonKhoForm, "Tồn kho");
                cardLayout.show(cardPanel, "Tồn kho");
                break;
            case "Tài khoản user":
                QLTaiKhoanForm qlTaiKhoanForm = new QLTaiKhoanForm();
                cardPanel.add(qlTaiKhoanForm, "Quản lí tài khoản");
                cardLayout.show(cardPanel, "Quản lí tài khoản");
                break;
            case "Thống kê":
                ThongKeForm thongKeForm = new ThongKeForm();
                cardPanel.add(thongKeForm, "Thống kê");
                cardLayout.show(cardPanel, "Thống kê");
                break;
            case "Xuất hàng":
                XuatHangForm xuatHangForm = new XuatHangForm(currentUser);
                cardPanel.add(xuatHangForm, "Xuất hàng");
                cardLayout.show(cardPanel, "Xuất hàng");
                break;
            case "Chi nhánh":
                ChiNhanhForm chiNhanhForm = new ChiNhanhForm();
                cardPanel.add(chiNhanhForm,"Chi nhánh");
                cardLayout.show(cardPanel, "Chi nhánh");
                break;
            case "Nhập hàng - CN":
                NhapHangBranchForm nhapHangBranchForm = new NhapHangBranchForm(currentUser);
                cardPanel.add(nhapHangBranchForm,"Nhập hàng - CN");
                cardLayout.show(cardPanel,"Nhập hàng - CN");
                break;
            case "Phiếu nhập - CN":
                PhieuNhapBranchForm phieuNhapBranchForm = new PhieuNhapBranchForm(currentUser);
                cardPanel.add(phieuNhapBranchForm,"Phiếu nhập - CN");
                cardLayout.show(cardPanel,"Phiếu nhập - CN");
                break;
            case "Bán hàng":
                BanHang banHang = new BanHang(currentUser);
                cardPanel.add(banHang,"Bán hàng");
                cardLayout.show(cardPanel,"Bán hàng");
                break;
        }
    }
}
