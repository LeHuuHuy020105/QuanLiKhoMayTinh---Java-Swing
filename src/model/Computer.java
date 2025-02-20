package model;

public class Computer {
    private String maMay;
    private String tenMay;
    private int soLuong;
    private double gia;
    private String tenCpu;
    private String ram;
    private String xuatXu;
    private String cardManHinh;
    private String Rom;
    private String maNhaCungCap;
    private double dungLuongLuuTru;

    public Computer() {
    }

    public Computer(String cardManHinh, double gia, String maMay, String ram, String rom, int soLuong, String tenCpu, String tenMay, String xuatXu, String maNhaCungCap , double dungLuongLuuTru) {
        this.cardManHinh = cardManHinh;
        this.gia = gia;
        this.maMay = maMay;
        this.ram = ram;
        Rom = rom;
        this.soLuong = soLuong;
        this.tenCpu = tenCpu;
        this.tenMay = tenMay;
        this.xuatXu = xuatXu;
        this.maNhaCungCap = maNhaCungCap;
        this.dungLuongLuuTru = dungLuongLuuTru;
    }

    public double getDungLuongLuuTru() {
        return dungLuongLuuTru;
    }

    public void setDungLuongLuuTru(double dungLuongLuuTru) {
        this.dungLuongLuuTru = dungLuongLuuTru;
    }

    public void setCardManHinh(String cardManHinh) {
        this.cardManHinh = cardManHinh;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setRom(String rom) {
        Rom = rom;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTenCpu(String tenCpu) {
        this.tenCpu = tenCpu;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public String getTenMay() {
        return tenMay;
    }

    public String getTenCpu() {
        return tenCpu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getRom() {
        return Rom;
    }

    public String getRam() {
        return ram;
    }

    public String getMaMay() {
        return maMay;
    }

    public double getGia() {
        return gia;
    }

    public String getCardManHinh() {
        return cardManHinh;
    }

    @Override
    public String toString() {
        return "MayTinh{" +
                "cardManHinh='" + cardManHinh + '\'' +
                ", maMay='" + maMay + '\'' +
                ", tenMay='" + tenMay + '\'' +
                ", soLuong=" + soLuong +
                ", gia=" + gia +
                ", tenCpu='" + tenCpu + '\'' +
                ", ram='" + ram + '\'' +
                ", xuatXu='" + xuatXu + '\'' +
                ", Rom='" + Rom + '\'' +
                '}';
    }
}
