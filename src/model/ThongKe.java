package model;

public class ThongKe {
    private String maMay;
    private String tenMay;
    private int slNhap;
    private int slXuat;

    public ThongKe() {
    }

    public ThongKe(String maMay, int slNhap, int slXuat, String tenMay) {
        this.maMay = maMay;
        this.slNhap = slNhap;
        this.slXuat = slXuat;
        this.tenMay = tenMay;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public int getSlNhap() {
        return slNhap;
    }

    public void setSlNhap(int slNhap) {
        this.slNhap = slNhap;
    }

    public int getSlXuat() {
        return slXuat;
    }

    public void setSlXuat(int slXuat) {
        this.slXuat = slXuat;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    @Override
    public String toString() {
        return "ThongKe{" +
                "maMay='" + maMay + '\'' +
                ", tenMay='" + tenMay + '\'' +
                ", slNhap=" + slNhap +
                ", slXuat=" + slXuat +
                '}';
    }
}
