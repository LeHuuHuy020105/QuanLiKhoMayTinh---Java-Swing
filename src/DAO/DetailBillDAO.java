package DAO;

import database.JDBCUtil;
import DTO.DetailBill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public ArrayList<DetailBill> selectAllByMaPhieu(int maPhieu) {
        ArrayList<DetailBill> result = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT * FROM detailbill WHERE maphieu = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maPhieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetailBill detail = new DetailBill(
                        rs.getInt("mamay"),
                        rs.getInt("maphieu"),
                        rs.getInt("soluong")
                );
                result.add(detail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return result;
    }
}
