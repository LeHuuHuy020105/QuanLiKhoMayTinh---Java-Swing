package BLL;

import DAO.DetailExportProductsDAO;
import DTO.DetailExportProducts;

import java.util.ArrayList;

public class DetailExportProductsBLL {
    private DetailExportProductsDAO detailExportProductsDAO;

    public DetailExportProductsBLL() {
        this.detailExportProductsDAO = DetailExportProductsDAO.getInstance();
    }
    public ArrayList<DetailExportProducts> selectAllByMaPhieuXuat(int maPhieuXuat){
        return this.detailExportProductsDAO.selectAllByMaPhieuXuat(maPhieuXuat);
    }
    public int insert(DetailExportProducts detailExportProducts){
        return this.detailExportProductsDAO.insert(detailExportProducts);
    }
}
