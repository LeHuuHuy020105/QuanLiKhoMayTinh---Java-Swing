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
            String sql = Query.insertProduct;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, pc.getTenMay());
            pst.setInt(2, pc.getSoLuong());
            pst.setDouble(3, pc.getGia());
            pst.setString(4, pc.getTenCpu());
            pst.setString(5, pc.getRam());
            pst.setString(6, pc.getXuatXu());
            pst.setString(7, pc.getCardManHinh());
            pst.setString(8, pc.getMainBoard());
            pst.setInt(9, pc.getCongSuatNguon());
            pst.setString(10, null);
            pst.setString(11, null);
            pst.setString(12, pc.getRom());
            pst.setString(13, "PC");
            pst.setString(14, pc.getMaNhaCungCap());
            pst.setDouble(15, pc.getDungLuongLuuTru());
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(PC pc) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = Query.updatePC;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,pc.getTenMay());
            pst.setInt(2,pc.getSoLuong());
            pst.setDouble(3,pc.getGia());
            pst.setString(4,pc.getTenCpu());
            pst.setString(5,pc.getRam());
            pst.setString(6,pc.getXuatXu());
            pst.setString(7,pc.getMainBoard());
            pst.setInt(8,pc.getCongSuatNguon());
            pst.setString(9,pc.getRom());
            pst.setString(10,"PC");
            pst.setString(11,pc.getMaNhaCungCap());
            pst.setDouble(12,pc.getDungLuongLuuTru());
            pst.setInt(13,pc.getMaMay());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
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
            String sql = Query.selectAllProductByType("PC");
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
