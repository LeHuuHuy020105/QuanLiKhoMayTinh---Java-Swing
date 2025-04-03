package view.User.PhieuXuat;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.*;
import com.toedter.calendar.JDateChooser;
import controller.SearchExportProducts;
import controller.updateDataToTable;
import model.*;
import view.User.PhieuNhap.ChiTietPhieuNhapForm;
import view.User.PhieuNhap.KhoiPhucPhieuNhapForm;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PhieuXuatForm extends JPanel implements updateDataToTable<ExportProducts> {

	private static final long serialVersionUID = 1L;
	private JButton btnNhapExcel;
	private JButton btnSua;
	private JButton btnXuatExcel;
	private JButton btnXemChiTiet;
	private JButton btn_Xoa;
	private JDateChooser date_Start;
	private JDateChooser date_End;
	private JTextField input_TimKiem;
	private JTable table_PhieuXuatHang;
	private JComboBox cbx_TimKiem;
	private JComboBox cbx_TrangThai;
	private User currentUser;

	/**
	 * Create the panel.
	 */
	public PhieuXuatForm(User currentUser) {
		this.currentUser = currentUser;
		setLayout(null);
		setSize(1257,911);

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

		btn_Xoa = new JButton("Xoá");
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

		btnXemChiTiet = new JButton("Xem chi tiết");
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

		btnXuatExcel = new JButton("Xuất Excel");
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

		btnNhapExcel = new JButton("Nhập Excel");
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

		btnSua = new JButton("Sửa");
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SuaMouseClick();
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

		String[] luachonStrings = new String[] {"Tất cả","Mã phiếu xuất","Địa chỉ"};
		cbx_TimKiem = new JComboBox(luachonStrings);
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
		btnNewButton_1.setBounds(546, 9, 114, 30);
		panel_5_1_1.add(btnNewButton_1);

		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_1.setBounds(10, 107, 682, 75);
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
		verticalBox_1_2.setBounds(750, 107, 294, 75);
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
		cbx_TrangThai.setBackground(UIManager.getColor("Button.background"));
		cbx_TrangThai.setBounds(10, 11, 262, 30);
		panel_5_1_1_2.add(cbx_TrangThai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 216, 1247, 684);
		add(scrollPane);

		table_PhieuXuatHang = new JTable();
		table_PhieuXuatHang.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"STT", "Mã phiếu xuất", "Người tạo", "Thời gian tạo","Thời gian hoàn thành","Địa chỉ","Tình trạng đơn"
				}
		));
		scrollPane.setViewportView(table_PhieuXuatHang);
		Permission();
		updateTableDataFormDAO();
	}
	public void Permission(){
		int idRole = UserDAO.getInstance().getIDRoleByIDUser(currentUser.getIdUser());
		PermissionsDAO.applyPermissions(idRole,"Phiếu xuất",null,btn_Xoa,btnSua,btnXemChiTiet,btnXuatExcel,btnNhapExcel);
	}

	@Override
	public void updateTableDataFormDAO() {
		ArrayList<ExportProducts>exportProducts = ExportProductsDAO.getInstance().selectAll();
		updateTableData(exportProducts);
	}

	@Override
	public void updateTableData(ArrayList<ExportProducts> t) {
		DefaultTableModel model = (DefaultTableModel) table_PhieuXuatHang.getModel();
		model.setRowCount(0);
		int i = 0;
		for(ExportProducts exportProducts : t){
			i++;
			String diaChi = BrandDAO.getInstance().BranchByID(exportProducts.getMaChiNhanh()).getDiaChi();
			String tenNguoiDung = UserDAO.getInstance().getUsetById(exportProducts.getManguoidung()).getFullName();
			String trangThai = StatusDeliveryDAO.getInstance().selectByID(exportProducts.getTrangThai());
			model.addRow(new Object[]{
					i,
					exportProducts.getMaPhieuXuat(),
					tenNguoiDung,
					exportProducts.getNgayLenDonXuat(),
					exportProducts.getNgayNhanDonXuat()==null? "Trống":exportProducts.getNgayNhanDonXuat(),
					diaChi,
					trangThai
			});
		}
	}
	public ExportProducts getExportProductsSelected(){
		DefaultTableModel model = (DefaultTableModel) table_PhieuXuatHang.getModel();
		int i_row = table_PhieuXuatHang.getSelectedRow();
		if(i_row==-1){
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu xuất !");
			return null;
		}
		int maPhieuXuat = Integer.parseInt(model.getValueAt(i_row,1)+"");
		System.out.println(maPhieuXuat);
		ExportProducts exportProducts = ExportProductsDAO.getInstance().ExportProductsByID(maPhieuXuat);
		return exportProducts;
	}
	public void SuaMouseClick() {
		SuaTrangThaiPhieuXuat suaTrangThai = new SuaTrangThaiPhieuXuat(this);
		suaTrangThai.setVisible(true);
	}
	public void ChiTietMouseClicked() {
		ExportProducts exportProducts = getExportProductsSelected();
		if (exportProducts.getTrangThai() == 6) {
			KhoiPhucPhieuXuatForm khoiPhucPhieuXuatForm = new KhoiPhucPhieuXuatForm(this);
			khoiPhucPhieuXuatForm.setVisible(true);
		} else {
			ChiTietPhieuXuatForm chiTietPhieuXuatForm = new ChiTietPhieuXuatForm(this);
			chiTietPhieuXuatForm.setVisible(true);
		}
	}
	public void XoaMouseClicked() {
		ExportProducts exportProducts_Selected = getExportProductsSelected();
		if(exportProducts_Selected.getTrangThai()==1|| exportProducts_Selected.getTrangThai()==2){
			int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có muốn xoá phiếu xuất này hay không ", "xoá phiếu xuất", JOptionPane.YES_NO_OPTION);
			if(luaChon==JOptionPane.YES_OPTION){
				exportProducts_Selected.setTrangThai(6);
				ExportProductsDAO.getInstance().update(exportProducts_Selected);
				updateTableDataFormDAO();
			}
		}else {
			JOptionPane.showMessageDialog(this,"Bạn không thể xoá phiếu nhập khi đã bàn giao cho đơn vị vận chuyển !");
		}
	}
	public void updateDatabase(int maPhieuXuat){
		ArrayList<DetailExportProducts>detailExportProducts = DetailExportProductsDAO.getInstance().selectAllByMaPhieuXuat(maPhieuXuat);
		for(DetailExportProducts item : detailExportProducts){
			Computer computer = ProductsDAO.getInstance().searchByIDProduct(item.getMaMay());
			computer.setSoLuong(computer.getSoLuong()+item.getSoLuong());
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
		}
		if (date_End.getDate() != null) {
			dateEnd = new Timestamp(date_End.getDate().getTime());
		}

		// Lấy danh sách tất cả sản phẩm
		ArrayList<ExportProducts> allExportProducts = ExportProductsDAO.getInstance().selectAll();

		ArrayList<ExportProducts> filteredExportProducts = new ArrayList<>();

		for (ExportProducts exportProducts : allExportProducts) {
			System.out.println("-----Tat ca-----");
			System.out.println(exportProducts);
			boolean matchStatus = statusFilter.equals("Tất cả") || matchStatus(exportProducts, statusFilter);
			boolean matchKeyword = keyword.isEmpty() || matchKeyword(exportProducts, keyword, cbxLuaChon);
			boolean matchTime = (dateStart == null && dateEnd == null) || matchTime(dateStart, dateEnd, exportProducts);
			System.out.println("bool: "+ matchTime);
			// Chỉ thêm nếu thỏa mãn cả 3 điều kiện
			if (matchStatus && matchKeyword && matchTime) {
				filteredExportProducts.add(exportProducts);
			}
		}
		updateTableData(filteredExportProducts);
	}

	private boolean matchTime(Timestamp dateStart, Timestamp dateEnd, ExportProducts exportProducts) {
		// Chuyển đổi Timestamp thành LocalDate (chỉ lấy ngày, không lấy giờ phút giây)
		System.out.println("Macht time");
		System.out.println("1: "+ dateStart);
		System.out.println("2: "+ dateEnd);
		System.out.println("3: "+ exportProducts.getNgayNhanDonXuat());
		System.out.println("4: "+ exportProducts.getThoiDiemHuyPhieu());
		LocalDate startDate = (dateStart != null) ? dateStart.toLocalDateTime().toLocalDate() : null;
		LocalDate endDate = (dateEnd != null) ? dateEnd.toLocalDateTime().toLocalDate() : null;
		LocalDate productDate = (exportProducts.getNgayLenDonXuat() != null)
				? exportProducts.getNgayLenDonXuat().toLocalDateTime().toLocalDate()
				: null;
		LocalDate productCancelDate = (exportProducts.getThoiDiemHuyPhieu() != null)
				? exportProducts.getThoiDiemHuyPhieu().toLocalDateTime().toLocalDate()
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
		System.out.print("iD: " + exportProducts.getMaPhieuXuat()+" - ");
		System.out.print(matchesDate+ " - ");
		System.out.println(matchesCancelDate);

		// Trả về true nếu ít nhất một trong hai timestamp phù hợp
		return matchesDate || matchesCancelDate;
	}

//	 Kiểm tra tình trạng tồn kho
	private boolean matchStatus(ExportProducts exportProducts, String statusFilter) {
		int status = StatusDeliveryDAO.getInstance().selectByName(statusFilter);
		return exportProducts.getTrangThai() == status;
	}

	public ArrayList<ExportProducts> search(String luaChon, String input) {
		ArrayList<ExportProducts> result = new ArrayList<>();
		SearchExportProducts searchExportProducts = new SearchExportProducts();
		switch (luaChon) {
			case "Tất cả":
				result = searchExportProducts.searchAll(input);
				break;
			case "Mã phiếu xuất":
				result = searchExportProducts.searchMaPhieuXuat(input);
				break;
			case "Địa chỉ":
				result = searchExportProducts.searchDiaChi(input);
				break;
		}
		return result;
	}

	public boolean matchKeyword(ExportProducts exportProducts, String keyword, String luaChon) {
		ArrayList<ExportProducts> exportProductsFilter = search(luaChon, keyword);
		return exportProductsFilter.contains(exportProducts);
	}

}
