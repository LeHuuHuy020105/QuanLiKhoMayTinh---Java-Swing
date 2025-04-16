package DAO;

import database.JDBCUtil;
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RoleDAO implements DAOInterface<Role>{
    public static RoleDAO getInstance(){
        return new RoleDAO();
    }


    @Override
    public int insert(Role role) {
        return 0;
    }

    @Override
    public int update(Role role) {
        return 0;
    }

    @Override
    public int delete(Role role) {
        return 0;
    }

    @Override
    public ArrayList<Role> selectAll() {
        return null;
    }
    public int updateRoleUserByIdUser(int idUser){
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update user_role set role_id = ? where user_id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idUser);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {}
    }
}
