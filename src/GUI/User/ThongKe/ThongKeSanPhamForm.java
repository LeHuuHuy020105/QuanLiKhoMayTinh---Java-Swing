package GUI.User.ThongKe;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextField;

import DAO.ProductStatisticsDAO;
import com.toedter.calendar.JDateChooser;
import BLL.updateDataToTable;
import DTO.ProductStatistics;
import DTO.User;
import GUI.User.SanPham.SanPhamForm;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ThongKeSanPhamForm extends JPanel implements updateDataToTable<ProductStatistics> {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTextField input_Search = new JTextField();
	ProductStatisticsDAO statisticsDAO = new ProductStatisticsDAO();
	JDateChooser startDate;
	JDateChooser endDate;
	private User currentUser;

	public ThongKeSanPhamForm() {
	}

	/**
	 * Create the panel.
	 */


	public ThongKeSanPhamForm(User currentUser) {
		this.currentUser = currentUser;
		setLayout(null);
		setSize(1247, 504);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 1223, 407);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Mã máy", "Tên máy", "Số lượng", "Giá nhập", "Giá bán"
				}
		));
		scrollPane.setViewportView(table);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1.setBounds(0, 0, 518, 75);
		add(verticalBox_1);

		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		verticalBox_1.add(panel_5_1_1);

		String[] cbxLuaChonValues = new String[]{"Tất cả", "Tên máy", "RAM", "CPU", "Dung lượng", "Card màn hình"};
		JComboBox optionsForSearch = new JComboBox(cbxLuaChonValues);
		optionsForSearch.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateTableDataFormDAO();
				input_Search.setText("");
				startDate.setDate(null);
				endDate.setDate(null);
			}
		});
		optionsForSearch.setBackground(UIManager.getColor("Button.background"));
		optionsForSearch.setBounds(10, 11, 126, 30);
		panel_5_1_1.add(optionsForSearch);
		input_Search = new JTextField();
		input_Search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SanPhamForm sanPhamForm = new SanPhamForm();
				sanPhamForm.setCbx_luaChon(optionsForSearch);
				sanPhamForm.setInput_Search(input_Search);
				sanPhamForm.setTable_product(table);
				jTextFieldSearchKeyReleased((String) optionsForSearch.getSelectedItem(), input_Search.getText());
			}
		});
		input_Search.setColumns(10);
		input_Search.setBounds(156, 11, 325, 30);
		panel_5_1_1.add(input_Search);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(156, 11, 325, 30);
		panel_5_1_1.add(textField);

		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_1.setBounds(555, 0, 682, 75);
		add(verticalBox_1_1);

		JPanel panel_5_1_1_1 = new JPanel();
		panel_5_1_1_1.setLayout(null);
		verticalBox_1_1.add(panel_5_1_1_1);

		startDate = new JDateChooser();
		startDate.setBounds(87, 11, 165, 30);

		JLabel lblNewLabel_5 = new JLabel("Từ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(50, 11, 32, 30);
		panel_5_1_1_1.add(lblNewLabel_5);

		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbln.setBounds(308, 11, 32, 30);
		panel_5_1_1_1.add(lbln);

		endDate = new JDateChooser();
		endDate.setBounds(369, 11, 165, 30);
		startDate.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				filterByTime((String) optionsForSearch.getSelectedItem(), input_Search.getText());
			}
		});
		endDate.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				filterByTime((String) optionsForSearch.getSelectedItem(), input_Search.getText());
			}
		});
		panel_5_1_1_1.add(startDate);
		panel_5_1_1_1.add(endDate);

		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(546, 11, 114, 30);
		btnNewButton_1.addActionListener((e -> {
			input_Search.setText("");
			startDate.setDate(null);
			endDate.setDate(null);
			updateTableDataFormDAO();
		}));
		panel_5_1_1_1.add(btnNewButton_1);
		updateTableDataFormDAO();

	}

	@Override
	public void updateTableDataFormDAO() {
		ArrayList<ProductStatistics> statistics = new ProductStatisticsDAO().findAllProducts();
		updateTableData(statistics);
		updateStatus();
	}

	@Override
	public void updateTableData(ArrayList<ProductStatistics> statistics) {
		Map<String, ProductStatistics> map = new HashMap<>();
		for (int i = 0; i < statistics.size(); i++) {
			if (!map.containsKey(statistics.get(i).getTenMay())) {
				map.put(statistics.get(i).getTenMay(), statistics.get(i));
			} else {
				ProductStatistics productStatistics = map.get(statistics.get(i).getTenMay());
				productStatistics.setSoLuongBan(productStatistics.getSoLuongBan() + 1);
			}
		}
		DecimalFormat df = new DecimalFormat("#,###");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		map.forEach((key, value) -> {
			model.addRow(
					new Object[]{
							value.getMaMay(),
							value.getTenMay(),
							value.getSoLuongBan(),
							df.format(value.getGiaNhap() * value.getSoLuongBan()) + " VND",
							df.format(value.getGiaBan() * value.getSoLuongBan()) + " VND",
					});
		});
	}

	public void jTextFieldSearchKeyReleased(String selectedOption, String searchString) {
		ArrayList<ProductStatistics> result = new ArrayList<>();
		if (startDate.getDate() == null || endDate.getDate() == null) {
			ArrayList<ProductStatistics> list = statisticsDAO.findAllProducts();
			switch (selectedOption) {
				case "Tất cả": {
					result = searchAll(list, searchString);
					break;
				}
				case "Tên máy": {
					result = searchByName(list, searchString);
					break;
				}
				case "RAM": {
					result = searchByRam(list, searchString);
					break;
				}
				case "CPU": {
					result = searchByCpu(list, searchString);
					break;
				}
				case "Dung lượng": {
					result = searchByDungLuong(list, searchString);
					break;
				}
				case "Card màn hình": {
					result = searchByCard(list, searchString);
					break;
				}
			}
			updateTableData(result);
			updateStatus();
		} else if (startDate.getDate() != null && endDate.getDate() != null) {
			filterByTime(selectedOption, searchString);
		}
	}

	public void updateStatus() {
		JLabel doanhThuLabel = ThongKeForm.getLblNhCungCp();
		JLabel sanPhamBanRaLabel = ThongKeForm.getLblSnPhmTrong_2();
		double doanhThu = 0;
		int sanPhamBanRa = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int row = 0; row < model.getRowCount(); row++) {
			sanPhamBanRa += Integer.parseInt(model.getValueAt(row, 2).toString());
			doanhThu += Double.parseDouble(model.getValueAt(row, 4).toString().replaceAll("[^0-9.]", ""));
		}
		DecimalFormat df = new DecimalFormat("#,###");
		df.setGroupingSize(3);
		doanhThuLabel.setText("Doanh thu: " + df.format(doanhThu) + " VND");
		sanPhamBanRaLabel.setText("Sản phẩm bán ra: " + sanPhamBanRa);
	}

	public void filterByTime(String selectedOption, String searchString) {
		if (startDate.getDate() == null || endDate.getDate() == null) return;
		LocalDate startLocalDate = startDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endLocalDate = endDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if (startLocalDate.isAfter(endLocalDate)) {
			startDate.setDate(null);
			endDate.setDate(null);
			return;
		}
		ArrayList<ProductStatistics> result = statisticsDAO.findAllProductsByTime(startLocalDate, endLocalDate, selectedOption, searchString);
		updateTableData(result);
		updateStatus();
	}

	public ArrayList<ProductStatistics> searchAll(ArrayList<ProductStatistics> list, String searchString) {
		System.out.println(list.size());
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<ProductStatistics> result = new ArrayList<>();
		searchString = searchString.trim().toLowerCase();
		for (ProductStatistics statistics : list) {
			if (statistics.getTenMay().toLowerCase().contains(searchString) ||
					statistics.getTenCpu().toLowerCase().contains(searchString) ||
					statistics.getRam().toLowerCase().contains(searchString) ||
					statistics.getCardManHinh().toLowerCase().contains(searchString) ||
					(searchString.matches("\\d+") && statistics.getDungLuongLuuTru() == Integer.parseInt(searchString))) {
				result.add(statistics);
			}
		}
		return result;
	}

	public ArrayList<ProductStatistics> searchByName(ArrayList<ProductStatistics> list, String searchString) {
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<ProductStatistics> result = new ArrayList<>();
		searchString = searchString.trim().toLowerCase();
		for (ProductStatistics statistics : list) {
			if (statistics.getTenMay().toLowerCase().contains(searchString)) {
				result.add(statistics);
			}
		}
		return result;
	}

	public ArrayList<ProductStatistics> searchByCpu(ArrayList<ProductStatistics> list, String searchString) {
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<ProductStatistics> result = new ArrayList<>();
		searchString = searchString.toLowerCase();
		for (ProductStatistics statistics : list) {
			if (statistics.getTenCpu().toLowerCase().contains(searchString)) {
				result.add(statistics);
			}
		}
		return result;
	}

	public ArrayList<ProductStatistics> searchByRam(ArrayList<ProductStatistics> list, String searchString) {
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<ProductStatistics> result = new ArrayList<>();
		searchString = searchString.trim().toLowerCase();
		for (ProductStatistics statistics : list) {
			if (statistics.getRam().toLowerCase().contains(searchString)) {
				result.add(statistics);
			}
		}
		return result;
	}

	public ArrayList<ProductStatistics> searchByDungLuong(ArrayList<ProductStatistics> list, String searchString) {
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<ProductStatistics> result = new ArrayList<>();
		int dungLuong_search = Integer.parseInt(searchString);
		for (ProductStatistics statistics : list) {
			if (statistics.getDungLuongLuuTru() == dungLuong_search) {
				result.add(statistics);
			}
		}
		return result;
	}

	public ArrayList<ProductStatistics> searchByCard(ArrayList<ProductStatistics> list, String searchString) {
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<ProductStatistics> result = new ArrayList<>();
		searchString = searchString.toLowerCase();
		for (ProductStatistics statistics : list) {
			if (statistics.getCardManHinh().toLowerCase().contains(searchString)) {
				result.add(statistics);
			}
		}
		return result;
	}
}
