package DAO.Address;

import DAO.DAOInterface;
import database.JDBCUtil;
import model.Address.District;
import model.Address.Province;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProvinceDAO implements DAOInterface<Province> {
    public static ProvinceDAO getInstance(){
        return new ProvinceDAO();
    }
    @Override
    public int insert(Province province) {
        return 0;
    }

    @Override
    public int update(Province province) {
        return 0;
    }

    @Override
    public int delete(Province province) {
        return 0;
    }

    @Override
    public ArrayList<Province> selectAll() {
        ArrayList<Province> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from province";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int province_id = rs.getInt("province_id");
                String name = rs.getString("name");
                Province province = new Province(name,province_id);
                ketQua.add(province);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public Province ProvinceByName(String nameProvince){
        Province province =null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM province WHERE name = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nameProvince);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int province_id = rs.getInt("province_id");
                String name = rs.getString("name");
                province = new Province(name,province_id);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return province;
    }
}
