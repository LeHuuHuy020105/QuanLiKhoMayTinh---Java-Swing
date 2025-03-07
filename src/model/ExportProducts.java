package model;

import java.sql.Timestamp;

public class ExportProducts {
    private int maPhieuXuat;
    private Timestamp ngayLenDonXuat;
    private String trangThai;
    private Timestamp ngayNhanDonXuat;
    private int maChiNhanh;
    private int manguoidung;

    public ExportProducts(int maPhieuXuat, Timestamp ngayLenDonXuat, Timestamp ngayNhanDonXuat, String trangThai,int maChiNhanh,int manguoidung) {
        this.maPhieuXuat = maPhieuXuat;
        this.ngayLenDonXuat = ngayLenDonXuat;
        this.ngayNhanDonXuat = ngayNhanDonXuat;
        this.trangThai = trangThai;
        this.maChiNhanh=maChiNhanh;
        this.manguoidung = manguoidung;
    }

    public int getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(int maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public Timestamp getNgayLenDonXuat() {
        return ngayLenDonXuat;
    }

    public void setNgayLenDonXuat(Timestamp ngayLenDonXuat) {
        this.ngayLenDonXuat = ngayLenDonXuat;
    }

    public Timestamp getNgayNhanDonXuat() {
        return ngayNhanDonXuat;
    }

    public void setNgayNhanDonXuat(Timestamp ngayNhanDonXuat) {
        this.ngayNhanDonXuat = ngayNhanDonXuat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(int maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public int getManguoidung() {
        return manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        this.manguoidung = manguoidung;
    }

    @Override
    public String toString() {
        return "ExportProducts{" +
                "maChiNhanh=" + maChiNhanh +
                ", maPhieuXuat=" + maPhieuXuat +
                ", ngayLenDonXuat=" + ngayLenDonXuat +
                ", trangThai='" + trangThai + '\'' +
                ", ngayNhanDonXuat=" + ngayNhanDonXuat +
                ", manguoidung=" + manguoidung +
                '}';
    }
}
