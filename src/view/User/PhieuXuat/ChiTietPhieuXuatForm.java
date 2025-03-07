package view.User.PhieuXuat;

import DAO.*;
import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ChiTietPhieuXuatForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_ChiTietPhieuXuat;
	private PhieuXuatForm phieuXuatForm;
	private JLabel label_maPhieuXuat;
	private JLabel label_tenNguoiTaoPhieu;
	private JLabel label_vaiTroNguoiTaoPhieu;
	private JLabel label_thoiDiemTaoPhieu;
	private JLabel label_DiaChi;
	private JLabel label_TinhTrangDon;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChiTietPhieuXuatForm(PhieuXuatForm phieuXuatForm) {
		this.phieuXuatForm = phieuXuatForm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 903, 580);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(144, 238, 144));
		panel.setBounds(0, 0, 887, 49);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT PHIẾU NHẬP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 887, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phiếu :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 60, 92, 28);
		contentPane.add(lblNewLabel_1);
		
		label_maPhieuXuat = new JLabel("PN40");
		label_maPhieuXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_maPhieuXuat.setBounds(112, 60, 92, 28);
		contentPane.add(label_maPhieuXuat);
		
		JLabel lblNewLabel_1_2 = new JLabel("Người tạo :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 147, 92, 28);
		contentPane.add(lblNewLabel_1_2);
		
		label_tenNguoiTaoPhieu = new JLabel("Admin");
		label_tenNguoiTaoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_tenNguoiTaoPhieu.setBounds(112, 147, 186, 28);
		contentPane.add(label_tenNguoiTaoPhieu);
		
		JLabel lblNewLabel_1_3 = new JLabel("Vai trò : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(446, 94, 92, 28);
		contentPane.add(lblNewLabel_1_3);
		
		label_vaiTroNguoiTaoPhieu = new JLabel("Admin");
		label_vaiTroNguoiTaoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_vaiTroNguoiTaoPhieu.setBounds(599, 94, 92, 28);
		contentPane.add(label_vaiTroNguoiTaoPhieu);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Thời gian tạo :");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(446, 147, 121, 28);
		contentPane.add(lblNewLabel_1_3_1);
		
		label_thoiDiemTaoPhieu = new JLabel("Admin");
		label_thoiDiemTaoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_thoiDiemTaoPhieu.setBounds(599, 147, 278, 28);
		contentPane.add(label_thoiDiemTaoPhieu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 867, 237);
		contentPane.add(scrollPane);
		
		table_ChiTietPhieuXuat = new JTable();
		table_ChiTietPhieuXuat.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã máy", "Tên máy", "Số lượng", "Đơn giá"
			}
		));
		scrollPane.setViewportView(table_ChiTietPhieuXuat);
		
		JButton btnXut = new JButton("Xuất PDF");
		btnXut.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\pdf.png"));
		btnXut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXut.setBounds(738, 480, 139, 41);
		contentPane.add(btnXut);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Địa chỉ :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(10, 193, 71, 28);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tình trạng đơn :");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(10, 99, 140, 28);
		contentPane.add(lblNewLabel_1_2_2);
		
		label_TinhTrangDon = new JLabel("");
		label_TinhTrangDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_TinhTrangDon.setBounds(160, 103, 194, 19);
		contentPane.add(label_TinhTrangDon);
		
		label_DiaChi = new JLabel("");
		label_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_DiaChi.setBounds(104, 193, 684, 28);
		contentPane.add(label_DiaChi);
		hienThiThongTinPhieuNhap();
	}
	public void hienThiThongTinPhieuNhap(){
		DecimalFormat df = new DecimalFormat("#,###");
		ExportProducts exportProducts_selected = phieuXuatForm.getExportProductsSelected();
		User user = UserDAO.getInstance().getUsetById(exportProducts_selected.getManguoidung());
		String tenNguoiTaoPhieu =user.getFullName();
		String role = UserDAO.getInstance().getRoleByIDUser(user.getIdUser());
		label_maPhieuXuat.setText("");
		label_tenNguoiTaoPhieu.setText(tenNguoiTaoPhieu);
		label_vaiTroNguoiTaoPhieu.setText(role);
		label_thoiDiemTaoPhieu.setText(exportProducts_selected.getNgayLenDonXuat()+"");
		String diaChi = BrandDAO.getInstance().BranchByID(exportProducts_selected.getMaChiNhanh()).getDiaChi();
		label_DiaChi.setText(diaChi);
		label_maPhieuXuat.setText(exportProducts_selected.getMaPhieuXuat()+"");
		label_TinhTrangDon.setText(exportProducts_selected.getTrangThai());
		ArrayList<DetailExportProducts>detailExportProducts = DetailExportProductsDAO.getInstance().selectAllByMaPhieuXuat(exportProducts_selected.getMaPhieuXuat());
		updateDataToTable(detailExportProducts);
	}
	public void updateDataToTable(ArrayList<DetailExportProducts>detailExportProducts){
		DecimalFormat df = new DecimalFormat("#,###");
		DefaultTableModel model = (DefaultTableModel) table_ChiTietPhieuXuat.getModel();
		model.setRowCount(0);
		int i = 0;
		for(DetailExportProducts detailExportProducts1 : detailExportProducts){
			i++;
			Computer computer = ProductsDAO.getInstance().searchByIDProduct(detailExportProducts1.getMaMay());
			model.addRow(new Object[]{
					i,
					detailExportProducts1.getMaMay(),
					computer.getTenMay(),
					detailExportProducts1.getSoLuong(),
					df.format(computer.getGia()),
			});
		}
	}
}
