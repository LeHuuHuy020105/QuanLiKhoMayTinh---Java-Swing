package controller;

import DAO.CountryDAO;
import DAO.ProducersDAO;
import DAO.ProductsDAO;
import model.Computer;

import java.util.ArrayList;

public class SearchProduct {
    public ArrayList<Computer> searchTatCa(String content_Search) {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Computer computer : computers) {
            if (computer.getRam().toLowerCase().contains(content_Search)
                    || computer.getTenMay().toLowerCase().contains(content_Search)
                    || computer.getCardManHinh().toLowerCase().contains(content_Search)
                    || computer.getMaNhaCungCap().toLowerCase().contains(content_Search)
                    || computer.getRom().toLowerCase().contains(content_Search)
                    || computer.getTenCpu().toLowerCase().contains(content_Search)
                    || computer.getXuatXu().toLowerCase().contains(content_Search)) {
                ketQua.add(computer);
            }
        }
        return  ketQua;
    }



    public ArrayList<Computer> searchTenMay(String content_Search) {
        System.out.println("tim kiem ten may");
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Computer computer : computers) {
            if (computer.getTenMay().toLowerCase().contains(content_Search)) {
                ketQua.add(computer);
            }
        }
        return ketQua;
    }

    public ArrayList<Computer> searchSoLuong(String content_Search) {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        int soLuong_search = Integer.parseInt(content_Search);
        for (Computer computer : computers) {
            if (computer.getSoLuong() == soLuong_search) {
                ketQua.add(computer);
            }
        }
        return ketQua;
    }

    public ArrayList<Computer> searchDonGia(String content_Search) {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        double donGia_search = Double.parseDouble(content_Search);
        for (Computer computer : computers) {
            if (computer.getSoLuong() == donGia_search) {
                ketQua.add(computer);
            }
        }
        return ketQua;
    }

    public ArrayList<Computer> searchRam(String content_Search) {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Computer computer : computers) {
            if (computer.getRam().toLowerCase().contains(content_Search)) {
                ketQua.add(computer);
            }
        }
        return ketQua;
    }

    public ArrayList<Computer> searchCpu(String content_Search) {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Computer computer : computers) {
            if (computer.getTenCpu().toLowerCase().contains(content_Search)) {
                ketQua.add(computer);
            }
        }
        return ketQua;
    }

    public ArrayList<Computer> searchDungLuong(String content_Search) {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        double dungLuong_search = Integer.parseInt(content_Search);
        for (Computer computer : computers) {
            if (computer.getDungLuongLuuTru() == dungLuong_search) {
                ketQua.add(computer);
            }
        }
        return ketQua;
    }

    public ArrayList<Computer> searchCard(String content_Search) {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Computer computer : computers) {
            if (computer.getCardManHinh().toLowerCase().contains(content_Search)) {
                ketQua.add(computer);
            }
        }
        return ketQua;
    }

    public ArrayList<Computer> searchXuatXu(String content_Search) {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Computer computer : computers) {
            String tenQuocGia = CountryDAO.getInstance().CountryByID(computer.getXuatXu()).getTenQuocGia();
            if (tenQuocGia.toLowerCase().contains(content_Search)) {
                ketQua.add(computer);
            }
        }
        return ketQua;
    }
    public ArrayList<Computer> searchMaMay(String content_Search) {
        ArrayList<Computer> computers = ProductsDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        double maMay = Double.parseDouble(content_Search);
        for (Computer computer : computers) {
            if (computer.getMaMay() == maMay) {
                ketQua.add(computer);
            }
        }
        return ketQua;
    }
    public ArrayList<Computer>searchTenNhaCungCap(String tenNCC){
        tenNCC = tenNCC.toLowerCase();
        ArrayList<Computer>computers = ProductsDAO.getInstance().selectAll();
        if(tenNCC.equals("")){
            return computers;
        }
        ArrayList<Computer> ketQua = new ArrayList<>();
        for (Computer computer : computers){
            String tennhacungcap = ProducersDAO.getInstance().producerByID(computer.getMaNhaCungCap()).getTenNhaCungCap();
            if(tennhacungcap.toLowerCase().contains(tenNCC)){
                ketQua.add(computer);
            }
        }
        return ketQua;
    }
}
