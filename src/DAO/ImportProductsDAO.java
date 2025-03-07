package DAO;

import database.JDBCUtil;
import model.ImportProducts;

import java.sql.*;
import java.util.ArrayList;

public class ImportProductsDAO implements DAOInterface<ImportProducts>{
    public static ImportProductsDAO getInstance(){
        return new ImportProductsDAO();
    }
    @Override
    public int insert(ImportProducts importProducts) {
        int ketQua=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.insertImportProduct;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setDouble(1, importProducts.getTongTien());
            pst.setTimestamp(2, importProducts.getTimestamp());
            pst.setInt(3,importProducts.getManguoidung());
            ketQua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public int insertImportProduct(ImportProducts importProducts) {
        int ketQua=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql =Query.insertImportProduct;
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setDouble(1, importProducts.getTongTien());
            pst.setTimestamp(2, importProducts.getTimestamp());
            pst.setInt(3,importProducts.getManguoidung());
            pst.executeUpdate();
            var key = pst.getGeneratedKeys();
            key.next();
            ketQua= key.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    @Override
    public int update(ImportProducts importProducts) {
        return 0;
    }

    @Override
    public int delete(ImportProducts importProducts) {
        return 0;
    }

    @Override
    public ArrayList<ImportProducts> selectAll() {
        ArrayList<ImportProducts> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from importproducts";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maPhieuNhap = rs.getInt("maphieunhap");
                int maNguoiDung = rs.getInt("id");
                double tongTien = rs.getDouble("tongtien");
                Timestamp thoiGianTao = rs.getTimestamp("thoidiemtaophieu");
                ImportProducts importProducts = new ImportProducts(maPhieuNhap,thoiGianTao,tongTien,maNguoiDung);
                ketQua.add(importProducts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
     public ImportProducts getImportProductsByMaPhieuNhap(int maphieunhap){
         ImportProducts importProducts =null;
         try {
             Connection connection = JDBCUtil.getConnection();
             String sql = "select * from importproducts where  maphieunhap =?";
             PreparedStatement pst = connection.prepareStatement(sql);
             pst.setInt(1,maphieunhap);
             ResultSet rs = pst.executeQuery();
             while (rs.next()){
                 int maPhieuNhap = rs.getInt("maphieunhap");
                 int maNguoiDung = rs.getInt("id");
                 double tongTien = rs.getDouble("tongtien");
                 Timestamp thoiGianTao = rs.getTimestamp("thoidiemtaophieu");
                 importProducts = new ImportProducts(maPhieuNhap,thoiGianTao,tongTien,maNguoiDung);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return importProducts;
     }
}
