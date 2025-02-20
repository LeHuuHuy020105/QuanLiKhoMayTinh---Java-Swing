package DAO;

import database.JDBCUtil;
import model.Laptop;
import model.PC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LaptopDAO implements DAOInterface<Laptop> {
    public static LaptopDAO getInstance(){
        return new LaptopDAO();
    }
    @Override
    public int insert(Laptop laptop) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Insert into product(mamay,tenmay,soluong,gia,tenCPU,ram,xuatxu,cardmanhinh,mainboard,congsuatnguon,kichthuocman,dungluongpin,rom,loaimay,manhacungcap,dungluongluutru) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, laptop.getMaMay());
            pst.setString(2, laptop.getTenMay());
            pst.setInt(3, laptop.getSoLuong());
            pst.setDouble(4, laptop.getGia());
            pst.setString(5, laptop.getTenCpu());
            pst.setString(6, laptop.getRam());
            pst.setString(7, laptop.getXuatXu());
            pst.setString(8, laptop.getCardManHinh());
            pst.setString(13, laptop.getRom());
            pst.setString(9, null);
            pst.setString(10, null);
            pst.setDouble(11, laptop.getKichThuocMan());
            pst.setString(12, laptop.getDungLuongPin());
            pst.setString(14, "Laptop");
            pst.setString(15, laptop.getMaNhaCungCap());
            pst.setDouble(16, laptop.getDungLuongLuuTru());
            System.out.println(sql);
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Laptop laptop) {
        return 0;
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
            String sql = "Select * from product where loaimay = 'Laptop'";
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
                double kichThuocMan = rs.getDouble("kichthuocman");
                String dungLuongPin = rs.getString("dungluongpin");
                String maNhaCungCap = rs.getString("manhacungcap");
                double dungLuongLuuTru = rs.getDouble("dungluongluutru");
                Laptop newLaptop = new Laptop(cardManHinh, gia, maMay, Ram, Rom, soLuong, tenCPU, tenMay, xuatXu, dungLuongPin, kichThuocMan,maNhaCungCap,dungLuongLuuTru);
                ketQua.add(newLaptop);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
