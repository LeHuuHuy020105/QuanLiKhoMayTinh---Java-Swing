package view.User.NhaCungCap;

import DAO.ProducersDAO;
import controller.*;
import model.Producer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.Icon;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class NhaCungCapForm extends JPanel implements updateDataToTable<Producer>, ExcelIntrerface {

    private static final long serialVersionUID = 1L;

    private JTextField input_Search;
    private JTable table_NCC;
    private JFileChooser jFileChooser;

	private JComboBox cbx_Search;

    /**
     * Create the panel.
     */
    public NhaCungCapForm() {
        setLayout(null);
        setSize(1257, 764);
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

        JButton btnXuatExcel = new JButton("Xuất Excel");
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

        JButton btnNhapExcel = new JButton("Nhập Excel");
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

        JButton btnSua = new JButton("Sửa");
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

        JButton btnXoa = new JButton("Xoá");
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
        add(verticalBox_1);

        JPanel panel_5_1_1 = new JPanel();
        panel_5_1_1.setLayout(null);
        verticalBox_1.add(panel_5_1_1);

        String [] cbx_SearchValue = new String[]{"Tất cả","Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Địa chỉ"};
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

        table_NCC = new JTable();
        table_NCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table_NCC.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "STT", "Mã NCC", "Tên NCC", "Địa chỉ", "SDT"
                }
        ));
        JScrollPane scrollPane = new JScrollPane(table_NCC);
        scrollPane.setBounds(10, 127, 1237, 626);
        add(scrollPane);
        updateTableDataFormDAO();
    }

    public void ThemNhaCungCapMouseClicked() {
        ThemNhaCungCap themSanPham = new ThemNhaCungCap();
        themSanPham.setVisible(true);
    }

    public void resetSearch() {

    }

    @Override
    public void updateTableDataFormDAO() {
        ArrayList<Producer> producers = ProducersDAO.getInstance().selectAll();
        updateTableData(producers);
    }

    @Override
    public void updateTableData(ArrayList<Producer> t) {
        DefaultTableModel model = (DefaultTableModel) table_NCC.getModel();
        model.setRowCount(0);
        int i = 0;
        for (Producer producer : t) {
            i++;
            model.addRow(new Object[]{
                    i,
                    producer.getMaNhaCungCap(),
                    producer.getTenNhaCungCap(),
                    producer.getDiaChi(),
                    producer.getSdt()
            });
        }
    }

    @Override
    public void NhapExelMouseClicked() {
        jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(null);
        File file = jFileChooser.getSelectedFile();
        if (!file.getName().endsWith("xlsx")) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng chọn file Excel.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            fillData(file);
        }
    }

    @Override
    public void XuatExcelMouseClicked() {
        jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Chọn nơi lưu trữ file Excel");
        jFileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        exportTableToExcel(table_NCC, jFileChooser);
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

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String maNCC = row.getCell(0).getStringCellValue();
                String tenNCC = row.getCell(1).getStringCellValue();
                String diaChi = row.getCell(2).getStringCellValue();
                String sdt = row.getCell(3).getStringCellValue();
                Producer producer = new Producer(diaChi, maNCC, sdt, tenNCC);
                ProducersDAO.getInstance().update(producer);
            }
            JOptionPane.showMessageDialog(this, "Nhập Excel thành công !");
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateTableDataFormDAO();
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
        ArrayList<Producer> result = SearchFn(luachon,content_Search);
        updateTableData(result);
    }
    public ArrayList<Producer> SearchFn(String luachon , String content_Search){
        ArrayList<Producer>result = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        SearchProducer searchProducer = new SearchProducer();
        switch (luachon){
            case "Tất cả":
                result = searchProducer.searchTatCa(content_Search);
                break;
            case "Mã nhà cung cấp":
                result = searchProducer.searchMaNhaCungCap(content_Search);
                break;
            case "Tên nhà cung cấp":
                result = searchProducer.searchTenNhaCungCap(content_Search);
                break;
            case "Số điện thoại":
                result = searchProducer.searchSDT(content_Search);
                break;
            case "Địa chỉ":
                result = searchProducer.searchDiaChi(content_Search);
                break;
        }
        return result;
    }
    public Producer getNhaCungCapSelected(){
        Producer producer_Selected = null;
        try {
            DefaultTableModel model = (DefaultTableModel) table_NCC.getModel();
            int i_row = table_NCC.getSelectedRow();

            // Kiểm tra xem có hàng nào được chọn không
            if (i_row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhà cung cấp để chỉnh sửa!");
                return null; // Trả về null nếu không có hàng nào được chọn
            }

            // Lấy mã máy từ hàng được chọn
            String maNCC = model.getValueAt(i_row, 0) + "";

            // Tìm kiếm máy trong cơ sở dữ liệu
            producer_Selected = ProducersDAO.getInstance().producerByID(maNCC);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
        return producer_Selected;
    }
    public void XoaMouseClicked(){
        int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có muốn xoá nhà cung cấp này hay không ", "xoá nhà cung cấp", JOptionPane.YES_NO_OPTION);
        if(luaChon == JOptionPane.YES_OPTION){
            ProducersDAO.getInstance().delete(getNhaCungCapSelected());
            updateTableDataFormDAO();
        }
    }
    public void SuaMouseClick(){
        SuaNhaCungCap suaNhaCungCap = new SuaNhaCungCap(this);
        suaNhaCungCap.setVisible(true);
    }
    public Producer getProducerSelected(){
        Producer producer = null;
        try {
            DefaultTableModel model = (DefaultTableModel) table_NCC.getModel();
            int i_row = table_NCC.getSelectedRow();
            if(i_row == -1){
                JOptionPane.showMessageDialog(this,"Vui lòng chọn 1 nhà cung cấp !");
                return null;
            }
            String maNCC = model.getValueAt(i_row,1)+"";
            producer = ProducersDAO.getInstance().producerByID(maNCC);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producer;
    }
}
