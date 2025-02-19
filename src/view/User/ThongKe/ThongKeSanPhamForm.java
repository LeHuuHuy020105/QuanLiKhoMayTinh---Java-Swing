package view.User.ThongKe;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ThongKeSanPhamForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ThongKeSanPhamForm() {
		setLayout(null);
		setSize(1247, 678);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 188, 1223, 490);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã máy", "Tên máy", "Số lượng nhập", "Số lượng xuất"
			}
		));
		scrollPane.setViewportView(table);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1.setBounds(0, 0, 518, 75);
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
		textField.setBounds(156, 11, 325, 30);
		panel_5_1_1.add(textField);
		
		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_1.setBounds(555, 0, 682, 75);
		add(verticalBox_1_1);
		
		JPanel panel_5_1_1_1 = new JPanel();
		panel_5_1_1_1.setLayout(null);
		verticalBox_1_1.add(panel_5_1_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(87, 11, 165, 30);
		panel_5_1_1_1.add(dateChooser);
		
		JLabel lblNewLabel_5 = new JLabel("Từ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(50, 11, 32, 30);
		panel_5_1_1_1.add(lblNewLabel_5);
		
		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbln.setBounds(308, 11, 32, 30);
		panel_5_1_1_1.add(lbln);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(369, 11, 165, 30);
		panel_5_1_1_1.add(dateChooser_1);
		
		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(546, 11, 114, 30);
		panel_5_1_1_1.add(btnNewButton_1);
		
		Box verticalBox_1_2 = Box.createVerticalBox();
		verticalBox_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1EAFp x\u1EBFp", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_2.setBounds(384, 100, 312, 75);
		add(verticalBox_1_2);
		
		JPanel panel_5_1_1_2 = new JPanel();
		panel_5_1_1_2.setLayout(null);
		verticalBox_1_2.add(panel_5_1_1_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(UIManager.getColor("Button.background"));
		comboBox_1.setBounds(10, 11, 126, 30);
		panel_5_1_1_2.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBackground(UIManager.getColor("Button.background"));
		comboBox_1_1.setBounds(158, 11, 126, 30);
		panel_5_1_1_2.add(comboBox_1_1);

	}
}
