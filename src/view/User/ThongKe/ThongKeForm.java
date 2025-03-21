package view.User.ThongKe;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComponent;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThongKeForm extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel cardPanel;
    private Color selectionColor = new Color(220, 220, 220);
    private Color sideColor = new Color(0, 206, 209);
    private Color default_selectionColor = new Color(240, 240, 240);
    private Color default_sideColor = new Color(240, 240, 240);
    private JPanel panel_ThongKe_SanPham;
    private Container panel_ThongKe_Phieu;
    private JPanel panel_ThongKe_TaiKhoan;
    private JComponent side_ThongKe_SanPham;
    private JPanel side_ThongKe_Phieu;
    private JPanel side_ThongKe_TaiKhoan;
    private CardLayout cardLayout;

    /**
     * Create the panel.
     */
    public ThongKeForm() {
        setLayout(null);
        setSize(1257, 911);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 165, 0));
        panel.setBounds(20, 11, 367, 110);
        add(panel);
        panel.setLayout(null);

        cardPanel = new JPanel();
        cardPanel.setBounds(10, 222, 1247, 678);
        add(cardPanel);
        cardLayout = new CardLayout(0, 0);
        cardPanel.setLayout(cardLayout);

        ThongKeSanPhamForm thongKeSanPhamForm = new ThongKeSanPhamForm();
        ThongKePhieuForm thongKePhieuForm = new ThongKePhieuForm();
        ThongKeTaiKhoanForm thongKeTaiKhoanForm = new ThongKeTaiKhoanForm();

        cardPanel.add(thongKeSanPhamForm, "Thống kê sản phẩm");
        cardPanel.add(thongKeTaiKhoanForm, "Thống kê tài khoản");
        cardPanel.add(thongKePhieuForm, "Thống kê phiếu");

        JLabel lblNewLabel = new JLabel("26");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(121, 11, 68, 31);
        panel.add(lblNewLabel);

        JLabel lblSnPhmTrong = new JLabel("Sản phẩm trong kho");
        lblSnPhmTrong.setForeground(new Color(255, 255, 255));
        lblSnPhmTrong.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSnPhmTrong.setBounds(121, 57, 172, 31);
        panel.add(lblSnPhmTrong);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1.setBounds(10, 11, 89, 74);
        ImageIcon originalIcon = new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\desktop.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        lblNewLabel_1.setIcon(resizedIcon);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(205, 133, 63));
        panel_1.setBounds(448, 11, 367, 110);
        add(panel_1);

        JLabel lblNewLabel_2 = new JLabel("8");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_2.setBounds(121, 11, 68, 31);
        panel_1.add(lblNewLabel_2);

        JLabel lblNhCungCp = new JLabel("Nhà cung cấp");
        lblNhCungCp.setForeground(Color.WHITE);
        lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNhCungCp.setBounds(121, 57, 172, 31);
        panel_1.add(lblNhCungCp);

        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1_1.setBounds(10, 11, 89, 74);
        ImageIcon originalIcon_1 = new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\nhacungcap.png");
        Image scaledImage_1 = originalIcon_1.getImage().getScaledInstance(lblNewLabel_1_1.getWidth(), lblNewLabel_1_1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_1 = new ImageIcon(scaledImage_1);
        lblNewLabel_1_1.setIcon(resizedIcon_1);
        panel_1.add(lblNewLabel_1_1);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(100, 149, 237));
        panel_2.setBounds(866, 11, 367, 110);
        add(panel_2);

        JLabel lblNewLabel_3 = new JLabel("26");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_3.setBounds(121, 11, 68, 31);
        panel_2.add(lblNewLabel_3);

        JLabel lblSnPhmTrong_2 = new JLabel("Sản phẩm trong kho");
        lblSnPhmTrong_2.setForeground(Color.WHITE);
        lblSnPhmTrong_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSnPhmTrong_2.setBounds(121, 57, 172, 31);
        panel_2.add(lblSnPhmTrong_2);

        JLabel lblNewLabel_1_2 = new JLabel("");
        lblNewLabel_1_2.setForeground(Color.BLACK);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1_2.setBounds(10, 11, 89, 74);
        ImageIcon originalIcon_2 = new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\nhacungcap.png");
        Image scaledImage_2 = originalIcon_2.getImage().getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_2 = new ImageIcon(scaledImage_1);
        lblNewLabel_1_2.setIcon(resizedIcon_2);
        panel_2.add(lblNewLabel_1_2);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 166, 1247, 27);
        add(panel_3);
        panel_3.setLayout(null);

        panel_ThongKe_SanPham = new JPanel();
        panel_ThongKe_SanPham.setBackground(new Color(220, 220, 220));
        panel_ThongKe_SanPham.setBounds(0, 0, 119, 26);
        panel_3.add(panel_ThongKe_SanPham);
        panel_ThongKe_SanPham.setLayout(null);

        JLabel btn_ThongKe_SanPham = new JLabel("Sản phẩm");
        btn_ThongKe_SanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ThongKeSanPhamMouseClicked();
            }
        });
        btn_ThongKe_SanPham.setHorizontalAlignment(SwingConstants.CENTER);
        btn_ThongKe_SanPham.setBounds(0, 0, 119, 26);
        panel_ThongKe_SanPham.add(btn_ThongKe_SanPham);

        side_ThongKe_SanPham = new JPanel();
        side_ThongKe_SanPham.setBackground(new Color(0, 206, 209));
        side_ThongKe_SanPham.setBounds(0, 0, 10, 26);
        panel_ThongKe_SanPham.add(side_ThongKe_SanPham);

        panel_ThongKe_Phieu = new JPanel();
        panel_ThongKe_Phieu.setLayout(null);
        panel_ThongKe_Phieu.setBackground(new Color(240, 240, 240));
        panel_ThongKe_Phieu.setBounds(119, 0, 119, 26);
        panel_3.add(panel_ThongKe_Phieu);

        JLabel btn_ThongKe_Phieu = new JLabel("Phiếu");
        btn_ThongKe_Phieu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThongKePhieuMouseClicked();
            }
        });
        btn_ThongKe_Phieu.setHorizontalAlignment(SwingConstants.CENTER);
        btn_ThongKe_Phieu.setBounds(0, 0, 119, 26);
        panel_ThongKe_Phieu.add(btn_ThongKe_Phieu);

        side_ThongKe_Phieu = new JPanel();
        side_ThongKe_Phieu.setBackground(new Color(240, 240, 240));
        side_ThongKe_Phieu.setBounds(0, 0, 10, 26);
        panel_ThongKe_Phieu.add(side_ThongKe_Phieu);

        panel_ThongKe_TaiKhoan = new JPanel();
        panel_ThongKe_TaiKhoan.setLayout(null);
        panel_ThongKe_TaiKhoan.setBackground(new Color(240, 240, 240));
        panel_ThongKe_TaiKhoan.setBounds(237, 0, 119, 26);
        panel_3.add(panel_ThongKe_TaiKhoan);

        JLabel btn_ThongKe_TaiKhoan = new JLabel("Tài khoản");
        btn_ThongKe_TaiKhoan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThongKeTaiKhoanMouseClicked();
            }
        });
        btn_ThongKe_TaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
        btn_ThongKe_TaiKhoan.setBounds(0, 0, 119, 26);
        panel_ThongKe_TaiKhoan.add(btn_ThongKe_TaiKhoan);

        side_ThongKe_TaiKhoan = new JPanel();
        side_ThongKe_TaiKhoan.setBackground(new Color(240, 240, 240));
        side_ThongKe_TaiKhoan.setBounds(0, 0, 10, 26);
        panel_ThongKe_TaiKhoan.add(side_ThongKe_TaiKhoan);


    }
    public void resetMenu() {
        side_ThongKe_SanPham.setBackground(default_sideColor);
        side_ThongKe_Phieu.setBackground(default_sideColor);
        side_ThongKe_TaiKhoan.setBackground(default_sideColor);

        panel_ThongKe_SanPham.setBackground(default_selectionColor);
        panel_ThongKe_Phieu.setBackground(default_selectionColor);
        panel_ThongKe_TaiKhoan.setBackground(default_selectionColor);
    }

    public void ThongKeSanPhamMouseClicked() {
        resetMenu();
        side_ThongKe_SanPham.setBackground(sideColor);
        panel_ThongKe_SanPham.setBackground(selectionColor);
        cardLayout.show(cardPanel,"Thống kê sản phẩm");
    }

    public void ThongKePhieuMouseClicked() {
        resetMenu();
        side_ThongKe_Phieu.setBackground(sideColor);
        panel_ThongKe_Phieu.setBackground(selectionColor);
        cardLayout.show(cardPanel,"Thống kê phiếu");
    }

    public void ThongKeTaiKhoanMouseClicked() {
        resetMenu();
        side_ThongKe_TaiKhoan.setBackground(sideColor);
        panel_ThongKe_TaiKhoan.setBackground(selectionColor);
        cardLayout.show(cardPanel,"Thống kê tài khoản");
    }

    public static void main(String[] args) {
        new ThongKeForm().setVisible(true);
    }
}
