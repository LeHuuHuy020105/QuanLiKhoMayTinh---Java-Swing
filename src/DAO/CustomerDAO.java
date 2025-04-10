package DAO;

import database.JDBCUtil;
import model.Customer;
import model.ImportProducts;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO implements DAOInterface<Customer>{
    public static CustomerDAO getInstance(){
        return new CustomerDAO();
    }

    @Override
    public int insert(Customer customer) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "INSERT INTO customer(username,password,phone,fullname,diachi,email,loaitaikhoan) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, customer.getUserName());
            pst.setString(2, customer.getPassword());
            pst.setString(3, customer.getSoDienThoai());
            pst.setString(4, customer.getFullName());
            pst.setString(5, customer.getDiaChi());
            pst.setString(6, customer.getEmail());
            pst.setString(7, customer.getLoaiTaiKhoan());
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Customer customer) {
        return 0;
    }

    @Override
    public int delete(Customer customer) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Delete from customer where makhachhang=?";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from customer";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maKhachHang = rs.getInt("makhachhang");
                String taiKhoan = rs.getString("username");
                String matKhau = rs.getString("password");
                String sdt = rs.getString("phone");
                String hoVaTen = rs.getString("fullname");
                String diaChi = rs.getString("diachi");
                String email = rs.getString("email");
                String loaiTaiKhoan = rs.getString("loaitaikhoan");
                Customer customer = new Customer(diaChi,email,hoVaTen,maKhachHang,matKhau,sdt,taiKhoan,loaiTaiKhoan);
                ketQua.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public Customer findByID(int maKH) {
        Customer customer = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from customer where makhachhang = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,maKH);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int maKhachHang = rs.getInt("makhachhang");
                String taiKhoan = rs.getString("username");
                String matKhau = rs.getString("password");
                String sdt = rs.getString("phone");
                String hoVaTen = rs.getString("fullname");
                String diaChi = rs.getString("diachi");
                String email = rs.getString("email");
                String loaiTaiKhoan = rs.getString("loaitaikhoan");
                customer = new Customer(diaChi,email,hoVaTen,maKhachHang,matKhau,sdt,taiKhoan,loaiTaiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
    public ArrayList<Customer>selectAllOnline(){
        ArrayList<Customer> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from customer where loaitaikhoan = 'online'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maKhachHang = rs.getInt("makhachhang");
                String taiKhoan = rs.getString("username");
                String matKhau = rs.getString("password");
                String sdt = rs.getString("phone");
                String hoVaTen = rs.getString("fullname");
                String diaChi = rs.getString("diachi");
                String email = rs.getString("email");
                String loaiTaiKhoan = rs.getString("loaitaikhoan");
                Customer customer = new Customer(diaChi,email,hoVaTen,maKhachHang,matKhau,sdt,taiKhoan,loaiTaiKhoan);
                ketQua.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<Customer>selectAllOffline(){
        ArrayList<Customer> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from customer where loaitaikhoan = 'offline'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maKhachHang = rs.getInt("makhachhang");
                String taiKhoan = rs.getString("username");
                String matKhau = rs.getString("password");
                String sdt = rs.getString("phone");
                String hoVaTen = rs.getString("fullname");
                String diaChi = rs.getString("diachi");
                String email = rs.getString("email");
                String loaiTaiKhoan = rs.getString("loaitaikhoan");
                Customer customer = new Customer(diaChi,email,hoVaTen,maKhachHang,matKhau,sdt,taiKhoan,loaiTaiKhoan);
                ketQua.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public boolean checkSdt(String sdt,String loaiTaiKhoan){
        String regex = sdt.replaceAll("[^0-9]", "");
        if (!regex.matches("^0[0-9]{9}$")) {
            System.out.println("Số điện thoại không đúng định dạng!");
            return false;
        }
        Connection c = JDBCUtil.getConnection();
        String sql = "select count(*) from customer where phone = ? and loaitaikhoan = ?";
        try (
            PreparedStatement ps = c.prepareStatement(sql);
            ) {
            ps.setString(1, regex);
            ps.setString(2, loaiTaiKhoan);
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
        String sql = "SELECT COUNT(*) FROM customer WHERE username = ?";
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
    public Customer findByPhone(String phone){
        Connection c = JDBCUtil.getConnection();
        String sql = "select * from customer where phone = ? loaitaikhoan = ?";
        Customer customer = null;
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            pst.setString(1, "phone");
            pst.setString(2, "loaitaikhoan");
            if (rs.next()) {
                String sdt = rs.getString("phone");
                String taikhoan = rs.getString("loaitaikhoan");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
