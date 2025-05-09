package DAO;

import com.toedter.calendar.JDateChooser;
import database.JDBCUtil;
import model.Bill;
import model.BillStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.User.ThongKe.ThongKePhieuForm;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class BillStatisticsDAO implements DAOInterface<BillStatistics> {
    private static final Logger log = LoggerFactory.getLogger(BillStatisticsDAO.class);

    public static BillStatisticsDAO getInstance() {
        return new BillStatisticsDAO();
    }

    public BillStatisticsDAO() {
    }

    @Override
    public int insert(BillStatistics statistics) {
        return 0;
    }

    @Override
    public int update(BillStatistics statistics) {
        return 0;
    }

    @Override
    public int delete(BillStatistics statistics) {
        return 0;
    }

    @Override
    public ArrayList<BillStatistics> selectAll() {
        return null;
    }

    public ArrayList<BillStatistics> findAllBills() {
        ArrayList<BillStatistics> result = new ArrayList<>();
        try {
            String sql = "select maphieu, manhanvien, thoidiemtao, tongtien from bills";
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                BillStatistics statistics = new BillStatistics(resultSet.getInt("maphieu"), resultSet.getInt("manhanvien"), resultSet.getTimestamp("thoidiemtao").toLocalDateTime(), resultSet.getDouble("tongtien"));
                result.add(statistics);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public ArrayList<BillStatistics> findAllBillsIdBranch(int id) {
        ArrayList<BillStatistics> result = new ArrayList<>();
        try {
            String sql = "select maphieu, manhanvien, thoidiemtao, tongtien from bills where machinhanh=?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultSet = pst.executeQuery(sql);
            while (resultSet.next()) {
                BillStatistics statistics = new BillStatistics(resultSet.getInt("maphieu"), resultSet.getInt("manhanvien"), resultSet.getTimestamp("thoidiemtao").toLocalDateTime(), resultSet.getDouble("tongtien"));
                result.add(statistics);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<BillStatistics> findAllBillsByTime(LocalDate startDate, LocalDate endDate, String selectedOption, String searchString) {
        if (startDate.isAfter(endDate)) return null;
        ArrayList<BillStatistics> result = new ArrayList<>();
        try {
            String sql = "select b.maphieu, b.manhanvien, b.thoidiemtao, b.tongtien from bills b where b.thoidiemtao >= ? and b.thoidiemtao <= ?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, startDate.atStartOfDay());
            preparedStatement.setObject(2, endDate.atTime(23, 59, 59));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BillStatistics statistics = new BillStatistics(resultSet.getInt("maphieu"), resultSet.getInt("manhanvien"), resultSet.getTimestamp("thoidiemtao").toLocalDateTime(), resultSet.getDouble("tongtien"));
                result.add(statistics);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ThongKePhieuForm thongKePhieuForm = new ThongKePhieuForm();
        switch (selectedOption) {
            case "Tất cả": {
                result = thongKePhieuForm.searchAll(result, searchString);
                break;
            }
            case "Mã phiếu": {
                result = thongKePhieuForm.searchByMaPhieu(result, searchString);
                break;
            }
            case "Người tạo": {
                result = thongKePhieuForm.searchByCreator(result, searchString);
                break;
            }
            default:
                break;
        }
        return result;
    }

    public int soldOrderCount(List<BillStatistics> list) {
        int count = 0;
        String sql = "SELECT b.tongtien, db.soluong FROM bills b JOIN detailbill db ON b.maphieu = db.maphieu where b.maphieu = ?";
        Connection connection = JDBCUtil.getConnection();
        try {
            for (int i = 0; i < list.size(); i++) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, list.get(i).getMaPhieu());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    count++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
