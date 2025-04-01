package DAO;

import database.JDBCUtil;
import model.DetailBill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DetailBillDAO implements DAOInterface<DetailBill> {
    public static DetailBillDAO getInstance(){
        return new DetailBillDAO();
    }
    @Override
    public int insert(DetailBill detailBill) {
        int ketQua=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into detailbill(maphieu, mamay, soluong) values (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, detailBill.getMaPhieu());
            pst.setInt(2, detailBill.getMaMay());
            pst.setInt(3, detailBill.getSoLuong());
            ketQua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(DetailBill detailBill) {
        return 0;
    }

    @Override
    public int delete(DetailBill detailBill) {
        return 0;
    }

    @Override
    public ArrayList<DetailBill> selectAll() {
        return null;
    }
}
