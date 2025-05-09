package DAO;

import database.JDBCUtil;
import DTO.Customer;

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
        int ketQua =0;
        if(customer.getLoaiTaiKhoan().equals("offline")){
            ketQua= updateCustomerOffline(customer);
        }else {
            ketQua = updateCustomerOnline(customer);
        }
        return ketQua;
    }

    public int updateCustomerOffline(Customer customer){
        int ketQua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update customer set fullname =?, phone =? , username=?, password=? ,email=? , diachi=? where makhachhang =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,customer.getFullName());
            pst.setString(2,customer.getSoDienThoai());
            pst.setString(3,customer.getUserName());
            pst.setString(4,customer.getPassword());
            pst.setString(5,customer.getEmail());
            pst.setString(6,customer.getDiaChi());
            pst.setInt(7,customer.getMaKhachHang());
            ketQua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int updateCustomerOnline(Customer customer){
        int ketQua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update customer set fullname =?, phone =? where makhachhang =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,customer.getFullName());
            pst.setString(2,customer.getSoDienThoai());
            pst.setInt(3,customer.getMaKhachHang());
            ketQua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    @Override
    public int delete(Customer customer) {
        int ketQua = 0;
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement("DELETE FROM customer WHERE makhachhang = ?")) {
            pst.setInt(1, customer.getMaKhachHang());
            ketQua = pst.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            ketQua = -1; // Giá trị đặc biệt biểu thị lỗi khóa ngoại
        } catch (SQLException e) {
            e.printStackTrace(); // Vẫn in lỗi khác để debug, nhưng không ném
            ketQua = -2; // Giá trị đặc biệt cho các lỗi khác (nếu cần phân biệt)
        }
        return ketQua;
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
    public String getPhoneByCustomerId(int idCustomer) {
        Connection c = JDBCUtil.getConnection();
        String sql = "SELECT phone FROM producer WHERE makhachhang = ?";
        try (
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, idCustomer);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("sodienthoai");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
        Connection c = JDBCUtil.getConnection();
        String sql = "select count(*) from customer where phone = ? and loaitaikhoan = ?";
        try (
            PreparedStatement ps = c.prepareStatement(sql);
            ) {
            ps.setString(1, sdt);
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
//        Connection c = JDBCUtil.getConnection();
//        String sql = "select * from customer where phone = ? loaitaikhoan = ?";
//        Customer customer = null;
//        try {
//            PreparedStatement pst = c.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            pst.setString(1, "phone");
//            pst.setString(2, "loaitaikhoan");
//            if (rs.next()) {
//                String sdt = rs.getString("phone");
//                String taikhoan = rs.getString("loaitaikhoan");
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }
    public String GetTypeCustomer(int idCustomer){
        Connection c = JDBCUtil.getConnection();
        String sql = "select * from customer where makhachhang = ? ";
        String typeCustomer = null;
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, idCustomer);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                typeCustomer = rs.getString("loaitaikhoan");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeCustomer;
    }
}
