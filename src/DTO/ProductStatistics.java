package DTO;

public class ProductStatistics {
    private int maMay;
    private String tenMay;
    private String tenCpu;
    private String ram;
    private int dungLuongLuuTru;
    private String cardManHinh;
    private int soLuongBan;
    private double giaNhap;
    private double giaBan;

    public ProductStatistics() {
    }

    public ProductStatistics(int maMay, String tenMay, String tenCpu, String ram, int dungLuongLuuTru, String cardManHinh, int soLuongBan, double giaNhap, double giaBan) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.tenCpu = tenCpu;
        this.ram = ram;
        this.dungLuongLuuTru = dungLuongLuuTru;
        this.cardManHinh = cardManHinh;
        this.soLuongBan = soLuongBan;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public int getMaMay() {
        return maMay;
    }

    public void setMaMay(int maMay) {
        this.maMay = maMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public String getTenCpu() {
        return tenCpu;
    }

    public void setTenCpu(String tenCpu) {
        this.tenCpu = tenCpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getDungLuongLuuTru() {
        return dungLuongLuuTru;
    }

    public void setDungLuongLuuTru(int dungLuongLuuTru) {
        this.dungLuongLuuTru = dungLuongLuuTru;
    }

    public String getCardManHinh() {
        return cardManHinh;
    }

    public void setCardManHinh(String cardManHinh) {
        this.cardManHinh = cardManHinh;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "maMay=" + maMay +
                ", tenMay='" + tenMay + '\'' +
                ", tenCpu='" + tenCpu + '\'' +
                ", ram='" + ram + '\'' +
                ", dungLuongLuuTru=" + dungLuongLuuTru +
                ", cardManHinh='" + cardManHinh + '\'' +
                ", soLuongBan=" + soLuongBan +
                ", giaNhap=" + giaNhap +
                ", giaBan=" + giaBan +
                '}';
    }
}
