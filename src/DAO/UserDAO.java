package DAO;

import database.JDBCUtil;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User>{
    public static UserDAO getInstance(){
        return new UserDAO();
    }
    @Override
    public int insert(User user) {
        int ketQua=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.insertUser;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFullName());
            pst.setInt(4, user.getStatus());
            pst.setString(5, user.getEmail());
            pst.setInt(6, user.getMaChiNhanh());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from user";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int idUser = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                int status = rs.getInt("status");
                int machinhanh = rs.getInt("machinhanh");
                User user = new User(email,fullname,password,status,username,idUser,machinhanh);
                ketQua.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public User getCurrentUser(String Username, String Password)  {
    	User user = null;
    	try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.getCurrentUser;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, Username);
            pst.setString(2, Password);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                int status = rs.getInt("status");
                int machinhanh = rs.getInt("machinhanh");
                user = new User(email,fullname,password,status,username,idUser,machinhanh);
            }
            JDBCUtil.closeConnection(connection);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
        return user;
	}
    public User getUsetById(int idUser){
        User user = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from user where id =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idUser);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maNguoiDung = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                int status = rs.getInt("status");
                int machinhanh = rs.getInt("machinhanh");
                user = new User(email,fullname,password,status,username,maNguoiDung,machinhanh);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public String getRoleByIDUser(int idUser){
        String ketQua = "";
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from user_role,role where user_id =? AND user_role.role_id = role.id";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idUser);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                ketQua=rs.getString("name");
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public int getIDRoleByIDUser(int idUser){
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from user_role,role where user_id =? AND user_role.role_id = role.id";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idUser);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                ketQua=rs.getInt("role_id");
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public int getMaChiNhanhByIDUser(int idUser){
        int ketQua=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from user_role,role where user_id =? AND user_role.role_id = role.id";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,idUser);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                ketQua =rs.getInt("id");
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<String> nameBtn_Menu(String nameRole){
        ArrayList<String> ketQua=new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from role_interfaceuser,role,interfaceuser where name =? AND role_interfaceuser.id = role.id AND role_interfaceuser.magiaodien=interfaceuser.magiaodien ";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,nameRole);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String nameBtn =rs.getString("tengiaodien");
                ketQua.add(nameBtn);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
