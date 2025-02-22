package view.User.SanPham;

import DAO.LaptopDAO;
import DAO.PCDAO;
import DAO.ProductsDAO;
import controller.SearchProduct;
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
import java.text.NumberFormat;
import java.util.ArrayList;

import model.PC;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SanPhamForm extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField input_Search;
    private JTable table_product;
    private Color btn_hoverColor = new Color(192, 192, 192);
    private Color default_btn_hover = new Color(240, 240, 240);
    private JFileChooser jChooser = new JFileChooser();
	private JComboBox cbx_luaChon;

    /**
     * Create the panel.
     */
    public SanPhamForm() {
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
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThemSanPhamMouseClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton.setBackground(btn_hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton.setBackground(default_btn_hover);
            }
        });
        btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\add.png"));
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setOpaque(true);
        btnNewButton.setBackground(UIManager.getColor("Button.background"));
        btnNewButton.setBounds(10, 0, 70, 52);
        panel_5_1.add(btnNewButton);

        JButton btnXemChiTiet = new JButton("Xem chi tiết");
        btnXemChiTiet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnXemChiTiet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XemChiTietMouseClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnXemChiTiet.setBackground(btn_hoverColor);
            }

            public void mouseExited(MouseEvent e) {
                btnXemChiTiet.setBackground(default_btn_hover);
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
        panel_5_1.add(btnXemChiTiet);

        JButton btnXuatExcel = new JButton("Xuất Excel");
        btnXuatExcel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		XuatExcelMouseClicked();
        	}
        });
        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXuatExcel.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\xuatexcel.png"));
        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXuatExcel.setFocusPainted(false);
        btnXuatExcel.setContentAreaFilled(false);
        btnXuatExcel.setBorderPainted(false);
        btnXuatExcel.setBackground(UIManager.getColor("Button.background"));
        btnXuatExcel.setBounds(487, 0, 99, 52);
        panel_5_1.add(btnXuatExcel);

        JButton btnNhapExcel = new JButton("Nhập Excel");
        btnNhapExcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                NhapExelMouseClicked();
            }
        });
        btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNhapExcel.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\nhapexcel.png"));
        btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNhapExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNhapExcel.setFocusPainted(false);
        btnNhapExcel.setContentAreaFilled(false);
        btnNhapExcel.setBorderPainted(false);
        btnNhapExcel.setBackground(UIManager.getColor("Button.background"));
        btnNhapExcel.setBounds(375, 0, 98, 52);
        panel_5_1.add(btnNhapExcel);

        JButton btnSua = new JButton("Sửa");
        btnSua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SuaSanPhamMouseClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSua.setBackground(btn_hoverColor);
            }

            public void mouseExited(MouseEvent e) {
                btnSua.setBackground(default_btn_hover);
            }
        });
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
        btnXoa.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		XoaMouseClicked();
        	}
        });
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\delete.png"));
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

        String [] cbxLuaChonValues = new String[] {"Tất cả", "Mã máy", "Tên máy","Số lượng","Đơn giá","RAM","CPU","Dung lượng","Card màn hình","Xuất xứ"};
        cbx_luaChon = new JComboBox(cbxLuaChonValues);
        cbx_luaChon.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		updateTableDataProductFormDAO();
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
                updateTableDataProductFormDAO();
            }
        });
        btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(491, 9, 114, 30);
        panel_5_1_1.add(btnNewButton_1);

        table_product = new JTable();
        table_product.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Mã máy", "Tên máy", "Số lượng", "Đơn giá", "Bộ xử lí", "RAM", "Bộ nhớ", "Loại máy"
                }
        ));

        JScrollPane scrollPane = new JScrollPane(table_product);
        scrollPane.setBounds(10, 126, 1247, 774);
        add(scrollPane);
        updateTableDataProductFormDAO();
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

    public void updateTableDataProduct(ArrayList<Computer>computers) {
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
                            computer.getCardManHinh(),
                            computer.getRam(),
                            computer.getDungLuongLuuTru(),
                            loaiMay
                    });
        }
    }

    public Computer getComputerSelected() {
        Computer computer_Selected = null;
        try {
            DefaultTableModel model = (DefaultTableModel) table_product.getModel();
            int i_row = table_product.getSelectedRow();

            // Kiểm tra xem có hàng nào được chọn không
            if (i_row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một máy để chỉnh sửa!");
                return null; // Trả về null nếu không có hàng nào được chọn
            }

            // Lấy mã máy từ hàng được chọn
            String maMay = model.getValueAt(i_row, 0) + "";
            System.out.println("Mã máy được chọn: " + maMay);

            // Tìm kiếm máy trong cơ sở dữ liệu
            computer_Selected = ProductsDAO.getInstance().searchByIDProduct(maMay);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
        return computer_Selected;
    }
    public void updateTableDataProductFormDAO(){
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        updateTableDataProduct(computers);
    }
    public void jTextFieldSearchKeyReleased(){
        String luaChon = cbx_luaChon.getSelectedItem()+"";
        String content_Search = input_Search.getText();
        ArrayList<Computer> result = SearchFn(luaChon,content_Search);
        System.out.println(luaChon);
        updateTableDataProduct(result);
    }
    public ArrayList<Computer> SearchFn(String luaChon , String content_Search){
        ArrayList<Computer> result = new ArrayList<>();
        SearchProduct searchProduct = new SearchProduct();
        switch (luaChon) {
            case "Tất cả":
                result = searchProduct.searchTatCa(content_Search);
                break;
            case "Mã máy":
                result = searchProduct.searchMaMay(content_Search);
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
    public void XuatExcelMouseClicked(){
        jChooser.setDialogTitle("Chọn nơi lưu file Excel");
        jChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        exportTableToExcel(table_product,jChooser);
    }
    public void exportTableToExcel(JTable table,JFileChooser jChooser){
        int userSelection = jChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = jChooser.getSelectedFile();

            // Đảm bảo file có đuôi .xlsx
            if (!file.getAbsolutePath().endsWith(".xlsx")) {
                file = new File(file.getAbsolutePath() + ".xlsx");
            }

            try (Workbook workbook = new XSSFWorkbook()) { // Tạo workbook Excel
                Sheet sheet = workbook.createSheet("Data"); // Tạo sheet mới

                TableModel model = table.getModel();
                int rowCount = model.getRowCount();
                int colCount = model.getColumnCount();

                // Ghi tiêu đề cột
                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < colCount; col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(model.getColumnName(col));
                    cell.setCellStyle(createHeaderStyle(workbook)); // Style cho header
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
    private CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }
    public void NhapExelMouseClicked() {
        jChooser.showOpenDialog(null);
        File file = jChooser.getSelectedFile();
        if (!file.getName().endsWith("xlsx")) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng chọn file Excel.",
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

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Đọc dữ liệu từ các cột của file Excel
                String tenmay = row.getCell(0).getStringCellValue();
                int soluong = (int) row.getCell(1).getNumericCellValue();
                double gia = row.getCell(2).getNumericCellValue();
                String tenCPU = row.getCell(3).getStringCellValue();
                String ram = row.getCell(4).getStringCellValue();
                String xuatxu = row.getCell(5).getStringCellValue();
                String cardmanhinh = row.getCell(6).getStringCellValue();
                String rom = row.getCell(11).getStringCellValue();
                String loaimay = row.getCell(12).getStringCellValue();
                System.out.println(loaimay);
                String manhacungcap = row.getCell(13).getStringCellValue();
                double dungluongluutru = row.getCell(14).getNumericCellValue(); // Đọc số thay vì String

                // Kiểm tra loại máy để tạo đối tượng Laptop hoặc PC
                if (loaimay.equalsIgnoreCase("Laptop")) {
                    int soLuongLaptop = LaptopDAO.getInstance().selectAll().size();
                    String mamay = "LP" + (soLuongLaptop + 1);
                    double kichthuocman = row.getCell(9).getNumericCellValue();
                    String dungluongpin = row.getCell(10).getStringCellValue(); // Sử dụng String vì constructor yêu cầu

                    // Tạo đối tượng Laptop với đúng tham số
                    Laptop laptop = new Laptop(cardmanhinh, gia, mamay, ram, rom, soluong, tenCPU, tenmay, xuatxu, dungluongpin, kichthuocman, manhacungcap, dungluongluutru);
                    LaptopDAO.getInstance().insert(laptop);
                } else {
                    int soLuongPC = PCDAO.getInstance().selectAll().size();
                    String mamay = "PC" + (soLuongPC + 1);
                    String mainboard = row.getCell(7).getStringCellValue();
                    int congsuatnguon = (int) row.getCell(8).getNumericCellValue();

                    // Tạo đối tượng PC với đúng tham số
                    PC pc = new PC(cardmanhinh, gia, mamay, ram, rom, soluong, tenCPU, tenmay, xuatxu, congsuatnguon, mainboard, manhacungcap, dungluongluutru);
                    PCDAO.getInstance().insert(pc);
                }
            }
            JOptionPane.showMessageDialog(this, "Nhập Excel thành công !");
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateTableDataProductFormDAO();
    }
    public void XoaMouseClicked(){
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá sản phẩm này?", "Xoá sản phẩm",
                JOptionPane.YES_NO_OPTION);
        if(luaChon==JOptionPane.YES_OPTION){
            Computer computer_Selected = getComputerSelected();
            ProductsDAO.getInstance().delete(computer_Selected);
            updateTableDataProductFormDAO();
        }
    }
}
