package view.User.ThongKe;

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
import java.util.Optional;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextField;

import DAO.ProductsDAO;
import DAO.StatisticsDAO;
import com.toedter.calendar.JDateChooser;
import controller.SearchProduct;
import controller.updateDataToTable;
import model.Computer;
import model.Laptop;
import model.Statistics;
import view.User.SanPham.SanPhamForm;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ThongKeSanPhamForm extends JPanel implements updateDataToTable<Statistics> {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTextField input_Search = new JTextField();
	StatisticsDAO statisticsDAO = new StatisticsDAO();
	JDateChooser startDate;
	JDateChooser endDate;
	/**
	 * Create the panel.
	 */
	public ThongKeSanPhamForm() {
		setLayout(null);
		setSize( 1247, 504);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 1223, 407);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
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

		String [] cbxLuaChonValues = new String[] {"Tất cả","Tên máy"};
		JComboBox optionsForSearch = new JComboBox(cbxLuaChonValues);
		optionsForSearch.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateTableDataFormDAO();
				input_Search.setText("");
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
				filterByTime();
			}
		});
		endDate.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				filterByTime();
			}
		});
		panel_5_1_1_1.add(startDate);
		panel_5_1_1_1.add(endDate);

		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\refesh.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(546, 11, 114, 30);
		btnNewButton_1.addItemListener((e -> {

		}));
		panel_5_1_1_1.add(btnNewButton_1);
		updateTableDataFormDAO();

	}
	@Override
	public void updateTableDataFormDAO() {
		ArrayList<Statistics> statistics = new StatisticsDAO().findAllProducts();
		updateTableData(statistics);
	}

	@Override
	public void updateTableData(ArrayList<Statistics> Statistics) {
		DecimalFormat df = new DecimalFormat("#,###");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Statistics statistic : Statistics) {
			model.addRow(
					new Object[]{
							statistic.getMaMay(),
							statistic.getTenMay(),
							statistic.getSoLuongBan(),
							df.format(statistic.getGiaNhap()) + " VND",
							df.format(statistic.getGiaBan())+" VND",
					});
		}
	}

	public void jTextFieldSearchKeyReleased(String selectedOption, String searchString) {
		ArrayList<Statistics> result = SearchFn(selectedOption, searchString);
		updateTableData(result);
	}

	public ArrayList<Statistics> SearchFn(String selectedOption, String searchString) {
		ArrayList<Statistics> result = new ArrayList<>();
		switch (selectedOption) {
			case "Tất cả":
				result = searchTatCa(searchString);
				break;
			case "Tên máy":
				result = searchTenMay(searchString);
				break;
		}
		return result;
	}

	public ArrayList<Statistics> searchTatCa(String searchString) {
		ArrayList<Statistics> list = statisticsDAO.findAllProducts();
		System.out.println(list.size());
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<Statistics> result = new ArrayList<>();
		searchString = searchString.trim().toLowerCase();
		for (Statistics statistics : list) {
			if (statistics.getTenMay().toLowerCase().contains(searchString)) {
				result.add(statistics);
			}
		}
		return result;
	}

	public ArrayList<Statistics> searchTenMay(String searchString) {
		ArrayList<Statistics> list = statisticsDAO.findAllProducts();
		if (searchString.equals("")) {
			return list;
		}
		ArrayList<Statistics> result = new ArrayList<>();
		searchString = searchString.trim().toLowerCase();
		for (Statistics statistics : list) {
			if (statistics.getTenMay().toLowerCase().contains(searchString)) {
				result.add(statistics);
			}
		}
		return result;
	}

	public void filterByTime(String selectedOption, String searchString) {
		if (startDate.getDate() == null || endDate.getDate() == null) return;
		LocalDate startLocalDate = startDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endLocalDate = endDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		ArrayList<Statistics> result = statisticsDAO.findAllProductsByTime(startLocalDate, endLocalDate);

		updateTableData(result);
	}
}
