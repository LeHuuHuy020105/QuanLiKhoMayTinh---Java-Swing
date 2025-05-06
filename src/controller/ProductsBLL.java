package controller;

import DAO.ProductsDAO;
import model.Computer;
import model.DetailBill;

import java.util.ArrayList;

public class ProductsBLL {
    private ProductsDAO productsDAO;

    public ProductsBLL() {
        productsDAO = ProductsDAO.getInstance();
    }
    public Computer searchByIdProduct(int maMay){
        return ProductsDAO.getInstance().searchByIDProduct(maMay);
    }
    public ArrayList<Computer> selectAll(){
        return ProductsDAO.getInstance().selectAll();
    }
    public int update(Computer computer){
        return this.productsDAO.update(computer);
    }
    public int delete(Computer computer){
        return this.productsDAO.delete(computer);
    }
}
