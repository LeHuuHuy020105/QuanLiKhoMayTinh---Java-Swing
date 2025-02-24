package view.User.SanPham;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAO.CountryDAO;
import DAO.LaptopDAO;
import DAO.PCDAO;
import DAO.ProducersDAO;
import model.*;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.List;

public class ChiTietSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private SanPhamForm sanPhamForm;
	private JLabel label_IDproduct;
	private JPanel contentPane;
	private JTextField input_tenSanPham;
	private JTextField input_gia;
	private JTextField input_xuatXu;
	private JTextField input_CPU;
	private JTextField input_RAM;
	private JTextField input_dungLuongLuuTru;
	private JTextField input_cardDoHoa;
	private JTextField input_kichThuocMan;
	private JTextField input_dungLuongPin;
	private JTextField input_mainBoard;
	private JTextField input_congSuatNguon;
	private JComboBox comboBox_loaiSanPham;
	private JTextField input_ROM;
	private JComboBox comboBox_nhaCungCap;
	private JSpinner spinner_soLuong;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChiTietSanPham(SanPhamForm sanPhamForm) {
		this.sanPhamForm = sanPhamForm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1175, 489);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1159, 49);
		panel.setBackground(new Color(144,238,144));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT SẢN PHẨM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 1159, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 60, 116, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 99, 116, 28);
		contentPane.add(lblNewLabel_1_1);
		
		input_tenSanPham = new JTextField();
		input_tenSanPham.setColumns(10);
		input_tenSanPham.setBounds(10, 138, 202, 28);
		contentPane.add(input_tenSanPham);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Đơn giá");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 177, 116, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		input_gia = new JTextField();
		input_gia.setColumns(10);
		input_gia.setBounds(10, 207, 202, 28);
		contentPane.add(input_gia);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Xuất xứ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 246, 116, 28);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		input_xuatXu = new JTextField();
		input_xuatXu.setColumns(10);
		input_xuatXu.setBounds(10, 282, 202, 28);
		contentPane.add(input_xuatXu);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPU");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(316, 102, 116, 28);
		contentPane.add(lblNewLabel_1_2);
		
		input_CPU = new JTextField();
		input_CPU.setColumns(10);
		input_CPU.setBounds(316, 135, 202, 28);
		contentPane.add(input_CPU);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("RAM");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(316, 174, 116, 28);
		contentPane.add(lblNewLabel_1_2_1);
		
		input_RAM = new JTextField();
		input_RAM.setColumns(10);
		input_RAM.setBounds(316, 207, 202, 28);
		contentPane.add(input_RAM);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Dung lượng lưu trữ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(316, 246, 159, 28);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		input_dungLuongLuuTru = new JTextField();
		input_dungLuongLuuTru.setColumns(10);
		input_dungLuongLuuTru.setBounds(316, 282, 202, 28);
		contentPane.add(input_dungLuongLuuTru);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Card màn hình");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1_1.setBounds(316, 321, 116, 28);
		contentPane.add(lblNewLabel_1_2_1_1_1);
		
		input_cardDoHoa = new JTextField();
		input_cardDoHoa.setColumns(10);
		input_cardDoHoa.setBounds(316, 354, 202, 28);
		contentPane.add(input_cardDoHoa);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Loại sản phẩm");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(612, 102, 116, 28);
		contentPane.add(lblNewLabel_1_2_2);

		String [] cbxLoaiSPS = new String [] {"Laptop","PC"};
		comboBox_loaiSanPham = new JComboBox(cbxLoaiSPS);
		

	
		comboBox_loaiSanPham.setBounds(612, 138, 202, 28);
		contentPane.add(comboBox_loaiSanPham);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Khích thước màn");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_1.setBounds(612, 174, 172, 28);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		input_kichThuocMan = new JTextField();
		input_kichThuocMan.setColumns(10);
		input_kichThuocMan.setBounds(612, 211, 202, 28);
		contentPane.add(input_kichThuocMan);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Dung lượng pin");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_1_1.setBounds(612, 246, 116, 28);
		contentPane.add(lblNewLabel_1_2_2_1_1);
		
		input_dungLuongPin = new JTextField();
		input_dungLuongPin.setColumns(10);
		input_dungLuongPin.setBounds(612, 282, 202, 28);
		contentPane.add(input_dungLuongPin);
		
		JLabel lblNewLabel_1_2_2_1_2 = new JLabel("MainBoard");
		lblNewLabel_1_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_1_2.setBounds(612, 321, 172, 28);
		contentPane.add(lblNewLabel_1_2_2_1_2);
		
		input_mainBoard = new JTextField();
		input_mainBoard.setColumns(10);
		input_mainBoard.setBounds(612, 358, 202, 28);
		contentPane.add(input_mainBoard);
		
		JLabel lblNewLabel_1_2_2_1_2_1 = new JLabel("Công xuất nguồn");
		lblNewLabel_1_2_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_1_2_1.setBounds(10, 321, 172, 28);
		contentPane.add(lblNewLabel_1_2_2_1_2_1);
		
		input_congSuatNguon = new JTextField();
		input_congSuatNguon.setColumns(10);
		input_congSuatNguon.setBounds(10, 354, 202, 28);
		contentPane.add(input_congSuatNguon);
		
		label_IDproduct = new JLabel("");
		label_IDproduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_IDproduct.setBounds(147, 60, 94, 28);
		contentPane.add(label_IDproduct);
		
		JLabel lblNewLabel_1_2_2_1_3 = new JLabel("ROM");
		lblNewLabel_1_2_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_1_3.setBounds(888, 99, 172, 28);
		contentPane.add(lblNewLabel_1_2_2_1_3);
		
		input_ROM = new JTextField();
		input_ROM.setColumns(10);
		input_ROM.setBounds(888, 135, 202, 28);
		contentPane.add(input_ROM);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("Loại sản phẩm");
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_2.setBounds(888, 174, 116, 28);
		contentPane.add(lblNewLabel_1_2_2_2);
		
		ArrayList<Producer>producers = ProducersDAO.getInstance().selectAll();
		comboBox_nhaCungCap = new JComboBox();
		for(Producer producer : producers){
			comboBox_nhaCungCap.addItem(producer.getMaNhaCungCap());
		}
		comboBox_nhaCungCap.setBounds(888, 210, 202, 28);
		contentPane.add(comboBox_nhaCungCap);
		
		JLabel lblNewLabel_1_2_2_2_1 = new JLabel("Loại sản phẩm");
		lblNewLabel_1_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_2_1.setBounds(888, 270, 116, 28);
		contentPane.add(lblNewLabel_1_2_2_2_1);
		
		spinner_soLuong = new JSpinner();
		spinner_soLuong.setBounds(1014, 270, 110, 28);
		contentPane.add(spinner_soLuong);
		hienThiThongTinSanPham();
	}
	public void notAllowEdit() {
		input_tenSanPham.setEditable(false);
		input_congSuatNguon.setEditable(false);
		input_mainBoard.setEditable(false);
		input_kichThuocMan.setEditable(false);
		input_dungLuongPin.setEditable(false);
		input_gia.setEditable(false);
		input_CPU.setEditable(false);
		input_cardDoHoa.setEditable(false);
		input_dungLuongLuuTru.setEditable(false);
		input_RAM.setEditable(false);
		input_ROM.setEditable(false);
		input_xuatXu.setEditable(false);
		comboBox_loaiSanPham.setEnabled(false);
		comboBox_nhaCungCap.setEnabled(false);
		spinner_soLuong.setEnabled(false);
	}
	public void hienThiThongTinSanPham(){
		Computer computer_Selected = sanPhamForm.getComputerSelected();
		label_IDproduct.setText(computer_Selected.getMaMay()+"");
		input_tenSanPham.setText(computer_Selected.getTenMay());
		input_gia.setText(computer_Selected.getGia()+"");
		Country country_selected = CountryDAO.getInstance().CountryByID(computer_Selected.getXuatXu());
		input_xuatXu.setText(country_selected.getTenQuocGia());
		input_CPU.setText(computer_Selected.getTenCpu());
		input_RAM.setText(computer_Selected.getRam());
		input_cardDoHoa.setText(computer_Selected.getCardManHinh());
		input_ROM.setText(computer_Selected.getRom());
		input_dungLuongLuuTru.setText(computer_Selected.getDungLuongLuuTru()+"");
		comboBox_nhaCungCap.setSelectedItem(computer_Selected.getMaNhaCungCap());
		spinner_soLuong.setValue(computer_Selected.getSoLuong());
		String loaiMay ="";
		if(computer_Selected instanceof Laptop){
			Laptop laptop_selected = (Laptop)computer_Selected;
			loaiMay = "Laptop";
			input_kichThuocMan.setText(laptop_selected.getKichThuocMan()+"");
			input_dungLuongPin.setText(laptop_selected.getDungLuongPin());
		}else{
			PC pc_selected = (PC)computer_Selected;
			loaiMay = "PC";
			input_congSuatNguon.setText(pc_selected.getCongSuatNguon()+"");
			input_mainBoard.setText(pc_selected.getMainBoard());
		}
		comboBox_loaiSanPham.setSelectedItem(loaiMay);
		notAllowEdit();
	}

	public void closeWindow() {
		this.dispose();
	}
}
