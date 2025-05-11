package DAO;

import database.JDBCUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissionsDAO {
    public static PermissionsDAO getInstance() {
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
            System.out.println(rs);
            while (rs.next()) {
                int id = rs.getInt("magiaodien");
                boolean canThem = rs.getInt("them") == 1;
                boolean canSua = rs.getInt("sua") == 1;
                boolean canXoa = rs.getInt("xoa") == 1;
                boolean canXuatExcel = rs.getInt("xuatexcel") == 1;
                boolean canNhapExcel = rs.getInt("nhapexcel") == 1;
                boolean canXemChiTiet = rs.getInt("xemchitiet") == 1;

                // Set trạng thái cho các nút
                if (them != null) them.setEnabled(canThem);
                if (sua != null) sua.setEnabled(canSua);
                if (xoa != null) xoa.setEnabled(canXoa);
                if (xuatExcel != null) xuatExcel.setEnabled(canXuatExcel);
                if (nhapExcel != null) nhapExcel.setEnabled(canNhapExcel);
                if (xemchitiet != null) xemchitiet.setEnabled(canXemChiTiet);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
