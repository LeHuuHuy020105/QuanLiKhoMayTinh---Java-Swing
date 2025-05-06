package controller;

import DAO.UserDAO;
import model.User;

import java.util.ArrayList;

public class UserBLL {
    private UserDAO userDAO;

    public UserBLL() {
        this.userDAO = UserDAO.getInstance();
    }
    public User getUsetById(int idUser){
        return this.userDAO.getUsetById(idUser);
    }
    public String getRoleByIDUser(int idUser){
        return this.userDAO.getRoleByIDUser(idUser);
    }
    public int getIDRoleByIDUser(int idUSer){
        return this.userDAO.getIDRoleByIDUser(idUSer);
    }
    public int delete(User user){
        return this.userDAO.delete(user);
    }
    public ArrayList<User> selectAllNotAdmin(User currentUser){
        return this.userDAO.selectAllNotAdmin(currentUser);
    }
    public int update(User user){
        return this.userDAO.update(user);
    }
    public int insert(User user){
        return this.userDAO.insert(user);
    }
    public int getMaChiNhanhByIDUser(int idUser){
        return this.userDAO.getMaChiNhanhByIDUser(idUser);
    }
    public ArrayList<String> nameBtn_Menu(String roleName){
        return this.userDAO.nameBtn_Menu(roleName);
    }
}
