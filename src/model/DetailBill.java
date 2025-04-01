package model;

public class DetailBill {
    private int maPhieu;
    private int maMay;
    private int soLuong;

    public DetailBill(int maMay, int maPhieu, int soLuong) {
        this.maMay = maMay;
        this.maPhieu = maPhieu;
        this.soLuong = soLuong;
    }

    public int getMaMay() {
        return maMay;
    }

    public void setMaMay(int maMay) {
        this.maMay = maMay;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
