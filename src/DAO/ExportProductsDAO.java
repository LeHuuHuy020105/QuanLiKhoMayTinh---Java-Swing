package DAO;

import database.JDBCUtil;
import model.ExportProducts;
import model.ImportProducts;

import java.sql.*;
import java.util.ArrayList;

public class ExportProductsDAO implements DAOInterface<ExportProducts> {
    public static ExportProductsDAO getInstance(){
        return new ExportProductsDAO();
    }
    @Override
    public int insert(ExportProducts exportProducts) {
        return 0;
    }

    @Override
    public int update(ExportProducts exportProducts) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql ="update exportproducts set ngaylendon=?,trangthai=?,machinhanh=?,id=? where maphieuxuat =?";
            if (exportProducts.getTrangThai().equals("Hoàn thành")){
                sql ="update exportproducts set ngaylendon=?,trangthai=?,ngaynhandonxuat=CURRENT_TIMESTAMP,machinhanh=?,id=? where maphieuxuat =?";
            }
            System.out.println(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setTimestamp(1,exportProducts.getNgayLenDonXuat());
            pst.setString(2,exportProducts.getTrangThai());
            pst.setInt(3,exportProducts.getMaChiNhanh());
            pst.setInt(4,exportProducts.getManguoidung());
            pst.setInt(5,exportProducts.getMaPhieuXuat());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(ExportProducts exportProducts) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "delete from exportproducts where maphieuxuat = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,exportProducts.getMaPhieuXuat());
            ketQua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<ExportProducts> selectAll() {
        ArrayList<ExportProducts> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from exportproducts";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maPhieuXuat = rs.getInt("maphieuxuat");
                String trangThai = rs.getString("trangthai");
                Timestamp ngaylendon = rs.getTimestamp("ngaylendon");
                int maChiNhanh = rs.getInt("machinhanh");
                int maNguoiDung = rs.getInt("id");
                ExportProducts exportProducts = new ExportProducts(maPhieuXuat,ngaylendon,null,trangThai,maChiNhanh,maNguoiDung);
                ketQua.add(exportProducts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public int insertExportProduct(ExportProducts exportProducts) {
        int ketQua=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into exportproducts (ngaylendon,trangthai,machinhanh,id) values (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setTimestamp(1, exportProducts.getNgayLenDonXuat());
            pst.setString(2,exportProducts.getTrangThai());
            pst.setInt(3,exportProducts.getMaChiNhanh());
            pst.setInt(4,exportProducts.getManguoidung());
            pst.executeUpdate();
            var key = pst.getGeneratedKeys();
            key.next();
            ketQua= key.getInt(1);
            System.out.println(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public ExportProducts ExportProductsByID(int idPhieuXuat){
        ExportProducts exportProducts = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from exportproducts where maphieuxuat =? ";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idPhieuXuat);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maPhieuXuat = rs.getInt("maphieuxuat");
                String trangThai = rs.getString("trangthai");
                Timestamp ngaylendon = rs.getTimestamp("ngaylendon");
                int maChiNhanh = rs.getInt("machinhanh");
                int maNguoiDung = rs.getInt("id");
                exportProducts = new ExportProducts(maPhieuXuat,ngaylendon,null,trangThai,maChiNhanh,maNguoiDung);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exportProducts;
    }

}
