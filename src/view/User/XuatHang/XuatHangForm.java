package view.User.XuatHang;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class XuatHangForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTextField textField_3;
	private JButton btnNewButton_2;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public XuatHangForm() {
		  setLayout(null);
	      setSize(1257, 911);
	      
	      Box verticalBox_1 = Box.createVerticalBox();
	      verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
	      verticalBox_1.setBounds(10, 11, 637, 75);
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
	      textField.setBounds(156, 11, 335, 30);
	      panel_5_1_1.add(textField);
	      
	      JButton btnNewButton_1 = new JButton("Làm mới");
	      btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
	      btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      btnNewButton_1.setBounds(501, 9, 114, 30);
	      panel_5_1_1.add(btnNewButton_1);
	      
	      JLabel lblNewLabel = new JLabel("Mã phiếu nhập");
	      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      lblNewLabel.setBounds(676, 34, 96, 27);
	      add(lblNewLabel);
	      
	      textField_1 = new JTextField();
	      textField_1.setBounds(834, 35, 381, 27);
	      add(textField_1);
	      textField_1.setColumns(10);
	      
	      JScrollPane scrollPane = new JScrollPane();
	      scrollPane.setBounds(10, 121, 637, 678);
	      add(scrollPane);
	      
	      table = new JTable();
	      table.setModel(new DefaultTableModel(
	      	new Object[][] {
	      	},
	      	new String[] {
	      		"STT","Mã máy", "Tên máy", "Số lượng", "Đơn giá"
	      	}
	      ));
	      scrollPane.setViewportView(table);
	      
	      JLabel lblNewLabel_1 = new JLabel("Người tạo phiếu");
	      lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      lblNewLabel_1.setBounds(676, 97, 115, 27);
	      add(lblNewLabel_1);
	      
	      JScrollPane scrollPane_1 = new JScrollPane();
	      scrollPane_1.setBounds(676, 212, 571, 487);
	      add(scrollPane_1);
	      
	      table_1 = new JTable();
	      table_1.setModel(new DefaultTableModel(
	      	new Object[][] {
	      	},
	      	new String[] {
	      			"Mã máy", "Tên máy", "Số lượng", "Đơn giá"
	      	}
	      ));
	      scrollPane_1.setViewportView(table_1);
	      
	      JButton btnNewButton = new JButton("Nhập Excel");
	      btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      btnNewButton.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\xuatexcel.png"));
	      btnNewButton.setBounds(676, 739, 139, 41);
	      add(btnNewButton);
	      
	      JButton btnSaSLng = new JButton("Sửa số lượng");
	      btnSaSLng.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\edit.png"));
	      btnSaSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      btnSaSLng.setBounds(871, 739, 160, 41);
	      add(btnSaSLng);
	      
	      JButton btnXoSnPhm = new JButton("Xoá sản phẩm");
	      btnXoSnPhm.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\delete.png"));
	      btnXoSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      btnXoSnPhm.setBounds(1076, 739, 171, 41);
	      add(btnXoSnPhm);
	      
	      JLabel lblNewLabel_2 = new JLabel("Số lượng");
	      lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      lblNewLabel_2.setBounds(166, 837, 65, 41);
	      add(lblNewLabel_2);
	      
	      textField_3 = new JTextField();
	      textField_3.setBounds(250, 839, 86, 41);
	      add(textField_3);
	      textField_3.setColumns(10);
	      
	      btnNewButton_2 = new JButton("Thêm\r\n");
	      btnNewButton_2.setBackground(new Color(60, 179, 113));
	      btnNewButton_2.setBorderPainted(false);
	      btnNewButton_2.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\add.png"));
	      btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      btnNewButton_2.setForeground(Color.WHITE); // Đặt màu chữ
	      btnNewButton_2.setBounds(359, 837, 139, 41);
	      add(btnNewButton_2);
	      
	      JButton btnNewButton_2_1 = new JButton("Xuất hàng");
	      btnNewButton_2_1.setIcon(null);
	      btnNewButton_2_1.setForeground(Color.WHITE);
	      btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      btnNewButton_2_1.setBorderPainted(false);
	      btnNewButton_2_1.setBackground(new Color(60, 179, 113));
	      btnNewButton_2_1.setBounds(1076, 837, 139, 41);
	      add(btnNewButton_2_1);
	      
	      textField_2 = new JTextField();
	      textField_2.setColumns(10);
	      textField_2.setBounds(834, 97, 381, 27);
	      add(textField_2);
	      
	      JLabel lblNewLabel_1_1 = new JLabel("Chi nhánh");
	      lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      lblNewLabel_1_1.setBounds(676, 163, 115, 27);
	      add(lblNewLabel_1_1);
	      
	      JComboBox comboBox_1 = new JComboBox();
	      comboBox_1.setBounds(839, 163, 376, 26);
	      add(comboBox_1);
	}
}
