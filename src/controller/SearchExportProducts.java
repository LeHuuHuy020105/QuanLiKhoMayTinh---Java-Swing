package controller;

import DAO.*;
import model.ExportProducts;
import model.ImportProducts;

import java.util.ArrayList;

public class SearchExportProducts {
    public ArrayList<ExportProducts> searchDiaChi(String content_search){
        ArrayList<ExportProducts>exportProducts = ExportProductsDAO.getInstance().selectAll();
        if(content_search.equals("")){
            return exportProducts;
        }
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
        if(content_search.equals("")){
            return exportProducts;
        }
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
        if(trangThai.equals("")){
            return exportProducts;
        }
        ArrayList<ExportProducts>ketQua = new ArrayList<>();
        int idStatus = StatusDeliveryDAO.getInstance().selectByName(trangThai);
        if(trangThai.equals("Tất cả")){
            return exportProducts;
        }
        for(ExportProducts exportProducts1 :  exportProducts){

            if(exportProducts1.getTrangThai()==idStatus){
                ketQua.add(exportProducts1);
            }
        }
        return ketQua;
    }
    public ArrayList<ExportProducts> searchAll(String input) {
        ArrayList<ExportProducts> exportProducts = ExportProductsDAO.getInstance().selectAll();
        if(input.equals("")){
            return exportProducts;
        }
        ArrayList<ExportProducts> result = new ArrayList<>();
        input = input.toLowerCase().trim();
        try {
            int maphieuxuat = Integer.parseInt(input);
            System.out.println(maphieuxuat);
            for (ExportProducts exportProducts1 : exportProducts) {
                String diaChi = BrandDAO.getInstance().BranchByID(exportProducts1.getMaChiNhanh()).getDiaChi();
                if (exportProducts1.getMaPhieuXuat() == maphieuxuat || diaChi.toLowerCase().trim().contains(input)) {
                    result.add(exportProducts1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
