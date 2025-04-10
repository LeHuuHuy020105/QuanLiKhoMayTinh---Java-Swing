package view.User.QLTaiKhoanNguoiDung;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAO.CustomerDAO;
import DAO.ProducersDAO;
import DAO.UserDAO;
import controller.ValueAddress;
import model.Customer;
import model.Producer;
import model.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class ThemTaiKhoanNguoiDung extends JFrame {

    private static final long serialVersionUID = 1L;
    private JComboBox cbx_LoaiTK;
    private JPanel contentPane;
    private JTextField input_HoTen;
    private JTextField input_SDT;
    private JTextField textField_TK;
    private User currentUser;
    private JTextField textField_Email;
    private JPasswordField passwordField;
    private JPasswordField Re_passwordField;
    private QLTaiKhoanNguoiDungForm qlTaiKhoanNguoiDungForm;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public ThemTaiKhoanNguoiDung() {
        init();
        lockoffline();
    }

    public ThemTaiKhoanNguoiDung(QLTaiKhoanNguoiDungForm qlTaiKhoanNguoiDungForm) {
        this.currentUser = qlTaiKhoanNguoiDungForm.getCurrentUser();
        this.qlTaiKhoanNguoiDungForm = qlTaiKhoanNguoiDungForm;
        init();
        Permission();
    }

    public void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 388, 780);
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

        JLabel lblThmNhCung = new JLabel("THÊM TÀI KHOẢN");
        lblThmNhCung.setHorizontalAlignment(SwingConstants.CENTER);
        lblThmNhCung.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblThmNhCung.setBounds(0, 0, 372, 49);
        panel.add(lblThmNhCung);

        JLabel lblNewLabel_1 = new JLabel("Họ và tên");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(10, 112, 169, 28);
        contentPane.add(lblNewLabel_1);

        input_HoTen = new JTextField();
        input_HoTen.setColumns(10);
        input_HoTen.setBounds(10, 140, 328, 28);
        contentPane.add(input_HoTen);

        JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(10, 197, 116, 28);
        contentPane.add(lblNewLabel_1_1);

        input_SDT = new JTextField();
        input_SDT.setColumns(10);
        input_SDT.setBounds(10, 224, 328, 28);
        contentPane.add(input_SDT);

        JButton btn_ThemSanPham = new JButton("Thêm");
        btn_ThemSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThemNhaCungCapMouseClicked();
            }
        });
        btn_ThemSanPham.setIcon(null);
        btn_ThemSanPham.setForeground(Color.WHITE);
        btn_ThemSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_ThemSanPham.setBorderPainted(false);
        btn_ThemSanPham.setBackground(new Color(60, 179, 113));
        btn_ThemSanPham.setBounds(10, 692, 131, 41);
        contentPane.add(btn_ThemSanPham);

        JButton btnNewButton_2_1_1 = new JButton("Huỷ bỏ");
        btnNewButton_2_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_2_1_1.setIcon(null);
        btnNewButton_2_1_1.setForeground(Color.WHITE);
        btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2_1_1.setBorderPainted(false);
        btnNewButton_2_1_1.setBackground(Color.RED);
        btnNewButton_2_1_1.setBounds(199, 692, 139, 41);
        contentPane.add(btnNewButton_2_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Tài khoản");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1.setBounds(10, 280, 116, 28);
        contentPane.add(lblNewLabel_1_1_1);

        textField_TK = new JTextField();
        textField_TK.setColumns(10);
        textField_TK.setBounds(10, 309, 328, 28);
        contentPane.add(textField_TK);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Mật khẩu");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1.setBounds(10, 369, 116, 28);
        contentPane.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Email");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1_1.setBounds(10, 531, 116, 28);
        contentPane.add(lblNewLabel_1_1_1_1_1);

        textField_Email = new JTextField();
        textField_Email.setColumns(10);
        textField_Email.setBounds(10, 560, 328, 28);
        contentPane.add(textField_Email);

        passwordField = new JPasswordField();
        passwordField.setBounds(10, 402, 328, 28);
        contentPane.add(passwordField);

        JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Nhập lại mật khẩu");
        lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1_2.setBounds(10, 447, 191, 28);
        contentPane.add(lblNewLabel_1_1_1_1_2);

        Re_passwordField = new JPasswordField();
        Re_passwordField.setBounds(10, 480, 328, 28);
        contentPane.add(Re_passwordField);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Loại tài khoản");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1_1_1.setBounds(10, 598, 116, 28);
        contentPane.add(lblNewLabel_1_1_1_1_1_1);

        String[] loaiTK = new String[]{"online", "offline"};
        cbx_LoaiTK = new JComboBox(loaiTK);
        cbx_LoaiTK.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                cbxLoaiTKMouseClicked();
            }
        });
        cbx_LoaiTK.setBounds(10, 636, 328, 28);
        contentPane.add(cbx_LoaiTK);
        setVisible(true);
    }

    private void Permission() {
        String role = UserDAO.getInstance().getRoleByIDUser(currentUser.getIdUser());
        if (role.equals("Nhân viên bán hàng")) {
            PerrmissionStaff();
            cbx_LoaiTK.setEnabled(false);
        }
    }

    public void PerrmissionStaff() {
        textField_TK.setEditable(false);
        passwordField.setEditable(false);
        Re_passwordField.setEditable(false);
        textField_Email.setEditable(false);
    }

    public void PerrmissionAdmin() {
        textField_TK.setEditable(true);
        passwordField.setEditable(true);
        Re_passwordField.setEditable(true);
        textField_Email.setEditable(true);
    }

    public void cbxLoaiTKMouseClicked() {
        String loaiTK = cbx_LoaiTK.getSelectedItem() + "";
        if (loaiTK.equals("offline")) {
            PerrmissionStaff();
        } else {
            PerrmissionAdmin();
        }
    }

    public void lockoffline() {
        if (this.currentUser == null) {
            cbx_LoaiTK.setSelectedItem("online");
            cbx_LoaiTK.setEnabled(false);
        }
    }

    private void ThemNhaCungCapMouseClicked() {
        if (currentUser == null) {
            String email = textField_Email.getText();
            String taikhoan = textField_TK.getText();
            String pass = new String(passwordField.getPassword());
            String phone = input_SDT.getText();
            String repass = new String(Re_passwordField.getPassword());
            String username = input_HoTen.getText();
            String loaiTaiKhoan = cbx_LoaiTK.getSelectedItem() + "";
            if (checkConfirmPassword(pass, repass) && checkEmail(email) && checkValidAccount(taikhoan) && kiemTraNameUser(username) && checkValidPhone(phone,loaiTaiKhoan)) {
                ThemTaiKhoanOnline();
                this.dispose();
            }
            return;
        } else {
            String role = UserDAO.getInstance().getRoleByIDUser(currentUser.getIdUser());
            if (role.equals("Nhân viên bán hàng")) {
                ThemTaiKhoanOffline();
            } else {
                ThemTaiKhoanOnline();
            }
        }
        qlTaiKhoanNguoiDungForm.updateTableDataFormDAO();
        this.dispose();
    }

    private void ThemTaiKhoanOnline() {
        String hoTen = input_HoTen.getText();
        String soDienThoai = input_SDT.getText();
        String taiKhoan = textField_TK.getText();
        String matKhau = new String(passwordField.getPassword());
        String nhapLaiMatKhau = new String(Re_passwordField.getPassword());
        String email = textField_Email.getText();
        if (hoTen.isEmpty() || soDienThoai.isEmpty() || taiKhoan.isEmpty() || matKhau.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !");
            return;
        }
        if (!checkConfirmPassword(matKhau, nhapLaiMatKhau)) {
            return;
        }
        Customer customer = new Customer(taiKhoan, matKhau, "online", hoTen, email, soDienThoai);
        CustomerDAO.getInstance().insert(customer);
    }

    private void ThemTaiKhoanOffline() {
        String hoTen = input_HoTen.getText();
        String soDienThoai = input_SDT.getText();
        if (hoTen.isEmpty() || soDienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin họ tên và số điện thoại !");
            return;
        }
        Customer customer = new Customer(soDienThoai, hoTen, "offline");
        CustomerDAO.getInstance().insert(customer);
    }

    public static boolean kiemTraNameUser(String fullname) {
        if (fullname.trim().isEmpty() || fullname.equals("null")) {
            return false;
        }
        String regex = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s]+$";

        return fullname.matches(regex);
    }

    public boolean checkConfirmPassword(String password, String confirmPassword) {
        if (password == null || confirmPassword == null) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống!");
            return false;
        }

        boolean match = password.equals(confirmPassword);

        if (!match) {
            JOptionPane.showMessageDialog(this, "Mật khẩu và mật khẩu xác nhận không khớp!");
        }
        return match;
    }

    public boolean checkEmail(String email) {
        if (email == null || email.equals("null")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống!");
            return false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        boolean match = email.matches(emailRegex);
        if (!match) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng!");
            return false;
        }
        return match;
    }

    public boolean checkValidAccount(String nameAccount) {
        if (nameAccount == null || nameAccount.equals("null")) {
            JOptionPane.showMessageDialog(this, "Tài khoản không được để trống!");
            return false;
        }
        boolean flag = CustomerDAO.getInstance().checkDataAccount(nameAccount);
        if (flag == true) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại!");
            return false;
        }
        return true;
    }
	public boolean checkValidPhone(String phoneNumber , String loaiTaiKhoan) {
        if (phoneNumber == null || phoneNumber.equals("null")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!");
            return false;
        }
        boolean flag = CustomerDAO.getInstance().checkSdt(phoneNumber,loaiTaiKhoan);
        if (flag == true) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!");
            return false;
        }
        return true;
    }

}
