package DAO;

import database.JDBCUtil;
import model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class BillDAO implements DAOInterface<Bill>{
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
        int ketQua=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql ="insert into bills (ngayxuatphieu, thanhtien, tongtien, manhanvien, makhachhang, machinhanh) values (?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setTimestamp(1,bill.getNgayXuatPhieu());
            pst.setDouble(2,bill.getThanhTien());
            pst.setDouble(3,bill.getTongTien());
            pst.setInt(4,bill.getMaNhanVien());
            pst.setInt(5,bill.getMaKhachHang());
            pst.setInt(6,bill.getMaChiNhanh());
            pst.executeUpdate();
            var key = pst.getGeneratedKeys();
            key.next();
            ketQua= key.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
