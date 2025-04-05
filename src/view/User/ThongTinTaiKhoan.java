package view.User;

import javax.swing.*;

import model.User;

import java.awt.*;

public class ThongTinTaiKhoan extends JFrame {
    private JLabel lblTitle, lblHoTen, lblNgaySinh, lblEmail, lblSDT;
    private JTextField txtHoTen, txtNgaySinh, txtEmail, txtSDT;
    private JButton btnChinhSua;
    private JLabel lblSDT_1;
    private JComboBox comboBox;
    private JLabel lblSDT_2;
    private JTextField textField;
    private User currentUser;

    public ThongTinTaiKhoan(User currentUser) {
    	this.currentUser = currentUser;
        setTitle("Thông Tin Người Dùng");
        setSize(856, 392);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // 🟢 Header Panel (Tiêu đề)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(144, 238, 144));
        lblTitle = new JLabel("Thông Tin Cá Nhân");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0, 102, 204));
        headerPanel.add(lblTitle);

        // 🟡 Main Panel (Chứa thông tin người dùng)
        JPanel mainPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        lblHoTen = new JLabel("Họ Tên:");
        lblNgaySinh = new JLabel("Username");
        lblEmail = new JLabel("Password");

        txtHoTen = new JTextField("Nguyễn Văn A");
        txtNgaySinh = new JTextField("01/01/1995");
        txtEmail = new JTextField("nguyenvana@gmail.com");
        txtSDT = new JTextField("0987654321");

        // 🔹 Vô hiệu hóa chỉnh sửa (Chỉ để hiển thị)
        txtHoTen.setEditable(false);
        txtNgaySinh.setEditable(false);
        txtEmail.setEditable(false);
        txtSDT.setEditable(false);

        // 🔹 Thêm vào Main Panel
        mainPanel.add(lblHoTen);
        mainPanel.add(txtHoTen);
        mainPanel.add(lblNgaySinh);
        mainPanel.add(txtNgaySinh);
        mainPanel.add(lblEmail);
        mainPanel.add(txtEmail);
        
        lblSDT_1 = new JLabel("Số Điện Thoại:");
        mainPanel.add(lblSDT_1);
        mainPanel.add(txtSDT);

        // 🟠 Footer Panel (Nút Chỉnh Sửa)
        JPanel footerPanel = new JPanel();
        btnChinhSua = new JButton("Chỉnh sửa thông tin");
        btnChinhSua.setBackground(new Color(0, 153, 76));
        btnChinhSua.setForeground(Color.WHITE);
        btnChinhSua.setFocusPainted(false);
        btnChinhSua.setFont(new Font("Arial", Font.BOLD, 14));

        footerPanel.add(btnChinhSua);

        // 🏗️ Thêm các phần vào JFrame
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        lblSDT_2 = new JLabel("Số Điện Thoại:");
        mainPanel.add(lblSDT_2);
        
        comboBox = new JComboBox();
        mainPanel.add(comboBox);
        lblSDT = new JLabel("Điểm tích luỹ");
        mainPanel.add(lblSDT);
        
        textField = new JTextField("0987654321");
        textField.setEditable(false);
        mainPanel.add(textField);
        getContentPane().add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
