package DAO;

import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StatusDeliveryDAO implements DAOInterface<String>{
    public static StatusDeliveryDAO getInstance(){
        return new StatusDeliveryDAO();
    }

    @Override
    public int insert(String s) {
        return 0;
    }

    @Override
    public int update(String s) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }

    @Override
    public ArrayList<String> selectAll() {
       ArrayList<String>ketQua = new ArrayList<>();
       ketQua.add("Tất cả");
       try {
           Connection connection = JDBCUtil.getConnection();
           String sql = "Select * from status ";
           PreparedStatement pst = connection.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           while (rs.next()){
               String name = rs.getString("name");
               ketQua.add(name);
           }
           JDBCUtil.closeConnection(connection);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return ketQua;
    }
    public int selectByName(String name) {
        int ketQua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from status where name=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,name);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                ketQua= rs.getInt("id");
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public String selectByID(int id) {
        String ketQua ="" ;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from status where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                ketQua= rs.getString("name");
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<String> selectAllStatus() {
        ArrayList<String>ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from status ";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                ketQua.add(name);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<String> selectAllChangeStatus() {
        ArrayList<String>ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from status where name !='Đã huỷ' ";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                ketQua.add(name);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<String> selectChangeStatus(int idStatus) {
        ArrayList<String>ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from status where id>=? and id<=5 and name !='Đã huỷ' ";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idStatus);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                ketQua.add(name);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
