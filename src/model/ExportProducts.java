package model;

public class ExportProducts {
    private String maMay;
    private int soLuong;
    private String maChiNhanh;

    public ExportProducts() {
    }

    public ExportProducts(String maChiNhanh, String maMay, int soLuong) {
        this.maChiNhanh = maChiNhanh;
        this.maMay = maMay;
        this.soLuong = soLuong;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "ExitForm{" +
                "maChiNhanh='" + maChiNhanh + '\'' +
                ", maMay='" + maMay + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }
}
