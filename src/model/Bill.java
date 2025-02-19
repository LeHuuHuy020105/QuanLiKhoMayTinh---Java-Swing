package model;

public class Bill {
    private String maMay;
    private int soLuong;
    private String maChiNhanh;
    private String maNhaCungCap;
    private int totalPrice;

    public Bill(String maChiNhanh, String maMay, String maNhaCungCap, int soLuong , int totalPrice) {
        this.maChiNhanh = maChiNhanh;
        this.maMay = maMay;
        this.maNhaCungCap = maNhaCungCap;
        this.soLuong = soLuong;
        this.totalPrice = totalPrice;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "maChiNhanh='" + maChiNhanh + '\'' +
                ", maMay='" + maMay + '\'' +
                ", soLuong=" + soLuong +
                ", maNhaCungCap='" + maNhaCungCap + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
