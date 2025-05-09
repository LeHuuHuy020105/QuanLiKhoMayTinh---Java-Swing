package BLL;

import DAO.RoleDAO;
import DTO.Role;

import java.util.ArrayList;

public class RoleBLL {
    private RoleDAO roleDAO;

    public RoleBLL() {
        this.roleDAO = RoleDAO.getInstance();
    }
    public ArrayList<String> selectAllNameRole(){
        return this.roleDAO.selectAllNameRole();
    }
    public int updateRoleUserByIdUser(int idUser , int idRole){
        return this.roleDAO.updateRoleUserByIdUser(idUser,idRole);
    }
    public Role getRoleCBX(String roleName){
        return this.roleDAO.getRoleCBX(roleName);
    }
    public int insertRoleUser(int idUser , int idRole){
        return this.roleDAO.insertRoleUser(idUser,idRole);
    }
}
