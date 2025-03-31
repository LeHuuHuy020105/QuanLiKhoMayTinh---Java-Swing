package model;

import java.sql.Timestamp;

public class Bill {
    private int maPhieu;
    private Timestamp ngayXuatPhieu;
    private double thanhTien;
    private double tongTien;
    private int maNhanVien;
    private int maKhachHang;
    private int maChiNhanh;

    public Bill() {
    }


    public Bill(int maPhieu, Timestamp ngayXuatPhieu, double thanhTien, double tongTien, int maNhanVien, int maKhachHang, int maChiNhanh) {
        this.maPhieu = maPhieu;
        this.ngayXuatPhieu = ngayXuatPhieu;
        this.thanhTien = thanhTien;
        this.tongTien = tongTien;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.maChiNhanh = maChiNhanh;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Timestamp getNgayXuatPhieu() {
        return ngayXuatPhieu;
    }

    public void setNgayXuatPhieu(Timestamp ngayXuatPhieu) {
        this.ngayXuatPhieu = ngayXuatPhieu;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(int maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }
}
