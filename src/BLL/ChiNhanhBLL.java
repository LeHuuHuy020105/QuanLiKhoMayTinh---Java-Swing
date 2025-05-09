package BLL;

import DAO.BrachDAO;
import DTO.Branch;

import java.util.ArrayList;

public class ChiNhanhBLL {
    private BrachDAO brandDAO;

    public ChiNhanhBLL() {
        this.brandDAO = BrachDAO.getInstance();
    }
    public ArrayList<Branch> selectAll(){
        return brandDAO.selectAll();
    }
    public Branch selectByID(int maCN){
        return BrachDAO.getInstance().BranchByID(maCN);
    }
    public int delete(Branch branch){
        return BrachDAO.getInstance().delete(branch);
    }
    public int update(Branch branch){
        return BrachDAO.getInstance().update(branch);
    }
    public int insert(Branch branch){
        return  BrachDAO.getInstance().insert(branch);
    }
}
