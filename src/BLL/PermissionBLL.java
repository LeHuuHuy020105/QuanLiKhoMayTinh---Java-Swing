package BLL;

import DAO.PermissionsDAO;

import javax.swing.*;

public class PermissionBLL {
    private PermissionsDAO permissionsDAO;

    public PermissionBLL() {
        this.permissionsDAO = PermissionsDAO.getInstance();
    }
    public void applyPermissions(int idRole, String tenGiaoDien, JButton them, JButton xoa, JButton sua, JButton xemchitiet, JButton xuatExcel, JButton nhapExcel){
        PermissionsDAO.applyPermissions(idRole, tenGiaoDien, them, xoa, sua, xemchitiet, xuatExcel, nhapExcel);
    }
}
