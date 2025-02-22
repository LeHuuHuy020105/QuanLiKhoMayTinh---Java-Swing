package DAO;

import database.JDBCUtil;
import model.Country;
import model.Laptop;
import model.PC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CountryDAO implements DAOInterface<Country>{
    public static CountryDAO getInstance(){
        return new CountryDAO();
    }
    @Override
    public int insert(Country country) {
        return 0;
    }

    @Override
    public int update(Country country) {
        return 0;
    }

    @Override
    public int delete(Country country) {
        return 0;
    }

    @Override
    public ArrayList<Country> selectAll() {
        ArrayList<Country> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from country";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maQuocGia = rs.getString("maquocgia");
                String tenQuocGia = rs.getString("tenquocgia");
                Country country = new Country(maQuocGia,tenQuocGia);
                ketQua.add(country);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
