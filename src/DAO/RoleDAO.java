package DAO;

import database.JDBCUtil;
import DTO.Role;

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
    public ArrayList<String> selectAllNameRole(){
        ArrayList<String> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from role";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                ketQua.add(name);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
    public Role getRoleCBX(String nameRole){
        Role role = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from role where name =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,nameRole);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                role = new Role(id,name);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }
    public int updateRoleUserByIdUser(int idUser , int idRole){
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update user_role set role_id =? where user_id =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idRole);
            pst.setInt(2,idUser);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public int insertRoleUser(int idUser , int idRole){
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into user_role (user_id , role_id) values (?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idUser);
            pst.setInt(2,idRole);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
