package view.User.NhapHang;

import DAO.ProducersDAO;
import DAO.ProductsDAO;
import controller.Notification;
import controller.SearchProduct;
import controller.updateDataToTable;
import model.Computer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NhapHangForm extends JPanel implements updateDataToTable<Computer> {

    private static final long serialVersionUID = 1L;
    private JTextField input_Search;
    private JTable table_product;
    private JTextField textField_2;
    private JTable table_nhapHang;
    private JTextField input_SoLuong;
    private JButton btnNewButton_2;
    private JComboBox cbx_luaChon;
    private JTextField textField_4;

    /**
     * Create the panel.
     */
    public NhapHangForm() {
        setLayout(null);
        setSize(1257, 911);

        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
        verticalBox_1.setBounds(10, 11, 637, 75);
        add(verticalBox_1);

        JPanel panel_5_1_1 = new JPanel();
        panel_5_1_1.setLayout(null);
        verticalBox_1.add(panel_5_1_1);

        String[] luaChon = new String[]{"Tất cả", "Mã máy", "Tên máy", "Nhà cung cấp"};
        cbx_luaChon = new JComboBox(luaChon);
        cbx_luaChon.setBackground(UIManager.getColor("Button.background"));
        cbx_luaChon.setBounds(10, 11, 126, 30);
        panel_5_1_1.add(cbx_luaChon);

        input_Search = new JTextField();
        input_Search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                jTextFieldSearchKeyReleased();
            }
        });
        input_Search.setColumns(10);
        input_Search.setBounds(156, 11, 335, 30);
        panel_5_1_1.add(input_Search);

        JButton btnNewButton_1 = new JButton("Làm mới");
        btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(501, 9, 114, 30);
        panel_5_1_1.add(btnNewButton_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 121, 637, 678);
        add(scrollPane);

        table_product = new JTable();
        table_product.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Mã máy", "Tên máy", "Nhà cung cấp", "Đơn giá",
                }
        ));
        scrollPane.setViewportView(table_product);

        JLabel lblNewLabel_1 = new JLabel("Nhà cung cấp");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(676, 31, 123, 27);
        add(lblNewLabel_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(834, 87, 390, 27);
        add(textField_2);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(676, 147, 559, 552);
        add(scrollPane_1);

        table_nhapHang = new JTable();
        table_nhapHang.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Mã máy", "Tên máy", "Số lương", "Đơn giá"
                }
        ));
        scrollPane_1.setViewportView(table_nhapHang);

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
        btnXoSnPhm.setBounds(1076, 739, 148, 41);
        add(btnXoSnPhm);

        JLabel lblNewLabel_2 = new JLabel("Số lượng");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(166, 837, 65, 41);
        add(lblNewLabel_2);

        input_SoLuong = new JTextField();
        input_SoLuong.setBounds(250, 839, 86, 41);
        add(input_SoLuong);
        input_SoLuong.setColumns(10);

        btnNewButton_2 = new JButton("Thêm\r\n");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThemMouseClicked();
            }
        });
        btnNewButton_2.setBackground(new Color(60, 179, 113));
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\add.png"));
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2.setForeground(Color.WHITE); // Đặt màu chữ
        btnNewButton_2.setBounds(359, 837, 139, 41);
        add(btnNewButton_2);

        JLabel lblNewLabel_2_1 = new JLabel("Tổng tiền :");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_1.setBounds(721, 836, 108, 41);
        add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_1_1 = new JLabel("140000000");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_1_1.setBounds(853, 836, 197, 41);
        add(lblNewLabel_2_1_1);

        JButton btnNewButton_2_1 = new JButton("Nhập Hàng");
        btnNewButton_2_1.setIcon(null);
        btnNewButton_2_1.setForeground(Color.WHITE);
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2_1.setBorderPainted(false);
        btnNewButton_2_1.setBackground(new Color(60, 179, 113));
        btnNewButton_2_1.setBounds(1076, 837, 139, 41);
        add(btnNewButton_2_1);

        JLabel lblNewLabel_1_1 = new JLabel("Người tạo phiếu");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(676, 85, 123, 27);
        add(lblNewLabel_1_1);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(834, 33, 381, 27);
        add(textField_4);
        updateTableDataFormDAO();
    }

    public void jTextFieldSearchKeyReleased() {
        String luaChon = (String) cbx_luaChon.getSelectedItem();
        String input = input_Search.getText();
        ArrayList<Computer> computers = searchProduct(luaChon, input);
        updateTableData(computers);
    }

    public ArrayList<Computer> searchProduct(String luaChon, String content_Search) {
        ArrayList<Computer> result = new ArrayList<>();
        SearchProduct searchProduct = new SearchProduct();
        switch (luaChon) {
            case "Tất cả":
                result = searchProduct.searchTatCa(content_Search);
                break;
            case "Tên máy":
                result = searchProduct.searchTenMay(content_Search);
                break;
            case "Mã máy":
                result = searchProduct.searchMaMay(content_Search);
                break;
            case "Nhà cung cấp":
                result = searchProduct.searchTenNhaCungCap(content_Search);
                break;
        }
        return result;
    }

    @Override
    public void updateTableDataFormDAO() {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        updateTableData(computers);
    }

    @Override
    public void updateTableData(ArrayList<Computer> computers) {
        DecimalFormat df = new DecimalFormat("#,###");
        DefaultTableModel model = (DefaultTableModel) table_product.getModel();
        model.setRowCount(0);
        for (Computer computer : computers) {
            String tenNCC = ProducersDAO.getInstance().producerByID(computer.getMaNhaCungCap()).getTenNhaCungCap();
            model.addRow(
                    new Object[]{
                            computer.getMaMay(),
                            computer.getTenMay(),
                            tenNCC,
                            df.format(computer.getGia()) + " VND",
                    });
        }
    }

    public Computer getComputerSelected() {
        Computer computer = null;
        DefaultTableModel model = (DefaultTableModel) table_product.getModel();
        int i_row = table_product.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, Notification.not_SelectedProduct);
            return null;
        }
        String maMay = model.getValueAt(i_row, 0) + "";
        computer = ProductsDAO.getInstance().searchByIDProduct(maMay);
        return computer;
    }

    public void ThemMouseClicked() {
        double soLuong = 0;
        boolean hasError = false;
        try {
            soLuong= Double.parseDouble(input_SoLuong.getText());
            if(soLuong <=0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn giá hợp lệ (số dương)!");
            hasError = true;
        }
        if(hasError)return;
        Computer computer_selected = getComputerSelected();
        updateDataToTableNhapHangForm(computer_selected,table_nhapHang);
        input_SoLuong.setText("");
    }
    public void updateDataToTableNhapHangForm(Computer computer , JTable jTable){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        DecimalFormat df = new DecimalFormat("#,###");
        int soLuong = Integer.parseInt(input_SoLuong.getText());
        model.addRow(new Object[]{
                computer.getMaMay(),
                computer.getTenMay(),
                soLuong,
                df.format(computer.getGia()) + " VND",
        });
    }
}

