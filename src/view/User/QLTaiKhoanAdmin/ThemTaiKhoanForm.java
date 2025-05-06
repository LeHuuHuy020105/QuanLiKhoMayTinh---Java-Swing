package view.User.QLTaiKhoanAdmin;

import DAO.BrachDAO;
import DAO.RoleDAO;
import DAO.UserDAO;
import controller.BranchBLL;
import controller.CheckValidInput;
import controller.RoleBLL;
import controller.UserBLL;
import model.Branch;
import model.Role;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ThemTaiKhoanForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox cbx_DiaChi;
	private JComboBox cbx_VaiTro;
	private JPanel contentPane;
	private JTextField textField_TK;
	private JTextField textField_Email;
	private JTextField textField_HoVaTen;
	private JTextField textField_SDT;
	private JPasswordField textField_MK;
	private QLTaiKhoanForm qlTaiKhoanForm;
	private CheckValidInput checkValidInput;
	private User user_Selected;
	private BranchBLL branchBLL;
	private RoleBLL roleBLL;
	private UserBLL userBLL;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ThemTaiKhoanForm(QLTaiKhoanForm qlTaiKhoanForm) {
		this.qlTaiKhoanForm = qlTaiKhoanForm;
		this.user_Selected = qlTaiKhoanForm.getUserSelected();
		this.branchBLL = new BranchBLL();
		this.roleBLL = new RoleBLL();
		this.userBLL = new UserBLL();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 388, 786);
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

		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 112, 169, 28);
		contentPane.add(lblNewLabel_1);

		textField_TK = new JTextField();
		textField_TK.setColumns(10);
		textField_TK.setBounds(10, 140, 328, 28);
		contentPane.add(textField_TK);

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 197, 116, 28);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Vai trò");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 353, 116, 28);
		contentPane.add(lblNewLabel_1_1_1);

		JButton btnNewButton_2_1 = new JButton("Thêm");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemTaiKhoanMouseClicked();
			}
		});
		btnNewButton_2_1.setIcon(null);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBackground(new Color(60, 179, 113));
		btnNewButton_2_1.setBounds(10, 698, 131, 41);
		contentPane.add(btnNewButton_2_1);

		JButton btnNewButton_2_1_1 = new JButton("Huỷ bỏ");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HuyBoMouseClicked();
			}
		});
		btnNewButton_2_1_1.setIcon(null);
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1_1.setBorderPainted(false);
		btnNewButton_2_1_1.setBackground(Color.RED);
		btnNewButton_2_1_1.setBounds(192, 698, 139, 41);
		contentPane.add(btnNewButton_2_1_1);

		String [] list_VaiTro = roleBLL.selectAllNameRole().toArray(new String[0]);
		cbx_VaiTro = new JComboBox(list_VaiTro);
		cbx_VaiTro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setChiNhanh();
			}
		});
		cbx_VaiTro.setBounds(10, 381, 328, 28);
		contentPane.add(cbx_VaiTro);

		JLabel lblNewLabel_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(10, 282, 116, 28);
		contentPane.add(lblNewLabel_1_1_2);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(10, 310, 328, 28);
		contentPane.add(textField_Email);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Chi nhánh");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 443, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		cbx_DiaChi = new JComboBox();
		cbx_DiaChi.setBounds(10, 471, 328, 28);
		contentPane.add(cbx_DiaChi);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ và tên");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 525, 169, 28);
		contentPane.add(lblNewLabel_1_2);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setText((String) null);
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(10, 563, 328, 28);
		contentPane.add(textField_HoVaTen);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(10, 601, 169, 28);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField_SDT = new JTextField();
		textField_SDT.setText((String) null);
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(10, 639, 328, 28);
		contentPane.add(textField_SDT);
		
		textField_MK = new JPasswordField();
		textField_MK.setBounds(10, 235, 328, 28);
		contentPane.add(textField_MK);
		checkValidInput = new CheckValidInput(this);
	}
	public void HuyBoMouseClicked(){
		this.dispose();
	}
	public void setChiNhanh(){
		String role = cbx_VaiTro.getSelectedItem().toString();
		if(role.equals("Quản lí chi nhánh") || role.equals("Nhân viên bán hàng")){
			ArrayList<Branch> branches = branchBLL.selectAll();
			cbx_DiaChi.setModel(new DefaultComboBoxModel(dataCbxDiaChi(branches)));
		}
		else {
			cbx_DiaChi.removeAllItems();
			cbx_DiaChi.setSelectedItem(false);
		}
	}
	public String[] dataCbxDiaChi(ArrayList<Branch> branches){
		String[] data = new String[branches.size()];
		for(Branch branch : branches){
			String description = branch.getTenChiNhanh()+" - "+branch.getDiaChi();
			data[branches.indexOf(branch)] = description;
		}
		return data;
	}
	public void ThemTaiKhoanMouseClicked(){
		User user = new User();
		String username = textField_TK.getText();
		String password = textField_MK.getText();
		String email = textField_Email.getText();
		String cbx_Vaitro = cbx_VaiTro.getSelectedItem()+"";
		String chiNhanh = cbx_DiaChi.getSelectedItem() != null ? cbx_DiaChi.getSelectedItem().toString() : "";
		String fullname = textField_HoVaTen.getText();
		String phone = textField_SDT.getText();
		Role role = roleBLL.getRoleCBX(cbx_Vaitro);
		Branch branch = null;
		System.out.println("chi nhanh "+ chiNhanh);
		if(password.equals("") || email.equals("") || username.equals("")){
			JOptionPane.showMessageDialog(this,"Vui lòng nhập đầy đủ thông tin !");
			return;
		}
		if(!checkValidInput.checkValidAccountUser(username) || !checkValidInput.checkValidPhoneUser(phone,user_Selected.getIdUser(),false) || !checkValidInput.checkEmailUser(email,user_Selected.getIdUser(),false)){
			return;
		}
		if(!chiNhanh.isEmpty()){
			System.out.println("nulll-chinhanh");
			branch = getBranchSelected(chiNhanh);
			user.setMaChiNhanh(branch.getMaChiNhanh());
		}
		user.setUserName(username);
		user.setPassword(password);
		user.setFullName(fullname);
		user.setPhone(phone);
		user.setStatus(1);
		user.setEmail(email);
		int idUser = userBLL.insert(user);
		System.out.println("idUSer + "+ idUser);
		int ketQua = roleBLL.insertRoleUser(idUser,role.getId());
		if(ketQua>0){
			JOptionPane.showMessageDialog(this,"Thêm tài khoản thành công !");
			this.dispose();
			qlTaiKhoanForm.updateTableDataFormDAO();
		}
	}
	public Branch getBranchSelected(String description){
		System.out.println("description "+description);
		String [] data = description.split(" - ");
		System.out.println("diachi "+data[1]);
		return branchBLL.BranchByDiaChi(data[1]);
	}
}
