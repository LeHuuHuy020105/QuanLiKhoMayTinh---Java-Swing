package view.User.QLTaiKhoanAdmin;

import DAO.UserDAO;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SuaTaiKhoanForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TaiKhoan;
	private JPasswordField textField_Password;
	private JTextField textField_Email;
	private QLTaiKhoanForm qlTaiKhoanForm;
	private JComboBox cbx_VaiTro;
	private JComboBox cbx_TrangThai;
	private JComboBox cbx_DiaChi;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SuaTaiKhoanForm(QLTaiKhoanForm qlTaiKhoanForm) {
		this.qlTaiKhoanForm = qlTaiKhoanForm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 388, 746);
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

		JLabel lblThmNhCung = new JLabel("SỬA TÀI KHOẢN");
		lblThmNhCung.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmNhCung.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThmNhCung.setBounds(0, 0, 372, 49);
		panel.add(lblThmNhCung);

		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 112, 169, 28);
		contentPane.add(lblNewLabel_1);

		textField_TaiKhoan = new JTextField();
		textField_TaiKhoan.setColumns(10);
		textField_TaiKhoan.setBounds(10, 140, 328, 28);
		contentPane.add(textField_TaiKhoan);

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 197, 116, 28);
		contentPane.add(lblNewLabel_1_1);

		textField_Password = new JPasswordField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(10, 224, 328, 28);
		contentPane.add(textField_Password);

		JLabel lblNewLabel_1_1_1 = new JLabel("Vai trò");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 363, 116, 28);
		contentPane.add(lblNewLabel_1_1_1);

		JButton btnNewButton_2_1 = new JButton("Lưu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setIcon(null);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBackground(new Color(60, 179, 113));
		btnNewButton_2_1.setBounds(10, 646, 131, 41);
		contentPane.add(btnNewButton_2_1);

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
		btnNewButton_2_1_1.setBounds(199, 646, 139, 41);
		contentPane.add(btnNewButton_2_1_1);

		cbx_VaiTro = new JComboBox();
		cbx_VaiTro.setBounds(10, 391, 328, 28);
		contentPane.add(cbx_VaiTro);

		JLabel lblNewLabel_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(10, 282, 116, 28);
		contentPane.add(lblNewLabel_1_1_2);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(10, 309, 328, 28);
		contentPane.add(textField_Email);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Trạng thái");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 446, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1);

		cbx_TrangThai = new JComboBox();
		cbx_TrangThai.setBounds(10, 476, 328, 28);
		contentPane.add(cbx_TrangThai);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 537, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		cbx_DiaChi = new JComboBox();
		cbx_DiaChi.setBounds(10, 575, 328, 28);
		contentPane.add(cbx_DiaChi);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(82, 543, 70, 21);
		contentPane.add(btnNewButton);

		JButton btnXo = new JButton("Xoá");
		btnXo.setBounds(180, 543, 70, 21);
		contentPane.add(btnXo);
	}
	public void fillData(){
		User user_Selected = this.qlTaiKhoanForm.getUserSelected();
		System.out.println(user_Selected);
		String role = UserDAO.getInstance().getRoleByIDUser(user_Selected.getIdUser());
		textField_Email.setText(user_Selected.getEmail());
		textField_TaiKhoan.setText(user_Selected.getUserName());
		textField_Password.setText(user_Selected.getPassword());
		cbx_VaiTro.setSelectedItem(role);
		cbx_TrangThai.setSelectedItem(user_Selected.getStatus()==1?"Bình thường":"Khoá");
	}
}
