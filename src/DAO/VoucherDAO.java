package DAO;

import database.JDBCUtil;
import model.Customer;
import model.Voucher;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VoucherDAO implements DAOInterface<Voucher> {
    public static VoucherDAO getInstance() {
        return new VoucherDAO();
    }

    @Override
    public int insert(Voucher voucher) {
        return 0;
    }

    @Override
    public int update(Voucher voucher) {
        return 0;
    }

    @Override
    public int delete(Voucher voucher) {
        return 0;
    }

    @Override
    public ArrayList<Voucher> selectAll() {
        return null;
    }
    public ArrayList<Voucher> getSelectedVoucher(Customer customer) {
        ArrayList<Voucher> vouchers = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "";
            PreparedStatement pst = connection.prepareStatement(sql);
            if (customer != null) {
                sql = "select * from voucher a ,point_customer b where a.id = b.idvoucher and a.makhachhang = ?";
                pst.setInt(1,customer.getMaKhachHang());
            }
            else {
                sql = "select * from voucher a where a.id not in (select idvoucher from point_customer)";
            }
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                BigDecimal percent = rs.getBigDecimal("phantram");
                String descrip = rs.getString("mota");
                Voucher voucher = new Voucher(id, percent, descrip);
                vouchers.add(voucher);
            }
            JDBCUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return vouchers;
    }
}
