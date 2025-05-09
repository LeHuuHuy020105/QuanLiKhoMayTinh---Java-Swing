package DAO;

import database.JDBCUtil;
import DTO.ProductStatistics;
import GUI.User.ThongKe.ThongKeSanPhamForm;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductStatisticsDAO implements DAOInterface<ProductStatistics>{
    public ProductStatisticsDAO() {
    }

    @Override
    public int insert(ProductStatistics statistics) {
        return 0;
    }

    @Override
    public int update(ProductStatistics statistics) {
        return 0;
    }

    @Override
    public int delete(ProductStatistics statistics) {
        return 0;
    }

    @Override
    public ArrayList<ProductStatistics> selectAll() {
        return null;
    }

    public ArrayList<ProductStatistics> findAllProducts() {
        ArrayList<ProductStatistics> result = new ArrayList<>();
        try {
            String sql = "select p.mamay, p.tenmay, p.tenCPU, p.ram, p.dungluongluutru, p.cardmanhinh, d.soluong, p.gia, p.giaban from bills b join detailbill d on b.maphieu = d.maphieu join product p on d.mamay = p.mamay";
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                ProductStatistics statistics = new ProductStatistics(resultSet.getInt("mamay"), resultSet.getString("tenmay"), resultSet.getString("tenCPU"), resultSet.getString("ram"), resultSet.getInt("dungluongluutru"), resultSet.getString("cardmanhinh"), resultSet.getInt("soluong"), resultSet.getDouble("gia"), resultSet.getDouble("giaban"));
                result.add(statistics);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<ProductStatistics> findAllProductsByTime(LocalDate startDate, LocalDate endDate, String selectedOption, String searchString) {
        if (startDate.isAfter(endDate)) return null;
        ArrayList<ProductStatistics> result = new ArrayList<>();
        try {
            String sql = "select p.mamay, p.tenmay, p.tenCPU, p.ram, p.dungluongluutru, p.cardmanhinh, d.soluong, p.gia, p.giaban from bills b join detailbill d on b.maphieu = d.maphieu join product p on d.mamay = p.mamay where b.thoidiemtao >= ? and b.thoidiemtao <= ?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, startDate.atStartOfDay());
            preparedStatement.setObject(2, endDate.atTime(23, 59, 59));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProductStatistics statistics = new ProductStatistics(resultSet.getInt("mamay"), resultSet.getString("tenmay"), resultSet.getString("tenCPU"), resultSet.getString("ram"), resultSet.getInt("dungluongluutru"), resultSet.getString("cardmanhinh"), resultSet.getInt("soluong"), resultSet.getDouble("gia"), resultSet.getDouble("giaban"));
                result.add(statistics);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ThongKeSanPhamForm thongKeSanPhamForm = new ThongKeSanPhamForm();
        switch (selectedOption) {
            case "Tất cả": {
                result = thongKeSanPhamForm.searchAll(result, searchString);
                break;
            }
            case "Tên máy": {
                result = thongKeSanPhamForm.searchByName(result, searchString);
                break;
            }
            case "RAM": {
                result = thongKeSanPhamForm.searchByRam(result, searchString);
                break;
            }
            case "CPU": {
                result = thongKeSanPhamForm.searchByCpu(result, searchString);
                break;
            }
            case "Dung lượng": {
                result = thongKeSanPhamForm.searchByDungLuong(result, searchString);
                break;
            }
            case "Card màn hình": {
                result = thongKeSanPhamForm.searchByCard(result, searchString);
                break;
            }
        }
        return result;
    }
}
