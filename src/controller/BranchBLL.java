package controller;

import DAO.BrachDAO;
import model.Branch;

import java.util.ArrayList;

public class BranchBLL {
    private BrachDAO brachDAO;

    public BranchBLL() {
        this.brachDAO = BrachDAO.getInstance();
    }
    public Branch BranchByID(int maChiNhanh){
        return this.brachDAO.BranchByID(maChiNhanh);
    }
    public ArrayList<Branch> selectAll(){
        return this.brachDAO.selectAll();
    }
    public Branch BranchByDiaChi(String diaChi){
        return this.brachDAO.BranchByDiaChi(diaChi);
    }
}
