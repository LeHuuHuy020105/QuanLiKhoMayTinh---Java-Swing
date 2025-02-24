package controller;

import DAO.ProducersDAO;
import DAO.ProductsDAO;
import model.Producer;

import java.util.ArrayList;

public class SearchProducer {
    public ArrayList<Producer> searchTatCa(String content_Search) {
        ArrayList<Producer> producers = ProducersDAO.getInstance().selectAll();
        ArrayList<Producer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Producer producer : producers) {
            if (producer.getTenNhaCungCap().toLowerCase().contains(content_Search)
                    || producer.getMaNhaCungCap().toLowerCase().contains(content_Search)
                    || producer.getDiaChi().toLowerCase().contains(content_Search)
                    || producer.getSdt().toLowerCase().contains(content_Search)) {
                ketQua.add(producer);
            }
        }
        return  ketQua;
    }
    public ArrayList<Producer> searchMaNhaCungCap(String content_Search) {
        ArrayList<Producer> producers = ProducersDAO.getInstance().selectAll();
        ArrayList<Producer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Producer producer : producers) {
            if (producer.getMaNhaCungCap().toLowerCase().contains(content_Search)) {
                ketQua.add(producer);
            }
        }
        return  ketQua;
    }

    public ArrayList<Producer> searchDiaChi(String content_Search) {
        ArrayList<Producer> producers = ProducersDAO.getInstance().selectAll();
        ArrayList<Producer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Producer producer : producers) {
            if (producer.getDiaChi().toLowerCase().contains(content_Search)) {
                ketQua.add(producer);
            }
        }
        return  ketQua;
    }
    public ArrayList<Producer> searchSDT(String content_Search) {
        ArrayList<Producer> producers = ProducersDAO.getInstance().selectAll();
        ArrayList<Producer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Producer producer : producers) {
            if (producer.getSdt().toLowerCase().contains(content_Search)) {
                ketQua.add(producer);
            }
        }
        return  ketQua;
    }
    public ArrayList<Producer> searchTenNhaCungCap(String content_Search) {
        ArrayList<Producer> producers = ProducersDAO.getInstance().selectAll();
        ArrayList<Producer> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (Producer producer : producers) {
            if (producer.getTenNhaCungCap().toLowerCase().contains(content_Search)) {
                ketQua.add(producer);
            }
        }
        return  ketQua;
    }

}
