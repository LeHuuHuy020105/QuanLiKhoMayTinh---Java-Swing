package DAO;

import database.JDBCUtil;
import model.Branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BrandDAO implements DAOInterface<Branch>{
    public static BrandDAO getInstance(){
        return new BrandDAO();
    }
    @Override
    public int insert(Branch branch) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql =Query.insertBranch;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,branch.getTenChiNhanh());
            pst.setString(2,branch.getDiaChi());
            pst.setString(3,branch.getTenQuan());
            pst.setString(4,branch.getThanhPho());
            pst.setString(5,branch.getSoDienThoai());
            pst.setString(6,branch.getMoTa());
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Branch branch) {
        int ketQua =0 ;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update set tenchinhanh =?, diachi =?, tenquan =?, thanhpho =?, sodienthoai =?, mota=? from branch where machinhanh=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            ketQua=pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int delete(Branch branch) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "delete from branch where machinhanh=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,branch.getMaChiNhanh());
            ketQua=pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Branch> selectAll() {
        ArrayList<Branch> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from branch";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maChiNhanh = rs.getInt("machinhanh");
                String diaChi = rs.getString("diachi");
                String SDT = rs.getString("sodienthoai");
                String tenChiNhanh = rs.getNString("tenchinhanh");
                String thanhPho = rs.getNString("tenchinhanh");
                String tenQuan = rs.getNString("tenquan");
                String moTa = rs.getNString("mota");
                Branch branch = new Branch(diaChi,maChiNhanh,SDT,tenChiNhanh,tenQuan,thanhPho,moTa);
                ketQua.add(branch);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public Branch BranchByID(int idChiNhanh){
        Branch branch = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from branch where machinhanh=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idChiNhanh);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maChiNhanh = rs.getInt("machinhanh");
                String diaChi = rs.getString("diachi");
                String SDT = rs.getString("sodienthoai");
                String tenChiNhanh = rs.getNString("tenchinhanh");
                String thanhPho = rs.getNString("tenchinhanh");
                String tenQuan = rs.getNString("tenquan");
                String moTa = rs.getNString("mota");
                branch = new Branch(diaChi,maChiNhanh,SDT,tenChiNhanh,tenQuan,thanhPho,moTa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return branch;
    }
    public Branch BranchByDiaChi(String diaChi){
        Branch branch = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from branch where diachi=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,diaChi);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maChiNhanh = rs.getInt("machinhanh");
                String diachi = rs.getString("diachi");
                String SDT = rs.getString("sodienthoai");
                String tenChiNhanh = rs.getNString("tenchinhanh");
                String thanhPho = rs.getNString("tenchinhanh");
                String tenQuan = rs.getNString("tenquan");
                String moTa = rs.getNString("mota");
                branch = new Branch(diachi,maChiNhanh,SDT,tenChiNhanh,tenQuan,thanhPho,moTa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return branch;
    }
}
