package model;

import java.sql.Timestamp;

public class Bill {
    private int maPhieu;
    private Timestamp thoiDiemTao;
    private double thanhTien;
    private double tongTien;
    private int maNhanVien;
    private int maKhachHang;
    private int maChiNhanh;
    private String hinhThuc;
    private Timestamp thoiDiemHuy;
    private int trangThai;
    private int madiachi;

    public Bill() {
    }

    public Bill(String hinhThuc, int madiachi, int maKhachHang, double tongTien, int trangThai) {
        this.hinhThuc = hinhThuc;
        this.madiachi = madiachi;
        this.maKhachHang = maKhachHang;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public Bill(int maChiNhanh, int maKhachHang, int maNhanVien, Timestamp thoiDiemTao, double thanhTien, double tongTien, String hinhThuc) {
        this.maChiNhanh = maChiNhanh;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.thoiDiemTao = thoiDiemTao;
        this.thanhTien = thanhTien;
        this.tongTien = tongTien;
        this.hinhThuc = hinhThuc;
    }
    public Bill(int maChiNhanh, int maKhachHang, int maNhanVien, Timestamp thoiDiemTao, double thanhTien, double tongTien,String hinhThuc , Timestamp thoiDiemHuy ,int trangThai) {
        this.maChiNhanh = maChiNhanh;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.thoiDiemTao = thoiDiemTao;
        this.thanhTien = thanhTien;
        this.tongTien = tongTien;
        this.hinhThuc = hinhThuc;
        this.thoiDiemHuy = thoiDiemHuy;
        this.trangThai = trangThai;
    }

    public Bill(int maPhieu, Timestamp thoiDiemTao, double thanhTien, double tongTien, int maNhanVien, int maKhachHang, int maChiNhanh,String hinhThuc) {
        this.maPhieu = maPhieu;
        this.thoiDiemTao = thoiDiemTao;
        this.thanhTien = thanhTien;
        this.tongTien = tongTien;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.maChiNhanh = maChiNhanh;
        this.hinhThuc = hinhThuc;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }
    public int getMadiachi() {
        return madiachi;
    }

    public void setMadiachi(int madiachi) {
        this.madiachi = madiachi;
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


    public Timestamp getThoiDiemHuy() {
        return thoiDiemHuy;
    }

    public void setThoiDiemHuy(Timestamp thoiDiemHuy) {
        this.thoiDiemHuy = thoiDiemHuy;
    }

    public Timestamp getThoiDiemTao() {
        return thoiDiemTao;
    }

    public void setThoiDiemTao(Timestamp thoiDiemTao) {
        this.thoiDiemTao = thoiDiemTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
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
