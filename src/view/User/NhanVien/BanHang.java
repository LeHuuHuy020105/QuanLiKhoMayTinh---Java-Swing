package view.User.NhanVien;

import DAO.*;
import controller.Notification;
import controller.SearchProduct;
import controller.updateDataToTable;
import model.*;
import view.Icon;
import view.User.QLTaiKhoanNguoiDung.QLTaiKhoanNguoiDungForm;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
    private JTextField textField_InfoVoucher;

    /**
     * Create the panel.
     */
    public BanHang(User user) {
        this.detailBills = new ArrayList<>();
        this.currentUser = user;
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
        scrollPane_1.setBounds(676, 236, 559, 312);
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

        textField_InfoVoucher = new JTextField();
        textField_InfoVoucher.setText((String) null);
        textField_InfoVoucher.setEditable(false);
        textField_InfoVoucher.setColumns(10);
        textField_InfoVoucher.setBounds(676, 156, 493, 27);
        add(textField_InfoVoucher);

        JButton btnNewButton_3_1 = new JButton("Voucher");
        btnNewButton_3_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VoucherMouseClicked();

            }
        });
        btnNewButton_3_1.setBounds(1174, 159, 47, 21);
        add(btnNewButton_3_1);

        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        ArrayList<String> items = dataCustomer(customers);
        fillData();
        setVisible(true);
    }

    private void VoucherMouseClicked() {
        RadioButtonScrollExample radioButtonScrollExample = new RadioButtonScrollExample(this);
    }


    private void SearchCustomer() {
        QLTaiKhoanNguoiDungForm qlTaiKhoanNguoiDungForm = new QLTaiKhoanNguoiDungForm(this);
    }
    public void fillInfoCustomer(Customer customer){
        String s = customer.getSoDienThoai()+" - "+customer.getFullName();
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
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
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
    public DetailBill isValidProduct(DetailBill detailBill, ArrayList<DetailBill>detailBills){
        for(DetailBill item : detailBills){
            if(item.getMaMay()==detailBill.getMaMay()){
                return item;
            }
        }
        return null;
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
        ArrayList<Computer> computers = InventoryBranchData();
        updateTableData(computers);
    }
    public ArrayList<Computer> InventoryBranchData(){
        Branch branch = BrandDAO.getInstance().BranchByID(currentUser.getMaChiNhanh());
        ArrayList<Inventory> inventories = InventoryDAO.getInstance().InventoryByBranch(branch);
        ArrayList<Computer> result = new ArrayList<>();
        for(Inventory item : inventories){
            Computer computer = ProductsDAO.getInstance().searchByIDProduct(item.getMaMay());
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
            String tenNCC = ProducersDAO.getInstance().producerByID(computer.getMaNhaCungCap()).getTenNhaCungCap();
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

    public Computer getComputerSelectedTableProduct() {
        Computer computer = null;
        DefaultTableModel model = (DefaultTableModel) table_product.getModel();
        int i_row = table_product.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, Notification.not_SelectedProduct);
            return null;
        }
        int maMay = Integer.parseInt(model.getValueAt(i_row, 0) + "");
        computer = ProductsDAO.getInstance().searchByIDProduct(maMay);
        return computer;
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
        Computer computer_selected = getComputerSelectedTableProduct();
        int maMay =computer_selected.getMaMay();

        DetailBill detailBill = new DetailBill(maMay,0,soLuong);
        DetailBill detailBill_isValid = isValidProduct(detailBill,detailBills);
        if(detailBill_isValid==null){
            this.detailBills.add(detailBill);
        }else {
            int soluong_valid = detailBill_isValid.getSoLuong();
            detailBill_isValid.setSoLuong(soluong_valid+soLuong);
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
            Computer computer = ProductsDAO.getInstance().searchByIDProduct(detailBill.getMaMay());
            String tenNCC = ProducersDAO.getInstance().producerByID(computer.getMaNhaCungCap()).getTenNhaCungCap();
            model.addRow(new Object[]{
                    computer.getMaMay(),
                    computer.getTenMay(),
                    tenNCC,
                    detailBill.getSoLuong(),
                    df.format(computer.getGia()) + " VND",
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
        computer = ProductsDAO.getInstance().searchByIDProduct(maMay);
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
        if(hasError)return;

        DetailBill detailBill =EntryFormByProductID(this.detailBills,computer_selected);
        detailBill.setSoLuong(soLuong);
        updateDataToTableBanHangForm(this.detailBills,table_nhapHang);
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
            Computer computer = ProductsDAO.getInstance().searchByIDProduct(detailBill.getMaMay());
            double donGia = computer.getGia();
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
            bill = new Bill();

        }else {
            bill = new Bill(currentUser.getMaChiNhanh(),customer.getMaKhachHang(),currentUser.getIdUser(),null,0,0,"offline");
        }

        int maPhieu = BillDAO.getInstance().insertBill(bill);
        updateDatabaseDetailBill(maPhieu);
        JOptionPane.showMessageDialog(this,"Nhập hàng thành công !");
        resetNhapHang();
    }
    public void updateDatabaseDetailBill(int maphieu){
        for(DetailBill detailBill : detailBills){
            detailBill.setMaPhieu(maphieu);
            DetailBillDAO.getInstance().insert(detailBill);
            Computer computer = ProductsDAO.getInstance().searchByIDProduct(detailBill.getMaMay());
            computer.setSoLuong(computer.getSoLuong() - detailBill.getSoLuong());
            ProductsDAO.getInstance().update(computer);
            updateTableDataFormDAO();
        }
    }
    public void resetNhapHang(){
        detailBills.clear();
        updateDataToTableBanHangForm(detailBills,table_nhapHang);
        label_TotalPrice.setText("");
    }
    public void fillInfoVoucher(Voucher voucher){
        textField_InfoVoucher.setText(voucher.getDescription());
    }
    public void exportPDF(ArrayList<DetailImportProducts>detailImportProducts){
//        try {
//            com.itextpdf.text.Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream("PhieuNhap.pdf"));
//            document.open();
//
//            // Font setting
//            BaseFont baseFont = BaseFont.createFont("times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(baseFont, 14, Font.BOLD);
//            com.itextpdf.text.Font textFont = new com.itextpdf.text.Font(baseFont, 12);
//
//            // Title
//            Paragraph title = new Paragraph("THÔNG TIN PHIẾU NHẬP", titleFont);
//            title.setAlignment(Element.ALIGN_CENTER);
//            document.add(title);
//
//            document.add(new Paragraph("\n"));
//
//
//            int maPhieu = detailImportProducts.get(0).getMaphieunhap();
//            ImportProducts importProducts = ImportProductsDAO.getInstance().getImportProductsByMaPhieuNhap(maPhieu);
//            Timestamp thoiGian =importProducts .getTimestamp();
//            String nguoiTao = UserDAO.getInstance().getUsetById(importProducts.getManguoidung()).getFullName();
//
//            // Information
//            document.add(new Paragraph("Mã phiếu: " + maPhieu, textFont));
//            document.add(new Paragraph("Thời gian tạo: " + thoiGian, textFont));
//            document.add(new Paragraph("Người tạo: " + nguoiTao, textFont));
//
//            document.add(new Paragraph("\n"));
//
//            // Table
//            PdfPTable table = new PdfPTable(5);
//            table.setWidthPercentage(100);
//            table.setWidths(new float[]{2, 5, 3, 2, 3});
//
//            String[] headers = {"Mã máy", "Tên máy", "Đơn giá", "SL", "Tổng tiền"};
//            for (String header : headers) {
//                PdfPCell cell = new PdfPCell(new Phrase(header, textFont));
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//                table.addCell(cell);
//            }
//            // Duyệt qua mảng detailImportProducts để tạo dữ liệu cho bảng
//            DecimalFormat df = new DecimalFormat("#,###");
//            for (DetailImportProducts detail : detailImportProducts) {
//                Computer computer = ProductsDAO.getInstance().searchByIDProduct(detail.getMaMay());
//                String tenMay = computer.getTenMay();
//                String donGia = df.format(computer.getGia()) + " VND";
//                int soLuong = detail.getSoluong();
//                double tongTien = importProducts.getTongTien();
//                String tongTienFormatted = df.format(tongTien) + " VND";
//
//                // Thêm dữ liệu vào bảng
//                table.addCell(new PdfPCell(new Phrase(String.valueOf(detail.getMaMay()), textFont)));
//                table.addCell(new PdfPCell(new Phrase(tenMay, textFont)));
//                table.addCell(new PdfPCell(new Phrase(donGia, textFont)));
//                table.addCell(new PdfPCell(new Phrase(String.valueOf(soLuong), textFont)));
//                table.addCell(new PdfPCell(new Phrase(tongTienFormatted, textFont)));
//            }
//            document.add(table);
//
//            // Total amount
//            document.add(new Paragraph("\nTổng thanh toán: "+importProducts.getTongTien() , textFont));
//            document.close();
//
//            JOptionPane.showMessageDialog(null, "Xuất PDF thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Lỗi khi xuất PDF!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        }
        System.out.println("abc");
    }
    public Customer getCustomer() {
        String text = textField_InfoCustomer.getText();
        String[] split = text.split(" - ");
        Customer customer = CustomerDAO.getInstance()
        return customer;
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

