package view.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import DAO.UserDAO;
import controller.CheckValidInput;
import controller.UserBLL;
import model.User;

public class ThongTinTaiKhoan extends JFrame {
    private JLabel lblTitle, lblHoTen, lblUsername, lblPassword, lblEmail, lblSDT;
    private JTextField txtHoTen, txtUsername, txtSDT, txtEmail;
    private JPasswordField txtPassword;
    private JButton btnChinhSua, btnHuy;
    private User currentUser;
    private boolean isEdit = false;
    private CheckValidInput checkValidInput;
    private UserBLL userBLL;

    public ThongTinTaiKhoan(User currentUser) {
        this.currentUser = currentUser;
        this.userBLL = new UserBLL();
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
        lblUsername = new JLabel("Tên Đăng Nhập:");
        lblPassword = new JLabel("Mật Khẩu:");
        lblEmail = new JLabel("Email:");
        lblSDT = new JLabel("Số Điện Thoại:");

        txtHoTen = new JTextField();
        txtUsername = new JTextField();
        txtUsername.setEditable(false); // Không cho chỉnh sửa tên đăng nhập
        txtPassword = new JPasswordField();
        txtEmail = new JTextField();
        txtSDT = new JTextField();

        // Thêm vào Main Panel
        mainPanel.add(lblHoTen);
        mainPanel.add(txtHoTen);
        mainPanel.add(lblUsername);
        mainPanel.add(txtUsername);
        mainPanel.add(lblPassword);
        mainPanel.add(txtPassword);
        mainPanel.add(lblEmail);
        mainPanel.add(txtEmail);
        mainPanel.add(lblSDT);
        mainPanel.add(txtSDT);

        // 🟠 Footer Panel (Nút Chỉnh Sửa và Hủy)
        JPanel footerPanel = new JPanel();
        btnChinhSua = new JButton("Chỉnh sửa thông tin");
        btnChinhSua.setBackground(new Color(0, 153, 76));
        btnChinhSua.setForeground(Color.WHITE);
        btnChinhSua.setFocusPainted(false);
        btnChinhSua.setFont(new Font("Arial", Font.BOLD, 14));

        btnHuy = new JButton("Hủy");
        btnHuy.setBackground(new Color(255, 69, 0));
        btnHuy.setForeground(Color.WHITE);
        btnHuy.setFocusPainted(false);
        btnHuy.setFont(new Font("Arial", Font.BOLD, 14));
        btnHuy.setVisible(false); // Ẩn nút Hủy ban đầu

        btnChinhSua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editMouseClicked();
            }
        });

        btnHuy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancelEdit();
            }
        });

        footerPanel.add(btnChinhSua);
        footerPanel.add(btnHuy);

        // 🏗️ Thêm các phần vào JFrame
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(footerPanel, BorderLayout.SOUTH);

        fillData();
        setEdit();
        setVisible(true);
    }

    private void fillData() {
        txtHoTen.setText(currentUser.getFullName());
        txtUsername.setText(currentUser.getUserName());
        txtPassword.setText(currentUser.getPassword());
        txtEmail.setText(currentUser.getEmail());
        txtSDT.setText(currentUser.getPhone());
    }

    private void setEdit() {
        txtHoTen.setEditable(isEdit);
        txtPassword.setEditable(isEdit);
        txtEmail.setEditable(isEdit);
        txtSDT.setEditable(isEdit);
        btnHuy.setVisible(isEdit);
        btnChinhSua.setText(isEdit ? "Lưu" : "Chỉnh sửa thông tin");
    }

    private void editMouseClicked() {
        if (!isEdit) {
            // Bật chế độ chỉnh sửa
            isEdit = true;
            setEdit();
        } else {
            // Lưu thông tin
            if (validateInput()) {
                try {
                    String fullName = txtHoTen.getText().trim();
                    String password = new String(txtPassword.getPassword()).trim();
                    String email = txtEmail.getText().trim();
                    String phone = txtSDT.getText().trim();

                    currentUser.setFullName(fullName);
                    currentUser.setPassword(password);
                    currentUser.setEmail(email);
                    currentUser.setPhone(phone);

                    int ketQua = userBLL.update(currentUser);
                    if (ketQua > 0) {
                        JOptionPane.showMessageDialog(this, "Cập nhật thông tin cá nhân thành công!");
                        isEdit = false;
                        setEdit();
                    } else {
                        JOptionPane.showMessageDialog(this, "Cập nhật thất bại. Vui lòng thử lại!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thông tin: " + ex.getMessage());
                }
            }
        }
    }

    private void cancelEdit() {
        isEdit = false;
        setEdit();
        fillData(); // Khôi phục dữ liệu ban đầu
    }

    private boolean validateInput() {
        String fullName = txtHoTen.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        String email = txtEmail.getText().trim();
        String phone = txtSDT.getText().trim();

        // Kiểm tra trường rỗng
        if (fullName.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }


        if (!checkValidInput.checkEmailUser(email,currentUser.getIdUser(),true)) {
            return false;
        }

        // Kiểm tra định dạng số điện thoại (bắt đầu bằng 0, 10 chữ số)
        if (!checkValidInput.checkValidPhoneUser(phone,currentUser.getIdUser(),true)) {
            return false;
        }

        return true;
    }

}