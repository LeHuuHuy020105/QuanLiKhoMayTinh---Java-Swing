package DAO;

import com.mysql.cj.jdbc.ClientPreparedStatement;
import database.JDBCUtil;
import model.Bill;
import model.Statistics;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StatisticsDAO implements DAOInterface<Statistics>{
    public StatisticsDAO() {
    }

    @Override
    public int insert(Statistics statistics) {
        return 0;
    }

    @Override
    public int update(Statistics statistics) {
        return 0;
    }

    @Override
    public int delete(Statistics statistics) {
        return 0;
    }

    @Override
    public ArrayList<Statistics> selectAll() {
        return null;
    }

    public ArrayList<Statistics> findAllProducts() {
        ArrayList<Statistics> result = new ArrayList<>();
        try {
            String sql = "select p.mamay, p.tenmay, d.soluong, p.gia, p.giaban from bills b join detailbill d on b.maphieu = d.maphieu join product p on d.mamay = p.mamay";
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Statistics statistics = new Statistics(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getDouble(5));
                result.add(statistics);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<Statistics> findAllProductsByTime(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) return null;
        ArrayList<Statistics> result = new ArrayList<>();
        try {
            String sql = "select p.mamay, p.tenmay, d.soluong, p.gia, p.giaban from bills b join detailbill d on b.maphieu = d.maphieu join product p on d.mamay = p.mamay where b.thoidiemtao >= ? and b.thoidiemtao <= ?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, startDate);
            preparedStatement.setObject(2, endDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                if (startDate.isBefore(endDate)) {
                    Statistics statistics = new Statistics(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getDouble(5));
                    result.add(statistics);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
