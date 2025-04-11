package model;

public class Statistics {
    private int maMay;
    private String tenMay;
    private int soLuongBan;
    private double giaNhap;
    private double giaBan;

    public Statistics() {
    }

    public Statistics(int maMay, String tenMay, int soLuongBan, double giaNhap, double giaBan) {
        this.tenMay = tenMay;
        this.soLuongBan = soLuongBan;
        this.maMay = maMay;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public int getMaMay() {
        return maMay;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public String getTenMay() {
        return tenMay;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "giaBan=" + giaBan +
                ", maMay=" + maMay +
                ", tenMay='" + tenMay + '\'' +
                ", soLuongBan=" + soLuongBan +
                ", giaNhap=" + giaNhap +
                '}';
    }
}
