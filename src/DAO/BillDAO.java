package DAO;

import database.JDBCUtil;
import model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class BillDAO implements DAOInterface<Bill>{
    public static BillDAO getInstance(){
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
        int ketQua=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql="";
            PreparedStatement pst = null;
            if(bill.getHinhThuc().equals("online")){
                sql ="insert into bills (thoidiemtao, thanhtien, tongtien, manhanvien, makhachhang, machinhanh,hinhthuc,thoidiemhuy,trangthai,madiachi) values (?,?,?,?,?,?,?,?,?)";
                pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setTimestamp(1,bill.getThoiDiemTao());
                pst.setDouble(2,bill.getThanhTien());
                pst.setDouble(3,bill.getTongTien());
                pst.setInt(4,bill.getMaNhanVien());
                pst.setInt(5,bill.getMaKhachHang());
                pst.setInt(6,bill.getMaChiNhanh());
                pst.setString(7,bill.getHinhThuc());
                pst.setTimestamp(8,bill.getThoiDiemHuy());
                pst.setInt(9,bill.getTrangThai());
                pst.setInt(10,bill.getMadiachi());
            }else {
                sql ="insert into bills (thoidiemtao, thanhtien, tongtien, manhanvien, makhachhang, machinhanh,hinhthuc) values (?,?,?,?,?,?,?)";
                pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setTimestamp(1,bill.getThoiDiemTao());
                pst.setDouble(2,bill.getThanhTien());
                pst.setDouble(3,bill.getTongTien());
                pst.setInt(4,bill.getMaNhanVien());
                pst.setInt(5,bill.getMaKhachHang());
                pst.setInt(6,bill.getMaChiNhanh());
                pst.setString(7,bill.getHinhThuc());
            }
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
