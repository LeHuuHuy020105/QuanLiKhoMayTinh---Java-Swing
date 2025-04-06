package controller;

import DAO.CustomerDAO;
import DAO.ProducersDAO;
import model.Customer;
import model.Producer;

import java.util.ArrayList;

public class SearchCustomer {
    public ArrayList<Customer> searchTatCa(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Customer customer : customers) {
            if (customer.getSoDienThoai().toLowerCase().contains(content_Search)
                    || customer.getFullName().toLowerCase().contains(content_Search)
                    ) {
                ketQua.add(customer);
            }
        }
        return  ketQua;
    }
    public ArrayList<Customer> searchTen(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Customer customer : customers) {
            if (customer.getFullName().toLowerCase().contains(content_Search)) {
                ketQua.add(customer);
            }
        }
        return  ketQua;
    }
    public ArrayList<Customer> searchDiaChi(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Customer customer : customers) {
            if (customer.getDiaChi().toLowerCase().contains(content_Search)) {
                ketQua.add(customer);
            }
        }
        return  ketQua;
    }
    public ArrayList<Customer> searchSoDienThoai(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Customer customer : customers) {
            if (customer.getSoDienThoai().toLowerCase().contains(content_Search)) {
                ketQua.add(customer);
            }
        }
        return  ketQua;
    }
    public ArrayList<Customer> searchMaKH(String content_Search) {
        ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
        ArrayList<Customer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        int maKH = Integer.parseInt(content_Search);
        for (Customer customer : customers) {
            if (customer.getMaKhachHang()==maKH) {
                ketQua.add(customer);
            }
        }
        return  ketQua;
    }
}
