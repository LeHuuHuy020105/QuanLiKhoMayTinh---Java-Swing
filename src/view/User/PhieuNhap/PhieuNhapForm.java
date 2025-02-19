package view.User.PhieuNhap;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PhieuNhapForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PhieuNhapForm() {
		setLayout(null);
		setSize(1257,911);
		
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
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\add.png"));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(10, 0, 70, 52);
		panel_5_1.add(btnNewButton);
		
		JButton btnXemChiTiet = new JButton("Xem chi tiết");
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
		btnNewButton_1.setBounds(546, 9, 114, 30);
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
		scrollPane.setBounds(10, 216, 1247, 684);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã phiếu nhập", "Nhà cung cấp", "Người tạo", "Thời gian tạo", "Tổng tiền"
			}
		));
		scrollPane.setViewportView(table);
	}
}
