package DAO;

import database.JDBCUtil;
import model.Producer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProducersDAO implements DAOInterface<Producer>{
    public static ProducersDAO getInstance(){
        return new ProducersDAO();
    }
    @Override
    public int insert(Producer producer) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Insert into producer(manhacungcap,tennhacungcap,sodienthoai,diachi) VALUES (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, producer.getMaNhaCungCap());
            pst.setString(2, producer.getTenNhaCungCap());
            pst.setString(3, producer.getSdt());
            pst.setString(4, producer.getDiaChi());
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Producer producer) {
        return 0;
    }

    @Override
    public int delete(Producer producer) {
        return 0;
    }

    @Override
    public ArrayList<Producer> selectAll() {
        ArrayList<Producer>ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from producer";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String maNhaCungCap = rs.getString("manhacungcap");
                String tenNhaCungCap = rs.getString("tennhacungcap");
                String soDienThoai = rs.getString("sodienthoai");
                String diaChi = rs.getString("diachi");
                Producer producer = new Producer(diaChi,maNhaCungCap,soDienThoai,tenNhaCungCap);
                ketQua.add(producer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
