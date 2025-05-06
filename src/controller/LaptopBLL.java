package controller;

import DAO.LaptopDAO;
import model.Laptop;

public class LaptopBLL {
    private LaptopDAO laptopDAO;

    public LaptopBLL() {
        this.laptopDAO = LaptopDAO.getInstance();
    }
    public int update(Laptop laptop){
        return this.laptopDAO.update(laptop);
    }
    public int insert(Laptop laptop){
        return this.laptopDAO.insert(laptop);
    }
}
