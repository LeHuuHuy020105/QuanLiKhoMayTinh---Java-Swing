package DAO;

import database.JDBCUtil;
import model.DetailImportProducts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DetailImportProductsDAO implements DAOInterface<DetailImportProducts> {
    public static DetailImportProductsDAO getInstance(){
        return new DetailImportProductsDAO();
    }
    @Override
    public int insert(DetailImportProducts detailImportProducts) {
        int ketQua=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql =Query.insertDetailImportProduct;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, detailImportProducts.getMaphieunhap());
            pst.setInt(2, detailImportProducts.getMaMay());
            pst.setInt(3,detailImportProducts.getSoluong());
            ketQua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(DetailImportProducts detailImportProducts) {
        return 0;
    }

    @Override
    public int delete(DetailImportProducts detailImportProducts) {
        return 0;
    }

    @Override
    public ArrayList<DetailImportProducts> selectAll() {
        return null;
    }
    public ArrayList<DetailImportProducts>selectAllByMaPhieuNhap(int maphieunhap){
        ArrayList<DetailImportProducts> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from detailimportproducts where maphieunhap=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,maphieunhap);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maMay = rs.getInt("mamay");
                int soLuong = rs.getInt("soluong");
                int maPhieuNhap = rs.getInt("maphieunhap");
                DetailImportProducts detailImportProducts1 = new DetailImportProducts(maMay,maPhieuNhap,soLuong);
                ketQua.add(detailImportProducts1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
