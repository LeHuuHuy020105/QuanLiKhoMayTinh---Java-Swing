package DAO;

import database.JDBCUtil;
import DTO.Branch;
import DTO.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InventoryDAO implements DAOInterface<Inventory> {
    public static InventoryDAO getInstance(){
        return new InventoryDAO();
    }
    @Override
    public int insert(Inventory inventory) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql= "insert into inventory_branch (machinhanh,mamay,soluong) values (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,inventory.getMaChiNhanh());
            pst.setInt(2,inventory.getMaMay());
            pst.setInt(3,inventory.getSoLuong());
            ketQua=pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int update(Inventory inventory) {
        return 0;
    }

    @Override
    public int delete(Inventory inventory) {
        return 0;
    }

    @Override
    public ArrayList<Inventory> selectAll() {
        ArrayList<Inventory>ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from inventory";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maChiNhanh = rs.getInt("machinhanh");
                int maMay = rs.getInt("mamay");
                int soLuong = rs.getInt("soluong");
                Inventory inventory = new Inventory(maChiNhanh,maMay,soLuong);
                ketQua.add(inventory);
                JDBCUtil.closeConnection(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public int updateSoLuong(Inventory inventory , Branch branch){
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql ="update inventory_branch set soluong=? where mamay =? and machinhanh=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,inventory.getSoLuong());
            pst.setInt(2,inventory.getMaMay());
            pst.setInt(3,branch.getMaChiNhanh());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<Inventory> InventoryByBranch (Branch branch){
        System.out.println("DAO" + branch);
        ArrayList<Inventory>ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from inventory_branch where machinhanh =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,branch.getMaChiNhanh());
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maChiNhanh = rs.getInt("machinhanh");
                int maMay = rs.getInt("mamay");
                int soLuong = rs.getInt("soluong");
                Inventory inventory = new Inventory(maChiNhanh,maMay,soLuong);
                ketQua.add(inventory);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public Inventory InventoryByIDProduct (int idProduct , Branch branch){
        Inventory inventory = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from inventory_branch where mamay =? and machinhanh=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idProduct);
            pst.setInt(2,branch.getMaChiNhanh());
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maChiNhanh = rs.getInt("machinhanh");
                int maMay = rs.getInt("mamay");
                int soLuong = rs.getInt("soluong");
                inventory = new Inventory(maChiNhanh,maMay,soLuong);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventory;
    }
}
