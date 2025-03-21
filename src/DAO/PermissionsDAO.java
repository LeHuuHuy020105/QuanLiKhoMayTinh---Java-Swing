package DAO;

import database.JDBCUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissionsDAO {
    public PermissionsDAO getInstance() {
        return new PermissionsDAO();
    }

    public static void applyPermissions(int idRole,String tenGiaoDien, JButton them, JButton xoa, JButton sua, JButton xemchitiet, JButton xuatExcel, JButton nhapExcel) {
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM interfaceuser a JOIN role_interfaceuser b WHERE a.magiaodien = b.magiaodien AND b.id = ? AND tengiaodien=? ";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idRole);
            pst.setString(2,tenGiaoDien);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int valueSua = rs.getInt("sua");
                System.out.println("Giá trị sửa từ database: " + valueSua);
                boolean canThem = rs.getInt("them") == 1;
                boolean canSua = rs.getInt("sua") == 1;
                boolean canXoa = rs.getInt("xoa") == 1;
                boolean canXuatExcel = rs.getInt("xuatexcel") == 1;
                boolean canNhapExcel = rs.getInt("nhapexcel") == 1;
                boolean canXemChiTiet = rs.getInt("xemchitiet") == 1;

                // Set trạng thái cho các nút
                them.setEnabled(canThem);
                sua.setEnabled(canSua);
                xoa.setEnabled(canXoa);
                xuatExcel.setEnabled(canXuatExcel);
                nhapExcel.setEnabled(canNhapExcel);
                xemchitiet.setEnabled(canXemChiTiet);

                // In giá trị ra console để kiểm tra
                System.out.println("Quyền truy cập:");
                System.out.println("Thêm: " + canThem);
                System.out.println("Sửa: " + canSua);
                System.out.println("Xóa: " + canXoa);
                System.out.println("Xuất Excel: " + canXuatExcel);
                System.out.println("Nhập Excel: " + canNhapExcel);
                System.out.println("Xem chi tiết: " + canXemChiTiet);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
