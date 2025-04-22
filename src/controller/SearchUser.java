package controller;

import DAO.ProductsDAO;
import DAO.UserDAO;
import model.Computer;
import model.User;

import java.util.ArrayList;

public class SearchUser {
    public ArrayList<User> searchTatCa(String content_Search) {
        ArrayList<User> users = UserDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return users;
        }
        ArrayList<User> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (User user : users) {
            if (user.getPhone().toLowerCase().contains(content_Search) || user.getUserName().toLowerCase().contains(content_Search) ||
                user.getFullName().toLowerCase().contains(content_Search) || user.getEmail().toLowerCase().contains(content_Search)) {
                ketQua.add(user);
            }
        }
        return  ketQua;
    }
    public ArrayList<User> searchSDT(String content_Search) {
        ArrayList<User> users = UserDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return users;
        }
        ArrayList<User> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (User user : users) {
            if (user.getPhone().toLowerCase().contains(content_Search)) {
                ketQua.add(user);
            }
        }
        return  ketQua;
    }
    public ArrayList<User> searchUserName(String content_Search) {
        ArrayList<User> users = UserDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return users;
        }
        ArrayList<User> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (User user : users) {
            if (user.getUserName().toLowerCase().contains(content_Search)) {
                ketQua.add(user);
            }
        }
        return  ketQua;
    }
    public ArrayList<User> searchFullName(String content_Search) {
        ArrayList<User> users = UserDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return users;
        }
        ArrayList<User> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (User user : users) {
            if (user.getFullName().toLowerCase().contains(content_Search)) {
                ketQua.add(user);
            }
        }
        return  ketQua;
    }

    public ArrayList<User> searchEmail(String content_Search) {
        ArrayList<User> users = UserDAO.getInstance().selectAll();
        if(content_Search.equals("")){
            return users;
        }
        ArrayList<User> ketQua = new ArrayList<>();
        content_Search = content_Search.toLowerCase();
        for (User user : users) {
            if (user.getEmail().toLowerCase().contains(content_Search)) {
                ketQua.add(user);
            }
        }
        return  ketQua;
    }

}
