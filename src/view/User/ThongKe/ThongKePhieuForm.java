package view.User.ThongKe;

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

public class ThongKePhieuForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ThongKePhieuForm() {
		setLayout(null);
		setSize(1247, 504);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(


				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),


				"Chức năng",


				TitledBorder.LEADING,


				TitledBorder.TOP,


				new Font("Tahoma", Font.BOLD, 12),  // Đã sửa null thành Font.BOLD


				new Color(0, 0, 0)  // Màu chữ đen


		));
		verticalBox.setBounds(10, 11, 490, 75);
		add(verticalBox);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		verticalBox.add(panel_5_1);

		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXemChiTiet.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\eye.png"));
		btnXemChiTiet.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXemChiTiet.setFocusPainted(false);
		btnXemChiTiet.setContentAreaFilled(false);
		btnXemChiTiet.setBorderPainted(false);
		btnXemChiTiet.setBackground(UIManager.getColor("Button.background"));
		btnXemChiTiet.setBounds(10, 0, 107, 52);
		panel_5_1.add(btnXemChiTiet);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1.setBounds(555, 11, 682, 75);
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
		verticalBox_1_1.setBounds(10, 109, 682, 75);
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
		verticalBox_1_2.setBounds(702, 109, 533, 75);
		add(verticalBox_1_2);

		JPanel panel_5_1_1_2 = new JPanel();
		panel_5_1_1_2.setLayout(null);
		verticalBox_1_2.add(panel_5_1_1_2);

		JLabel lblNewLabel_1 = new JLabel("Từ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 32, 30);
		panel_5_1_1_2.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(52, 11, 177, 30);
		panel_5_1_1_2.add(textField_1);

		JLabel lblNewLabel_1_1 = new JLabel("Đến");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(282, 11, 32, 30);
		panel_5_1_1_2.add(lblNewLabel_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(324, 13, 177, 30);
		panel_5_1_1_2.add(textField_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 1227, 286);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã phiếu", "Người tạo", "Thời gian tạo", "Tổng tiền"
				}
		));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2_1 = new JLabel("Tổng phiếu :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(34, 526, 153, 41);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("65");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(197, 524, 161, 41);
		add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Tổng tiền :");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2.setBounds(738, 526, 124, 41);
		add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("140000000");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_1.setBounds(887, 524, 286, 41);
		add(lblNewLabel_2_1_1_1);
	}
}
