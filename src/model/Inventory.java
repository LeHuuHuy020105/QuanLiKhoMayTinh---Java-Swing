package model;

public class Inventory {
    private int maChiNhanh;
    private int maMay;
    private int soLuong;

    public Inventory() {
    }

    public Inventory(int maChiNhanh, int maMay, int soLuong) {
        this.maChiNhanh = maChiNhanh;
        this.maMay = maMay;
        this.soLuong = soLuong;
    }

    public int getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(int maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
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

    @Override
    public String toString() {
        return "Inventory{" +
                "maChiNhanh=" + maChiNhanh +
                ", maMay=" + maMay +
                ", soLuong=" + soLuong +
                '}';
    }
}
