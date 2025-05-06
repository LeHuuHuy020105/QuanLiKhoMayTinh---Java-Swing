package controller;

import DAO.DetailImportProductsDAO;
import model.DetailImportProducts;

import java.util.ArrayList;

public class DetailImportProductsBLL {
    private DetailImportProductsDAO detailImportProductsDAO;

    public DetailImportProductsBLL() {
        this.detailImportProductsDAO = DetailImportProductsDAO.getInstance();
    }
    public int insert(DetailImportProducts detailImportProducts){
        return this.detailImportProductsDAO.insert(detailImportProducts);
    }
    public ArrayList<DetailImportProducts>selectAllByMaPhieuNhap(int maphieunhap){
        return this.detailImportProductsDAO.selectAllByMaPhieuNhap(maphieunhap);
    }
}
