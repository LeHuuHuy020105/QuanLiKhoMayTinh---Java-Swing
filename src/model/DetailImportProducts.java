package model;

public class DetailImportProducts {
    private int maphieunhap;
    private int maMay;
    private int soluong;


    public DetailImportProducts() {
    }

    public DetailImportProducts(int maMay, int soluong) {
        this.maMay = maMay;
        this.soluong = soluong;
    }

    public DetailImportProducts(int maMay, int maphieunhap, int soluong) {
        this.maMay = maMay;
        this.maphieunhap = maphieunhap;
        this.soluong = soluong;
    }

    public int getMaMay() {
        return maMay;
    }

    public void setMaMay(int maMay) {
        this.maMay = maMay;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getSoluong() {
        return soluong;
    }

    @Override
    public String toString() {
        return "DetailImportProducts{" +
                "maMay=" + maMay +
                ", maphieunhap=" + maphieunhap +
                ", soluong=" + soluong +
                '}';
    }
}
