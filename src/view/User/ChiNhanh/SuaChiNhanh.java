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

public class SuaChiNhanh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox cbx_Quan;
	private JComboBox cbx_ThanhPho;
	private JPanel contentPane;
	private JTextField input_MaCN;
	private JTextField input_SDT;
	private ChiNhanhForm chiNhanhForm;
	private JTextField input_SoNha;
	private JComboBox cbx_Phuong;
	private JTextField textField_tenChiNhanh;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SuaChiNhanh(ChiNhanhForm chiNhanhForm) {
		this.chiNhanhForm = chiNhanhForm;
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
		
		JLabel lblThmNhCung = new JLabel("SỬA CHI NHÁNH");
		lblThmNhCung.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmNhCung.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThmNhCung.setBounds(0, 0, 372, 49);
		panel.add(lblThmNhCung);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhà cung cấp");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 79, 169, 28);
		contentPane.add(lblNewLabel_1);
		
		input_MaCN = new JTextField();
		input_MaCN.setColumns(10);
		input_MaCN.setBounds(10, 118, 328, 28);
		contentPane.add(input_MaCN);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 163, 116, 28);
		contentPane.add(lblNewLabel_1_1);
		
		input_SDT = new JTextField();
		input_SDT.setColumns(10);
		input_SDT.setBounds(10, 202, 328, 28);
		contentPane.add(input_SDT);
		
		JButton btn_Lưu = new JButton("Lưu");
		btn_Lưu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Lưu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LuuNhaCungCapMouseClick();
			}
		});
		btn_Lưu.setIcon(null);
		btn_Lưu.setForeground(Color.WHITE);
		btn_Lưu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Lưu.setBorderPainted(false);
		btn_Lưu.setBackground(new Color(60, 179, 113));
		btn_Lưu.setBounds(10, 857, 131, 41);
		contentPane.add(btn_Lưu);
		
		JButton btn_HuyBo = new JButton("Huỷ bỏ");
		btn_HuyBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HuyBoMouseClicked();
			}
		});
		btn_HuyBo.setIcon(null);
		btn_HuyBo.setForeground(Color.WHITE);
		btn_HuyBo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_HuyBo.setBorderPainted(false);
		btn_HuyBo.setBackground(Color.RED);
		btn_HuyBo.setBounds(199, 857, 139, 41);
		contentPane.add(btn_HuyBo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Thành phố");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 258, 116, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		cbx_ThanhPho = new JComboBox();
		cbx_ThanhPho.setBounds(10, 297, 321, 28);
		contentPane.add(cbx_ThanhPho);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Quận / Huyện");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 346, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		cbx_Quan = new JComboBox();
		cbx_Quan.setBounds(10, 396, 321, 28);
		contentPane.add(cbx_Quan);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Số nhà");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(10, 534, 116, 28);
		contentPane.add(lblNewLabel_1_1_2);
		
		input_SoNha = new JTextField();
		input_SoNha.setColumns(10);
		input_SoNha.setBounds(10, 573, 328, 28);
		contentPane.add(input_SoNha);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Phường");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 445, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		cbx_Phuong = new JComboBox();
		cbx_Phuong.setBounds(10, 484, 321, 28);
		contentPane.add(cbx_Phuong);
		ValueAddress.getInstance().loadQuanHuyen(cbx_ThanhPho,cbx_Quan,cbx_Phuong);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tên chi nhánh");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1.setBounds(10, 618, 116, 28);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		textField_tenChiNhanh = new JTextField();
		textField_tenChiNhanh.setColumns(10);
		textField_tenChiNhanh.setBounds(10, 657, 328, 28);
		contentPane.add(textField_tenChiNhanh);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Mô tả");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1.setBounds(10, 704, 116, 28);
		contentPane.add(lblNewLabel_1_1_2_1_1);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 743, 328, 103);
		contentPane.add(textArea);
		hienThiThongTinSanPham();
	}
	public void hienThiThongTinSanPham(){
		Branch branch_selected = chiNhanhForm.getChiNhanhSelected();
		input_MaCN.setText(branch_selected.getMaChiNhanh()+"");
		input_MaCN.setEditable(false);
		input_SDT.setText(branch_selected.getSoDienThoai());
		String diaChi = branch_selected.getDiaChi();
		ValueAddress.updateValueAddressToCombobox(diaChi,cbx_ThanhPho,cbx_Quan,cbx_Phuong,input_SoNha);
		textArea.setText(branch_selected.getMoTa());
		textField_tenChiNhanh.setText(branch_selected.getTenChiNhanh());
	}
	public void LuuNhaCungCapMouseClick(){
		int maCN = chiNhanhForm.getChiNhanhSelected().getMaChiNhanh();
		boolean hasError = false;
		String SDT = input_SDT.getText().trim();
		if(SDT.isEmpty()){
			JOptionPane.showMessageDialog(this,"Vui lòng nhập số điện thoại!");
			hasError = true;
		}
		if(hasError)return;
		String tenQuan = cbx_Quan.getSelectedItem()+"";
		String thanhPho = cbx_ThanhPho.getSelectedItem()+"";
		String moTa = textArea.getText();
		String tenChiNhanh = textField_tenChiNhanh.getText();
		String diaChi = ValueAddress.getValueAddressFrame(this,cbx_ThanhPho,cbx_Quan,cbx_Phuong,input_SoNha);
		Branch branch = new Branch(diaChi,maCN,SDT,tenChiNhanh,tenQuan,thanhPho,moTa);
		try {
			BrandDAO.getInstance().update(branch);
			this.dispose();
			JOptionPane.showMessageDialog(this,"Cập nhật chi nhánh thành công !");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	public void HuyBoMouseClicked() {
		this.dispose();
	}
}
