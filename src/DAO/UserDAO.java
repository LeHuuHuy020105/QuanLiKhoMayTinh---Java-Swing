package DAO;

import database.JDBCUtil;
import DTO.User;

import java.sql.*;
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
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFullName());
            pst.setInt(4, user.getStatus());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getPhone());
            pst.executeUpdate();
            var key = pst.getGeneratedKeys();
            key.next();
            ketQua= key.getInt(1);
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(User user) {
        int ketQua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.updateUser;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,user.getPassword());
            pst.setString(2,user.getFullName());
            pst.setInt(3,user.getStatus());
            pst.setString(4,user.getEmail());
            if (user.getMaChiNhanh() == 0) {
                pst.setNull(5, Types.INTEGER);
            } else {
                pst.setInt(5,user.getMaChiNhanh());
            }
            pst.setString(6,user.getPhone());
            pst.setInt(7,user.getIdUser());
            ketQua = pst.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            ketQua = -1; // Giá trị đặc biệt biểu thị lỗi khóa ngoại
        } catch (Exception e) {
            e.printStackTrace();
            ketQua = -2;
        }
        return ketQua;
    }

    @Override
    public int delete(User user) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
//            String sql_deleteDBUser_Role = "delete from user_role where user_id =?";
//            PreparedStatement pstUserRole = connection.prepareStatement(sql_deleteDBUser_Role);
//            pstUserRole.setInt(1,user.getIdUser());
//            pstUserRole.executeUpdate();
            String sql = Query.deleteUser;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,user.getIdUser());
            ketQua = pst.executeUpdate();
            connection.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            ketQua = -1; // Giá trị đặc biệt biểu thị lỗi khóa ngoại
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
            ketQua = -2;
        }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.selectAllUser;
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
                String phone = rs.getString("phone");
                User user = new User(email,fullname,idUser,machinhanh,password,phone,status,username);
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
                Integer machinhanh = rs.getInt("machinhanh");
                String phone = rs.getString("phone");
                user = new User(email,fullname,idUser,machinhanh,password,phone,status,username);
            }
            JDBCUtil.closeConnection(connection);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
        return user;
	}

    public String getPhoneByUserId(int idUser) {
        Connection c = JDBCUtil.getConnection();
        String sql = Query.getPhoneByUserId;
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("phone");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getEmailByUserId(int idUser) {
        Connection c = JDBCUtil.getConnection();
        String sql = Query.getEmailByUserId;
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUsetById(int idUser){
        User user = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.getUsetById;
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
                String phone = rs.getString("phone");
                user = new User(email,fullname,idUser,machinhanh,password,phone,status,username);
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
            String sql = Query.getRoleByIDUser;
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
            String sql = Query.getIDRoleByIDUser;
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
            String sql = Query.getMaChiNhanhByIDUser;
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
            String sql = Query.nameBtn_Menu;
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
    public ArrayList<User> selectAllNotAdmin(User currentUser) {
        ArrayList<User> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.selectAllNotAdmin;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,currentUser.getIdUser() );
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int idUser = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                int status = rs.getInt("status");
                int machinhanh = rs.getInt("machinhanh");
                String phone = rs.getString("phone");
                User user = new User(email,fullname,idUser,machinhanh,password,phone,status,username);
                ketQua.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public boolean checkSdt(String sdt){
        Connection c = JDBCUtil.getConnection();
        String sql = Query.checkSDTUser;
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkDataAccount(String account){
        Connection c = JDBCUtil.getConnection();
        String sql = Query.checkDataAccount;
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkEmail(String email){
        Connection c = JDBCUtil.getConnection();
        String sql = Query.checkEmailUser;
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
