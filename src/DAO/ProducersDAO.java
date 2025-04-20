package DAO;

import database.JDBCUtil;
import model.Producer;

import java.sql.*;
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
            String sql = Query.insertProducer;
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
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.updateProducer;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,producer.getMaNhaCungCap());
            pst.setString(2,producer.getDiaChi());
            pst.setString(3,producer.getSdt());
            pst.setString(4,producer.getMaNhaCungCap());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Producer producer) {
        int ketQua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.deleteProducer;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,producer.getMaNhaCungCap());
            ketQua = pst.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            ketQua = -1; // Giá trị đặc biệt biểu thị lỗi khóa ngoại
        } catch (Exception e) {
            e.printStackTrace();
            ketQua =-2;
        }
        return ketQua;
    }

    @Override
    public ArrayList<Producer> selectAll() {
        ArrayList<Producer>ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.selectAllProducer;
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
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public Producer producerByID(String id){
        Producer producer = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.producerByID;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String maNCC = rs.getString("manhacungcap");
                String tenNCC = rs.getString("tennhacungcap");
                String SDT = rs.getString("sodienthoai");
                String diaChi = rs.getString("diachi");
                producer = new Producer(diaChi,maNCC,SDT,tenNCC);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producer;
    }
    public Producer producerByName(String tennhacungcap){
        Producer producer = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.producerByName;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,tennhacungcap);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String maNCC = rs.getString("manhacungcap");
                String tenNCC = rs.getString("tennhacungcap");
                String SDT = rs.getString("sodienthoai");
                String diaChi = rs.getString("diachi");
                producer = new Producer(diaChi,maNCC,SDT,tenNCC);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producer;
    }
    public boolean checkSdt(String sdt){
        Connection c = JDBCUtil.getConnection();
        String sql = "select count(*) from producer where sodienthoai = ?";
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
