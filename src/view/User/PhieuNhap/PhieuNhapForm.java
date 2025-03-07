package view.User.PhieuNhap;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import DAO.ImportProductsDAO;
import DAO.UserDAO;
import com.toedter.calendar.JDateChooser;
import controller.updateDataToTable;
import model.ImportProducts;
import model.User;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PhieuNhapForm extends JPanel implements updateDataToTable<ImportProducts> {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_importProducts;

	/**
	 * Create the panel.
	 */
	public PhieuNhapForm() {
		setLayout(null);
		setSize(1257,718);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(

		                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

		                "Chức năng",

		                TitledBorder.LEADING,

		                TitledBorder.TOP,

		                new Font("Tahoma", Font.BOLD, 12),  // Đã sửa null thành Font.BOLD

		                new Color(0, 0, 0)  // Màu chữ đen

		        ));
		verticalBox.setBounds(10, 11, 533, 75);
		add(verticalBox);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		verticalBox.add(panel_5_1);
		
		JButton btn_Xoa = new JButton("Xoá");
		btn_Xoa.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn_Xoa.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\delete.png"));
		btn_Xoa.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Xoa.setFocusPainted(false);
		btn_Xoa.setContentAreaFilled(false);
		btn_Xoa.setBorderPainted(false);
		btn_Xoa.setBackground(UIManager.getColor("Button.background"));
		btn_Xoa.setBounds(10, 0, 70, 52);
		panel_5_1.add(btn_Xoa);
		
		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChiTietMouseClicked();
			}
		});
		btnXemChiTiet.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXemChiTiet.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\eye.png"));
		btnXemChiTiet.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXemChiTiet.setFocusPainted(false);
		btnXemChiTiet.setContentAreaFilled(false);
		btnXemChiTiet.setBorderPainted(false);
		btnXemChiTiet.setBackground(UIManager.getColor("Button.background"));
		btnXemChiTiet.setBounds(170, 0, 107, 52);
		panel_5_1.add(btnXemChiTiet);
		
		JButton btnXuatExcel = new JButton("Xuất Excel");
		btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXuatExcel.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\xuatexcel.png"));
		btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXuatExcel.setFocusPainted(false);
		btnXuatExcel.setContentAreaFilled(false);
		btnXuatExcel.setBorderPainted(false);
		btnXuatExcel.setBackground(UIManager.getColor("Button.background"));
		btnXuatExcel.setBounds(409, 0, 99, 52);
		panel_5_1.add(btnXuatExcel);
		
		JButton btnNhapExcel = new JButton("Nhập Excel");
		btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNhapExcel.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\nhapexcel.png"));
		btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhapExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNhapExcel.setFocusPainted(false);
		btnNhapExcel.setContentAreaFilled(false);
		btnNhapExcel.setBorderPainted(false);
		btnNhapExcel.setBackground(UIManager.getColor("Button.background"));
		btnNhapExcel.setBounds(287, 0, 98, 52);
		panel_5_1.add(btnNhapExcel);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSua.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\edit.png"));
		btnSua.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setFocusPainted(false);
		btnSua.setContentAreaFilled(false);
		btnSua.setBorderPainted(false);
		btnSua.setBackground(UIManager.getColor("Button.background"));
		btnSua.setBounds(90, 0, 70, 52);
		panel_5_1.add(btnSua);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1.setBounds(575, 11, 682, 75);
		add(verticalBox_1);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		verticalBox_1.add(panel_5_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("Button.background"));
		comboBox.setBounds(10, 11, 126, 30);
		panel_5_1_1.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(156, 11, 366, 30);
		panel_5_1_1.add(textField);
		
		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(532, 9, 128, 30);
		panel_5_1_1.add(btnNewButton_1);
		
		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_1.setBounds(10, 107, 682, 75);
		add(verticalBox_1_1);
		
		JPanel panel_5_1_1_1 = new JPanel();
		panel_5_1_1_1.setLayout(null);
		verticalBox_1_1.add(panel_5_1_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(87, 11, 165, 30);
		panel_5_1_1_1.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Từ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 11, 32, 30);
		panel_5_1_1_1.add(lblNewLabel);
		
		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbln.setBounds(397, 11, 32, 30);
		panel_5_1_1_1.add(lbln);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(435, 11, 165, 30);
		panel_5_1_1_1.add(dateChooser_1);
		
		Box verticalBox_1_2 = Box.createVerticalBox();
		verticalBox_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lọc theo giá", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_2.setBounds(714, 107, 533, 75);
		add(verticalBox_1_2);
		
		JPanel panel_5_1_1_2 = new JPanel();
		verticalBox_1_2.add(panel_5_1_1_2);
		panel_5_1_1_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Từ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 32, 30);
		panel_5_1_1_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(52, 11, 177, 30);
		panel_5_1_1_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đến");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(282, 11, 32, 30);
		panel_5_1_1_2.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(324, 13, 177, 30);
		panel_5_1_1_2.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 1247, 524);
		add(scrollPane);
		
		table_importProducts = new JTable();
		table_importProducts.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã phiếu nhập", "Người tạo","Vai trò","Thời gian tạo", "Tổng tiền"
			}
		));
		scrollPane.setViewportView(table_importProducts);
		updateTableDataFormDAO();
	}

	@Override
	public void updateTableDataFormDAO() {
		ArrayList<ImportProducts> importProducts = ImportProductsDAO.getInstance().selectAll();
		updateTableData(importProducts);
	}

	@Override
	public void updateTableData(ArrayList<ImportProducts> t) {
		DecimalFormat df = new DecimalFormat("#,###");
		DefaultTableModel model = (DefaultTableModel) table_importProducts.getModel();
		model.setRowCount(0);
		int i=0;
		for(ImportProducts importProducts: t){
			User user = UserDAO.getInstance().getUsetById(importProducts.getManguoidung());
			String tenNguoitao = user.getFullName();
			String role = UserDAO.getInstance().getRoleByIDUser(user.getIdUser());
			i++;
			model.addRow(new Object[]{
					i,
					importProducts.getMaphieunhap(),
					tenNguoitao,
					role,
					importProducts.getTimestamp(),
					df.format(importProducts.getTongTien())+"VND",
			});
		}
	}
	public ImportProducts getImportProductsSelected(){
		ImportProducts importProducts =null;
		DefaultTableModel model = (DefaultTableModel) table_importProducts.getModel();
		int i_row = table_importProducts.getSelectedRow();
		if(i_row==-1){
			JOptionPane.showMessageDialog(this,"Vui lòng chọn phiếu nhập");
			return null;
		}
		int maPhieuNhap = Integer.parseInt(model.getValueAt(i_row,1)+"");
		importProducts = ImportProductsDAO.getInstance().getImportProductsByMaPhieuNhap(maPhieuNhap);
		return importProducts;
	}
	public void ChiTietMouseClicked() {
		ChiTietPhieuNhapForm chiTietPhieuNhapForm = new ChiTietPhieuNhapForm(this);
		chiTietPhieuNhapForm.setVisible(true);
	}
}
