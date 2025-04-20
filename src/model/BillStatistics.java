package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BillStatistics {
    private int maPhieu;
    private int maNhanVien;
    private LocalDateTime thoiGianTao;
    private double tongTien;

    public BillStatistics() {
    }

    public BillStatistics(int maPhieu, int maNhanVien, LocalDateTime thoiGianTao, double tongTien) {
        this.maPhieu = maPhieu;
        this.maNhanVien = maNhanVien;
        this.thoiGianTao = thoiGianTao;
        this.tongTien = tongTien;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public LocalDateTime getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(LocalDateTime thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "BillStatistics{" +
                "maPhieu=" + maPhieu +
                ", maNhanVien=" + maNhanVien +
                ", thoiGianTao=" + thoiGianTao +
                ", tongTien=" + tongTien +
                '}';
    }
}
