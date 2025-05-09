package BLL;

import DAO.ExportProductsDAO;
import DTO.ExportProducts;

import java.util.ArrayList;

public class ExportProductsBLL {
    private ExportProductsDAO exportProductsDAO;

    public ExportProductsBLL() {
        this.exportProductsDAO = ExportProductsDAO.getInstance();
    }
    public int update(ExportProducts exportProducts){
        return this.exportProductsDAO.update(exportProducts);
    }
    public ArrayList<ExportProducts> selectAll(){
        return this.exportProductsDAO.selectAll();
    }
    public ExportProducts ExportProductsByID(int maPhieuXuat){
        return this.exportProductsDAO.ExportProductsByID(maPhieuXuat);
    }
    public int insertExportProduct(ExportProducts exportProducts){
        return this.exportProductsDAO.insertExportProduct(exportProducts);
    }
    public int delete(ExportProducts exportProducts){
        return this.exportProductsDAO.delete(exportProducts);
    }
}
