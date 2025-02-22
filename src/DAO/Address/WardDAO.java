package DAO.Address;

import DAO.DAOInterface;
import database.JDBCUtil;
import model.Address.District;
import model.Address.Ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WardDAO implements DAOInterface<Ward> {
    public static WardDAO getInstance(){
        return new WardDAO();
    }
    @Override
    public int insert(Ward ward) {
        return 0;
    }

    @Override
    public int update(Ward ward) {
        return 0;
    }

    @Override
    public int delete(Ward ward) {
        return 0;
    }

    @Override
    public ArrayList<Ward> selectAll() {
        return null;
    }
    public ArrayList<Ward>selectAllByDistrict(District district){
        ArrayList<Ward> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from wards where district_id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,district.getDistrict_id());
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int wards_id = rs.getInt("wards_id");
                int district_id = rs.getInt("district_id");
                String name = rs.getString("name");
                Ward ward = new Ward(district_id,name,wards_id);
                ketQua.add(ward);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
