package view.User.QLTaiKhoanAdmin;

import DAO.BrandDAO;
import DAO.RoleDAO;
import DAO.UserDAO;
import model.Branch;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
	private boolean isPasswordVisible = false;
	private User currentUser;
	private User user_Selected;
	private JTextField textField_HoVaTen;
	private JTextField textField_Sdt;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SuaTaiKhoanForm(QLTaiKhoanForm qlTaiKhoanForm) {
		this.qlTaiKhoanForm = qlTaiKhoanForm;
		currentUser = qlTaiKhoanForm.getCurrentUser();
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

		JLabel lblThmNhCung = new JLabel("SỬA TÀI KHOẢN");
		lblThmNhCung.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmNhCung.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThmNhCung.setBounds(0, 0, 372, 49);
		panel.add(lblThmNhCung);

		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 86, 169, 28);
		contentPane.add(lblNewLabel_1);

		textField_TaiKhoan = new JTextField();
		textField_TaiKhoan.setColumns(10);
		textField_TaiKhoan.setBounds(10, 124, 328, 28);
		contentPane.add(textField_TaiKhoan);

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 241, 116, 28);
		contentPane.add(lblNewLabel_1_1);

		textField_Password = new JPasswordField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(10, 279, 328, 28);
		contentPane.add(textField_Password);

		JLabel lblNewLabel_1_1_1 = new JLabel("Vai trò");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 393, 116, 28);
		contentPane.add(lblNewLabel_1_1_1);

		JButton btnNewButton_2_1 = new JButton("Lưu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LuuMouseClicked();
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
			}
		});
		btnNewButton_2_1_1.setIcon(null);
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1_1.setBorderPainted(false);
		btnNewButton_2_1_1.setBackground(Color.RED);
		btnNewButton_2_1_1.setBounds(199, 698, 139, 41);
		contentPane.add(btnNewButton_2_1_1);

		String [] list_VaiTro = RoleDAO.getInstance().selectAll().toArray(new String[0]);
		cbx_VaiTro = new JComboBox(list_VaiTro	);
		cbx_VaiTro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setChiNhanh();
			}
		});
		cbx_VaiTro.setBounds(10, 431, 328, 28);
		contentPane.add(cbx_VaiTro);

		JLabel lblNewLabel_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(10, 317, 116, 28);
		contentPane.add(lblNewLabel_1_1_2);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(10, 355, 328, 28);
		contentPane.add(textField_Email);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Trạng thái");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 469, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1);

		String [] trangThai = new String[]{"Bình thường","Khóa"};
		cbx_TrangThai = new JComboBox(trangThai);
		cbx_TrangThai.setBounds(10, 507, 328, 28);
		contentPane.add(cbx_TrangThai);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Chi nhánh");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 547, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		cbx_DiaChi = new JComboBox();
		cbx_DiaChi.setBounds(10, 575, 328, 28);
		contentPane.add(cbx_DiaChi);
		
		JLabel lbl_eyePasswordOpen = new JLabel("");
		lbl_eyePasswordOpen.setIcon(new ImageIcon("C:\\Users\\Hoc\\IdeaProjects\\JAVA\\project\\Java\\QuanLiKhoMayTinh---Java-Swing\\src\\icon\\hide_view.png"));
		lbl_eyePasswordOpen.setBounds(348, 282, 24, 20);
		contentPane.add(lbl_eyePasswordOpen);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ và tên");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 165, 169, 28);
		contentPane.add(lblNewLabel_1_2);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(10, 203, 328, 28);
		contentPane.add(textField_HoVaTen);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(10, 610, 169, 28);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField_Sdt = new JTextField();
		textField_Sdt.setText((String) null);
		textField_Sdt.setColumns(10);
		textField_Sdt.setBounds(10, 648, 328, 28);
		contentPane.add(textField_Sdt);
		
		lbl_eyePasswordOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isPasswordVisible = !isPasswordVisible;
                if (isPasswordVisible) {
                    textField_Password.setEchoChar((char) 0); // Show password
                    lbl_eyePasswordOpen.setIcon(new ImageIcon("C:\\Users\\Hoc\\IdeaProjects\\JAVA\\project\\Java\\QuanLiKhoMayTinh---Java-Swing\\src\\icon\\open_view.png"));
                } else {
                    textField_Password.setEchoChar('•'); // Hide password
                    lbl_eyePasswordOpen.setIcon(new ImageIcon("C:\\Users\\Hoc\\IdeaProjects\\JAVA\\project\\Java\\QuanLiKhoMayTinh---Java-Swing\\src\\icon\\hide_view.png"));
                }
            }
        });
		
		fillData();
	}
	public void fillData(){
		user_Selected = this.qlTaiKhoanForm.getUserSelected();
		System.out.println(user_Selected);
		String role = UserDAO.getInstance().getRoleByIDUser(user_Selected.getIdUser());
		textField_Email.setText(user_Selected.getEmail());
		textField_TaiKhoan.setText(user_Selected.getUserName());
		textField_TaiKhoan.setEditable(false);
		textField_Password.setText(user_Selected.getPassword());
		cbx_VaiTro.setSelectedItem(role);
		cbx_TrangThai.setSelectedItem(user_Selected.getStatus()==1?"Bình thường":"Khoá");
		textField_HoVaTen.setText(user_Selected.getFullName());
		textField_Sdt.setText(user_Selected.getPhone());
	}
	public void setChiNhanh(){
		String role = cbx_VaiTro.getSelectedItem().toString();
		if(role.equals("Quản lí chi nhánh") || role.equals("Nhân viên bán hàng")){
			System.out.println("aa");
			ArrayList<Branch> branches = BrandDAO.getInstance().selectAll();
			cbx_DiaChi.setModel(new DefaultComboBoxModel(dataCbxDiaChi(branches)));
		}
		else {
			System.out.println("bb");
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
	public void LuuMouseClicked(){
		String password = new String(textField_Password.getPassword());
		String email = textField_Email.getText();
		String chiNhanh = cbx_DiaChi.getSelectedItem()+"";
		int status = (cbx_TrangThai.getSelectedItem()+"").equals("Bình thường")?1:0;
		String phone = textField_Sdt.getText();
		String fullName = textField_HoVaTen.getText();
		String cbx_Vaitro = cbx_VaiTro.getSelectedItem()+"";
		Branch branch = null;
		if(password.equals("") || email.equals("")){
			JOptionPane.showMessageDialog(this,"Vui lòng nhập đầy đủ thông tin !");
			return;
		}
		if(chiNhanh==null){
			branch = getBranchSelected(chiNhanh);
			user_Selected.setMaChiNhanh(branch.getMaChiNhanh());
		}
		user_Selected.setPassword(password);
		user_Selected.setFullName(fullName);
		user_Selected.setEmail(email);
		user_Selected.setPhone(phone);
		user_Selected.setStatus(status);
		UserDAO.getInstance().update(user_Selected);
	}
	public Branch getBranchSelected(String description){
		System.out.println("description "+description);
		String [] data = description.split(" - ");
		System.out.println("diachi "+data[1]);
		return BrandDAO.getInstance().BranchByDiaChi(data[1]);
	}
}
