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
            String sql = "INSERT INTO USER (username,password,fullname,status,email,role) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFullName());
            pst.setInt(4, user.getStatus());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getRole());
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
        return null;
    }
    public User getCurrentUser(String Username, String Password) throws SQLException {
    	User user = null;
    	Connection connection = JDBCUtil.getConnection();
        String sql = "SELECT * FROM USER WHERE username =? && password =?" ;
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, Username);
        pst.setString(2, Password);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
			String username = rs.getString("username");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String fullname = rs.getString("fullname");
			int status = rs.getInt("status");
			String role= rs.getString("role");
			user = new User(email,fullname,password,role,status,username);
		}
        JDBCUtil.closeConnection(connection);
        return user;
	}
}
