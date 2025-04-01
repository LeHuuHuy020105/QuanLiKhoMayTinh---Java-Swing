package DAO;

import database.JDBCUtil;
import model.Customer;
import model.ImportProducts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CustomerDAO implements DAOInterface<Customer>{
    public static CustomerDAO getInstance(){
        return new CustomerDAO();
    }

    @Override
    public int insert(Customer customer) {
        return 0;
    }

    @Override
    public int update(Customer customer) {
        return 0;
    }

    @Override
    public int delete(Customer customer) {
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
                Customer customer = new Customer(diaChi,email,hoVaTen,maKhachHang,matKhau,sdt,taiKhoan);
                ketQua.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public Customer findByPhone(String phone) {
        Customer customer = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from customer where phone = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,phone);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int maKhachHang = rs.getInt("makhachhang");
                String taiKhoan = rs.getString("username");
                String matKhau = rs.getString("password");
                String sdt = rs.getString("phone");
                String hoVaTen = rs.getString("fullname");
                String diaChi = rs.getString("diachi");
                String email = rs.getString("email");
                customer = new Customer(diaChi,email,hoVaTen,maKhachHang,matKhau,sdt,taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
}
