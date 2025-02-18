package model;

public class MayTinh {
    private String maMay;
    private String tenMay;
    private int soLuong;
    private double gia;
    private String tenCpu;
    private String ram;
    private String xuatXu;
    private String cardManHinh;
    private String Rom;
    private int trangThai;

    public MayTinh() {
    }

    public MayTinh(String cardManHinh, double gia, String maMay, String ram, String rom, int soLuong, String tenCpu, String tenMay, int trangThai, String xuatXu) {
        this.cardManHinh = cardManHinh;
        this.gia = gia;
        this.maMay = maMay;
        this.ram = ram;
        Rom = rom;
        this.soLuong = soLuong;
        this.tenCpu = tenCpu;
        this.tenMay = tenMay;
        this.trangThai = trangThai;
        this.xuatXu = xuatXu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public int getTrangThai() {
        return trangThai;
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
                ", trangThai=" + trangThai +
                '}';
    }
}
