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
    public static ProductsDAO getInstance() {
        return new ProductsDAO();
    }

    @Override
    public int insert(Computer computer) {
        return 0;
    }

    @Override
    public int update(Computer computer) {
        if(computer instanceof Laptop){
            Laptop laptop = (Laptop) computer;
            LaptopDAO.getInstance().update(laptop);
        }else {
            PC pc = (PC) computer;
            PCDAO.getInstance().update(pc);
        }
        return 0;
    }

    @Override
    public int delete(Computer computer) {
        int ketQua =0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql =Query.deleteProduct;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,computer.getMaMay());
            ketQua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Computer> selectAll() {
        ArrayList<Computer> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql =Query.selectAllProduct;
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maMay = rs.getInt("mamay");
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
                double giaBan = rs.getDouble("giaban");
                if (loaiMay.equals("Laptop")) {
                    double kichThuocMan = rs.getDouble("kichthuocman");
                    String dungLuongPin = rs.getString("dungluongpin");
                    Laptop newLaptop = new Laptop(cardManHinh, gia, maMay, Ram, Rom, soLuong, tenCPU, tenMay, xuatXu, dungLuongPin, kichThuocMan, maNhaCungCap, dungLuongLuuTru,giaBan);
                    ketQua.add(newLaptop);
                } else {
                    String mainBoard = rs.getString("mainboard");
                    int congSuatNguon = rs.getInt("congsuatnguon");
                    PC newPC = new PC(cardManHinh, gia, maMay, Ram, Rom, soLuong, tenCPU, tenMay, xuatXu, congSuatNguon, mainBoard, maNhaCungCap, dungLuongLuuTru,giaBan);
                    ketQua.add(newPC);
                }
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public Computer searchByIDProduct(int idproduct) {
        Computer computer = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql =Query.selectroductByID;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idproduct);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int maMay = rs.getInt("mamay");
                String tenMay = rs.getString("tenmay");
                int soLuong = rs.getInt("soluong");
                double gia = rs.getDouble("gia");
                String tenCPU = rs.getString("tenCPU");
                String RAM = rs.getString("ram");
                String xuatXu = rs.getString("xuatxu");
                String cardManHinh = rs.getString("cardmanhinh");
                String ROM = rs.getString("rom");
                String loaiMay = rs.getString("loaimay");
                String maNhaCungCap = rs.getString("manhacungcap");
                double dungLuongLuuTru = rs.getDouble("dungluongluutru");
                double giaBan = rs.getDouble("giaban");
                if (loaiMay.equals("Laptop")) {
                    double kichThuocMan = rs.getDouble("kichthuocman");
                    String dungLuongPin = rs.getString("dungluongpin");
                    computer = new Laptop(cardManHinh, gia, maMay, RAM, ROM, soLuong, tenCPU, tenMay, xuatXu, dungLuongPin, kichThuocMan, maNhaCungCap, dungLuongLuuTru,giaBan);

                } else {
                    String mainBoard = rs.getString("mainboard");
                    int congSuatNguon = rs.getInt("congsuatnguon");
                    computer = new PC(cardManHinh, gia, maMay, RAM, ROM, soLuong, tenCPU, tenMay, xuatXu, congSuatNguon, mainBoard, maNhaCungCap, dungLuongLuuTru,giaBan);
                }
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computer;
    }
}
