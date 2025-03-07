package controller;

import DAO.BrandDAO;
import DAO.ProducersDAO;
import model.Branch;
import model.Producer;

import java.util.ArrayList;

public class SearchBranch {
    public ArrayList<Branch> searchTatCa(String content_Search) {
        ArrayList<Branch> branches = BrandDAO.getInstance().selectAll();
        ArrayList<Branch> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Branch branch : branches) {
            if (branch.getDiaChi().toLowerCase().contains(content_Search)
                    || branch.getSoDienThoai().toLowerCase().contains(content_Search)) {
                ketQua.add(branch);
            }
        }
        return  ketQua;
    }
    public ArrayList<Branch> searchMaChiNhanh(String content_Search) {
        ArrayList<Branch> branches = BrandDAO.getInstance().selectAll();
        ArrayList<Branch> ketQua = new ArrayList<>();
        int maChiNhanh = Integer.parseInt(content_Search);
        for (Branch branch : branches) {
            if (branch.getMaChiNhanh()==maChiNhanh) {
                ketQua.add(branch);
            }
        }
        return  ketQua;
    }
    public ArrayList<Branch> searchDiaChi(String content_Search) {
        ArrayList<Branch> branches = BrandDAO.getInstance().selectAll();
        ArrayList<Branch> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Branch branch : branches) {
            if (branch.getDiaChi().toLowerCase().contains(content_Search)) {
                ketQua.add(branch);
            }
        }
        return  ketQua;
    }
    public ArrayList<Branch> searchSDT(String content_Search) {
        ArrayList<Branch> branches = BrandDAO.getInstance().selectAll();
        ArrayList<Branch> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Branch branch : branches) {
            if (branch.getSoDienThoai().toLowerCase().contains(content_Search)) {
                ketQua.add(branch);
            }
        }
        return  ketQua;
    }
}
