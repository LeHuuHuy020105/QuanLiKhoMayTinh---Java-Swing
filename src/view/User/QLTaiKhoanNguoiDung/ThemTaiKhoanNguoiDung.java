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

public class ThemTaiKhoanNguoiDung extends JFrame  {

	private static final long serialVersionUID = 1L;
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
	public ThemTaiKhoanNguoiDung(QLTaiKhoanNguoiDungForm qlTaiKhoanNguoiDungForm) {
		this.currentUser = qlTaiKhoanNguoiDungForm.getCurrentUser();
		this.qlTaiKhoanNguoiDungForm = qlTaiKhoanNguoiDungForm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 388, 710);
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
		btn_ThemSanPham.setBounds(10, 622, 131, 41);
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
		btnNewButton_2_1_1.setBounds(210, 622, 139, 41);
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
		setVisible(true);
		Permission();
	}
	private void Permission() {
		String role = UserDAO.getInstance().getRoleByIDUser(currentUser.getIdUser());
		if(role.equals("Nhân viên bán hàng")) {
			textField_TK.setEditable(false);
			passwordField.setEditable(false);
			Re_passwordField.setEditable(false);
			textField_Email.setEditable(false);
		}
	}
	private void ThemNhaCungCapMouseClicked() {
		String role = UserDAO.getInstance().getRoleByIDUser(currentUser.getIdUser());
		if(role.equals("Nhân viên bán hàng")) {
			ThemTaiKhoanOffline();
		}else {
			ThemTaiKhoanOnline();
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
		if(hoTen.isEmpty() || soDienThoai.isEmpty() || taiKhoan.isEmpty() || matKhau.isEmpty() || email.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !");
			return;
		}
		if(!checkAccountDuplication(matKhau, nhapLaiMatKhau)) {
			return;
		}
		Customer customer = new Customer(taiKhoan,matKhau,"online",hoTen,email,soDienThoai);
		CustomerDAO.getInstance().insert(customer);
	}
	private void ThemTaiKhoanOffline() {
		String hoTen = input_HoTen.getText();
		String soDienThoai = input_SDT.getText();
		if(hoTen.isEmpty() || soDienThoai.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin họ tên và số điện thoại !");
			return;
		}
		Customer customer = new Customer(soDienThoai,hoTen,"offline");
		CustomerDAO.getInstance().insert(customer);
	}
	public boolean checkAccountDuplication(String password, String rePassword) {
		if(password.equals(rePassword)) {
			return true;
		}
		JOptionPane.showMessageDialog(this, "Mật khẩu không khớp !");
		return false;
	}
}
