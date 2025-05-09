package BLL;

import DAO.InventoryDAO;
import DTO.Branch;
import DTO.Inventory;

import java.util.ArrayList;

public class InventoryBLL {
    private InventoryDAO inventoryDAO;

    public InventoryBLL() {
        this.inventoryDAO = InventoryDAO.getInstance();
    }
    public ArrayList<Inventory> InventoryByBranch(Branch branch){
        return this.inventoryDAO.InventoryByBranch(branch);
    }
    public int updateSoLuong(Inventory inventory){
        return this.inventoryDAO.updateSoLuong(inventory);
    }
    public int insert(Inventory inventory){
        return this.inventoryDAO.insert(inventory);
    }
}
