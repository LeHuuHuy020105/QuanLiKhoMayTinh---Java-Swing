package controller;

import DAO.ImportProductsDAO;
import DAO.UserDAO;
import model.ImportProducts;

import java.util.ArrayList;

public class ImportProductsSearch {
    public ArrayList<ImportProducts> searchAll(String input) {
        ArrayList<ImportProducts> importProducts = ImportProductsDAO.getInstance().selectAll();
        ArrayList<ImportProducts> result = new ArrayList<>();
        try {
            int maphieunhap = Integer.parseInt(input);
            double tongTien = Double.parseDouble(input);
            for (ImportProducts importProducts1 : importProducts) {
                String tenNguoiDung = UserDAO.getInstance().getUsetById(importProducts1.getManguoidung()).getFullName();
                if (importProducts1.getMaphieunhap() == maphieunhap || importProducts1.getTongTien() == tongTien || tenNguoiDung.toLowerCase().contains(input)) {
                    result.add(importProducts1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<ImportProducts> searchMaPhieuNhap(String input) {
        ArrayList<ImportProducts> importProducts = ImportProductsDAO.getInstance().selectAll();
        ArrayList<ImportProducts> result = new ArrayList<>();
        int maphieunhap = Integer.parseInt(input);
        System.out.println(maphieunhap);
        for (ImportProducts importProducts1 : importProducts) {
            if (importProducts1.getMaphieunhap() == maphieunhap) {
                System.out.println(importProducts1);
                result.add(importProducts1);
            }
        }
        return result;
    }
    public ArrayList<ImportProducts> searchNguoiTao(String input) {
        ArrayList<ImportProducts> importProducts = ImportProductsDAO.getInstance().selectAll();
        ArrayList<ImportProducts> result = new ArrayList<>();
        for (ImportProducts importProducts1 : importProducts) {
            String tenNguoiDung = UserDAO.getInstance().getUsetById(importProducts1.getManguoidung()).getFullName();
            if (tenNguoiDung.toLowerCase().contains(input)) {
                result.add(importProducts1);
            }
        }
        return result;
    }
    public ArrayList<ImportProducts> searchTongTien(String input) {
        ArrayList<ImportProducts> importProducts = ImportProductsDAO.getInstance().selectAll();
        ArrayList<ImportProducts> result = new ArrayList<>();
        double tongTien = Double.parseDouble(input);
        for (ImportProducts importProducts1 : importProducts) {
            if (importProducts1.getTongTien() == tongTien) {
                result.add(importProducts1);
            }
        }
        return result;
    }
}
