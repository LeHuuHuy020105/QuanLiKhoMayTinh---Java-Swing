package DAO;

import database.JDBCUtil;
import model.Laptop;
import model.PC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PCDAO implements DAOInterface<PC> {
    public static PCDAO getInstance(){
        return new PCDAO();
    }
    @Override
    public int insert(PC pc) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Insert into product(mamay,tenmay,soluong,gia,tenCPU,ram,xuatxu,cardmanhinh,mainboard,congsuatnguon,kichthuocman,dungluongpin,rom,loaimay,dungluongluutru) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, pc.getMaMay());
            pst.setString(2, pc.getTenMay());
            pst.setInt(3, pc.getSoLuong());
            pst.setDouble(4, pc.getGia());
            pst.setString(5, pc.getTenCpu());
            pst.setString(6, pc.getRam());
            pst.setString(7, pc.getXuatXu());
            pst.setString(8, pc.getCardManHinh());
            pst.setString(13, pc.getRom());
            pst.setString(9, pc.getMainBoard());
            pst.setInt(10, pc.getCongSuatNguon());
            pst.setString(11, null);
            pst.setString(12, null);
            pst.setString(14, "PC");
            pst.setString(15, pc.getMaNhaCungCap());
            pst.setDouble(16, pc.getDungLuongLuuTru());
            ketQua = pst.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(PC pc) {
        return 0;
    }

    @Override
    public int delete(PC pc) {
        return 0;
    }

    @Override
    public ArrayList<PC> selectAll() {
        ArrayList<PC> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "Select * from product where loaimay = 'PC'";
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
                String mainBoard = rs.getString("mainboard");
                int congSuatNguon = rs.getInt("congsuatnguon");
                String maNhaCungCap = rs.getString("manhacungcap");
                double dungLuongLuuTru = rs.getDouble("dungluongluutru");
                PC newPC = new PC(cardManHinh, gia, maMay, Ram, Rom, soLuong, tenCPU, tenMay, xuatXu, congSuatNguon, mainBoard,maNhaCungCap,dungLuongLuuTru);
                ketQua.add(newPC);

            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
