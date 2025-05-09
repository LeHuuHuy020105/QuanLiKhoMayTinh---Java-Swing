package BLL;

import DAO.BillDAO;
import DTO.Bill;

public class BillBLL {
    private BillDAO billDAO;

    public BillBLL() {
        this.billDAO = BillDAO.getInstance();
    }
    public int insertBill(Bill bill){
        return this.billDAO.insertBill(bill);
    }
}
