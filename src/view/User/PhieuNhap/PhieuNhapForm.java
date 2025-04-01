package view.User.PhieuNhap;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.*;
import com.toedter.calendar.JDateChooser;
import controller.SearchImportProducts;
import controller.updateDataToTable;
import model.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PhieuNhapForm extends JPanel implements updateDataToTable<ImportProducts> {

	private static final long serialVersionUID = 1L;
	private JDateChooser date_End;
	private JDateChooser date_Start;
	private JComboBox cbx_TimKiem;
	private JTextField input_TimKiem;
	private JTable table_importProducts;
	private JComboBox cbx_TrangThai;

	/**
	 * Create the panel.
	 */
	public PhieuNhapForm() {
		setLayout(null);
		setSize(1257, 718);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Chức năng",

				TitledBorder.LEADING,

				TitledBorder.TOP,

				new Font("Tahoma", Font.BOLD, 12),  // Đã sửa null thành Font.BOLD

				new Color(0, 0, 0)  // Màu chữ đen

		));
		verticalBox.setBounds(10, 11, 533, 75);
		add(verticalBox);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		verticalBox.add(panel_5_1);

		JButton btn_Xoa = new JButton("Xoá");
		btn_Xoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaMouseClicked();
			}
		});

		btn_Xoa.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn_Xoa.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\delete.png"));
		btn_Xoa.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Xoa.setFocusPainted(false);
		btn_Xoa.setContentAreaFilled(false);
		btn_Xoa.setBorderPainted(false);
		btn_Xoa.setBackground(UIManager.getColor("Button.background"));
		btn_Xoa.setBounds(10, 0, 70, 52);
		panel_5_1.add(btn_Xoa);

		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChiTietMouseClicked();
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
		btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXuatExcel.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\xuatexcel.png"));
		btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXuatExcel.setFocusPainted(false);
		btnXuatExcel.setContentAreaFilled(false);
		btnXuatExcel.setBorderPainted(false);
		btnXuatExcel.setBackground(UIManager.getColor("Button.background"));
		btnXuatExcel.setBounds(409, 0, 99, 52);
		panel_5_1.add(btnXuatExcel);

		JButton btnNhapExcel = new JButton("Nhập Excel");
		btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNhapExcel.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\nhapexcel.png"));
		btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhapExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNhapExcel.setFocusPainted(false);
		btnNhapExcel.setContentAreaFilled(false);
		btnNhapExcel.setBorderPainted(false);
		btnNhapExcel.setBackground(UIManager.getColor("Button.background"));
		btnNhapExcel.setBounds(287, 0, 98, 52);
		panel_5_1.add(btnNhapExcel);

		JButton btnSua = new JButton("Sửa");
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SuaMouseClicked();
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

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1.setBounds(575, 11, 682, 75);
		add(verticalBox_1);

		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		verticalBox_1.add(panel_5_1_1);

		String[] timkiem = new String[]{"Tất cả", "Tên người tạo", "Tổng tiền", "Mã phiếu nhập"};
		cbx_TimKiem = new JComboBox(timkiem);
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
		input_TimKiem.setBounds(156, 11, 366, 30);
		panel_5_1_1.add(input_TimKiem);

		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(532, 9, 128, 30);
		panel_5_1_1.add(btnNewButton_1);

		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_1.setBounds(10, 107, 799, 75);
		add(verticalBox_1_1);

		JPanel panel_5_1_1_1 = new JPanel();
		panel_5_1_1_1.setLayout(null);
		verticalBox_1_1.add(panel_5_1_1_1);

		date_Start = new JDateChooser();
		date_Start.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				applyFilters();
			}
		});
		date_Start.setBounds(87, 11, 165, 30);
		panel_5_1_1_1.add(date_Start);

		JLabel lblNewLabel = new JLabel("Từ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 11, 32, 30);
		panel_5_1_1_1.add(lblNewLabel);

		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbln.setBounds(397, 11, 32, 30);
		panel_5_1_1_1.add(lbln);

		date_End = new JDateChooser();
		date_End.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				applyFilters();
			}
		});
		date_End.setBounds(435, 11, 165, 30);
		panel_5_1_1_1.add(date_End);

		Box verticalBox_1_2 = Box.createVerticalBox();
		verticalBox_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Trạng thái", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_2.setBounds(908, 107, 339, 75);
		add(verticalBox_1_2);

		JPanel panel_5_1_1_2 = new JPanel();
		verticalBox_1_2.add(panel_5_1_1_2);
		panel_5_1_1_2.setLayout(null);

		String[] trangthaiStrings = StatusDeliveryDAO.getInstance().selectAll().toArray(new String[0]);
		cbx_TrangThai = new JComboBox(trangthaiStrings);
		cbx_TrangThai.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				applyFilters();
			}
		});
		cbx_TrangThai.setBounds(20, 10, 245, 32);
		panel_5_1_1_2.add(cbx_TrangThai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 1247, 524);
		add(scrollPane);

		table_importProducts = new JTable();
		table_importProducts.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"STT", "Mã phiếu nhập", "Người tạo", "Vai trò", "Thời gian tạo", "Tổng tiền", "Trạng thái","Thời gian huỷ"
				}
		));
		scrollPane.setViewportView(table_importProducts);
		updateTableDataFormDAO();
	}

	@Override
	public void updateTableDataFormDAO() {
		ArrayList<ImportProducts> importProducts = ImportProductsDAO.getInstance().selectAll();
		updateTableData(importProducts);
	}

	@Override
	public void updateTableData(ArrayList<ImportProducts> t) {
		DecimalFormat df = new DecimalFormat("#,###");
		DefaultTableModel model = (DefaultTableModel) table_importProducts.getModel();
		model.setRowCount(0);
		int i = 0;
		for (ImportProducts importProducts : t) {
			User user = UserDAO.getInstance().getUsetById(importProducts.getManguoidung());
			String tenNguoitao = user.getFullName();
			String role = UserDAO.getInstance().getRoleByIDUser(user.getIdUser());
			i++;
			String trangThai = StatusDeliveryDAO.getInstance().selectByID(importProducts.getTrangThai());
			System.out.println(importProducts.getTrangThai());
			System.out.println(trangThai);
			model.addRow(new Object[]{
					i,
					importProducts.getMaphieunhap(),
					tenNguoitao,
					role,
					importProducts.getTimestamp(),
					df.format(importProducts.getTongTien()) + "VND",
					trangThai,
					importProducts.getThoiGianHuy() ==null? "N/A" : importProducts.getThoiGianHuy()
			});
		}
	}


	public ImportProducts getImportProductsSelected() {
		ImportProducts importProducts = null;
		DefaultTableModel model = (DefaultTableModel) table_importProducts.getModel();
		int i_row = table_importProducts.getSelectedRow();
		if (i_row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập");
			return null;
		}
		int maPhieuNhap = Integer.parseInt(model.getValueAt(i_row, 1) + "");
		importProducts = ImportProductsDAO.getInstance().getImportProductsByMaPhieuNhap(maPhieuNhap);
		return importProducts;
	}

	public void ChiTietMouseClicked() {
		ImportProducts importProducts = getImportProductsSelected();
		if (importProducts.getTrangThai() == 6) {
			KhoiPhucPhieuNhapForm khoiPhucPhieuNhapForm = new KhoiPhucPhieuNhapForm(this);
			khoiPhucPhieuNhapForm.setVisible(true);
		} else {
			ChiTietPhieuNhapForm chiTietPhieuNhapForm = new ChiTietPhieuNhapForm(this);
			chiTietPhieuNhapForm.setVisible(true);
		}
	}

	public void XoaMouseClicked() {
		ImportProducts importProducts_Selected = getImportProductsSelected();
		if(importProducts_Selected.getTrangThai()==1 || importProducts_Selected.getTrangThai()==2){
			int choice = JOptionPane.showConfirmDialog(this, "Bạn chắc muốn xoá phiếu nhập này ?", "Xoá phiếu nhập", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				importProducts_Selected.setTrangThai(6);
				importProducts_Selected.setThoiGianHuy(new Timestamp(System.currentTimeMillis()));
				ImportProductsDAO.getInstance().update(importProducts_Selected);
				updateDatabaseProducts(importProducts_Selected.getMaphieunhap());
			}
			updateTableDataFormDAO();
		}else {
			JOptionPane.showMessageDialog(this,"Bạn không thể xoá phiếu nhập khi đã bàn giao cho đơn vị vận chuyển !");
		}
	}

	public void updateDatabaseProducts(int maphieunhap) {
		ArrayList<DetailImportProducts> detailImportProducts = DetailImportProductsDAO.getInstance().selectAllByMaPhieuNhap(maphieunhap);
		for (DetailImportProducts item : detailImportProducts) {
			Computer computer = ProductsDAO.getInstance().searchByIDProduct(item.getMaMay());
			computer.setSoLuong(computer.getSoLuong() - item.getSoluong());
			ProductsDAO.getInstance().update(computer);
		}
	}

	public void applyFilters() {
		String statusFilter = cbx_TrangThai.getSelectedItem() + "";
		String keyword = input_TimKiem.getText().trim().toLowerCase();
		String cbxLuaChon = cbx_TimKiem.getSelectedItem() + "";
		Timestamp dateStart = null, dateEnd = null;

		// Lấy giá trị từ JDateChooser
		if (date_Start.getDate() != null) {
			dateStart = new Timestamp(date_Start.getDate().getTime());
			System.out.println("Date Start: " + dateStart.toLocalDateTime().toLocalDate());
		}
		if (date_End.getDate() != null) {
			dateEnd = new Timestamp(date_End.getDate().getTime());
			System.out.println("Date End: " + dateEnd.toLocalDateTime().toLocalDate());
		}

		// Lấy danh sách tất cả sản phẩm
		ArrayList<ImportProducts> allImportProducts = ImportProductsDAO.getInstance().selectAll();

		ArrayList<ImportProducts> filteredImportProducts = new ArrayList<>();

		for (ImportProducts importProducts : allImportProducts) {
			boolean matchStatus = statusFilter.equals("Tất cả") || matchStatus(importProducts, statusFilter);
			boolean matchKeyword = keyword.isEmpty() || matchKeyword(importProducts, keyword, cbxLuaChon);
			boolean matchTime = (dateStart == null && dateEnd == null) || matchTime(dateStart, dateEnd, importProducts);

			// Chỉ thêm nếu thỏa mãn cả 3 điều kiện
			if (matchStatus && matchKeyword && matchTime) {
				filteredImportProducts.add(importProducts);
			}
		}

		System.out.println("Mang: " + filteredImportProducts);
		updateTableData(filteredImportProducts);
	}

	private boolean matchTime(Timestamp dateStart, Timestamp dateEnd, ImportProducts importProducts) {
		// Chuyển đổi Timestamp thành LocalDate (chỉ lấy ngày, không lấy giờ phút giây)
		LocalDate startDate = (dateStart != null) ? dateStart.toLocalDateTime().toLocalDate() : null;
		LocalDate endDate = (dateEnd != null) ? dateEnd.toLocalDateTime().toLocalDate() : null;
		LocalDate productDate = (importProducts.getTimestamp() != null)
				? importProducts.getTimestamp().toLocalDateTime().toLocalDate()
				: null;
		LocalDate productCancelDate = (importProducts.getThoiGianHuy() != null)
				? importProducts.getThoiGianHuy().toLocalDateTime().toLocalDate()
				: null;

		// Nếu cả dateStart và dateEnd đều null, không có điều kiện thời gian, trả về true
		if (startDate == null && endDate == null) {
			return true;
		}

		// Kiểm tra productDate
		boolean matchesDate = true;
		if (productDate != null) {
			if (startDate != null && endDate != null) {
				// Trường hợp cả startDate và endDate đều có giá trị
				// Kiểm tra xem productDate có nằm trong khoảng [startDate, endDate] không
				matchesDate = !productDate.isBefore(startDate) && !productDate.isAfter(endDate);
			} else if (startDate != null) {
				// Trường hợp chỉ có startDate (endDate là null)
				// Kiểm tra xem productDate có từ startDate trở về sau không
				matchesDate = !productDate.isBefore(startDate);
			} else if (endDate != null) {
				// Trường hợp chỉ có endDate (startDate là null)
				// Kiểm tra xem productDate có trước endDate không
				matchesDate = !productDate.isAfter(endDate);
			}
		}

		// Kiểm tra productCancelDate (nếu có)
		boolean matchesCancelDate = true;
		if (productCancelDate != null) {
			if (startDate != null && endDate != null) {
				// Trường hợp cả startDate và endDate đều có giá trị
				matchesCancelDate = !productCancelDate.isBefore(startDate) && !productCancelDate.isAfter(endDate);
			} else if (startDate != null) {
				// Trường hợp chỉ có startDate (endDate là null)
				matchesCancelDate = !productCancelDate.isBefore(startDate);
			} else if (endDate != null) {
				// Trường hợp chỉ có endDate (startDate là null)
				matchesCancelDate = !productCancelDate.isAfter(endDate);
			}
		}else {
			matchesCancelDate =false;
		}
		System.out.print("iD: " + importProducts.getMaphieunhap()+" - ");
		System.out.print(matchesDate+ " - ");
		System.out.println(matchesCancelDate);

		// Trả về true nếu ít nhất một trong hai timestamp phù hợp
		return matchesDate || matchesCancelDate;
	}

	// Kiểm tra tình trạng tồn kho
	private boolean matchStatus(ImportProducts importProducts, String statusFilter) {
		int status = -1;
		switch (statusFilter) {
			case "Bình thường":
				status = 1;
				break;
			case "Đã huỷ":
				status = 0;
				break;
		}
		return importProducts.getTrangThai() == status;
	}

	public ArrayList<ImportProducts> search(String luaChon, String input) {
		ArrayList<ImportProducts> result = new ArrayList<>();
		SearchImportProducts searchImportProducts = new SearchImportProducts();
		switch (luaChon) {
			case "Tất cả":
				result = searchImportProducts.searchAll(input);
				break;
			case "Mã phiếu nhập":
				result = searchImportProducts.searchMaPhieuNhap(input);
				break;
			case "Tổng tiền":
				result = searchImportProducts.searchTongTien(input);
				break;
			case "Tên người tạo":
				result = searchImportProducts.searchNguoiTao(input);
				break;
		}
		return result;
	}

	public boolean matchKeyword(ImportProducts importProducts, String keyword, String luaChon) {
		ArrayList<ImportProducts> importProductsFilter = search(luaChon, keyword);
		return importProductsFilter.contains(importProducts);
	}
	public void SuaMouseClicked(){
		SuaTrangThaiPhieuNhap suaTrangThaiPhieuNhap = new SuaTrangThaiPhieuNhap(this);
	}
}
