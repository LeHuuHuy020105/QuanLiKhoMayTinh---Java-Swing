package view.User.QuanLiChiNhanh;

import DAO.BrandDAO;
import DAO.ExportProductsDAO;
import DAO.UserDAO;
import com.toedter.calendar.JDateChooser;
import controller.SearchExportProducts;
import controller.updateDataToTable;
import model.ExportProducts;
import model.User;
import view.User.PhieuXuat.ChiTietPhieuXuatForm;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PhieuNhapBranchForm extends JPanel implements updateDataToTable<ExportProducts> {

	private static final long serialVersionUID = 1L;
	private JTextField input_Search;
	private JTable table_PhieuXuatHang;
	private JComboBox cbx_luaChon;
	private JComboBox cbx_TrangThai;
	private User currentUser;



	/**
	 * Create the panel.
	 */
	public PhieuNhapBranchForm(User currentUser) {
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

		JButton btnNewButton = new JButton("Xoá");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaMouseClicked();
			}
		});
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\delete.png"));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(10, 0, 70, 52);
		panel_5_1.add(btnNewButton);

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

		String[] luachonStrings = new String[] {"Mã phiếu xuất","Địa chỉ"};
		cbx_luaChon = new JComboBox(luachonStrings);
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
		input_Search.setBounds(156, 11, 366, 30);
		panel_5_1_1.add(input_Search);

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

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(87, 11, 165, 30);
		panel_5_1_1_1.add(dateChooser);

		JLabel lblNewLabel = new JLabel("Từ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 11, 32, 30);
		panel_5_1_1_1.add(lblNewLabel);

		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbln.setBounds(397, 11, 32, 30);
		panel_5_1_1_1.add(lbln);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(435, 11, 165, 30);
		panel_5_1_1_1.add(dateChooser_1);

		Box verticalBox_1_2 = Box.createVerticalBox();
		verticalBox_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Trạng thái", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
		verticalBox_1_2.setBounds(750, 107, 294, 75);
		add(verticalBox_1_2);

		JPanel panel_5_1_1_2 = new JPanel();
		verticalBox_1_2.add(panel_5_1_1_2);
		panel_5_1_1_2.setLayout(null);

		String[] trangthaiStrings = new String[] {"Tất cả","Chờ xác nhận","Đang chuẩn bị hàng","Đã bàn giao cho đơn vị vận chuyển","Vận chuyển","Hoàn thành"};
		cbx_TrangThai = new JComboBox(trangthaiStrings);
		cbx_TrangThai.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				FilterTrangThai();
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
		updateTableDataFormDAO();
	}
	public void fillData(){

	}
	@Override
	public void updateTableDataFormDAO() {
		int idBranch = UserDAO.getInstance().getMaChiNhanhByIDUser(currentUser.getIdUser());
		ArrayList<ExportProducts>exportProducts = ExportProductsDAO.getInstance().selectAll();
		ArrayList<ExportProducts>exportProducts_filter = new ArrayList<>(
				exportProducts.stream().filter(item ->item.getMaChiNhanh()==idBranch).collect(Collectors.toList())
		);
		updateTableData(exportProducts_filter);
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
			model.addRow(new Object[]{
					i,
					exportProducts.getMaPhieuXuat(),
					tenNguoiDung,
					exportProducts.getNgayLenDonXuat(),
					exportProducts.getNgayNhanDonXuat()==null? "Trống":exportProducts.getNgayNhanDonXuat(),
					diaChi,
					exportProducts.getTrangThai()
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
	public void ChiTietMouseClicked() {
		ChiTietPhieuNhapBranchForm chiTietPhieuNhapBranchForm = new ChiTietPhieuNhapBranchForm(this);
		chiTietPhieuNhapBranchForm.setVisible(true);
	}
	public void XoaMouseClicked() {
		ExportProducts exportProducts_Selected = getExportProductsSelected();
		if(exportProducts_Selected.getTrangThai()==1 || exportProducts_Selected.getTrangThai()==2){
			int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có muốn xoá phiếu xuất này hay không ", "xoá phiếu xuất", JOptionPane.YES_NO_OPTION);
			if(luaChon==JOptionPane.YES_OPTION){
				ExportProductsDAO.getInstance().delete(exportProducts_Selected);
			}
		}else {
			JOptionPane.showMessageDialog(this,"Bạn không thể xoá phiếu nhập khi đã bàn giao cho đơn vị vận chuyển !");
		}
	}
	public void jTextFieldSearchKeyReleased() {
		String luaChon = (String) cbx_luaChon.getSelectedItem();
		String input = input_Search.getText();
		ArrayList<ExportProducts> exportProducts = searchExportProducts(luaChon, input);
		System.out.println(exportProducts);
		updateTableData(exportProducts);
	}

	public ArrayList<ExportProducts> searchExportProducts(String luaChon, String content_Search) {
		ArrayList<ExportProducts> result = new ArrayList<>();
		SearchExportProducts searchExportProducts = new SearchExportProducts();
		if(content_Search.equals("")){
			ArrayList<ExportProducts>exportProducts = ExportProductsDAO.getInstance().selectAll();
			return exportProducts;
		}
		content_Search = content_Search.toLowerCase();
		switch (luaChon) {
			case "Mã phiếu xuất":
				result = searchExportProducts.searchMaPhieuXuat(content_Search);
				break;
			case "Địa chỉ":
				result = searchExportProducts.searchDiaChi(content_Search);
				break;
		}
		return result;
	}
	public void FilterTrangThai(){
		String trangThai = cbx_TrangThai.getSelectedItem()+"";
		SearchExportProducts searchExportProducts = new SearchExportProducts();
		ArrayList<ExportProducts>result = searchExportProducts.searchTrangThai(trangThai);
		updateTableData(result);
	}
}
