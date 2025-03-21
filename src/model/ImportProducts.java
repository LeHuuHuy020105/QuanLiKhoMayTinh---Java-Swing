package model;

import java.sql.Timestamp;
import java.util.Objects;

public class ImportProducts {
    private int maphieunhap;
    private double tongTien;
    private Timestamp timestamp;
    private int manguoidung;
    private int trangThai;
    private Timestamp thoiGianHuy;
    private Timestamp ngayNhanDon;

    public ImportProducts() {
    }

    public ImportProducts(int maphieunhap, Timestamp timestamp, double tongTien,int manguoidung,int trangThai,Timestamp thoiGianHuy,Timestamp ngayNhanDon) {
        this.maphieunhap = maphieunhap;
        this.timestamp = timestamp;
        this.tongTien = tongTien;
        this.manguoidung = manguoidung;
        this.trangThai = trangThai;
        this.thoiGianHuy = thoiGianHuy;
        this.ngayNhanDon = ngayNhanDon;
    }

    public Timestamp getThoiGianHuy() {
        return thoiGianHuy;
    }

    public void setThoiGianHuy(Timestamp thoiGianHuy) {
        this.thoiGianHuy = thoiGianHuy;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getManguoidung() {
        return manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        this.manguoidung = manguoidung;
    }

    @Override
    public String toString() {
        return "ImportProducts{" +
                "manguoidung=" + manguoidung +
                ", maphieunhap=" + maphieunhap +
                ", tongTien=" + tongTien +
                ", timestamp=" + timestamp +
                ", trangThai=" + trangThai +
                ", thoiGianHuy=" + thoiGianHuy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ImportProducts that = (ImportProducts) o;
        return maphieunhap == that.maphieunhap && Double.compare(tongTien, that.tongTien) == 0 && manguoidung == that.manguoidung && trangThai == that.trangThai && Objects.equals(timestamp, that.timestamp) && Objects.equals(thoiGianHuy, that.thoiGianHuy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maphieunhap, tongTien, timestamp, manguoidung, trangThai, thoiGianHuy);
    }
}
