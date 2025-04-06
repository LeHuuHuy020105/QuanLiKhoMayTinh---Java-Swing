package controller;

import DAO.CustomerDAO;
import DAO.ProducersDAO;
import model.Customer;
import model.Producer;

import java.util.ArrayList;

public class SearchCustomer {
    public ArrayList<Customer> searchAllForStaff(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        if (content_Search.equals("")) {
            return customers;
        }
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Customer customer : customers) {
            if (customer.getSoDienThoai().toLowerCase().contains(content_Search)
                    || customer.getFullName().toLowerCase().contains(content_Search)
            ) {
                ketQua.add(customer);
            }
        }
        return ketQua;
    }

    public ArrayList<Customer> searchAll(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        if (content_Search.equals("")) {
            System.out.println("Rong");
            return customers;
        }
        ArrayList<Customer> ketQua = new ArrayList<>();

        content_Search = content_Search.toLowerCase().trim(); // Xóa khoảng trắng thừa
        System.out.println("Tìm kiếm: " + content_Search);
        System.out.println("Tổng số khách hàng: " + customers.size());

        for (Customer customer : customers) {
            // In dữ liệu để debug
            System.out.println("Username: " + customer.getUserName() +
                    ", FullName: " + customer.getFullName() +
                    ", DiaChi: " + customer.getDiaChi() +
                    ", SoDienThoai: " + customer.getSoDienThoai());

            // Kiểm tra từng trường
            boolean match = false;
            if (customer.getSoDienThoai() != null && customer.getSoDienThoai().toLowerCase().contains(content_Search)) {
                match = true;
            }
            if (customer.getFullName() != null && customer.getFullName().toLowerCase().contains(content_Search)) {
                match = true;
            }
            if (customer.getDiaChi() != null && customer.getDiaChi().toLowerCase().contains(content_Search)) {
                match = true;
            }
            if (customer.getUserName() != null && customer.getUserName().toLowerCase().contains(content_Search)) {
                match = true;
            }

            if (match) {
                ketQua.add(customer);
            }
        }

        System.out.println("Kết quả tìm kiếm: " + ketQua.size() + " khách hàng");
        return ketQua;
    }

    public ArrayList<Customer> searchTen(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        if (content_Search.equals("")) {
            return customers;
        }
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Customer customer : customers) {
            if (customer.getFullName().toLowerCase().contains(content_Search)) {
                ketQua.add(customer);
            }
        }
        return ketQua;
    }

    public ArrayList<Customer> searchDiaChi(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        if (content_Search.equals("")) {
            return customers;
        }
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Customer customer : customers) {
            if (customer.getDiaChi().toLowerCase().contains(content_Search)) {
                ketQua.add(customer);
            }
        }
        return ketQua;
    }

    public ArrayList<Customer> searchTaiKhoan(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        if (content_Search.equals("")) {
            System.out.println("Rong");
            return customers;
        }
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Customer customer : customers) {
            boolean match = false;
            if (customer.getUserName() != null && customer.getUserName().toLowerCase().contains(content_Search)) {
                match = true;
            }
            if(match){
                ketQua.add(customer);
            }
        }
        return ketQua;
    }

    public ArrayList<Customer> searchSoDienThoai(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        if (content_Search.equals("")) {
            return customers;
        }
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Customer customer : customers) {
            if (customer.getSoDienThoai().toLowerCase().contains(content_Search)) {
                ketQua.add(customer);
            }
        }
        return ketQua;
    }

    public ArrayList<Customer> searchMaKH(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        if (content_Search.equals("")) {
            return customers;
        }
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        int maKH = Integer.parseInt(content_Search);
        for (Customer customer : customers) {
            if (customer.getMaKhachHang() == maKH) {
                ketQua.add(customer);
            }
        }
        return ketQua;
    }
}
