package view.User.ThongKe;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import DAO.*;
import com.toedter.calendar.JDateChooser;
import controller.Notification;
import controller.updateDataToTable;
import model.*;
import view.User.SanPham.SanPhamForm;

import javax.swing.table.DefaultTableModel;

public class ThongKePhieuForm extends JPanel implements updateDataToTable<BillStatistics> {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField startPrice;
	private JTextField endPrice;
	private JTable table;
	BillStatisticsDAO statisticsDAO = new BillStatisticsDAO();
	JDateChooser startDate;
	JDateChooser endDate;
	private User currentUser;

	public ThongKePhieuForm() {
	}

	/**
	 * Create the panel.
	 */

	public ThongKePhieuForm(User currentUser) {
		this.currentUser = currentUser;
		setLayout(null);
		setSize(1247, 504);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Chức năng",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 12),  // Đã sửa null thành Font.BOLD
				new Color(0, 0, 0)  // Màu chữ đen
		));
		verticalBox.setBounds(10, 11, 490, 75);
		add(verticalBox);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		verticalBox.add(panel_5_1);

		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XemChiTietHoaDonMouseClicked();
			}
		});
		btnXemChiTiet.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXemChiTiet.setIcon(new ImageIcon("D:\\WEB\\FontEndAndBackEnd\\BackEnd\\Java Core\\Swing\\Project\\huy\\QuanLiKhoMayTinh---Java-Swing\\src\\icon\\eye.png"));
		btnXemChiTiet.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXemChiTiet.setFocusPainted(false);
		btnXemChiTiet.setContentAreaFilled(false);
		btnXemChiTiet.setBorderPainted(false);
		btnXemChiTiet.setBackground(UIManager.getColor("Button.background"));
		btnXemChiTiet.setBounds(10, 0, 107, 52);
		panel_5_1.add(btnXemChiTiet);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1.setBounds(555, 11, 682, 75);
		add(verticalBox_1);

		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		verticalBox_1.add(panel_5_1_1);

		String[] cbxLuaChonValues = new String[]{"Tất cả", "Mã phiếu", "Người tạo"};
		JComboBox optionsForSearch = new JComboBox(cbxLuaChonValues);
		optionsForSearch.setBackground(UIManager.getColor("Button.background"));
		optionsForSearch.setBounds(10, 11, 126, 30);
		optionsForSearch.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateTableDataFormDAO();
				textField.setText("");
				startPrice.setText("");
				endPrice.setText("");
				startDate.setDate(null);
				endDate.setDate(null);
			}
		});
		panel_5_1_1.add(optionsForSearch);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(156, 11, 366, 30);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SanPhamForm sanPhamForm = new SanPhamForm();
				sanPhamForm.setCbx_luaChon(optionsForSearch);
				sanPhamForm.setInput_Search(textField);
				sanPhamForm.setTable_product(table);
				jTextFieldSearchKeyReleased((String) optionsForSearch.getSelectedItem(), textField.getText());
			}
		});
		panel_5_1_1.add(textField);

		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(546, 9, 114, 30);
		btnNewButton_1.addActionListener((e) -> {
			textField.setText("");
			startPrice.setText("");
			endPrice.setText("");
			startDate.setDate(null);
			endDate.setDate(null);
			updateTableDataFormDAO();
		});
		panel_5_1_1.add(btnNewButton_1);

		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_1.setBounds(10, 109, 682, 75);
		add(verticalBox_1_1);

		JPanel panel_5_1_1_1 = new JPanel();
		panel_5_1_1_1.setLayout(null);
		verticalBox_1_1.add(panel_5_1_1_1);

		// Filter by time
		startDate = new JDateChooser();
		startDate.setBounds(87, 11, 165, 30);
		startDate.addPropertyChangeListener((e) -> {
			if (filterByTime((String) optionsForSearch.getSelectedItem(), textField.getText()) != null) {
				ArrayList<BillStatistics> result = filterByTime((String) optionsForSearch.getSelectedItem(), textField.getText()).stream().collect(Collectors.toCollection(ArrayList::new));
				updateTableData(result);
			}
		});
		panel_5_1_1_1.add(startDate);

		JLabel lblNewLabel = new JLabel("Từ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 11, 32, 30);
		panel_5_1_1_1.add(lblNewLabel);

		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbln.setBounds(397, 11, 32, 30);
		panel_5_1_1_1.add(lbln);

		endDate = new JDateChooser();
		endDate.setBounds(435, 11, 165, 30);
		endDate.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (filterByTime((String) optionsForSearch.getSelectedItem(), textField.getText()) != null) {
					ArrayList<BillStatistics> result = filterByTime((String) optionsForSearch.getSelectedItem(), textField.getText()).stream().collect(Collectors.toCollection(ArrayList::new));
					updateTableData(result);
				}
			}
		});
		panel_5_1_1_1.add(endDate);

		Box verticalBox_1_2 = Box.createVerticalBox();
		verticalBox_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lọc theo giá", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_2.setBounds(702, 109, 533, 75);
		add(verticalBox_1_2);

		JPanel panel_5_1_1_2 = new JPanel();
		panel_5_1_1_2.setLayout(null);
		verticalBox_1_2.add(panel_5_1_1_2);

		// Filter by price
		JLabel lblNewLabel_1 = new JLabel("Từ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 32, 30);
		panel_5_1_1_2.add(lblNewLabel_1);

		startPrice = new JTextField();
		startPrice.setColumns(10);
		startPrice.setBounds(52, 11, 177, 30);

		JLabel lblNewLabel_1_1 = new JLabel("Đến");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(282, 11, 32, 30);
		panel_5_1_1_2.add(lblNewLabel_1_1);

		endPrice = new JTextField();
		endPrice.setColumns(10);
		endPrice.setBounds(324, 13, 177, 30);
		startPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!startPrice.getText().trim().equals("") && !endPrice.getText().trim().equals("")) {
					List<BillStatistics> result = filterByPrice((String) optionsForSearch.getSelectedItem(), textField.getText());
					updateTableData(result.stream().collect(Collectors.toCollection(ArrayList::new)));
				} else if (startPrice.getText().trim().equals("") && textField.getText().trim().equals("")) {
					updateTableDataFormDAO();
				} else if ((startPrice.getText().trim().equals("") || endPrice.getText().trim().equals("")) && !textField.getText().trim().equals("")) {
					jTextFieldSearchKeyReleased((String) optionsForSearch.getSelectedItem(), textField.getText());
				}
			}
		});
		panel_5_1_1_2.add(startPrice);
		endPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!startPrice.getText().trim().equals("") && !endPrice.getText().trim().equals("")) {
					List<BillStatistics> result = filterByPrice((String) optionsForSearch.getSelectedItem(), textField.getText());
					updateTableData(result.stream().collect(Collectors.toCollection(ArrayList::new)));
				} else if (endPrice.getText().trim().equals("") && textField.getText().trim().equals("")) {
					updateTableDataFormDAO();
				} else if ((endPrice.getText().trim().equals("") || startPrice.getText().trim().equals("")) && !textField.getText().trim().equals("")) {
					jTextFieldSearchKeyReleased((String) optionsForSearch.getSelectedItem(), textField.getText());
				}
			}
		});
		panel_5_1_1_2.add(endPrice);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 1227, 286);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Mã phiếu", "Người tạo", "Thời gian tạo", "Tổng tiền"
				}
		));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2_1 = new JLabel("Tổng phiếu :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(34, 526, 153, 41);
		lblNewLabel_2_1.setForeground(Color.RED);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("65");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(197, 524, 161, 41);
		lblNewLabel_2_1_1.setForeground(Color.BLUE);
		add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Tổng tiền :");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2.setBounds(738, 526, 124, 41);
		lblNewLabel_2_1_2.setForeground(Color.BLACK);
		add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("140000000");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_1.setBounds(887, 524, 286, 41);
		add(lblNewLabel_2_1_1_1);
		updateTableDataFormDAO();
	}

	@Override
	public void updateTableDataFormDAO() {
		ArrayList<BillStatistics> statistics = null;
		if (UserDAO.getInstance().getRoleByIDUser(currentUser.getIdUser()).equals("Quản lí chi nhánh")) {
			statistics = BillStatisticsDAO.getInstance().findAllBillsIdBranch(currentUser.getMaChiNhanh());
		} else {
			statistics = BillStatisticsDAO.getInstance().findAllBills();
		}
		updateStatus(statistics);
		updateTableData(statistics);
	}

	@Override
	public void updateTableData(ArrayList<BillStatistics> statistics) {
		DecimalFormat df = new DecimalFormat("#,###");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (BillStatistics statistic : statistics) {
			model.addRow(
					new Object[]{
							statistic.getMaPhieu(),
							statistic.getMaNhanVien(),
							statistic.getThoiGianTao(),
							df.format(statistic.getTongTien()) + " VND",
					});
		}
	}

	public void jTextFieldSearchKeyReleased(String selectedOption, String searchString) {
		ArrayList<BillStatistics> result = new ArrayList<>();
		if (!startPrice.getText().trim().equals("") && !endPrice.getText().trim().equals("")) {
			result = filterByPrice(selectedOption, searchString).stream().collect(Collectors.toCollection(ArrayList::new));
		} else if (startDate.getDate() != null && endDate.getDate() != null) {
			result = filterByTime(selectedOption, searchString).stream().collect(Collectors.toCollection(ArrayList::new));
		} else {
			ArrayList<BillStatistics> list = statisticsDAO.findAllBills();
			switch (selectedOption) {
				case "Tất cả": {
					result = searchAll(list, searchString);
					break;
				}
				case "Mã phiếu": {
					result = searchByMaPhieu(list, searchString);
					break;
				}
				case "Người tạo": {
					result = searchByCreator(list, searchString);
					break;
				}
			}
			updateStatus(result);
		}
		updateTableData(result);
	}

	public ArrayList<BillStatistics> searchAll(ArrayList<BillStatistics> list, String searchString) {
		System.out.println(list.size());
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<BillStatistics> result = new ArrayList<>();
		searchString = searchString.trim().toLowerCase();
		for (BillStatistics statistics : list) {
			if (searchString.matches("\\d+") && statistics.getMaNhanVien() == Integer.parseInt(searchString) ||
					searchString.matches("\\d+") && statistics.getMaPhieu() == Integer.parseInt(searchString)) {
				result.add(statistics);
			}
		}
		return result;
	}

	public ArrayList<BillStatistics> searchByMaPhieu(ArrayList<BillStatistics> list, String searchString) {
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<BillStatistics> result = new ArrayList<>();
		searchString = searchString.trim();
		for (BillStatistics statistics : list) {
			if (searchString.matches("\\d+") && statistics.getMaPhieu() == Integer.parseInt(searchString)) {
				result.add(statistics);
			}
		}
		return result;
	}

	public ArrayList<BillStatistics> searchByCreator(ArrayList<BillStatistics> list, String searchString) {
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<BillStatistics> result = new ArrayList<>();
		searchString = searchString.trim();
		for (BillStatistics statistics : list) {
			if (searchString.matches("\\d+") && statistics.getMaNhanVien() == Integer.parseInt(searchString)) {
				result.add(statistics);
			}
		}
		return result;
	}

	public List<BillStatistics> filterByTime(String selectedOption, String searchString) {
		if (startDate.getDate() == null || endDate.getDate() == null) return null;
		LocalDate startLocalDate = startDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endLocalDate = endDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		List<BillStatistics> result = new ArrayList<>();
		if (startLocalDate.isAfter(endLocalDate)) {
			startDate.setDate(null);
			endDate.setDate(null);
			return result;
		}
		result = (new BillStatisticsDAO()).findAllBillsByTime(startLocalDate, endLocalDate, selectedOption, searchString);
		updateStatus(result);
		return result;
	}

	public List<BillStatistics> filterByPrice(String selectedOption, String searchString) {
		if (startPrice.getText().matches(".*[^0-9].*") || endPrice.getText().matches(".*[^0-9].*")) {
			return null;
		}
		List<BillStatistics> result = filterByTime(selectedOption, searchString);
		if (result == null && !textField.getText().trim().isBlank()) {
			result = new ArrayList<>();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (int row = 0; row < model.getRowCount(); row++) {
				int maPhieu = Integer.parseInt(model.getValueAt(row, 0).toString());
				int maNhanVien = Integer.parseInt(model.getValueAt(row, 1).toString());
				LocalDateTime thoiGianTao = LocalDateTime.parse(model.getValueAt(row, 2).toString());
				double tongTien = Double.parseDouble(model.getValueAt(row, 3).toString().replaceAll("[^0-9.]", ""));
				BillStatistics billStatistics = new BillStatistics(maPhieu, maNhanVien, thoiGianTao, tongTien);
				result.add(billStatistics);
			}
		} else if (result == null && textField.getText().isBlank()) {
			result = new BillStatisticsDAO().findAllBills();
		}
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getTongTien() < Double.parseDouble(startPrice.getText()) || result.get(i).getTongTien() > Double.parseDouble(endPrice.getText())) {
				result.remove(result.get(i));
				i--;
			}
		}
		ThongKePhieuForm thongKePhieuForm = new ThongKePhieuForm();
		switch (selectedOption) {
			case "Tất cả": {
				result = thongKePhieuForm.searchAll(result.stream().collect(Collectors.toCollection(ArrayList::new)), searchString);
				break;
			}
			case "Mã phiếu": {
				result = thongKePhieuForm.searchByMaPhieu(result.stream().collect(Collectors.toCollection(ArrayList::new)), searchString);
				break;
			}
			case "Người tạo": {
				result = thongKePhieuForm.searchByCreator(result.stream().collect(Collectors.toCollection(ArrayList::new)), searchString);
				break;
			}
			default:
				break;
		}
		updateStatus(result);
		return result;
	}

	public void updateStatus(List<BillStatistics> list) {
		JLabel soHoaDonLabel = ThongKeForm.getLblSnPhmTrong();
		JLabel doanhThuLabel = ThongKeForm.getLblNhCungCp();
		JLabel sanPhamBanRaLabel = ThongKeForm.getLblSnPhmTrong_2();
		int soHoaDon = 0;
		double doanhThu = 0;
		int sanPhamBanRa = 0;
		for (int i = 0; i < list.size(); i++) {
			soHoaDon++;
			doanhThu += list.get(i).getTongTien();
		}
		sanPhamBanRa = (new BillStatisticsDAO()).soldOrderCount(list);
		DecimalFormat df = new DecimalFormat("#,###");
		df.setGroupingSize(3);
		soHoaDonLabel.setText("Số hóa đơn: " + soHoaDon);
		doanhThuLabel.setText("Doanh thu: " + df.format(doanhThu) + " VND");
		sanPhamBanRaLabel.setText("Sản phẩm bán ra: " + sanPhamBanRa);
	}

	public Bill getBillSelected() {
		Bill bill_Selected = null;
		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int i_row = table.getSelectedRow();

			if (i_row == -1) {
				JOptionPane.showMessageDialog(this, Notification.not_SelectedProduct);
				return null;
			}

			int maHD = Integer.parseInt(model.getValueAt(i_row, 0) + "");

			bill_Selected = BillDAO.getInstance().getBillByMaPhieu(maHD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
			e.printStackTrace();
		}
		return bill_Selected;
	}

	public void XemChiTietHoaDonMouseClicked() {
		ChiTietBillForm chiTietBillForm = new ChiTietBillForm(this);
	}
}
