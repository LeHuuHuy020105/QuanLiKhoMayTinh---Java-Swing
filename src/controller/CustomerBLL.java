package controller;

import DAO.CustomerDAO;
import model.Customer;

import java.util.ArrayList;

public class CustomerBLL {
    private CustomerDAO customerDAO;

    public CustomerBLL() {
        this.customerDAO = CustomerDAO.getInstance();
    }
    public ArrayList<Customer>selectAllOffline(){
        return this.customerDAO.selectAllOffline();
    }
    public ArrayList<Customer> selectAll(){
        return this.customerDAO.selectAll();
    }
    public int delete(Customer customer){
        return this.customerDAO.delete(customer);
    }
    public Customer findByID(int maKH){
        return this.customerDAO.findByID(maKH);
    }
    public int update(Customer customer){
        return this.customerDAO.update(customer);
    }
    public String GetTypeCustomer(int idCustomer){
        return this.customerDAO.GetTypeCustomer(idCustomer);
    }
    public int insert(Customer customer){
        return this.customerDAO.insert(customer);
    }
    public Customer findByPhone(String phone){
        return this.customerDAO.findByPhone(phone);
    }
}
