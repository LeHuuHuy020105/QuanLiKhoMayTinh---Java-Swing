package view.User.NhaCungCap;

import DAO.ProducersDAO;
import controller.ValueAddress;
import model.Producer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SuaNhaCungCap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox cbx_Quan;
	private JComboBox cbx_ThanhPho;
	private JPanel contentPane;
	private JTextField input_TenNCC;
	private JTextField input_SDT;
	private NhaCungCapForm nhaCungCapForm;
	private JTextField input_SoNha;
	private JComboBox cbx_Phuong;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SuaNhaCungCap(NhaCungCapForm nhaCungCapForm) {
		this.nhaCungCapForm = nhaCungCapForm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 388, 748);
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
		lblNewLabel_1.setBounds(10, 79, 169, 28);
		contentPane.add(lblNewLabel_1);
		
		input_TenNCC = new JTextField();
		input_TenNCC.setColumns(10);
		input_TenNCC.setBounds(10, 118, 328, 28);
		contentPane.add(input_TenNCC);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 163, 116, 28);
		contentPane.add(lblNewLabel_1_1);
		
		input_SDT = new JTextField();
		input_SDT.setColumns(10);
		input_SDT.setBounds(10, 202, 328, 28);
		contentPane.add(input_SDT);
		
		JButton btn_Them = new JButton("Thêm ");
		btn_Them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LuuNhaCungCapMouseClick();
			}
		});
		btn_Them.setIcon(null);
		btn_Them.setForeground(Color.WHITE);
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Them.setBorderPainted(false);
		btn_Them.setBackground(new Color(60, 179, 113));
		btn_Them.setBounds(10, 657, 131, 41);
		contentPane.add(btn_Them);
		
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
		btn_HuyBo.setBounds(199, 657, 139, 41);
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
		hienThiThongTinSanPham();
	}
	public void hienThiThongTinSanPham(){
		Producer producer_selected = nhaCungCapForm.getProducerSelected();
		input_TenNCC.setText(producer_selected.getTenNhaCungCap());
		input_SDT.setText(producer_selected.getSdt());
		String diaChi = producer_selected.getDiaChi();
		String[] dulieu_DiaChi = diaChi.split(",");
		String soNha = dulieu_DiaChi[0];
		String phuong = dulieu_DiaChi[1];
		String quan = dulieu_DiaChi[2];
		String thanhPho = dulieu_DiaChi[3];
		cbx_ThanhPho.setSelectedItem(thanhPho);
		cbx_Quan.setSelectedItem(quan);
		cbx_Phuong.setSelectedItem(phuong);
		input_SoNha.setText(soNha);
	}
	public void LuuNhaCungCapMouseClick(){
		boolean hasError = false;
		String tenNCC = input_TenNCC.getText().trim();
		String SDT = input_SDT.getText().trim();
		if(tenNCC.isEmpty()){
			JOptionPane.showMessageDialog(this,"Vui lòng nhập tên nhà cung cấp !");
			hasError = true;
		}
		if(SDT.isEmpty()){
			JOptionPane.showMessageDialog(this,"Vui lòng nhập số điện thoại!");
			hasError = true;
		}
		if(hasError)return;
		String maNCC = tenNCC.toUpperCase();
		String diaChi = ValueAddress.getValueAddressFrame(this,cbx_ThanhPho,cbx_Quan,cbx_Phuong,input_SoNha);
		Producer producer = new Producer(diaChi,maNCC,SDT,tenNCC);
		try {
			ProducersDAO.getInstance().update(producer);
			this.dispose();
			JOptionPane.showMessageDialog(this,"Cập nhật nhà cung cấp thành công !");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	public void HuyBoMouseClicked() {
		this.dispose();
	}
}
