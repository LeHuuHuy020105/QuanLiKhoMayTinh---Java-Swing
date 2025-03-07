package DAO;

import database.JDBCUtil;
import model.Laptop;
import model.PC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LaptopDAO implements DAOInterface<Laptop> {
    public static LaptopDAO getInstance() {
        return new LaptopDAO();
    }

    @Override
    public int insert(Laptop laptop) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.insertProduct;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, laptop.getTenMay());
            pst.setInt(2, laptop.getSoLuong());
            pst.setDouble(3, laptop.getGia());
            pst.setString(4, laptop.getTenCpu());
            pst.setString(5, laptop.getRam());
            pst.setString(6, laptop.getXuatXu());
            pst.setString(7, laptop.getCardManHinh());
            pst.setString(12, laptop.getRom());
            pst.setString(8, null);
            pst.setString(9, null);
            pst.setDouble(10, laptop.getKichThuocMan());
            pst.setString(11, laptop.getDungLuongPin());
            pst.setString(13, "Laptop");
            pst.setString(14, laptop.getMaNhaCungCap());
            pst.setDouble(15, laptop.getDungLuongLuuTru());
            pst.setDouble(16, laptop.getGiaBan());
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Laptop laptop) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql =Query.updateLaptop;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,laptop.getTenMay());
            pst.setInt(2,laptop.getSoLuong());
            pst.setDouble(3,laptop.getGia());
            pst.setString(4,laptop.getTenCpu());
            pst.setString(5,laptop.getRam());
            pst.setString(6,laptop.getXuatXu());
            pst.setDouble(7,laptop.getKichThuocMan());
            pst.setString(8,laptop.getDungLuongPin());
            pst.setString(9,laptop.getRom());
            pst.setString(10,"Laptop");
            pst.setString(11,laptop.getMaNhaCungCap());
            pst.setDouble(12,laptop.getDungLuongLuuTru());
            pst.setInt(13,laptop.getMaMay());
            pst.setDouble(14,laptop.getGiaBan());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(Laptop laptop) {
        return 0;
    }

    @Override
    public ArrayList<Laptop> selectAll() {
        ArrayList<Laptop> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.selectAllProductByType("Laptop");
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
                double kichThuocMan = rs.getDouble("kichthuocman");
                String dungLuongPin = rs.getString("dungluongpin");
                String maNhaCungCap = rs.getString("manhacungcap");
                double dungLuongLuuTru = rs.getDouble("dungluongluutru");
                double giaBan = rs.getDouble("giaban");
                Laptop newLaptop = new Laptop(cardManHinh, gia, maMay, Ram, Rom, soLuong, tenCPU, tenMay, xuatXu, dungLuongPin, kichThuocMan, maNhaCungCap, dungLuongLuuTru,giaBan);
                ketQua.add(newLaptop);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
