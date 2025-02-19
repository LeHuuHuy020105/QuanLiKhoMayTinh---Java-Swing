package DAO;

import database.JDBCUtil;
import model.Computer;

import java.sql.Connection;
import java.util.ArrayList;

public class ProductDAO implements DAOInterface<Computer>{

    @Override
    public int insert(Computer computer) {
       try {
           Connection connection = JDBCUtil.getConnection();
           String sql = "Insert into product(mamay,tenmay,soluong,gia,tenCPU,ram,xuatxu,cardmanhinh,rom,trang"
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public int update(Computer computer) {
        return 0;
    }

    @Override
    public int delete(Computer computer) {
        return 0;
    }

    @Override
    public ArrayList<Computer> selectAll() {
        return null;
    }
}
