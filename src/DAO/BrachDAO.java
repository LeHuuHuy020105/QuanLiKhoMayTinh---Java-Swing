package DAO;

import database.JDBCUtil;
import model.Branch;

import java.sql.*;
import java.util.ArrayList;

public class BrachDAO implements DAOInterface<Branch>{
    public static BrachDAO getInstance(){
        return new BrachDAO();
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
            String sql = Query.updateBranch;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,branch.getTenChiNhanh());
            pst.setString(2,branch.getDiaChi());
            pst.setString(3,branch.getTenQuan());
            pst.setString(4,branch.getThanhPho());
            pst.setString(5,branch.getSoDienThoai());
            pst.setString(6,branch.getMoTa());
            pst.setInt(7,branch.getMaChiNhanh());
            ketQua=pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(Branch branch) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.deleteBranch;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,branch.getMaChiNhanh());
            ketQua=pst.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            ketQua = -1; // Giá trị đặc biệt biểu thị lỗi khóa ngoại
        } catch (Exception e) {
            e.printStackTrace();
            ketQua = -2;
        }
        return ketQua;
    }

    @Override
    public ArrayList<Branch> selectAll() {
        ArrayList<Branch> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.selectAllBranch;
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
    public String getPhoneByBranchId(int idBranch) {
        Connection c = JDBCUtil.getConnection();
        String sql = Query.getPhoneByBranchId;
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, idBranch);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("sodienthoai");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Branch BranchByID(int idChiNhanh){
        Branch branch = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.BranchByID;
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
            String sql = Query.BranchByDiaChi;
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
    public boolean checkSdt(String sdt, int idBranch) {
        Connection c = JDBCUtil.getConnection();
        String sql = Query.checkSDTBranch;
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, sdt);
            ps.setInt(2, idBranch);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkName(String name){
        Connection c = JDBCUtil.getConnection();
        String sql = Query.checkNameBranch;
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, name);
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
