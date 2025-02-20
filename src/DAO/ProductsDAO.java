package DAO;

import database.JDBCUtil;
import model.Computer;
import model.Laptop;
import model.PC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductsDAO implements DAOInterface<Computer> {
    public static ProductsDAO getInstance(){
        return new ProductsDAO();
    }
    @Override
    public int insert(Computer computer) {
        return 0;
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
        ArrayList<Computer> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from product";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maMay = rs.getString("mamay");
                String tenMay = rs.getString("tenmay");
                int soLuong = rs.getInt("soluong");
                double gia = rs.getDouble("gia");
                String tenCPU = rs.getString("tenCPU");
                String Ram = rs.getString("ram");
                String xuatXu = rs.getString("xuatxu");
                String cardManHinh = rs.getString("cardmanhinh");
                String Rom = rs.getString("rom");
                String loaiMay = rs.getString("loaimay");
                String maNhaCungCap = rs.getString("manhacungcap");
                double dungLuongLuuTru = rs.getDouble("dungluongluutru");
                if (loaiMay.equals("Laptop")) {
                    double kichThuocMan = rs.getDouble("kichthuocman");
                    String dungLuongPin = rs.getString("dungluongpin");
                    Laptop newLaptop = new Laptop(cardManHinh, gia, maMay, Ram, Rom, soLuong, tenCPU, tenMay, xuatXu, dungLuongPin, kichThuocMan,maNhaCungCap,dungLuongLuuTru);
                    ketQua.add(newLaptop);
                } else {
                    String mainBoard = rs.getString("mainboard");
                    int congSuatNguon = rs.getInt("congsuatnguon");
                    PC newPC = new PC(cardManHinh, gia, maMay, Ram, Rom, soLuong, tenCPU, tenMay, xuatXu, congSuatNguon, mainBoard,maNhaCungCap,dungLuongLuuTru);
                    ketQua.add(newPC);
                }
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
