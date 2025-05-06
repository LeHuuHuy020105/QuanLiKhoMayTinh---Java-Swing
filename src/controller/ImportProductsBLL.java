package controller;

import DAO.ImportProductsDAO;
import model.ImportProducts;

import java.util.ArrayList;

public class ImportProductsBLL {
    private ImportProductsDAO importProductsDAO;

    public ImportProductsBLL() {
        this.importProductsDAO = ImportProductsDAO.getInstance();
    }
    public int insertImportProduct(ImportProducts importProducts){
        return importProductsDAO.insertImportProduct(importProducts);
    }
    public int update(ImportProducts importProducts ){
        return this.importProductsDAO.update(importProducts);
    }
    public ArrayList<ImportProducts> selectAll(){
        return this.importProductsDAO.selectAll();
    }
    public ImportProducts getImportProductsByMaPhieuNhap(int maphieunhap){
        return this.importProductsDAO.getImportProductsByMaPhieuNhap(maphieunhap);
    }
}
