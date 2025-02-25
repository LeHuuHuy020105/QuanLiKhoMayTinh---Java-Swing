package model;

import java.sql.Timestamp;

public class ImportProducts {
    private int maphieunhap;
    private double tongTien;
    private Timestamp timestamp;
    private int manguoidung;

    public ImportProducts() {
    }

    public ImportProducts(int maphieunhap, Timestamp timestamp, double tongTien,int manguoidung) {
        this.maphieunhap = maphieunhap;
        this.timestamp = timestamp;
        this.tongTien = tongTien;
        this.manguoidung = manguoidung;
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
                '}';
    }
}
