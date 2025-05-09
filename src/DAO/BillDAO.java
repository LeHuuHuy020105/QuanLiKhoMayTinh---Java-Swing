package DAO;

import database.JDBCUtil;
import DTO.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BillDAO implements DAOInterface<Bill> {
    public static BillDAO getInstance() {
        return new BillDAO();
    }

    @Override
    public int insert(Bill bill) {
        return 0;
    }

    @Override
    public int update(Bill bill) {
        return 0;
    }

    @Override
    public int delete(Bill bill) {
        return 0;
    }

    @Override
    public ArrayList<Bill> selectAll() {
        return null;
    }

    public int insertBill(Bill bill) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into bills (thoidiemtao, thanhtien, tongtien, manhanvien, makhachhang, machinhanh,hinhthuc) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setTimestamp(1, bill.getThoiDiemTao());
            pst.setDouble(2, bill.getThanhTien());
            pst.setDouble(3, bill.getTongTien());
            pst.setInt(4, bill.getMaNhanVien());
            pst.setInt(5, bill.getMaKhachHang());
            pst.setInt(6, bill.getMaChiNhanh());
            pst.setString(7, bill.getHinhThuc());

            pst.executeUpdate();
            var key = pst.getGeneratedKeys();
            key.next();
            ketQua = key.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public Bill getBillByMaPhieu(int maPhieu) {
        Connection conn = JDBCUtil.getConnection(); // Giả định JDBCUtil cung cấp kết nối
        String sql = "SELECT * FROM bills WHERE maphieu = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maPhieu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Bill bill = new Bill();
                bill.setMaPhieu(rs.getInt("maphieu"));
                bill.setThoiDiemTao(rs.getTimestamp("thoidiemtao"));
                bill.setThanhTien(rs.getDouble("thanhtien"));
                bill.setTongTien(rs.getDouble("tongtien"));
                bill.setMaNhanVien(rs.getInt("manhanvien"));
                bill.setMaKhachHang(rs.getInt("makhachhang"));
                bill.setMaChiNhanh(rs.getInt("machinhanh"));
                bill.setHinhThuc(rs.getString("hinhthuc"));
                bill.setThoiDiemHuy(rs.getTimestamp("thoidiemhuy"));
                bill.setTrangThai(rs.getInt("trangthai"));
                bill.setMadiachi(rs.getInt("madiachi"));
                return bill;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return null;
    }
}
