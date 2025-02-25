package DAO;

import database.JDBCUtil;
import model.Branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class BrandDAO implements DAOInterface<Branch>{
    @Override
    public int insert(Branch branch) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql =Query.insertBranch;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,branch.getDiaChi());
            pst.setString(2,branch.getSoDienThoai());
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Branch branch) {
        return 0;
    }

    @Override
    public int delete(Branch branch) {
        return 0;
    }

    @Override
    public ArrayList<Branch> selectAll() {

        return null;
    }
}
