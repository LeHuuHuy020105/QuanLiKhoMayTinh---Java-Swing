package view.User.TonKho;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TonKhoForm extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTable table;

    /**
     * Create the panel.
     */
    public TonKhoForm() {
        setLayout(null);
        setSize(1257, 911);
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                "Chức năng",
                TitledBorder.LEADING,
                TitledBorder.TOP,
                new Font("Tahoma", Font.BOLD, 12),  // Đã sửa null thành Font.BOLD
                new Color(0, 0, 0)  // Màu chữ đen
        ));
        verticalBox.setBounds(10, 11, 600, 75);
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
        btnNewButton.setOpaque(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setEnabled(false);
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
        btnXemChiTiet.setOpaque(false);
        btnXemChiTiet.setContentAreaFilled(false);
        btnXemChiTiet.setBorderPainted(false);
        btnXemChiTiet.setEnabled(false);
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
        btnXuatExcel.setBounds(367, 0, 99, 52);
        panel_5_1.add(btnXuatExcel);

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
        btnSua.setOpaque(false);
        btnSua.setContentAreaFilled(false);
        btnSua.setBorderPainted(false);
        btnSua.setEnabled(false);
        panel_5_1.add(btnSua);

        JButton btnXoa = new JButton("Xoá");
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\delete.png"));
        btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXoa.setFocusPainted(false);
        btnXoa.setContentAreaFilled(false);
        btnXoa.setBorderPainted(false);
        btnXoa.setBackground(UIManager.getColor("Button.background"));
        btnXoa.setBounds(287, 0, 70, 52);
        btnXoa.setOpaque(false);
        btnXoa.setContentAreaFilled(false);
        btnXoa.setBorderPainted(false);
        btnXoa.setEnabled(false);
        panel_5_1.add(btnXoa);
        
        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
        verticalBox_1.setBounds(620, 11, 627, 75);
        add(verticalBox_1);
        
        JPanel panel_5_1_1 = new JPanel();
        verticalBox_1.add(panel_5_1_1);
        panel_5_1_1.setLayout(null);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(UIManager.getColor("Button.background"));
        comboBox.setBounds(10, 11, 126, 30);
        panel_5_1_1.add(comboBox);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(156, 11, 325, 30);
        panel_5_1_1.add(textField);
        
        JButton btnNewButton_1 = new JButton("Làm mới");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(491, 9, 114, 30);
        panel_5_1_1.add(btnNewButton_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 126, 1247, 774);
        add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Mã máy", "Tên máy", "Số lượng", "Đơn giá", "Bộ xử lí", "RAM", "Bộ nhớ", "Loại máy"
        	}
        ));
        scrollPane.setViewportView(table);

    }
}
