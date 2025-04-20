package view.User;

import javax.swing.*;

import DAO.UserDAO;
import model.User;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThongTinTaiKhoan extends JFrame {
    private JLabel lblTitle, lblHoTen, lblNgaySinh, lblEmail;
    private JTextField txtHoTen, txtUsername, txtSDT;
    private JButton btnChinhSua;
    private JLabel lblSDT_1;
    private JLabel lblSDT_2;
    private User currentUser;
    private boolean isEdit = false;
    private JTextField txtEmail;
    private JPasswordField txtPassword;

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
        JPanel mainPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        lblHoTen = new JLabel("Họ Tên:");
        lblNgaySinh = new JLabel("Username");
        lblEmail = new JLabel("Password");

        txtHoTen = new JTextField();
        txtUsername = new JTextField();
        txtSDT = new JTextField();

        // 🔹 Vô hiệu hóa chỉnh sửa (Chỉ để hiển thị)
        txtUsername.setEditable(false);

        // 🔹 Thêm vào Main Panel
        mainPanel.add(lblHoTen);
        mainPanel.add(txtHoTen);
        mainPanel.add(lblNgaySinh);
        mainPanel.add(txtUsername);
        mainPanel.add(lblEmail);
        
        txtPassword = new JPasswordField();
        mainPanel.add(txtPassword);
        
        lblSDT_1 = new JLabel("Số Điện Thoại:");
        mainPanel.add(lblSDT_1);
        mainPanel.add(txtSDT);

        // 🟠 Footer Panel (Nút Chỉnh Sửa)
        JPanel footerPanel = new JPanel();
        btnChinhSua = new JButton("Chỉnh sửa thông tin");
        btnChinhSua.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		EditMouseClicked();
        	}
        });
        btnChinhSua.setBackground(new Color(0, 153, 76));
        btnChinhSua.setForeground(Color.WHITE);
        btnChinhSua.setFocusPainted(false);
        btnChinhSua.setFont(new Font("Arial", Font.BOLD, 14));

        footerPanel.add(btnChinhSua);

        // 🏗️ Thêm các phần vào JFrame
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        lblSDT_2 = new JLabel("Email");
        mainPanel.add(lblSDT_2);
        
        txtEmail = new JTextField();

        mainPanel.add(txtEmail);
        getContentPane().add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
        setEdit();
        fillData();
    }
    public void fillData(){
        txtEmail.setText(currentUser.getEmail());
        txtHoTen.setText(currentUser.getFullName());
        txtPassword.setText(currentUser.getPassword());
        txtSDT.setText(currentUser.getPhone());
        txtUsername.setText(currentUser.getUserName());
    }
    public void setEdit(){
        if(isEdit){
            txtEmail.setEditable(true);
            txtHoTen.setEditable(true);
            txtPassword.setEditable(true);
            txtSDT.setEditable(true);
        }else {
            txtEmail.setEditable(false);
            txtHoTen.setEditable(false);
            txtPassword.setEditable(false);
            txtSDT.setEditable(false);
        }
    }
    public void EditMouseClicked(){
        isEdit = !isEdit;
        setEdit();
        if(isEdit){
            btnChinhSua.setText("Lưu");
            String password = new String(txtPassword.getPassword());
            String email = txtEmail.getText();
            String phone = txtSDT.getText();
            String fullnaem = txtHoTen.getText();
            currentUser.setPassword(password);
            currentUser.setEmail(email);
            currentUser.setPhone(phone);
            currentUser.setFullName(fullnaem);
            int ketQua = UserDAO.getInstance().update(currentUser);
            if(ketQua>0){
                JOptionPane.showMessageDialog(this,"Cập nhật tài khoản cá nhân thành công !");
            }else {
                JOptionPane.showMessageDialog(this, "Không thể cập nhật vì đã có dữ liệu tham chiếu tham chiếu liên quan!");
            }

        }else {
            btnChinhSua.setText("Chỉnh sửa thông tin");
        }
    }

}
