package DAO;

import database.JDBCUtil;
import model.DetailExportProducts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetailExportProductsDAO implements DAOInterface<DetailExportProducts> {
    public static DetailExportProductsDAO getInstance(){
        return new DetailExportProductsDAO();
    }
    @Override
    public int insert(DetailExportProducts detailExportProducts) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into detailexportproducts(mamay,soluong,maphieuxuat) values (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,detailExportProducts.getMaMay());
            pst.setInt(2,detailExportProducts.getSoLuong());
            pst.setInt(3,detailExportProducts.getMaPhieuXuat());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(DetailExportProducts detailExportProducts) {
        return 0;
    }

    @Override
    public int delete(DetailExportProducts detailExportProducts) {
        return 0;
    }

    @Override
    public ArrayList<DetailExportProducts> selectAll() {
        return null;
    }
    public ArrayList<DetailExportProducts>selectAllByMaPhieuXuat(int maphieuxuat){
        ArrayList<DetailExportProducts>ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql ="select * from detailexportproducts where maphieuxuat =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,maphieuxuat);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maMay = rs.getInt("mamay");
                int soLuong = rs.getInt("soluong");
                DetailExportProducts detailExportProducts = new DetailExportProducts(maphieuxuat,maMay,soLuong);
                ketQua.add(detailExportProducts);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
