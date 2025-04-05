package view.User.TonKho;

import DAO.*;
import controller.Notification;
import controller.SearchProduct;
import controller.updateDataToTable;
import model.*;
import view.User.SanPham.ChiTietSanPham;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TonKhoForm extends JPanel implements updateDataToTable<Computer> {

    private static final long serialVersionUID = 1L;
    private JButton btnXemChiTiet;
    private JButton btnXuatExcel;
    private JButton btnXoa;
    private JButton btnSua;
    private JButton btnNewButton;
    private JComboBox cbx_TimKiem;
    private JTextField input_TimKiem;
    private JTable table_product;
    private JComboBox cbx_ChiNhanh;
    private JComboBox cbx_TrangThai;
    private ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
    private User currentUser;

    /**
     * Create the panel.
     */
    public TonKhoForm(User currentUser) {
        this.currentUser = currentUser;
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

        btnNewButton = new JButton("Thêm");
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

        btnXemChiTiet = new JButton("Xem chi tiết");
        btnXemChiTiet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XemChiTietMouseClicked();
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
        btnXemChiTiet.setOpaque(false);
        btnXemChiTiet.setContentAreaFilled(false);
        btnXemChiTiet.setBorderPainted(false);
        btnXemChiTiet.setEnabled(false);
        panel_5_1.add(btnXemChiTiet);

        btnXuatExcel = new JButton("Xuất Excel");
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

        btnSua = new JButton("Sửa");
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

        btnXoa = new JButton("Xoá");
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

        cbx_TimKiem = new JComboBox();
        cbx_TimKiem.setBackground(UIManager.getColor("Button.background"));
        cbx_TimKiem.setBounds(10, 11, 126, 30);
        panel_5_1_1.add(cbx_TimKiem);


        input_TimKiem = new JTextField();
        input_TimKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                applyFilters();
            }
        });
        input_TimKiem.setColumns(10);
        input_TimKiem.setBounds(156, 11, 325, 30);
        panel_5_1_1.add(input_TimKiem);

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
        scrollPane.setBounds(10, 203, 1247, 697);
        add(scrollPane);

        table_product = new JTable();
        table_product.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Mã máy", "Tên máy", "Số lượng", "Đơn giá", "Giá bán", "Bộ xử lí", "RAM", "Bộ nhớ", "Loại máy"
                }
        ));
        scrollPane.setViewportView(table_product);

        Box verticalBox_1_1 = Box.createVerticalBox();
        verticalBox_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi nhánh", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
        verticalBox_1_1.setBounds(10, 112, 768, 75);
        add(verticalBox_1_1);

        JPanel panel_5_1_1_1 = new JPanel();
        panel_5_1_1_1.setLayout(null);
        verticalBox_1_1.add(panel_5_1_1_1);

        cbx_ChiNhanh = new JComboBox();
        cbx_ChiNhanh.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                applyFilters();
            }
        });
        cbx_ChiNhanh.setBackground(UIManager.getColor("Button.background"));
        cbx_ChiNhanh.setBounds(101, 11, 645, 30);
        panel_5_1_1_1.add(cbx_ChiNhanh);

        JLabel lblNewLabel = new JLabel("Chi Nhánh");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 103, 30);
        panel_5_1_1_1.add(lblNewLabel);

        Box verticalBox_1_1_1 = Box.createVerticalBox();
        verticalBox_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tình trạng", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
        verticalBox_1_1_1.setBounds(903, 112, 344, 75);
        add(verticalBox_1_1_1);

        JPanel panel_5_1_1_1_1 = new JPanel();
        panel_5_1_1_1_1.setLayout(null);
        verticalBox_1_1_1.add(panel_5_1_1_1_1);

        cbx_TrangThai = new JComboBox();
        cbx_TrangThai.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                applyFilters();
            }
        });
        cbx_TrangThai.setBackground(UIManager.getColor("Button.background"));
        cbx_TrangThai.setBounds(101, 11, 221, 30);
        panel_5_1_1_1_1.add(cbx_TrangThai);

        JLabel lblSnPhm = new JLabel("Sản phẩm");
        lblSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSnPhm.setBounds(10, 11, 103, 30);
        panel_5_1_1_1_1.add(lblSnPhm);
        updateTableDataFormDAO();
        fillData();
        Permission();
    }
    public void Permission(){
        int roleUser = UserDAO.getInstance().getIDRoleByIDUser(currentUser.getIdUser());
        PermissionsDAO.applyPermissions(roleUser,"Sản phẩm",btnNewButton,btnXoa,btnSua,btnXemChiTiet,btnXuatExcel,null);
    }
    public void fillData() {
        ArrayList<Branch> branches = BrandDAO.getInstance().selectAll();
        cbx_ChiNhanh.addItem("Tất cả");
        for (Branch branch : branches) {
            String chiNhanh = branch.getTenChiNhanh() + "-" + branch.getDiaChi();
            cbx_ChiNhanh.addItem(chiNhanh);
        }
        String[] tinhTrang = new String[]{"Tất cả", "Sắp hết hàng", "Còn hàng", "Hết hàng"};
        for (String trangThai : tinhTrang) {
            cbx_TrangThai.addItem(trangThai);
        }
        String[] cbxLuaChonValues = new String[]{"Tất cả", "Tên máy", "Số lượng", "Đơn giá", "RAM", "CPU", "Dung lượng", "Card màn hình", "Xuất xứ"};
        for (String luaChon : cbxLuaChonValues) {
            cbx_TimKiem.addItem(luaChon);
        }
        String role = UserDAO.getInstance().getRoleByIDUser(currentUser.getIdUser());
        if (role.equals("Quản lí chi nhánh")) {
            int idBranch = UserDAO.getInstance().getMaChiNhanhByIDUser(currentUser.getIdUser());
            Branch branch = BrandDAO.getInstance().BranchByID(idBranch);
            String diaChi = branch.getTenChiNhanh() + "-" + branch.getDiaChi();
            for (int i = 0; i < cbx_ChiNhanh.getItemCount(); i++) {
                String item = cbx_ChiNhanh.getItemAt(i) + "";
                if (item.contains(diaChi)) {
                    System.out.println(item);
                    cbx_ChiNhanh.setSelectedItem(item);
                    cbx_ChiNhanh.setEnabled(false);
                }
            }
        }
    }

    @Override
    public void updateTableDataFormDAO() {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        updateTableData(computers);
    }

    @Override
    public void updateTableData(ArrayList<Computer> t) {
        DecimalFormat df = new DecimalFormat("#,###");
        DefaultTableModel model = (DefaultTableModel) table_product.getModel();
        model.setRowCount(0);
        for (Computer computer : t) {
            String loaiMay = "";
            if (computer instanceof Laptop) {
                loaiMay = "Laptop";
            } else {
                loaiMay = "PC";
            }
            model.addRow(new Object[]{
                    computer.getMaMay(),
                    computer.getTenMay(),
                    computer.getSoLuong(),
                    df.format(computer.getGia()) + "VND",
                    df.format(computer.getGiaBan()) + "VND",
                    computer.getTenCpu(),
                    computer.getRam(),
                    computer.getDungLuongLuuTru(),
                    loaiMay
            });
        }
    }

    public void applyFilters() {
        String branchFilter = cbx_ChiNhanh.getSelectedItem() + "";
        String statusFilter = cbx_TrangThai.getSelectedItem() + "";
        String keyword = input_TimKiem.getText().trim().toLowerCase();

        // Lấy danh sách tất cả sản phẩm
        ArrayList<Computer> allComputers = ProductsDAO.getInstance().selectAll();

        ArrayList<Computer> filteredComputers = new ArrayList<>();

        for (Computer computer : allComputers) {
            boolean matchBranch = branchFilter.equals("Tất cả") || matchBranch(computer, branchFilter);
            boolean matchStatus = statusFilter.equals("Tất cả") || matchStatus(computer, statusFilter);
            boolean matchKeyword = keyword.isEmpty() || matchKeyword(computer, keyword);

            // Chỉ thêm nếu thỏa mãn cả 3 điều kiện
            if (matchBranch && matchStatus && matchKeyword) {
                filteredComputers.add(computer);
            }
        }

        updateTableData(filteredComputers);
    }

    // Kiểm tra chi nhánh
    private boolean matchBranch(Computer computer, String branchFilter) {
        String cbx_ChiNhanhValue = cbx_ChiNhanh.getSelectedItem() + "";
        System.out.println(cbx_ChiNhanhValue);
        String[] data = cbx_ChiNhanhValue.split("-");
        System.out.println(data[0]);
        String diaChi = data[1];
        Branch branch = BrandDAO.getInstance().BranchByDiaChi(diaChi);
        ArrayList<Inventory> inventories = InventoryDAO.getInstance().InventoryByBranch(branch);
        for (Inventory inventory : inventories) {
            if (inventory.getMaMay() == computer.getMaMay()) {
                computer.setSoLuong(inventory.getSoLuong());
                return true;
            }
        }
        return false;
    }

    // Kiểm tra tình trạng tồn kho
    private boolean matchStatus(Computer computer, String statusFilter) {
        switch (statusFilter) {
            case "Sắp hết hàng":
                return computer.getSoLuong() > 0 && computer.getSoLuong() <= 5;
            case "Hết hàng":
                return computer.getSoLuong() == 0;
            case "Còn hàng":
                return computer.getSoLuong() > 5;
            default:
                return true;
        }
    }

    public boolean matchKeyword(Computer computer, String keyword) {
        return computer.getTenMay().toLowerCase().contains(keyword) ||
                computer.getTenCpu().toLowerCase().contains(keyword) ||
                computer.getRam().toLowerCase().contains(keyword);
    }
    public Computer getComputerSelected() {
        Computer computer_Selected = null;
        try {
            DefaultTableModel model = (DefaultTableModel) table_product.getModel();
            int i_row = table_product.getSelectedRow();

            if (i_row == -1) {
                JOptionPane.showMessageDialog(this, Notification.not_SelectedProduct);
                return null;
            }

            int maMay = Integer.parseInt(model.getValueAt(i_row, 0)+"");

            computer_Selected = ProductsDAO.getInstance().searchByIDProduct(maMay);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
        return computer_Selected;
    }
    public void XemChiTietMouseClicked(){
        Computer computer_Selected = getComputerSelected();
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham(computer_Selected);
        chiTietSanPham.setVisible(true);
    }
}
