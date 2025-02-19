package model;

public class EntryForm {
    private String maMay;
    private int soluong;
    private String maNhaCungCap;

    public EntryForm() {
    }

    public EntryForm(String maMay, String maNhaCungCap, int soluong) {
        this.maMay = maMay;
        this.maNhaCungCap = maNhaCungCap;
        this.soluong = soluong;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "EntryForm{" +
                "maMay='" + maMay + '\'' +
                ", soluong=" + soluong +
                ", maNhaCungCap='" + maNhaCungCap + '\'' +
                '}';
    }
}
