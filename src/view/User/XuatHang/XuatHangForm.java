package view.User.XuatHang;

import DAO.*;
import controller.Notification;
import controller.SearchProduct;
import controller.updateDataToTable;
import model.*;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class XuatHangForm extends JPanel implements updateDataToTable<Computer> {

    private static final long serialVersionUID = 1L;
    private JComboBox cbx_luaChon;
    private JTextField input_Search;
    private JTable table_Product;
    private JTable table_XuatHang;
    private JTextField input_SoLuong;
    private JButton btn_Them;
    private JTextField input_NguoiTaoPhieu;
    private ArrayList<DetailExportProducts> detailExportProducts;
    private JComboBox cbx_ChiNhanh;
    private User currentUser;

    /**
     * Create the panel.
     */
    public XuatHangForm(User currentUser) {
        this.currentUser = currentUser;
        detailExportProducts = new ArrayList<>();
        setLayout(null);
        setSize(1257, 736);

        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
        verticalBox_1.setBounds(10, 11, 637, 75);
        add(verticalBox_1);

        JPanel panel_5_1_1 = new JPanel();
        panel_5_1_1.setLayout(null);
        verticalBox_1.add(panel_5_1_1);

        String[] luaChon = new String[]{"Tất cả", "Mã máy", "Tên máy", "Nhà cung cấp"};
        cbx_luaChon = new JComboBox(luaChon);
        cbx_luaChon.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateTableDataFormDAO();
                input_Search.setText("");
            }
        });
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
        scrollPane.setBounds(10, 121, 637, 455);
        add(scrollPane);

        table_Product = new JTable();
        table_Product.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "STT", "Mã máy", "Tên máy", "Số lượng", "Đơn giá"
                }
        ));
        scrollPane.setViewportView(table_Product);

        JLabel lblNewLabel_1 = new JLabel("Người tạo phiếu");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(676, 33, 115, 27);
        add(lblNewLabel_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(676, 134, 571, 442);
        add(scrollPane_1);

        table_XuatHang = new JTable();
        table_XuatHang.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Mã máy", "Tên máy", "Số lượng", "Đơn giá"
                }
        ));
        scrollPane_1.setViewportView(table_XuatHang);

        JButton btnNewButton = new JButton("Nhập Excel");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\xuatexcel.png"));
        btnNewButton.setBounds(701, 601, 139, 41);
        add(btnNewButton);

        JButton btnSaSLng = new JButton("Sửa số lượng");
        btnSaSLng.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnSaSLng.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\edit.png"));
        btnSaSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSaSLng.setBounds(877, 601, 160, 41);
        add(btnSaSLng);

        JButton btnXoSnPhm = new JButton("Xoá sản phẩm");
        btnXoSnPhm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnXoSnPhm.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\delete.png"));
        btnXoSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnXoSnPhm.setBounds(1076, 601, 171, 41);
        add(btnXoSnPhm);

        JLabel lblNewLabel_2 = new JLabel("Số lượng");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(137, 601, 65, 41);
        add(lblNewLabel_2);

        input_SoLuong = new JTextField();
        input_SoLuong.setBounds(245, 603, 86, 41);
        add(input_SoLuong);
        input_SoLuong.setColumns(10);

        btn_Them = new JButton("Thêm\r\n");
        btn_Them.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btn_Them.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThemMouseClicked();
            }
        });

        btn_Them.setBackground(new Color(60, 179, 113));
        btn_Them.setBorderPainted(false);
        btn_Them.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\add.png"));
        btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_Them.setForeground(Color.WHITE); // Đặt màu chữ
        btn_Them.setBounds(382, 601, 139, 41);
        add(btn_Them);

        input_NguoiTaoPhieu = new JTextField();
        input_NguoiTaoPhieu.setColumns(10);
        input_NguoiTaoPhieu.setBounds(834, 35, 381, 27);
        add(input_NguoiTaoPhieu);

        JLabel lblNewLabel_1_1 = new JLabel("Chi nhánh");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(676, 85, 115, 27);
        add(lblNewLabel_1_1);

        cbx_ChiNhanh = new JComboBox();
        cbx_ChiNhanh.setBounds(834, 87, 376, 26);
        add(cbx_ChiNhanh);

        JButton btnNewButton_2_1 = new JButton("Xuất hàng");
        btnNewButton_2_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XuatHangMouseClicked();
            }
        });
        btnNewButton_2_1.setIcon(null);
        btnNewButton_2_1.setForeground(Color.WHITE);
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2_1.setBorderPainted(false);
        btnNewButton_2_1.setBackground(new Color(60, 179, 113));
        btnNewButton_2_1.setBounds(1108, 668, 139, 41);
        add(btnNewButton_2_1);
        updateTableDataFormDAO();
        FillData();
    }
    public void FillData(){
        ArrayList<Branch>branches = BrandDAO.getInstance().selectAll();
        for(Branch branch : branches){
            cbx_ChiNhanh.addItem(branch.getDiaChi());
        }
        input_NguoiTaoPhieu.setText(currentUser.getFullName());
        input_NguoiTaoPhieu.setEditable(false);
    }
    @Override
    public void updateTableDataFormDAO() {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        updateTableData(computers);
    }

    @Override
    public void updateTableData(ArrayList<Computer> t) {
        DecimalFormat df = new DecimalFormat("#,###");
        DefaultTableModel model = (DefaultTableModel) table_Product.getModel();
        model.setRowCount(0);
        int i = 0;
        for (Computer computer : t) {
            i++;
            model.addRow(new Object[]{
                    i,
                    computer.getMaMay(),
                    computer.getTenMay(),
                    computer.getSoLuong(),
                    df.format(computer.getGia()) + " VND",

            });
        }
    }

    public Computer getComputerSelectedTableProduct() {
        DefaultTableModel model = (DefaultTableModel) table_Product.getModel();
        int i_row = table_Product.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showConfirmDialog(this, "Vui lòng chọn sản phẩm");
            return null;
        }
        int maMay = Integer.parseInt(model.getValueAt(i_row, 1) + "");
        Computer computer = ProductsDAO.getInstance().searchByIDProduct(maMay);
        return computer;
    }

    public void ThemMouseClicked() {
        int soLuong = 0;
        boolean hasError = false;
        try {
            soLuong = Integer.parseInt(input_SoLuong.getText());
            if (soLuong <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, Notification.isValidNumber);
            hasError = true;
        }
        if (hasError) return;
        Computer computer_selected = getComputerSelectedTableProduct();
        int maMay = computer_selected.getMaMay();
        DetailExportProducts detailExportProducts1 = new DetailExportProducts(0,maMay,soLuong);
        DetailExportProducts detailExportProducts_isValid =isValidProduct(detailExportProducts1,detailExportProducts);
        if(detailExportProducts_isValid==null){
            this.detailExportProducts.add(detailExportProducts1);
        }else {
            int soluong_valid = detailExportProducts_isValid.getSoLuong();
            detailExportProducts_isValid.setSoLuong(soluong_valid + soLuong);
        }
        updateDataToTableXuatHangForm(this.detailExportProducts, table_XuatHang);
        input_SoLuong.setText("");
    }
    public DetailExportProducts isValidProduct(DetailExportProducts detailExportProducts1,ArrayList<DetailExportProducts>detailExportProducts){
        for(DetailExportProducts detailExportProducts2 : detailExportProducts){
            if(detailExportProducts2.getMaMay()==detailExportProducts1.getMaMay()){
                return detailExportProducts2;
            }
        }
        return null;
    }
    public void updateDataToTableXuatHangForm(ArrayList<DetailExportProducts>detailExportProducts,JTable jTable){
        DecimalFormat df = new DecimalFormat("#,###");
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        for(DetailExportProducts detailExportProducts1 : detailExportProducts){
            Computer computer = ProductsDAO.getInstance().searchByIDProduct(detailExportProducts1.getMaMay());
            String tenMay = computer.getTenMay();
            double donGia = computer.getGia();
            model.addRow(new Object[]{
                    detailExportProducts1.getMaMay(),
                    tenMay,
                    detailExportProducts1.getSoLuong(),
                    df.format(donGia)+" VND",
            });
        }
    }
    public void XuatHangMouseClicked() {
        if(detailExportProducts.size()==0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để xuất hàng !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }else {
            int check = JOptionPane.showConfirmDialog( this, "Bạn có chắc chắn muốn nhập hàng ?", "Xác nhận nhập hàng", JOptionPane.YES_NO_OPTION);
            if(check==JOptionPane.YES_OPTION) {
                String diaChi = cbx_ChiNhanh.getSelectedItem()+"";
                Branch branch = BrandDAO.getInstance().BranchByDiaChi(diaChi);
                int maChiNhanh = branch.getMaChiNhanh();
                ExportProducts exportProducts = new ExportProducts(0,null,null,1,maChiNhanh,currentUser.getIdUser(),null);
                int maPhieuXuat = ExportProductsDAO.getInstance().insertExportProduct(exportProducts);
                updateDatabaseExportProducts(maPhieuXuat);
            }
        }
        updateTableDataFormDAO();
        resetXuatHang();
    }
    public void updateDatabaseExportProducts(int maphieuxuat){
        for(DetailExportProducts detailExportProducts1 : detailExportProducts){
            detailExportProducts1.setMaPhieuXuat(maphieuxuat);
            Computer computer = ProductsDAO.getInstance().searchByIDProduct(detailExportProducts1.getMaMay());
            computer.setSoLuong(computer.getSoLuong() - detailExportProducts1.getSoLuong());
            ProductsDAO.getInstance().update(computer);
            DetailExportProductsDAO.getInstance().insert(detailExportProducts1);
        }

    }
    public void resetXuatHang(){
        input_SoLuong.setText("");
        detailExportProducts.clear();
        updateDataToTableXuatHangForm(detailExportProducts,table_XuatHang);
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
}
