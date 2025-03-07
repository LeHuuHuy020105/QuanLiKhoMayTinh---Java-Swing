package controller;

import DAO.BrandDAO;
import DAO.ExportProductsDAO;
import model.ExportProducts;

import java.util.ArrayList;

public class SearchExportProducts {
    public ArrayList<ExportProducts> searchDiaChi(String content_search){
        ArrayList<ExportProducts>exportProducts = ExportProductsDAO.getInstance().selectAll();
        ArrayList<ExportProducts>ketQua = new ArrayList<>();
        for(ExportProducts exportProducts1 :exportProducts){
            String diaChi = BrandDAO.getInstance().BranchByID(exportProducts1.getMaChiNhanh()).getDiaChi();
            if(diaChi.toLowerCase().contains(content_search)){
                ketQua.add(exportProducts1);
            }
        }
        return ketQua;
    }
    public ArrayList<ExportProducts> searchMaPhieuXuat(String content_search){
        int maPhieuXuat = Integer.parseInt(content_search);
        ArrayList<ExportProducts>exportProducts = ExportProductsDAO.getInstance().selectAll();
        ArrayList<ExportProducts>ketQua = new ArrayList<>();
        for (ExportProducts exportProducts1 : exportProducts){
            if(exportProducts1.getMaPhieuXuat()==maPhieuXuat){
                ketQua.add(exportProducts1);
            }
        }
        return ketQua;
    }
    public ArrayList<ExportProducts> searchTrangThai(String trangThai){
        ArrayList<ExportProducts>exportProducts = ExportProductsDAO.getInstance().selectAll();
        ArrayList<ExportProducts>ketQua = new ArrayList<>();
        if(trangThai.equals("Tất cả")){
            return exportProducts;
        }
        for(ExportProducts exportProducts1 :  exportProducts){
            if(exportProducts1.getTrangThai().equals(trangThai)){
                ketQua.add(exportProducts1);
            }
        }
        return ketQua;
    }
}
