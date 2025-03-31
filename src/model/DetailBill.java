package model;

public class DetailBill {
    private Bill bill;
    private int maPhieu;
    private int maMay;
    private int soLuong;

    public DetailBill(Bill bill, int maPhieu, int maMay, int soLuong) {
        this.bill = bill;
        this.maPhieu = maPhieu;
        this.maMay = maMay;
        this.soLuong = soLuong;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaMay() {
        return maMay;
    }

    public void setMaMay(int maMay) {
        this.maMay = maMay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
