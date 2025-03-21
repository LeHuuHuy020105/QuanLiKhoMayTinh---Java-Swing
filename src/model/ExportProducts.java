package model;

import java.sql.Timestamp;

public class ExportProducts {
    private int maPhieuXuat;
    private Timestamp ngayLenDonXuat;
    private int trangThai;
    private Timestamp ngayNhanDonXuat;
    private int maChiNhanh;
    private int manguoidung;
    private Timestamp thoiDiemHuyPhieu;

    public ExportProducts(int maPhieuXuat, Timestamp ngayLenDonXuat, Timestamp ngayNhanDonXuat, int trangThai,int maChiNhanh,int manguoidung,Timestamp thoiDiemHuyPhieu) {
        this.maPhieuXuat = maPhieuXuat;
        this.ngayLenDonXuat = ngayLenDonXuat;
        this.ngayNhanDonXuat = ngayNhanDonXuat;
        this.trangThai = trangThai;
        this.maChiNhanh=maChiNhanh;
        this.manguoidung = manguoidung;
        this.thoiDiemHuyPhieu = thoiDiemHuyPhieu;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
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
