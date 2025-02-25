package view.User.PhieuNhap;

import DAO.DetailImportProductsDAO;
import DAO.ProductsDAO;
import DAO.UserDAO;
import model.Computer;
import model.DetailImportProducts;
import model.ImportProducts;
import model.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ChiTietPhieuNhapForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_ChiTietPhieuNhap;
	private PhieuNhapForm phieuNhapForm;
	private JLabel label_maPhieuNhap;
	private JLabel label_tenNguoiTaoPhieu;
	private JLabel label_vaiTroNguoiTaoPhieu;
	private JLabel label_thoiDiemTaoPhieu;
	private JLabel label_TongTien;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChiTietPhieuNhapForm(PhieuNhapForm phieuNhapForm) {
		this.phieuNhapForm = phieuNhapForm;
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
		lblNewLabel_1.setBounds(10, 94, 92, 28);
		contentPane.add(lblNewLabel_1);
		
		label_maPhieuNhap = new JLabel("PN40");
		label_maPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_maPhieuNhap.setBounds(112, 94, 92, 28);
		contentPane.add(label_maPhieuNhap);
		
		JLabel lblNewLabel_1_2 = new JLabel("Người tạo :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 147, 92, 28);
		contentPane.add(lblNewLabel_1_2);
		
		label_tenNguoiTaoPhieu = new JLabel("Admin");
		label_tenNguoiTaoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_tenNguoiTaoPhieu.setBounds(112, 147, 186, 28);
		contentPane.add(label_tenNguoiTaoPhieu);
		
		JLabel lblNewLabel_1_3 = new JLabel("Vai trò");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(446, 94, 92, 28);
		contentPane.add(lblNewLabel_1_3);
		
		label_vaiTroNguoiTaoPhieu = new JLabel("Admin");
		label_vaiTroNguoiTaoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_vaiTroNguoiTaoPhieu.setBounds(599, 94, 92, 28);
		contentPane.add(label_vaiTroNguoiTaoPhieu);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Thời gian tạo");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(446, 147, 121, 28);
		contentPane.add(lblNewLabel_1_3_1);
		
		label_thoiDiemTaoPhieu = new JLabel("Admin");
		label_thoiDiemTaoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_thoiDiemTaoPhieu.setBounds(599, 147, 278, 28);
		contentPane.add(label_thoiDiemTaoPhieu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 867, 237);
		contentPane.add(scrollPane);
		
		table_ChiTietPhieuNhap = new JTable();
		table_ChiTietPhieuNhap.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã máy", "Tên máy", "Số lượng", "Đơn giá", "Thành tiền"
			}
		));
		scrollPane.setViewportView(table_ChiTietPhieuNhap);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tổng tiền :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(10, 480, 108, 41);
		contentPane.add(lblNewLabel_2_1);
		
		label_TongTien = new JLabel("0");
		label_TongTien.setHorizontalAlignment(SwingConstants.CENTER);
		label_TongTien.setForeground(Color.RED);
		label_TongTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_TongTien.setBounds(132, 480, 197, 41);
		contentPane.add(label_TongTien);
		
		JButton btnXut = new JButton("Xuất PDF");
		btnXut.setIcon(new ImageIcon("D:\\WEB\\FontEnd & BackEnd\\BackEnd\\Java Core\\Swing\\Project\\QLKhoHangMayTinh\\src\\icon\\pdf.png"));
		btnXut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXut.setBounds(738, 480, 139, 41);
		contentPane.add(btnXut);
		hienThiThongTinPhieuNhap();
	}
	public void hienThiThongTinPhieuNhap(){
		DecimalFormat df = new DecimalFormat("#,###");
		ImportProducts importProducts_selected = phieuNhapForm.getImportProductsSelected();
		User user = UserDAO.getInstance().getUsetById(importProducts_selected.getManguoidung());
		String tenNguoiTaoPhieu =user.getFullName();
		String vaiTro = user.getRole();
		label_maPhieuNhap.setText(importProducts_selected.getMaphieunhap()+"");
		label_tenNguoiTaoPhieu.setText(tenNguoiTaoPhieu);
		label_vaiTroNguoiTaoPhieu.setText(vaiTro);
		label_thoiDiemTaoPhieu.setText(importProducts_selected.getTimestamp()+"");
		String tongTien = df.format(importProducts_selected.getTongTien())+" VND";
		label_TongTien.setText(tongTien);
		ArrayList<DetailImportProducts>detailImportProducts = DetailImportProductsDAO.getInstance().selectAllByMaPhieuNhap(importProducts_selected.getMaphieunhap());
		updateDataToTable(detailImportProducts);
	}
	public void updateDataToTable(ArrayList<DetailImportProducts>detailImportProducts){
		DecimalFormat df = new DecimalFormat("#,###");
		DefaultTableModel model = (DefaultTableModel) table_ChiTietPhieuNhap.getModel();
		model.setRowCount(0);
		int i = 0;
		for(DetailImportProducts detailImportProducts1 : detailImportProducts){
			i++;
			Computer computer = ProductsDAO.getInstance().searchByIDProduct(detailImportProducts1.getMaMay());
			double thanhTien = detailImportProducts1.getSoluong()*computer.getGia();
			System.out.println(df.format(thanhTien));
			model.addRow(new Object[]{
					i,
					detailImportProducts1.getMaMay(),
					computer.getTenMay(),
					detailImportProducts1.getSoluong(),
					df.format(computer.getGia()),
					df.format(thanhTien),
			});
		}
	}
}
