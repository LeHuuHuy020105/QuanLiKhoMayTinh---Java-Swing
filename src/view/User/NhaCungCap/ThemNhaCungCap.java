package view.User.NhaCungCap;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Address.ProvinceDAO;
import DAO.CountryDAO;
import DAO.ProducersDAO;
import controller.ValueAddress;
import controller.updateDataToTable;
import model.Address.Province;
import model.Country;
import model.Producer;
import view.User.SanPham.ThemSanPham;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

public class ThemNhaCungCap extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JComboBox cbx_Phuong;
	private JPanel contentPane;
	private JTextField input_TenNCC;
	private JTextField input_SDT;
	private JComboBox cbx_ThanhPho;
	private JTextField input_SoNha;
	private JComboBox cbx_Quan;
	private NhaCungCapForm nhaCungCapForm;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ThemNhaCungCap(NhaCungCapForm nhaCungCapForm) {
		this.nhaCungCapForm = nhaCungCapForm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 388, 720);
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

		JLabel lblThmNhCung = new JLabel("THÊM NHÀ CUNG CẤP");
		lblThmNhCung.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmNhCung.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThmNhCung.setBounds(0, 0, 372, 49);
		panel.add(lblThmNhCung);

		JLabel lblNewLabel_1 = new JLabel("Tên nhà cung cấp");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 112, 169, 28);
		contentPane.add(lblNewLabel_1);

		input_TenNCC = new JTextField();
		input_TenNCC.setColumns(10);
		input_TenNCC.setBounds(10, 140, 328, 28);
		contentPane.add(input_TenNCC);

		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 197, 116, 28);
		contentPane.add(lblNewLabel_1_1);

		input_SDT = new JTextField();
		input_SDT.setColumns(10);
		input_SDT.setBounds(10, 224, 328, 28);
		contentPane.add(input_SDT);

		JLabel lblNewLabel_1_1_1 = new JLabel("Thành phố");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 273, 116, 28);
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
		btn_ThemSanPham.setBounds(10, 611, 131, 41);
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
		btnNewButton_2_1_1.setBounds(199, 611, 139, 41);
		contentPane.add(btnNewButton_2_1_1);

		cbx_ThanhPho = new JComboBox();
		cbx_ThanhPho.setBounds(10, 300, 321, 28);
		contentPane.add(cbx_ThanhPho);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Quận / Huyện");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 350, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1);

		cbx_Quan = new JComboBox();
		cbx_Quan.setBounds(10, 377, 321, 28);
		contentPane.add(cbx_Quan);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Phường / Xã");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 426, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		cbx_Phuong = new JComboBox();
		cbx_Phuong.setBounds(10, 453, 321, 28);
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
	}

	private void ThemNhaCungCapMouseClicked() {
		try {
			String tenNCC = input_TenNCC.getText().trim();
			String SDT = input_SDT.getText().trim();
			String diaChi = ValueAddress.getValueAddressFrame(this, cbx_ThanhPho, cbx_Quan, cbx_Phuong, input_SoNha);
			if (tenNCC.isEmpty() || SDT.isEmpty() || input_SoNha.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
				return;
			}

			String maNCC = tenNCC.toUpperCase();
			Producer producer = new Producer(diaChi, maNCC, SDT, tenNCC);
			ProducersDAO.getInstance().insert(producer);
			JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công!");
			dispose();
			nhaCungCapForm.updateTableDataFormDAO();
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Lỗi khi thêm nhà cung cấp!");
		}
	}
}
