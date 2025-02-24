package view.User.SanPham;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAO.CountryDAO;
import DAO.LaptopDAO;
import DAO.PCDAO;
import DAO.ProducersDAO;
import model.Computer;
import model.Country;
import model.Laptop;
import model.PC;
import model.Producer;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.util.List;

public class SuaSanPhamForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private SanPhamForm sanPhamForm;
	private JLabel label_IDproduct;
	private JPanel contentPane;
	private JTextField input_tenSanPham;
	private JTextField input_gia;
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
	private JComboBox cbx_xuatXu;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SuaSanPhamForm(SanPhamForm sanPhamForm) {
		this.sanPhamForm = sanPhamForm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1175, 578);
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
		
		JLabel lblNewLabel = new JLabel("SỬA SẢN PHẨM");
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
		comboBox_loaiSanPham.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxLoaiSanPhamMouseClicked();
			}
		});

	
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
		
		JButton btnNewButton_2_1 = new JButton("Lưu");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LuuSanPhamMouseClicked();
			}
		});
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setIcon(null);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1.setBackground(new Color(60, 179, 113));
		btnNewButton_2_1.setBounds(379, 426, 139, 41);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Huỷ bỏ");
		btnNewButton_2_1_1.setIcon(null);
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1_1.setBorderPainted(false);
		btnNewButton_2_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_2_1_1.setBounds(611, 426, 139, 41);
		contentPane.add(btnNewButton_2_1_1);
		
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
		
		ArrayList<Country>list_country = CountryDAO.getInstance().selectAll();
		cbx_xuatXu = new JComboBox();
		cbx_xuatXu.setBounds(10, 285, 202, 25);
		contentPane.add(cbx_xuatXu);
		JTextField textField = (JTextField) cbx_xuatXu.getEditor().getEditorComponent();
		textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = textField.getText().toLowerCase();
                cbx_xuatXu.removeAllItems();

                for (Country country : list_country) {
                    if (country.getTenQuocGia().toLowerCase().contains(input)) {
						cbx_xuatXu.addItem(country.getTenQuocGia());
                    }
                }
                textField.setText(input);
				cbx_xuatXu.showPopup(); // Hiển thị danh sách gợi ý
            }
        });
		hienThiThongTinSanPham();
	}
	public void resetCBXLoaiSanPham() {
		input_congSuatNguon.setEditable(true);
		input_mainBoard.setEditable(true);
		
		input_kichThuocMan.setEditable(true);
		input_dungLuongPin.setEditable(true);
		
	}
	public void cbxLoaiSanPhamMouseClicked() {
		if(comboBox_loaiSanPham.getSelectedItem().equals("Laptop")) {
			resetCBXLoaiSanPham();
			int soLuongLaptop = LaptopDAO.getInstance().selectAll().size();
			input_congSuatNguon.setEditable(false);
			input_mainBoard.setEditable(false);
		}
		else if (comboBox_loaiSanPham.getSelectedItem().equals("PC")) {
			resetCBXLoaiSanPham();
			int soLuongPC = PCDAO.getInstance().selectAll().size();
			input_kichThuocMan.setEditable(false);
			input_dungLuongPin.setEditable(false);
		}
	}
	public void hienThiThongTinSanPham(){
		Computer computer_Selected = sanPhamForm.getComputerSelected();
		System.out.println(computer_Selected);
		label_IDproduct.setText(computer_Selected.getMaMay()+"");
		input_tenSanPham.setText(computer_Selected.getTenMay());
		input_gia.setText(computer_Selected.getGia()+"");
		input_CPU.setText(computer_Selected.getTenCpu());
		input_RAM.setText(computer_Selected.getRam());
		input_cardDoHoa.setText(computer_Selected.getCardManHinh());
		input_ROM.setText(computer_Selected.getRom());
		input_dungLuongLuuTru.setText(computer_Selected.getDungLuongLuuTru()+"");
		System.out.println("manhacungcap"+computer_Selected.getMaNhaCungCap());
		comboBox_nhaCungCap.setSelectedItem(computer_Selected.getMaNhaCungCap());
		System.out.println("ma may: "+ computer_Selected.getMaMay());
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
		cbxLoaiSanPhamMouseClicked();
	}
	public void LuuSanPhamMouseClicked() {
		boolean hasError = false;

		String cbxLoaiSanPham = comboBox_loaiSanPham.getSelectedItem().toString();
		String tenMay = input_tenSanPham.getText().trim();
		String CPU = input_CPU.getText().trim();
		String RAM = input_RAM.getText().trim();
		String ROM = input_ROM.getText().trim();
		String cardManHinh = input_cardDoHoa.getText().trim();
		double dungLuongLuuTru = Double.parseDouble(input_dungLuongLuuTru.getText().trim());
		String xuatXu =  (String) cbx_xuatXu.getSelectedItem();
		String maNhaCungCap = (String) comboBox_nhaCungCap.getSelectedItem();

		double gia = 0, kichThuocMan = 0;
		dungLuongLuuTru = 0;
		int congSuatNguon = 0;

		// Kiểm tra tên sản phẩm
		if (tenMay.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm!");
			hasError = true;
		}

		// Kiểm tra giá (double)
		try {
			gia = Double.parseDouble(input_gia.getText().trim());
			if (gia <= 0) throw new NumberFormatException();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn giá hợp lệ (số dương)!");
			hasError = true;
		}

		// Kiểm tra dung lượng lưu trữ (double)
		try {
			if (dungLuongLuuTru <= 0) throw new NumberFormatException();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập dung lượng lưu trữ hợp lệ (số dương)!");
			hasError = true;
		}

		if (cbxLoaiSanPham.equals("Laptop")) {
			String dungLuongPin = input_dungLuongPin.getText().trim();

			// Kiểm tra kích thước màn (double)
			try {
				kichThuocMan = Double.parseDouble(input_kichThuocMan.getText().trim());
				if (kichThuocMan <= 0) throw new NumberFormatException();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập kích thước màn hợp lệ (số dương)!");
				hasError = true;
			}

			// Kiểm tra các trường khác
			if (dungLuongPin.isEmpty() || cardManHinh.isEmpty() || RAM.isEmpty() || ROM.isEmpty() || CPU.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin cho Laptop!");
				hasError = true;
			}

			// Nếu có lỗi, dừng lại ngay
			if (hasError) return;

			// Nếu hợp lệ, thêm Laptop
			Laptop laptop_update = new Laptop(cardManHinh, gia, 0, RAM, ROM, 0, CPU, tenMay, xuatXu, dungLuongPin, kichThuocMan, maNhaCungCap, dungLuongLuuTru);
			try {
				LaptopDAO.getInstance().update(laptop_update);
				this.dispose();
				JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm Laptop thành công!");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else { // Nếu là PC
			String mainBoard = input_mainBoard.getText().trim();

			// Kiểm tra công suất nguồn (int)
			try {
				congSuatNguon = Integer.parseInt(input_congSuatNguon.getText().trim());
				if (congSuatNguon <= 0) throw new NumberFormatException();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập công suất nguồn hợp lệ (số dương)!");
				hasError = true;
			}

			// Kiểm tra các trường khác
			if (mainBoard.isEmpty() || cardManHinh.isEmpty() || RAM.isEmpty() || ROM.isEmpty() || CPU.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin cho PC!");
				hasError = true;
			}

			// Nếu có lỗi, dừng lại ngay
			if (hasError) return;

			// Nếu hợp lệ, thêm PC
			PC pc_update = new PC(cardManHinh, gia, 0, RAM, ROM, 0, CPU, tenMay, xuatXu, congSuatNguon, mainBoard, maNhaCungCap, dungLuongLuuTru);
			try {
				PCDAO.getInstance().update(pc_update);
				this.dispose();
				JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm PC thành công!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.sanPhamForm.updateTableDataFormDAO();
	}

	public void closeWindow() {
		this.dispose();
	}
}
