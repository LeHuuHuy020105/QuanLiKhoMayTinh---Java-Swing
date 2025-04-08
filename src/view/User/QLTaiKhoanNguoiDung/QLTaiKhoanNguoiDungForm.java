package view.User.QLTaiKhoanNguoiDung;

import DAO.CustomerDAO;
import DAO.PermissionsDAO;
import DAO.ProducersDAO;
import DAO.UserDAO;
import controller.*;
import model.Customer;
import model.Producer;
import model.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.Icon;
import view.User.Excel.ConfirmDataExcel;
import view.User.NhaCungCap.SuaNhaCungCap;
import view.User.NhaCungCap.ThemNhaCungCap;
import view.User.NhanVien.BanHang;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class QLTaiKhoanNguoiDungForm extends JFrame implements updateDataToTable<Customer>, ExcelIntrerface {

    private static final long serialVersionUID = 1L;
    private String[] columnNames;

    private JTextField input_Search;
    private JTable table_NCC;
    private JFileChooser jChooser ;
    private JComboBox cbx_Search;
    private User currentUser;
    private String role;
    private BanHang banHang;
    private JButton btn_ThemNCC;
    private JButton btnXuatExcel;
    private JButton btnNhapExcel;
    private JButton btnSua;
    private JButton btnXoa;

    /**
     * Create the panel.
     */
    public QLTaiKhoanNguoiDungForm(BanHang banHang) {
        this.banHang = banHang;
        this.currentUser = banHang.getCurrentUser();
        this.jChooser  = new JFileChooser();
        role = UserDAO.getInstance().getRoleByIDUser(currentUser.getIdUser());
        Component();
        Permission();
    }
    public QLTaiKhoanNguoiDungForm(User currentUser) {
        this.currentUser = currentUser;
        this.jChooser  = new JFileChooser();
        role = UserDAO.getInstance().getRoleByIDUser(currentUser.getIdUser());
        Component();
        Permission();
    }
    public void Permission(){
        int roleUser = UserDAO.getInstance().getIDRoleByIDUser(currentUser.getIdUser());
        PermissionsDAO.applyPermissions(roleUser,"Tài khoản khách hàng",btn_ThemNCC,btnXoa,btnSua,null,btnXuatExcel,btnNhapExcel);
    }
    public void Component(){
        getContentPane().setLayout(null);
        setSize(1257, 764);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        getContentPane().add(verticalBox);

        JPanel panel_5_1 = new JPanel();
        panel_5_1.setLayout(null);
        verticalBox.add(panel_5_1);

        btn_ThemNCC = new JButton("Thêm");
        btn_ThemNCC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThemNhaCungCapMouseClicked();
            }
        });
        btnEffect.effectBtnHover(btn_ThemNCC);
        btn_ThemNCC.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_ThemNCC.setIcon(new ImageIcon(Icon.add));
        btn_ThemNCC.setHorizontalTextPosition(SwingConstants.CENTER);
        btn_ThemNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btn_ThemNCC.setFocusPainted(false);
        btn_ThemNCC.setContentAreaFilled(false);
        btn_ThemNCC.setBorderPainted(false);
        btn_ThemNCC.setBackground(UIManager.getColor("Button.background"));
        btn_ThemNCC.setBounds(10, 0, 70, 52);
        panel_5_1.add(btn_ThemNCC);

        btnXuatExcel = new JButton("Xuất Excel");
        btnXuatExcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XuatExcelMouseClicked();
            }
        });
        btnEffect.effectBtnHover(btnXuatExcel);
        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXuatExcel.setIcon(new ImageIcon(Icon.xuatExcel));
        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXuatExcel.setFocusPainted(false);
        btnXuatExcel.setContentAreaFilled(false);
        btnXuatExcel.setBorderPainted(false);
        btnXuatExcel.setBackground(UIManager.getColor("Button.background"));
        btnXuatExcel.setBounds(400, 0, 99, 52);
        panel_5_1.add(btnXuatExcel);

        btnNhapExcel = new JButton("Nhập Excel");
        btnNhapExcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhapExelMouseClicked();
            }
        });
        btnEffect.effectBtnHover(btnNhapExcel);
        btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNhapExcel.setIcon(new ImageIcon(Icon.nhapExcel));
        btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNhapExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNhapExcel.setFocusPainted(false);
        btnNhapExcel.setContentAreaFilled(false);
        btnNhapExcel.setBorderPainted(false);
        btnNhapExcel.setBackground(UIManager.getColor("Button.background"));
        btnNhapExcel.setBounds(274, 0, 98, 52);
        panel_5_1.add(btnNhapExcel);

        btnSua = new JButton("Sửa");
        btnSua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SuaMouseClick();
            }
        });
        btnEffect.effectBtnHover(btnSua);
        btnSua.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSua.setIcon(new ImageIcon(Icon.edit));
        btnSua.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSua.setFocusPainted(false);
        btnSua.setContentAreaFilled(false);
        btnSua.setBorderPainted(false);
        btnSua.setBackground(UIManager.getColor("Button.background"));
        btnSua.setBounds(90, 0, 70, 52);
        panel_5_1.add(btnSua);

        btnXoa = new JButton("Xoá");
        btnXoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XoaMouseClicked();
            }
        });
        btnEffect.effectBtnHover(btnXoa);
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setIcon(new ImageIcon(Icon.delete));
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
        getContentPane().add(verticalBox_1);

        JPanel panel_5_1_1 = new JPanel();
        panel_5_1_1.setLayout(null);
        verticalBox_1.add(panel_5_1_1);
        String [] cbx_SearchValue = null;
        if(role.equals("Nhân viên bán hàng")){
            cbx_SearchValue= new String[]{"Tất cả","Tên khách hàng","Số điện thoại"};
        }else {
            cbx_SearchValue= new String[]{"Tất cả","Tài khoản","Tên khách hàng","Số điện thoại"};
        }

        cbx_Search = new JComboBox(cbx_SearchValue);
        cbx_Search.setBackground(UIManager.getColor("Button.background"));
        cbx_Search.setBounds(10, 11, 126, 30);
        panel_5_1_1.add(cbx_Search);

        input_Search = new JTextField();
        input_Search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                jTextFieldSearchKeyReleased();
            }
        });
        input_Search.setColumns(10);
        input_Search.setBounds(156, 11, 384, 30);
        panel_5_1_1.add(input_Search);

        JButton btn_LamMoi = new JButton("Làm mới");
        btn_LamMoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        btn_LamMoi.setIcon(new ImageIcon(Icon.refesh));
        btn_LamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_LamMoi.setBounds(550, 9, 128, 30);
        panel_5_1_1.add(btn_LamMoi);

        if(role.equals("Nhân viên bán hàng")){
            columnNames = new String[]{
                    "STT", "Mã khách hàng","Tên khách hàng", "Địa chỉ", "SDT"
            };
        }else {
            columnNames = new String[]{
                    "STT", "Mã khách hàng","Tên tài khoản","Tên khách hàng", "Địa chỉ", "SDT"
            };
        }
        table_NCC = new JTable();
        table_NCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table_NCC.setModel(new DefaultTableModel(
                new Object[][]{
                },
                columnNames
        ));
        JScrollPane scrollPane = new JScrollPane(table_NCC);
        scrollPane.setBounds(10, 127, 1237, 529);
        getContentPane().add(scrollPane);

        if(role.equals("Nhân viên bán hàng")){
            JButton btnNewButton_2_1 = new JButton("Xác nhận");
            btnNewButton_2_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    XacNhanKHMouseClicked();
                }
            });
            btnNewButton_2_1.setIcon(null);
            btnNewButton_2_1.setForeground(Color.WHITE);
            btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            btnNewButton_2_1.setBorderPainted(false);
            btnNewButton_2_1.setBackground(new Color(60, 179, 113));
            btnNewButton_2_1.setBounds(1094, 666, 139, 41);
            getContentPane().add(btnNewButton_2_1);
        }
        updateTableDataFormDAO();
        setVisible(true);
    }
    public void XacNhanKHMouseClicked() {
		Customer customer = getCustomerSelected();
        banHang.fillInfoCustomer(customer);
        this.dispose();
	}
    public void ThemNhaCungCapMouseClicked() {
        ThemTaiKhoanNguoiDung themTaiKhoanNguoiDung = new ThemTaiKhoanNguoiDung(this);
    }

    @Override
    public void updateTableDataFormDAO() {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        updateTableData(customers);
    }

    @Override
    public void updateTableData(ArrayList<Customer> t) {
        DefaultTableModel model = (DefaultTableModel) table_NCC.getModel();
        model.setRowCount(0);
        int i = 0;
        boolean isStaff = role.equals("Nhân viên bán hàng");
        for (Customer customer : t) {
            i++;
            if(isStaff){
                model.addRow(new Object[]{
                        i,
                        customer.getMaKhachHang(),
                        customer.getFullName(),
                        customer.getDiaChi()==null? "N/a" : customer.getDiaChi(),
                        customer.getSoDienThoai()
                });
            }else {
                model.addRow(new Object[]{
                        i,
                        customer.getMaKhachHang(),
                        customer.getUserName(),
                        customer.getFullName(),
                        customer.getDiaChi()==null? "N/a" : customer.getDiaChi(),
                        customer.getSoDienThoai()
                });
            }
        }
    }

    @Override
    public void NhapExelMouseClicked() {
        jChooser.showOpenDialog(null);
        File file = jChooser.getSelectedFile();
        if (!file.getName().endsWith("xlsx")) {
            JOptionPane.showMessageDialog(null,
                    Notification.not_SelectedExcel,
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            fillData(file);
        }
    }

    @Override
    public void XuatExcelMouseClicked(){
        jChooser.setDialogTitle("Chọn nơi lưu file Excel");
        jChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        exportTableToExcel(table_NCC,jChooser);
    }

    public void exportTableToExcel(JTable jTable, JFileChooser jFileChooser) {
        int userSelection = jFileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();

            // Đảm bảo file có đuôi .xlsx
            if (!file.getAbsolutePath().endsWith(".xlsx")) {
                file = new File(file.getAbsolutePath() + ".xlsx");
            }

            try (Workbook workbook = new XSSFWorkbook()) { // Tạo workbook Excel
                Sheet sheet = workbook.createSheet("Data"); // Tạo sheet mới

                TableModel model = jTable.getModel();
                int rowCount = model.getRowCount();
                int colCount = model.getColumnCount();

                // Ghi tiêu đề cột
                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < colCount; col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(model.getColumnName(col));
                    cell.setCellStyle(this.createHeaderStyle(workbook)); // Style cho header
                }

                // Ghi dữ liệu từ JTable
                for (int row = 0; row < rowCount; row++) {
                    Row excelRow = sheet.createRow(row + 1);
                    for (int col = 0; col < colCount; col++) {
                        Cell cell = excelRow.createCell(col);
                        Object value = model.getValueAt(row, col);
                        cell.setCellValue(value != null ? value.toString() : "");
                    }
                }

                // Ghi file Excel ra đĩa
                try (FileOutputStream fileOut = new FileOutputStream(file)) {
                    workbook.write(fileOut);
                }

                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!\nLưu tại: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi xuất Excel!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public void fillData(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
            Iterator<Row> rowIterator = sheet.iterator();

            // Bỏ qua dòng đầu tiên nếu là header
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            ArrayList<Producer> producers = new ArrayList<>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String maNCC = row.getCell(1).getStringCellValue();
                String tenNCC = row.getCell(2).getStringCellValue();
                String diaChi = row.getCell(3).getStringCellValue();
                String sdt = row.getCell(4).getStringCellValue();
                Producer producer = new Producer(diaChi,maNCC,sdt,tenNCC);
                producers.add(producer);
            }
            ConfirmDataExcel confirmDataExcel = new ConfirmDataExcel(producers, columnNames, "Chi nhánh");
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateTableDataFormDAO();
    }
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (cell.getColumnIndex() == 1) { // Kiểm tra nếu cột Mã NCC
                    return String.valueOf((long) cell.getNumericCellValue()); // Chuyển số thành chuỗi
                } else {
                    return String.valueOf(cell.getNumericCellValue()); // Số khác thì giữ nguyên
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }

    public CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }
    public void jTextFieldSearchKeyReleased(){
        String luachon = (String) cbx_Search.getSelectedItem();
        String content_Search = input_Search.getText();
        ArrayList<Customer> result = SearchFn(luachon,content_Search);
        updateTableData(result);
    }
    public ArrayList<Customer> SearchFn(String luachon , String content_Search){
        ArrayList<Customer>result = new ArrayList<>();
        SearchCustomer searchCustomer = new SearchCustomer();
        switch (luachon){
            case "Tất cả":
                if(role.equals("Nhân viên bán hàng")){
                    result = searchCustomer.searchAllForStaff(content_Search);
                }else {
                    result = searchCustomer.searchAll(content_Search);
                }
                break;
            case "Tài khoản":
                result = searchCustomer.searchTaiKhoan(content_Search);
                break;
            case "Tên khách hàng":
                result = searchCustomer.searchTen(content_Search);
                break;
            case "Số điện thoại":
                result = searchCustomer.searchSoDienThoai(content_Search);
                break;
        }
        return result;
    }
    public void XoaMouseClicked(){
        int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có muốn xoá tài khoản này hay không ", "xoá tài khoản người dùng", JOptionPane.YES_NO_OPTION);
        if(luaChon == JOptionPane.YES_OPTION){
            CustomerDAO.getInstance().delete(getCustomerSelected());
            updateTableDataFormDAO();
        }
    }
    public void SuaMouseClick(){

    }
    public Customer getCustomerSelected(){
        Customer customer = null;
        try {
            DefaultTableModel model = (DefaultTableModel) table_NCC.getModel();
            int i_row = table_NCC.getSelectedRow();
            if(i_row == -1){
                JOptionPane.showMessageDialog(this,"Vui lòng chọn 1 nhà cung cấp !");
                return null;
            }
            int maKH = Integer.parseInt(model.getValueAt(i_row,1)+"");
            customer = CustomerDAO.getInstance().findByID(maKH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
