package controller;

import DAO.InventoryDAO;
import model.Branch;
import model.Inventory;

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
