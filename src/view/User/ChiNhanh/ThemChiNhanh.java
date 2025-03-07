package view.User.ChiNhanh;

import DAO.BrandDAO;
import DAO.ProducersDAO;
import controller.ValueAddress;
import model.Branch;
import model.Producer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ThemChiNhanh extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JComboBox cbx_Phuong;
	private JPanel contentPane;
	private JTextField input_SDT;
	private JComboBox cbx_ThanhPho;
	private JTextField input_SoNha;
	private JComboBox cbx_Quan;
	private ChiNhanhForm chiNhanhForm;
	private JTextField textField_tenChiNhanh;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ThemChiNhanh(ChiNhanhForm chiNhanhForm) {
		this.chiNhanhForm=chiNhanhForm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 388, 948);
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
		
		JLabel lblThmNhCung = new JLabel("THÊM CHI NHÁNH");
		lblThmNhCung.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmNhCung.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThmNhCung.setBounds(0, 0, 372, 49);
		panel.add(lblThmNhCung);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 80, 116, 28);
		contentPane.add(lblNewLabel_1_1);
		
		input_SDT = new JTextField();
		input_SDT.setColumns(10);
		input_SDT.setBounds(10, 118, 328, 28);
		contentPane.add(input_SDT);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Thành phố");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 168, 116, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
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
		btn_ThemSanPham.setBounds(10, 842, 131, 41);
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
		btnNewButton_2_1_1.setBounds(199, 842, 139, 41);
		contentPane.add(btnNewButton_2_1_1);

		cbx_ThanhPho = new JComboBox();
		cbx_ThanhPho.setBounds(10, 206, 328, 28);
		contentPane.add(cbx_ThanhPho);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Quận / Huyện");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 274, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		cbx_Quan = new JComboBox();
		cbx_Quan.setBounds(10, 322, 328, 28);
		contentPane.add(cbx_Quan);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Phường / Xã");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 388, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		cbx_Phuong = new JComboBox();
		cbx_Phuong.setBounds(10, 437, 328, 28);
		contentPane.add(cbx_Phuong);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Số nhà");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(10, 505, 116, 28);
		contentPane.add(lblNewLabel_1_1_2);
		
		input_SoNha = new JTextField();
		input_SoNha.setColumns(10);
		input_SoNha.setBounds(10, 533, 328, 28);
		contentPane.add(input_SoNha);

		ValueAddress.getInstance().loadQuanHuyen(cbx_ThanhPho,cbx_Quan,cbx_Phuong);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tên chi nhánh");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1.setBounds(10, 595, 116, 28);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		textField_tenChiNhanh = new JTextField();
		textField_tenChiNhanh.setColumns(10);
		textField_tenChiNhanh.setBounds(10, 625, 328, 28);
		contentPane.add(textField_tenChiNhanh);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Mô tả");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1.setBounds(10, 675, 116, 28);
		contentPane.add(lblNewLabel_1_1_2_1_1);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 714, 328, 109);
		contentPane.add(textArea);
	}
	public boolean isValidNumberPhone(String numberPhone){
		ArrayList<Branch>branches = BrandDAO.getInstance().selectAll();
		for(Branch branch : branches){
			if(branch.getSoDienThoai().equals(numberPhone)){
				return  true;
			}
		}
		return false;
	}
	private void ThemNhaCungCapMouseClicked() {
		try {
			String SDT = input_SDT.getText().trim();
			String diaChi = ValueAddress.getValueAddressFrame(this, cbx_ThanhPho, cbx_Quan, cbx_Phuong, input_SoNha);
			if (SDT.isEmpty() || diaChi.equals("N/A")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
				return;
			}else {
				if(isValidNumberPhone(SDT)){
					JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!");
					return;
				}
			}
			String tenQuan = cbx_Quan.getSelectedItem()+"";
			String thanhPho = cbx_ThanhPho.getSelectedItem()+"";
			String moTa = textArea.getText();
			String tenChiNhanh = textField_tenChiNhanh.getText();
			Branch branch = new Branch(diaChi, 0, SDT,tenChiNhanh,tenQuan,thanhPho,moTa);
			BrandDAO.getInstance().insert(branch);
			JOptionPane.showMessageDialog(this, "Thêm chi nhánh thành công!");
			dispose();
			chiNhanhForm.updateTableDataFormDAO();
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Lỗi khi thêm chi nhánh!");
		}

	}
}
