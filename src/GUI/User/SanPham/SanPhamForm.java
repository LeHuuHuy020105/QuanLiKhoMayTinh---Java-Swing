package GUI.User.SanPham;

import DAO.*;
import BLL.*;
import DTO.Computer;
import DTO.Laptop;

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
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.*;

import DTO.PC;
import DTO.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import GUI.Icon;
import GUI.User.Excel.ConfirmDataExcel;

import java.io.File;
import java.io.FileInputStream;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SanPhamForm extends JPanel implements updateDataToTable<Computer>,ExcelIntrerface{

    private static final long serialVersionUID = 1L;
    private JButton btnNhapExcel;
    private JButton btnXuatExcel;
    private JButton btnXemChiTiet;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btn_Them;
    private String[] columnNames;
    private JTextField input_Search;
    private JTable table_product;
    private JFileChooser jChooser = new JFileChooser();
    private JComboBox cbx_luaChon;
    private User currentUser;
    private UserBLL userBLL;
    private ProductsBLL productsBLL;

    public SanPhamForm() {
    }

    /**
     * Create the panel.
     */

    public SanPhamForm(User currentUser) {
        this.currentUser = currentUser;
        this.userBLL = new UserBLL();
        this.productsBLL = new ProductsBLL();
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


        btn_Them = new JButton("Thêm");
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

        btnXemChiTiet = new JButton("Xem chi tiết");
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

        btnXuatExcel = new JButton("Xuất Excel");
        btnXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XuatExcelMouseClicked();
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

        btnNhapExcel = new JButton("Nhập Excel");
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


        btnSua = new JButton("Sửa");
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

        btnXoa = new JButton("Xoá");
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

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                updateTableDataFormDAO();
            }
        });
        btnNewButton_1.setIcon(new ImageIcon(Icon.refesh));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(491, 9, 114, 30);
        panel_5_1_1.add(btnNewButton_1);

        String[] columnNames = new String[]{
                "Mã máy", "Tên máy", "Số lượng", "Đơn giá", "Giá bán",
                "Bộ xử lí", "CPU", "RAM", "Bộ nhớ", "Loại máy"
        };

        // Tạo JTable
        table_product = new JTable();

        // Tạo DefaultTableModel với isCellEditable trả về false
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                columnNames
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa bất kỳ ô nào
            }
        };

        // Gán model cho JTable
        table_product.setModel(model);

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
        Permission();
    }
    public void Permission(){
        int roleUser = userBLL.getIDRoleByIDUser(currentUser.getIdUser());
        PermissionsDAO.applyPermissions(roleUser,"Sản phẩm",btn_Them,btnXoa,btnSua,btnXemChiTiet,btnXuatExcel,btnNhapExcel);
    }
    public void XemChiTietMouseClicked() {
        Computer computer_Selected = getComputerSelected();
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham(computer_Selected);
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

            computer_Selected = productsBLL.searchByIdProduct(maMay);
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
        ArrayList<Computer>computers = productsBLL.selectAll();
        jChooser.setDialogTitle("Chọn nơi lưu file Excel");
        jChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        exportListToExcel(computers,jChooser);
    }
    public void exportListToExcel(ArrayList<Computer> dataList, JFileChooser jChooser) {
        int userSelection = jChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = jChooser.getSelectedFile();

            // Đảm bảo file có đuôi .xlsx
            if (!file.getAbsolutePath().endsWith(".xlsx")) {
                file = new File(file.getAbsolutePath() + ".xlsx");
            }

            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Data");
                CreationHelper createHelper = workbook.getCreationHelper();

                // Định dạng số cho cột giá
                CellStyle numberStyle = workbook.createCellStyle();
                DataFormat format = createHelper.createDataFormat();
                numberStyle.setDataFormat(format.getFormat("#,##0.00")); // Hiển thị dạng số (VD: 1,500.00)

                // 🔹 Lấy tất cả thuộc tính từ Computer, Laptop, PC (BỎ QUA hinhAnh)
                Set<Field> allFields = new LinkedHashSet<>();
                Class<?>[] classes = {Computer.class, Laptop.class, PC.class};
                for (Class<?> clazz : classes) {
                    while (clazz != null) {
                        allFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
                        clazz = clazz.getSuperclass();
                    }
                }

                // Loại bỏ trường "hinhAnh"
                allFields.removeIf(field -> field.getName().equals("hinhAnh"));
                allFields.removeIf(field -> field.getName().equals("soLuong"));

                // Chuyển danh sách thuộc tính về mảng để dễ xử lý
                Field[] fields = allFields.toArray(new Field[0]);

                // 🔹 Ghi tiêu đề cột
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(fields[i].getName()); // Đặt tên cột
                    cell.setCellStyle(createHeaderStyle(workbook)); // Áp dụng style header
                }
                int typeColumnIndex = fields.length; // Cột cuối cùng
                Cell typeHeader = headerRow.createCell(typeColumnIndex);
                typeHeader.setCellValue("Loại máy");
                typeHeader.setCellStyle(createHeaderStyle(workbook));

                // 🔹 Ghi dữ liệu của từng object
                for (int rowIndex = 0; rowIndex < dataList.size(); rowIndex++) {
                    Row row = sheet.createRow(rowIndex + 1);
                    Computer obj = dataList.get(rowIndex);

                    for (int colIndex = 0; colIndex < fields.length; colIndex++) {
                        fields[colIndex].setAccessible(true);
                        Cell cell = row.createCell(colIndex);

                        try {
                            // 🔹 Kiểm tra nếu obj có thuộc tính này
                            Object value = null;
                            if (fields[colIndex].getDeclaringClass().isAssignableFrom(obj.getClass())) {
                                value = fields[colIndex].get(obj);
                            }

                            // 🔹 Định dạng giá trị trước khi gán vào ô Excel
                            if (value != null) {
                                if (value instanceof Integer) {
                                    cell.setCellValue((Integer) value); // Giữ nguyên số nguyên
                                } else if (value instanceof Double) {
                                    cell.setCellValue((Double) value); // Giữ số thực
                                    cell.setCellStyle(numberStyle); // Áp dụng format số thập phân
                                } else {
                                    cell.setCellValue(value.toString()); // Ghi chuỗi nếu không phải số
                                }
                            } else {
                                cell.setCellValue(""); // Nếu không có dữ liệu, để trống
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            cell.setCellValue(""); // Nếu lỗi, đặt giá trị trống
                        }
                    }
                    // **GHI LOẠI MÁY VÀO CỘT CUỐI CÙNG**
                    Cell typeCell = row.createCell(typeColumnIndex);
                    if (obj instanceof Laptop) {
                        typeCell.setCellValue("Laptop");
                    } else {
                        typeCell.setCellValue("PC");
                    }
                }

                // Ghi file Excel ra đĩa
                try (FileOutputStream fileOut = new FileOutputStream(file)) {
                    workbook.write(fileOut);
                }

                JOptionPane.showMessageDialog(null, "Xuất Excel thành công: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file Excel", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
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
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
            Iterator<Row> rowIterator = sheet.iterator();

            // Bỏ qua dòng đầu tiên nếu là header
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            ArrayList<Computer> computers = new ArrayList<>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Computer computer = null;
                // Đọc dữ liệu từ các cột của file Excel
                String tenmay = row.getCell(1).getStringCellValue();
                int soluong = 0;
                double gia = row.getCell(2).getNumericCellValue();
                double giaBan = row.getCell(3).getNumericCellValue();
                String tenCPU = row.getCell(4).getStringCellValue();
                String ram = row.getCell(5).getStringCellValue();
                String xuatxu = row.getCell(6).getStringCellValue();
                String cardmanhinh = row.getCell(7).getStringCellValue();
                String rom = row.getCell(8).getStringCellValue();
                String manhacungcap = row.getCell(9).getStringCellValue();
                double dungluongluutru = row.getCell(10).getNumericCellValue(); // Đọc số thay vì String
                String loaimay = row.getCell(15).getStringCellValue();


                // Kiểm tra loại máy để tạo đối tượng Laptop hoặc PC
                if (loaimay.equalsIgnoreCase("Laptop")) {
                    double kichthuocman = row.getCell(11).getNumericCellValue();
                    String dungluongpin = row.getCell(12).getStringCellValue(); // Sử dụng String vì constructor yêu cầu

                    // Tạo đối tượng Laptop với đúng tham số
                     computer = new Laptop(cardmanhinh, gia, 0, ram, rom, soluong, tenCPU, tenmay, xuatxu, dungluongpin, kichthuocman, manhacungcap, dungluongluutru,giaBan,null);
                } else {
                    String mainboard = row.getCell(13).getStringCellValue();
                    int congsuatnguon = (int) row.getCell(14).getNumericCellValue();

                    // Tạo đối tượng PC với đúng tham số
                    computer = new PC(cardmanhinh, gia, 0, ram, rom, soluong, tenCPU, tenmay, xuatxu, congsuatnguon, mainboard, manhacungcap, dungluongluutru,giaBan,null);
                }
                computers.add(computer);
            }
            ConfirmDataExcel confirmDataExcel = new ConfirmDataExcel(computers, columnNames, "Sản phẩm",this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateTableDataFormDAO();
    }

    public void XoaMouseClicked(){
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá sản phẩm này?", "Xoá sản phẩm",
                JOptionPane.YES_NO_OPTION);
        if(luaChon==JOptionPane.YES_OPTION){
            Computer computer_Selected = getComputerSelected();
            int ketQua = productsBLL.delete(computer_Selected);
            if (ketQua == -1) {
                JOptionPane.showMessageDialog(this, "Không thể xóa sản phẩm này vì đã có đơn liên quan!");
            } else if (ketQua > 0) {
                updateTableDataFormDAO();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } else if (ketQua == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm để xóa!");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi không xác định khi xóa sản phẩm !");
            }
            updateTableDataFormDAO();
        }
    }

    @Override
    public void updateTableDataFormDAO() {
        ArrayList<Computer> computers = productsBLL.selectAll();
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
            model.addRow(
                    new Object[]{
                            computer.getMaMay(),
                            computer.getTenMay(),
                            computer.getSoLuong(),
                            df.format(computer.getGia()) + " VND",
                            df.format(computer.getGiaBan())+" VND",
                            computer.getCardManHinh(),
                            computer.getTenCpu(),
                            computer.getRam(),
                            computer.getDungLuongLuuTru(),
                            loaiMay
                    });
        }
    }

    public JButton getBtn_Them() {
        return btn_Them;
    }

    public void setBtn_Them(JButton btn_Them) {
        this.btn_Them = btn_Them;
    }

    public JButton getBtnNhapExcel() {
        return btnNhapExcel;
    }

    public void setBtnNhapExcel(JButton btnNhapExcel) {
        this.btnNhapExcel = btnNhapExcel;
    }

    public JButton getBtnSua() {
        return btnSua;
    }

    public void setBtnSua(JButton btnSua) {
        this.btnSua = btnSua;
    }

    public JButton getBtnXemChiTiet() {
        return btnXemChiTiet;
    }

    public void setBtnXemChiTiet(JButton btnXemChiTiet) {
        this.btnXemChiTiet = btnXemChiTiet;
    }

    public JButton getBtnXoa() {
        return btnXoa;
    }

    public void setBtnXoa(JButton btnXoa) {
        this.btnXoa = btnXoa;
    }

    public JButton getBtnXuatExcel() {
        return btnXuatExcel;
    }

    public void setBtnXuatExcel(JButton btnXuatExcel) {
        this.btnXuatExcel = btnXuatExcel;
    }

    public JComboBox getCbx_luaChon() {
        return cbx_luaChon;
    }

    public void setCbx_luaChon(JComboBox cbx_luaChon) {
        this.cbx_luaChon = cbx_luaChon;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public JTextField getInput_Search() {
        return input_Search;
    }

    public void setInput_Search(JTextField input_Search) {
        this.input_Search = input_Search;
    }

    public JFileChooser getjChooser() {
        return jChooser;
    }

    public void setjChooser(JFileChooser jChooser) {
        this.jChooser = jChooser;
    }

    public JTable getTable_product() {
        return table_product;
    }

    public void setTable_product(JTable table_product) {
        this.table_product = table_product;
    }
}
