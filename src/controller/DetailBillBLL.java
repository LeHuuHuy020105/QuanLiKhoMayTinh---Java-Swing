package controller;

import DAO.DetailBillDAO;
import model.DetailBill;

import java.util.ArrayList;

public class DetailBillBLL {
    private DetailBillDAO detailBillDAO;

    public DetailBillBLL() {
        this.detailBillDAO = DetailBillDAO.getInstance();
    }
    public ArrayList<DetailBill>selectAllByMaPhieu(int maHoaDon){
        return this.detailBillDAO.selectAllByMaPhieu(maHoaDon);
    }
    public int insert(DetailBill detailBill){
        return this.detailBillDAO.insert(detailBill);
    }
}
