package DAO.Address;

import DAO.DAOInterface;
import DAO.Query;
import database.JDBCUtil;
import model.Address.District;
import model.Address.Province;
import model.Laptop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DistrictDAO implements DAOInterface<District> {
    public static DistrictDAO getInstance(){
        return new DistrictDAO();
    }
    @Override
    public int insert(District district) {
        return 0;
    }

    @Override
    public int update(District district) {
        return 0;
    }

    @Override
    public int delete(District district) {
        return 0;
    }

    @Override
    public ArrayList<District> selectAll() {
        return null;
    }
    public ArrayList<District>selectAllByProvince(Province province){
        ArrayList<District> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.selectAllByProvince;
            PreparedStatement pst = connection.prepareStatement(sql);
            System.out.println(province.getProvince_id());
            pst.setInt(1,province.getProvince_id());
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int district_id = rs.getInt("district_id");
                int province_id = rs.getInt("province_id");
                String name = rs.getString("name");
                District district = new District(district_id,name,province_id);
                ketQua.add(district);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public District DistrictByName(String nameDistrict){
        District district =null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.districtByName;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,nameDistrict);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int district_id = rs.getInt("district_id");
                int province_id = rs.getInt("province_id");
                String name = rs.getString("name");
                district = new District(district_id,name,province_id);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return district;
    }
}
