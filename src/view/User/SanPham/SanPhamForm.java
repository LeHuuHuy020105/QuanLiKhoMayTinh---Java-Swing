package view.User.SanPham;

import DAO.LaptopDAO;
import DAO.PCDAO;
import DAO.PermissionsDAO;
import DAO.ProductsDAO;
import controller.*;
import model.Computer;
import model.Laptop;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import model.PC;
import model.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.Icon;

import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SanPhamForm extends JPanel implements updateDataToTable<Computer>,ExcelIntrerface{

    private static final long serialVersionUID = 1L;
    private JTextField input_Search;
    private JTable table_product;
    private JFileChooser jChooser = new JFileChooser();
    private JComboBox cbx_luaChon;
    private User currentUser;

    /**
     * Create the panel.
     */
    public SanPhamForm(User currentUser) {
        this.currentUser = currentUser;
        setLayout(null);
        setSize(1500, 950);
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

        JButton btn_Them = new JButton("Thêm");
        btn_Them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThemSanPhamMouseClicked();
            }
        });
        btnEffect.effectBtnHover(btn_Them);
        btn_Them.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_Them.setIcon(new ImageIcon(Icon.add));
        btn_Them.setHorizontalTextPosition(SwingConstants.CENTER);
        btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btn_Them.setFocusPainted(false);
        btn_Them.setContentAreaFilled(false);
        btn_Them.setBorderPainted(false);
        btn_Them.setOpaque(true);
        btn_Them.setBackground(UIManager.getColor("Button.background"));
        btn_Them.setBounds(10, 0, 70, 52);
        panel_5_1.add(btn_Them);

        JButton btnXemChiTiet = new JButton("Xem chi tiết");
        btnXemChiTiet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XemChiTietMouseClicked();
            }
        });
        btnXemChiTiet.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXemChiTiet.setIcon(new ImageIcon(Icon.eye));
        btnXemChiTiet.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXemChiTiet.setFocusPainted(false);
        btnXemChiTiet.setContentAreaFilled(false);
        btnXemChiTiet.setBorderPainted(false);
        btnXemChiTiet.setBackground(UIManager.getColor("Button.background"));
        btnXemChiTiet.setBounds(170, 0, 107, 52);
        panel_5_1.add(btnXemChiTiet);

        JButton btnXuatExcel = new JButton("Xuất Excel");
        btnXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhapExelMouseClicked();
            }
        });
        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXuatExcel.setIcon(new ImageIcon(Icon.xuatExcel));
        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXuatExcel.setFocusPainted(false);
        btnXuatExcel.setContentAreaFilled(false);
        btnXuatExcel.setBorderPainted(false);
        btnXuatExcel.setBackground(UIManager.getColor("Button.background"));
        btnXuatExcel.setBounds(487, 0, 99, 52);
        panel_5_1.add(btnXuatExcel);

        JButton btnNhapExcel = new JButton("Nhập Excel");
        btnNhapExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhapExelMouseClicked();
            }
        });
        btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNhapExcel.setIcon(new ImageIcon(Icon.nhapExcel));
        btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNhapExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNhapExcel.setFocusPainted(false);
        btnNhapExcel.setContentAreaFilled(false);
        btnNhapExcel.setBorderPainted(false);
        btnNhapExcel.setBackground(UIManager.getColor("Button.background"));
        btnNhapExcel.setBounds(375, 0, 98, 52);
        panel_5_1.add(btnNhapExcel);

        JButton btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuaSanPhamMouseClicked();
            }
        });
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

        JButton btnXoa = new JButton("Xoá");
        btnXoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XoaMouseClicked();
            }
        });
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setIcon(new ImageIcon(Icon.delete));
        btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXoa.setFocusPainted(false);
        btnXoa.setContentAreaFilled(false);
        btnXoa.setBorderPainted(false);
        btnXoa.setBackground(UIManager.getColor("Button.background"));
        btnXoa.setBounds(287, 0, 70, 52);
        panel_5_1.add(btnXoa);

        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
        verticalBox_1.setBounds(620, 11, 627, 75);
        add(verticalBox_1);

        JPanel panel_5_1_1 = new JPanel();
        verticalBox_1.add(panel_5_1_1);
        panel_5_1_1.setLayout(null);

        String [] cbxLuaChonValues = new String[] {"Tất cả","Tên máy","Số lượng","Đơn giá","RAM","CPU","Dung lượng","Card màn hình","Xuất xứ"};
        cbx_luaChon = new JComboBox(cbxLuaChonValues);
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
        input_Search.setBounds(156, 11, 325, 30);
        panel_5_1_1.add(input_Search);

        JButton btnNewButton_1 = new JButton("Làm mới");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                updateTableDataFormDAO();
            }
        });
        btnNewButton_1.setIcon(new ImageIcon(Icon.refesh));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(491, 9, 114, 30);
        panel_5_1_1.add(btnNewButton_1);

        table_product = new JTable();
        table_product.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Mã máy", "Tên máy", "Số lượng", "Đơn giá","Giá bán", "Bộ xử lí", "RAM", "Bộ nhớ", "Loại máy"
                }
        ));

        JScrollPane scrollPane = new JScrollPane(table_product);
        scrollPane.setBounds(10, 126, 1247, 774);
        add(scrollPane);
        updateTableDataFormDAO();
        btnEffect.effectBtnHover(btn_Them);     // Nút Thêm
        btnEffect.effectBtnHover(btnXemChiTiet);   // Nút Xem chi tiết
        btnEffect.effectBtnHover(btnXuatExcel);    // Nút Xuất Excel
        btnEffect.effectBtnHover(btnNhapExcel);    // Nút Nhập Excel
        btnEffect.effectBtnHover(btnSua);          // Nút Sửa
        btnEffect.effectBtnHover(btnXoa);          // Nút Xoá

        PermissionsDAO.applyPermissions(currentUser.getIdUser(),"Sản phẩm",btn_Them,btnXoa,btnSua,btnXemChiTiet,btnXuatExcel,btnNhapExcel);
    }

    public void XemChiTietMouseClicked() {
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham(this);
        chiTietSanPham.setVisible(true);
    }

    public void SuaSanPhamMouseClicked() {
        SuaSanPhamForm suaSanPhamForm = new SuaSanPhamForm(this);
        suaSanPhamForm.setVisible(true);
    }

    public void ThemSanPhamMouseClicked() {
        ThemSanPham themSanPham = new ThemSanPham(this);
        themSanPham.setVisible(true);
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
    public void jTextFieldSearchKeyReleased(){
        String luaChon = cbx_luaChon.getSelectedItem()+"";
        String content_Search = input_Search.getText();
        ArrayList<Computer> result = SearchFn(luaChon,content_Search);
        updateTableData(result);
    }
    public ArrayList<Computer> SearchFn(String luaChon , String content_Search){
        ArrayList<Computer> result = new ArrayList<>();
        SearchProduct searchProduct = new SearchProduct();
        switch (luaChon) {
            case "Tất cả":
                result = searchProduct.searchTatCa(content_Search);
                break;
            case "Tên máy":
                result = searchProduct.searchTenMay(content_Search);
                break;
            case "Số lượng":
                result = searchProduct.searchSoLuong(content_Search);
                break;
            case "Đơn giá":
                result = searchProduct.searchDonGia(content_Search);
                break;
            case "RAM":
                result = searchProduct.searchRam(content_Search);
                break;
            case "CPU":
                result = searchProduct.searchCpu(content_Search);
                break;
            case "Dung lượng":
                result = searchProduct.searchDungLuong(content_Search);
                break;
            case "Card màn hình":
                result = searchProduct.searchCard(content_Search);
                break;
            case "Xuất xứ":
                result = searchProduct.searchXuatXu(content_Search);
                break;
        }
        return result;
    }
    @Override
    public void XuatExcelMouseClicked(){
        jChooser.setDialogTitle("Chọn nơi lưu file Excel");
        jChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        exportTableToExcel(table_product,jChooser);
    }
    public void exportTableToExcel(JTable table,JFileChooser jChooser){
//        int userSelection = jChooser.showSaveDialog(null);
//        if (userSelection == JFileChooser.APPROVE_OPTION) {
//            File file = jChooser.getSelectedFile();
//
//            // Đảm bảo file có đuôi .xlsx
//            if (!file.getAbsolutePath().endsWith(".xlsx")) {
//                file = new File(file.getAbsolutePath() + ".xlsx");
//            }
//
//            try (Workbook workbook = new XSSFWorkbook()) { // Tạo workbook Excel
//                Sheet sheet = workbook.createSheet("Data"); // Tạo sheet mới
//
//                TableModel model = table.getModel();
//                int rowCount = model.getRowCount();
//                int colCount = model.getColumnCount();
//
//                // Ghi tiêu đề cột
//                Row headerRow = sheet.createRow(0);
//                for (int col = 0; col < colCount; col++) {
//                    Cell cell = headerRow.createCell(col);
//                    cell.setCellValue(model.getColumnName(col));
//                    cell.setCellStyle(createHeaderStyle(workbook)); // Style cho header
//                }
//
//                // Ghi dữ liệu từ JTable
//                for (int row = 0; row < rowCount; row++) {
//                    Row excelRow = sheet.createRow(row + 1);
//                    for (int col = 0; col < colCount; col++) {
//                        Cell cell = excelRow.createCell(col);
//                        Object value = model.getValueAt(row, col);
//                        cell.setCellValue(value != null ? value.toString() : "");
//                    }
//                }
//
//                // Ghi file Excel ra đĩa
//                try (FileOutputStream fileOut = new FileOutputStream(file)) {
//                    workbook.write(fileOut);
//                }
//
//                JOptionPane.showMessageDialog(null,Notification.success_ExportExcel  + file.getAbsolutePath());
//            } catch (IOException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, Notification.error_SaveExcel,"Lỗi",JOptionPane.ERROR_MESSAGE);
//            }
//        }
    }
    private CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
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
    public void fillData(File file) {
//        try (FileInputStream fis = new FileInputStream(file);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
//            Iterator<Row> rowIterator = sheet.iterator();
//
//            // Bỏ qua dòng đầu tiên nếu là header
//            if (rowIterator.hasNext()) {
//                rowIterator.next();
//            }
//
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//
//                // Đọc dữ liệu từ các cột của file Excel
//                String tenmay = row.getCell(0).getStringCellValue();
//                int soluong = (int) row.getCell(1).getNumericCellValue();
//                double gia = row.getCell(2).getNumericCellValue();
//                String tenCPU = row.getCell(4).getStringCellValue();
//                String ram = row.getCell(5).getStringCellValue();
//                String xuatxu = row.getCell(6).getStringCellValue();
//                String cardmanhinh = row.getCell(7).getStringCellValue();
//                String rom = row.getCell(11).getStringCellValue();
//                String loaimay = row.getCell(12).getStringCellValue();
//                System.out.println(loaimay);
//                String manhacungcap = row.getCell(13).getStringCellValue();
//                double dungluongluutru = row.getCell(14).getNumericCellValue(); // Đọc số thay vì String
//
//                // Kiểm tra loại máy để tạo đối tượng Laptop hoặc PC
//                if (loaimay.equalsIgnoreCase("Laptop")) {
//                    int soLuongLaptop = LaptopDAO.getInstance().selectAll().size();
//                    String mamay = "LP" + (soLuongLaptop + 1);
//                    double kichthuocman = row.getCell(9).getNumericCellValue();
//                    String dungluongpin = row.getCell(10).getStringCellValue(); // Sử dụng String vì constructor yêu cầu
//
//                    // Tạo đối tượng Laptop với đúng tham số
//                    Laptop laptop = new Laptop(cardmanhinh, gia, 0, ram, rom, soluong, tenCPU, tenmay, xuatxu, dungluongpin, kichthuocman, manhacungcap, dungluongluutru);
//                    LaptopDAO.getInstance().insert(laptop);
//                } else {
//                    int soLuongPC = PCDAO.getInstance().selectAll().size();
//                    String mamay = "PC" + (soLuongPC + 1);
//                    String mainboard = row.getCell(7).getStringCellValue();
//                    int congsuatnguon = (int) row.getCell(8).getNumericCellValue();
//
//                    // Tạo đối tượng PC với đúng tham số
//                    PC pc = new PC(cardmanhinh, gia, 0, ram, rom, soluong, tenCPU, tenmay, xuatxu, congsuatnguon, mainboard, manhacungcap, dungluongluutru);
//                    PCDAO.getInstance().insert(pc);
//                }
//            }
//            JOptionPane.showMessageDialog(this, Notification.success_ImportExcel);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        updateTableDataFormDAO();
    }
    public void XoaMouseClicked(){
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá sản phẩm này?", "Xoá sản phẩm",
                JOptionPane.YES_NO_OPTION);
        if(luaChon==JOptionPane.YES_OPTION){
            Computer computer_Selected = getComputerSelected();
            ProductsDAO.getInstance().delete(computer_Selected);
            updateTableDataFormDAO();
        }
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
            String loaiMay = "";
            if (computer instanceof Laptop) {
                loaiMay = "Laptop";
            } else {
                loaiMay = "PC";
            }
            System.out.println(computer.getGia());
            model.addRow(
                    new Object[]{
                            computer.getMaMay(),
                            computer.getTenMay(),
                            computer.getSoLuong(),
                            df.format(computer.getGia()) + " VND",
                            df.format(computer.getGiaBan())+" VND",
                            computer.getCardManHinh(),
                            computer.getRam(),
                            computer.getDungLuongLuuTru(),
                            loaiMay
                    });
        }
    }
}
