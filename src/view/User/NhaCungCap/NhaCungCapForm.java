package view.User.NhaCungCap;

import model.Producer;
import view.User.SanPham.ThemSanPham;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NhaCungCapForm extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTable table;

    /**
     * Create the panel.
     */
    public NhaCungCapForm() {
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
        verticalBox.setBounds(10, 11, 521, 75);
        add(verticalBox);

        JPanel panel_5_1 = new JPanel();
        panel_5_1.setLayout(null);
        verticalBox.add(panel_5_1);

        JButton btn_ThemNCC = new JButton("Thêm");
        btn_ThemNCC.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		ThemNhaCungCapMouseClicked();
        	}
        });
        btn_ThemNCC.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_ThemNCC.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\add.png"));
        btn_ThemNCC.setHorizontalTextPosition(SwingConstants.CENTER);
        btn_ThemNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btn_ThemNCC.setFocusPainted(false);
        btn_ThemNCC.setContentAreaFilled(false);
        btn_ThemNCC.setBorderPainted(false);
        btn_ThemNCC.setBackground(UIManager.getColor("Button.background"));
        btn_ThemNCC.setBounds(10, 0, 70, 52);
        panel_5_1.add(btn_ThemNCC);

        JButton btnXuatExcel = new JButton("Xuất Excel");
        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXuatExcel.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\xuatexcel.png"));
        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXuatExcel.setFocusPainted(false);
        btnXuatExcel.setContentAreaFilled(false);
        btnXuatExcel.setBorderPainted(false);
        btnXuatExcel.setBackground(UIManager.getColor("Button.background"));
        btnXuatExcel.setBounds(400, 0, 99, 52);
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
        btnNhapExcel.setBounds(274, 0, 98, 52);
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

        JButton btnXoa = new JButton("Xoá");
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\delete.png"));
        btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXoa.setFocusPainted(false);
        btnXoa.setContentAreaFilled(false);
        btnXoa.setBorderPainted(false);
        btnXoa.setBackground(UIManager.getColor("Button.background"));
        btnXoa.setBounds(184, 0, 70, 52);
        panel_5_1.add(btnXoa);

        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox_1.setBorder(new TitledBorder(


                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),


                "Chức năng",


                TitledBorder.LEADING,


                TitledBorder.TOP,


                new Font("Tahoma", Font.BOLD, 12),  // Đã sửa null thành Font.BOLD


                new Color(0, 0, 0)  // Màu chữ đen


        ));
        verticalBox_1.setBounds(547, 11, 700, 75);
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
        textField.setBounds(156, 11, 384, 30);
        panel_5_1_1.add(textField);

        JButton btnNewButton_1 = new JButton("Làm mới");
        btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(564, 9, 114, 30);
        panel_5_1_1.add(btnNewButton_1);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "STT", "Mã NCC", "Tên NCC", "Địa chỉ"
                }
        ));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 127, 1237, 774);
        add(scrollPane);
    }
    public void ThemNhaCungCapMouseClicked(){
        ThemNhaCungCap themSanPham = new ThemNhaCungCap();
        themSanPham.setVisible(true);
    }
}
