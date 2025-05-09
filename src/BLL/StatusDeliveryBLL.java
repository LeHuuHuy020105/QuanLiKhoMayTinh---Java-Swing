package BLL;

import DAO.StatusDeliveryDAO;

import java.util.ArrayList;

public class StatusDeliveryBLL {
    private StatusDeliveryDAO statusDeliveryDAO;

    public StatusDeliveryBLL() {
        this.statusDeliveryDAO = StatusDeliveryDAO.getInstance();
    }
    public ArrayList<String> selectAll(){
        return this.statusDeliveryDAO.selectAll();
    }
    public String selectByID(int trangThai){
        return this.statusDeliveryDAO.selectByID(trangThai);
    }
    public int selectByName(String nameStatus){
        return this.statusDeliveryDAO.selectByName(nameStatus);
    }
    public ArrayList<String> selectChangeStatus(int idStatus){
        return this.statusDeliveryDAO.selectChangeStatus(idStatus);
    }
}
