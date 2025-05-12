package GUI.User.NhanVien;

import BLL.*;
import DAO.InventoryDAO;
import DAO.ProductsDAO;
import DTO.*;
import GUI.Icon;
import GUI.User.QLTaiKhoanNguoiDung.QLTaiKhoanNguoiDungForm;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class BanHang extends JPanel implements updateDataToTable<Computer> {

    private static final long serialVersionUID = 1L;
    private JTextField input_Search;
    private JTable table_product;
    private JTextField input_NguoiTaoPhieu;
    private JTable table_nhapHang;
    private JTextField input_SoLuong;
    private JButton btnNewButton_2;
    private JComboBox cbx_luaChon;
    private User currentUser ;
    private ArrayList<DetailBill> detailBills;
    private JLabel label_TotalPrice;
    private Customer customer;
    private JTextField textField_InfoCustomer;
    private JFileChooser jFileChooser;
    private ProductsBLL productsBLL;
    private CustomerBLL customerBLL;
    private BranchBLL branchBLL;
    private InventoryBLL inventoryBLL;
    private ProducerBLL producerBLL;
    private DetailBillBLL detailBillBLL;
    private BillBLL billBLL;
    private Branch currentBranch;

    /**
     * Create the panel.
     */
    public BanHang(User user) {
        this.detailBills = new ArrayList<>();
        this.currentUser = user;
        this.producerBLL = new ProducerBLL();
        this.customerBLL = new CustomerBLL();
        this.productsBLL = new ProductsBLL();
        this.detailBillBLL = new DetailBillBLL();
        this.billBLL = new BillBLL();
        this.branchBLL = new BranchBLL();
        this.inventoryBLL = new InventoryBLL();
        jFileChooser = new JFileChooser();
        setLayout(null);
        setSize(1257, 735);

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
        input_Search.setBounds(156, 11, 310, 30);
        panel_5_1_1.add(input_Search);

        JButton btnNewButton_1 = new JButton("Làm mới");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                LamMoiMouseClicked();
        	}
        });

        btnNewButton_1.setIcon(new ImageIcon(Icon.refesh));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(476, 9, 139, 30);
        panel_5_1_1.add(btnNewButton_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 121, 637, 490);
        add(scrollPane);

        table_product = new JTable();
        table_product.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Mã máy", "Tên máy", "Nhà cung cấp", "Số lượng", "Đơn giá",
                }
        ));
        scrollPane.setViewportView(table_product);

        input_NguoiTaoPhieu = new JTextField();
        input_NguoiTaoPhieu.setColumns(10);
        input_NguoiTaoPhieu.setBounds(824, 45, 390, 27);
        add(input_NguoiTaoPhieu);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(676, 166, 559, 382);
        add(scrollPane_1);

        table_nhapHang = new JTable();
        table_nhapHang.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Mã máy", "Tên máy", "Nhà cung cấp","Số lượng","Đơn giá",
                }
        ));
        scrollPane_1.setViewportView(table_nhapHang);

        JButton btnNewButton = new JButton("Nhập Excel");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NhapExcelMouseClicked();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setIcon(new ImageIcon(Icon.xuatExcel));
        btnNewButton.setBounds(686, 569, 139, 41);
        add(btnNewButton);

        JButton btnSaSLng = new JButton("Sửa số lượng");
        btnSaSLng.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnSaSLng.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SuaSoLuongMouseClicked();
            }
        });
        btnSaSLng.setIcon(new ImageIcon(Icon.edit));
        btnSaSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSaSLng.setBounds(853, 569, 160, 41);
        add(btnSaSLng);

        JButton btn_XoaSanPham = new JButton("Xoá sản phẩm");
        btn_XoaSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XoaMouseClicked();
            }
        });
        btn_XoaSanPham.setIcon(new ImageIcon(Icon.delete));
        btn_XoaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_XoaSanPham.setBounds(1038, 569, 176, 41);
        add(btn_XoaSanPham);

        JLabel lblNewLabel_2 = new JLabel("Số lượng");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(146, 638, 65, 41);
        add(lblNewLabel_2);

        input_SoLuong = new JTextField();
        input_SoLuong.setBounds(238, 640, 86, 41);
        add(input_SoLuong);
        input_SoLuong.setColumns(10);

        btnNewButton_2 = new JButton("Thêm\r\n");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThemMouseClicked();
            }
        });
        btnNewButton_2.setBackground(new Color(60, 179, 113));
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setIcon(new ImageIcon(Icon.add));
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2.setForeground(Color.WHITE); // Đặt màu chữ
        btnNewButton_2.setBounds(357, 638, 139, 41);
        add(btnNewButton_2);

        JLabel lblNewLabel_2_1 = new JLabel("Tổng tiền :");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_1.setBounds(718, 637, 108, 41);
        add(lblNewLabel_2_1);

        label_TotalPrice = new JLabel("0");
        label_TotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
        label_TotalPrice.setForeground(new Color(255, 0, 0));
        label_TotalPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
        label_TotalPrice.setBounds(853, 637, 197, 41);
        add(label_TotalPrice);

        JButton btn_NhapHang = new JButton("Thanh toán");
        btn_NhapHang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BanHangMouseClicked();
            }
        });
        btn_NhapHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BanHangMouseClicked();
            }
        });
        btn_NhapHang.setIcon(null);
        btn_NhapHang.setForeground(Color.WHITE);
        btn_NhapHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_NhapHang.setBorderPainted(false);
        btn_NhapHang.setBackground(new Color(60, 179, 113));
        btn_NhapHang.setBounds(1076, 638, 139, 41);
        add(btn_NhapHang);

        JLabel lblNewLabel_1_1 = new JLabel("Người tạo phiếu");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(676, 43, 123, 27);
        add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Khách hàng");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1_1.setBounds(676, 105, 123, 27);
        add(lblNewLabel_1_1_1);

        JButton btnNewButton_3 = new JButton("New button");
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchCustomer();
            }
        });
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_3.setBounds(1174, 110, 47, 21);
        add(btnNewButton_3);

        textField_InfoCustomer = new JTextField();
        textField_InfoCustomer.setText((String) null);
        textField_InfoCustomer.setEditable(false);
        textField_InfoCustomer.setColumns(10);
        textField_InfoCustomer.setBounds(824, 107, 340, 27);
        add(textField_InfoCustomer);

        currentBranch = branchBLL.BranchByID(currentUser.getMaChiNhanh());
        ArrayList<Customer> customers = customerBLL.selectAll();
        ArrayList<String> items = dataCustomer(customers);
        fillData();
        setVisible(true);
    }
    public void LamMoiMouseClicked(){
        cbx_luaChon.setSelectedItem("Tất cả");
        input_Search.setText("");
        jTextFieldSearchKeyReleased();
    }

    private void SearchCustomer() {
        QLTaiKhoanNguoiDungForm qlTaiKhoanNguoiDungForm = new QLTaiKhoanNguoiDungForm(this);
    }
    public void fillInfoCustomer(Customer fillCustomer){
        String s = fillCustomer.getSoDienThoai()+" - "+fillCustomer.getFullName();
        customer = fillCustomer;
        textField_InfoCustomer.setText(s);
    }
    public ArrayList<String> dataCustomer(ArrayList<Customer> customers){
        ArrayList<String> result = new ArrayList<>();
        for(Customer customer : customers){
            String s = customer.getSoDienThoai()+"-"+customer.getFullName();
            result.add(s);
        }
        return result;
    }
    public void fillData(){
        loadNhaphangForm();
        updateTableDataFormDAO();
        ArrayList<Customer> customers = customerBLL.selectAll();
        String[] items = dataCustomer(customers).toArray(new String[0]);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);

    }
    public void loadNhaphangForm(){
        input_NguoiTaoPhieu.setText(currentUser.getFullName());
        input_NguoiTaoPhieu.setEditable(false);
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
        Branch currentBranch = branchBLL.BranchByID(currentUser.getMaChiNhanh());
        switch (luaChon) {
            case "Tất cả":
                result = searchProduct.searchChiNhanhTatCa(content_Search,currentBranch);
                break;
            case "Tên máy":
                result = searchProduct.searchChiNhanhTenMay(content_Search,currentBranch);
                break;
            case "Mã máy":
                result = searchProduct.searchChiNhanhMaMay(content_Search,currentBranch);
                break;
            case "Nhà cung cấp":
                result = searchProduct.searchChiNhanhTenNhaCungCap(content_Search,currentBranch);
                break;
        }
        return result;
    }

    @Override
    public void updateTableDataFormDAO() {
        ArrayList<Computer> computers = InventoryBranchData();
        updateTableData(computers);
    }
    public ArrayList<Computer> InventoryBranchData(){
        Branch branch = branchBLL.BranchByID(currentUser.getMaChiNhanh());
        ArrayList<Inventory> inventories = inventoryBLL.InventoryByBranch(branch);
        ArrayList<Computer> result = new ArrayList<>();
        for(Inventory item : inventories){
            Computer computer = productsBLL.searchByIdProduct(item.getMaMay());
            computer.setSoLuong(item.getSoLuong());
            result.add(computer);
        }
        return result;
    }

    @Override
    public void updateTableData(ArrayList<Computer> computers) {
        DecimalFormat df = new DecimalFormat("#,###");
        DefaultTableModel model = (DefaultTableModel) table_product.getModel();
        model.setRowCount(0);
        for (Computer computer : computers) {
            String tenNCC = producerBLL.producerByID(computer.getMaNhaCungCap()).getTenNhaCungCap();
            model.addRow(
                    new Object[]{
                            computer.getMaMay(),
                            computer.getTenMay(),
                            tenNCC,
                            computer.getSoLuong(),
                            df.format(computer.getGia()) + " VND",
                    });
        }
    }

    public Inventory getComputerSelectedTableProduct() {
        Inventory inventory = null;
        DefaultTableModel model = (DefaultTableModel) table_product.getModel();
        int i_row = table_product.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, Notification.not_SelectedProduct);
            return null;
        }
        int maMay = Integer.parseInt(model.getValueAt(i_row, 0) + "");
        inventory = InventoryDAO.getInstance().InventoryByIDProduct(maMay,currentBranch);
        return inventory;
    }

    public void ThemMouseClicked() {
        int soLuong = 0;
        boolean hasError = false;
        try {
            soLuong= Integer.parseInt(input_SoLuong.getText());
            if(soLuong <=0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, Notification.isValidNumber);
            hasError = true;
        }
        if(hasError)return;
        Inventory computer_selected = getComputerSelectedTableProduct();
        int maMay =computer_selected.getMaMay();

        if(soLuong>computer_selected.getSoLuong()){
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng trong kho!");
            return;
        }

        DetailBill detailBill = new DetailBill(maMay,0,soLuong);
        DetailBill detailBill_isValid = isValidProduct(detailBill,detailBills);
        if(detailBill_isValid==null){
            this.detailBills.add(detailBill);
        }else {
            int soluong_valid = detailBill_isValid.getSoLuong();
            int newSoLuong = soluong_valid+soLuong;
            if(newSoLuong>computer_selected.getSoLuong()){
                JOptionPane.showMessageDialog(this, "Vượt quá số lượng trong kho!");
                return;
            }
            detailBill_isValid.setSoLuong(newSoLuong);
        }
        updateDataToTableBanHangForm(this.detailBills,table_nhapHang);
        input_SoLuong.setText("");
        setTotalPrice();
    }
    public void updateDataToTableBanHangForm(ArrayList<DetailBill> detailBills, JTable jTable){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#,###");
        for(DetailBill detailBill : detailBills){
            Computer computer =productsBLL.searchByIdProduct(detailBill.getMaMay());
            String tenNCC = producerBLL.producerByID(computer.getMaNhaCungCap()).getTenNhaCungCap();
            model.addRow(new Object[]{
                    computer.getMaMay(),
                    computer.getTenMay(),
                    tenNCC,
                    detailBill.getSoLuong(),
                    df.format(computer.getGiaBan()) + " VND",
            });
        }
    }
    public Computer getComputerSelectedTableBanHang() {
        Computer computer = null;
        DefaultTableModel model = (DefaultTableModel) table_nhapHang.getModel();
        int i_row = table_nhapHang.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, Notification.not_SelectedProduct);
            return null;
        }
        int maMay = Integer.parseInt(model.getValueAt(i_row, 0) + "");
        computer = productsBLL.searchByIdProduct(maMay);
        return computer;
    }
    public DetailBill EntryFormByProductID(ArrayList<DetailBill> detailBills, Computer computer){
        for(DetailBill detailBill : detailBills){
            if(detailBill.getMaMay() == computer.getMaMay()){
                return detailBill;
            }
        }
        return null;
    }
    public void SuaSoLuongMouseClicked() {
        boolean hasError = false;
        Computer computer_selected = getComputerSelectedTableBanHang();
        if (computer_selected == null) {
            return;
        }
        String newSL = JOptionPane.showInputDialog(this, "Nhập số lượng cần thay đổi", "Thay đổi số lượng", JOptionPane.QUESTION_MESSAGE);
        int soLuong =0;
        if (newSL == null) {
            return;
        }
        try {
            soLuong = Integer.parseInt(newSL);
        } catch (Exception e) {
            hasError=true;
            JOptionPane.showMessageDialog(this,Notification.isValidNumber);
        }
        if(soLuong>computer_selected.getSoLuong()){
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng trong kho!");
            hasError=true;
        }
        if(hasError)return;

        DetailBill detailBill =EntryFormByProductID(this.detailBills,computer_selected);
        detailBill.setSoLuong(soLuong);
        updateDataToTableBanHangForm(this.detailBills,table_nhapHang);
        setTotalPrice();
    }
    public void XoaMouseClicked() {
        Computer computer_selected = getComputerSelectedTableBanHang();
        if (computer_selected == null) {
            return;
        }
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá sản phẩm này?", "Xoá sản phẩm",
                JOptionPane.YES_NO_OPTION);
        if(luaChon==JOptionPane.YES_OPTION){
            DetailBill detailBill =EntryFormByProductID(this.detailBills,computer_selected);
            this.detailBills.remove(detailBill);
        }
        updateDataToTableBanHangForm(detailBills,table_nhapHang);
        setTotalPrice();
    }
    public double CountTotalPrice(){
        double totalPrice = 0;
        for(DetailBill detailBill : this.detailBills){
            Computer computer = productsBLL.searchByIdProduct(detailBill.getMaMay());
            double donGia = computer.getGiaBan();
            int soLuong = detailBill.getSoLuong();
            totalPrice+=donGia*soLuong;
        }
        return totalPrice;
    }
    public void setTotalPrice(){
        DecimalFormat df = new DecimalFormat("#,###");
        double totalPrice = CountTotalPrice();
        label_TotalPrice.setText(df.format(totalPrice)+" VND");
    }
    public void BanHangMouseClicked() {
        if(detailBills.size()==0){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để nhập hàng !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bill bill = null;
        if(customer==null){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập thông tin khách hàng !");
            return;
        }
        bill = new Bill(currentUser.getMaChiNhanh(),customer.getMaKhachHang(),currentUser.getIdUser(),null,0,totalPrice(),"offline");
        int maPhieu = billBLL.insertBill(bill);
        updateDatabaseDetailBill(maPhieu);
        JOptionPane.showMessageDialog(this,"Nhập hàng thành công !");
        updateDatabaseInventory();
        resetNhapHang();
        writePDF.getInstance().writeHoaDonKhachHang(maPhieu);
    }
    public void updateDatabaseInventory(){
        ArrayList<Inventory>inventories = inventoryBLL.InventoryByBranch(currentBranch);
        for(DetailBill detailBill : detailBills){
            for (Inventory inventory :inventories){
                if(inventory.getMaMay() == detailBill.getMaMay()){
                    inventory.setSoLuong(inventory.getSoLuong()-detailBill.getSoLuong()) ;
                    inventoryBLL.updateSoLuong(inventory,currentBranch);
                }
            }
        }
        updateTableDataFormDAO();
    }
    public void updateDatabaseDetailBill(int maphieu){
        for(DetailBill detailBill : detailBills){
            detailBill.setMaPhieu(maphieu);
            detailBillBLL.insert(detailBill);
            Computer computer = productsBLL.searchByIdProduct(detailBill.getMaMay());
            computer.setSoLuong(computer.getSoLuong() - detailBill.getSoLuong());
            productsBLL.update(computer);
            updateTableDataFormDAO();
        }
    }
    public double totalPrice(){
        double tongTien = 0;
        for(DetailBill detailBill : detailBills){
            tongTien+=detailBill.getSoLuong()*productsBLL.searchByIdProduct(detailBill.getMaMay()).getGiaBan();
        }
        return tongTien;
    }
    public void resetNhapHang(){
        detailBills.clear();
        updateDataToTableBanHangForm(detailBills,table_nhapHang);
        label_TotalPrice.setText("");
    }
    public void NhapExcelMouseClicked(){
        jFileChooser.showOpenDialog(null);
        File file = jFileChooser.getSelectedFile();
        if(!file.getName().endsWith("xlsx")){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn file Excel.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            fillData(file);
        }
    }
    public void fillData(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {
            boolean hasError = false;
            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
            Iterator<Row> rowIterator = sheet.iterator();

            // Bỏ qua dòng đầu tiên nếu là header
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                int maMay = (int) row.getCell(0).getNumericCellValue();
                int soLuong =  (int) row.getCell(1).getNumericCellValue();
                DetailBill detailBill = new DetailBill(maMay,soLuong);
                Computer computer_Search = productsBLL.searchByIdProduct(maMay);
                if(computer_Search == null){
                    hasError = true;
                }else {
                    if(soLuong>computer_Search.getSoLuong()){
                        hasError = true;
                    }
                }
                if(hasError==false){
                    DetailBill detaiBill_isValid = isValidProduct(detailBill,detailBills);
                    if(detaiBill_isValid==null){
                        detailBills.add(detailBill);
                    }else {
                        detaiBill_isValid.setSoLuong(detaiBill_isValid.getSoLuong() + soLuong);
                    }
                }
                updateDataToTableBanHangForm(detailBills,table_nhapHang);
            }
            if(hasError){
                JOptionPane.showMessageDialog(this,"Tồn tại máy không có trong kho hoặc số lượng vượt quá kho !");
            }
            setTotalPrice();
            JOptionPane.showMessageDialog(this, Notification.success_ImportExcel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateTableDataFormDAO();
    }

    public DetailBill isValidProduct(DetailBill detailBill, ArrayList<DetailBill>detailBills){
        for(DetailBill item : detailBills){
            if(item.getMaMay()==detailBill.getMaMay()){
                return item;
            }
        }
        return null;
    }
    public Customer getCustomer() {
        String text = textField_InfoCustomer.getText();
        String[] split = text.split(" - ");
        Customer customer = customerBLL.findByPhone(split[0]);
        return customer;
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

