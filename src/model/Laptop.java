package model;

public class Laptop extends Computer {
    private double kichThuocMan;
    private String dungLuongPin;


    public Laptop(String cardManHinh, double gia, int maMay, String ram, String rom, int soLuong, String tenCpu, String tenMay, String xuatXu, String dungLuongPin, double kichThuocMan, String maNhaCungCap, double dungLuongLuuTru,double giaBan ,byte[] hinhAnh) {
        super(cardManHinh, gia, maMay, ram, rom, soLuong, tenCpu, tenMay, xuatXu, maNhaCungCap,dungLuongLuuTru,giaBan,hinhAnh);
        this.dungLuongPin = dungLuongPin;
        this.kichThuocMan = kichThuocMan;
    }

    public Laptop(){

    }

    public String getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(String dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    public double getKichThuocMan() {
        return kichThuocMan;
    }

    public void setKichThuocMan(double kichThuocMan) {
        this.kichThuocMan = kichThuocMan;
    }

    @Override
    public String toString() {
        return super.toString()+"Laptop{" +
                "dungLuongPin='" + dungLuongPin + '\'' +
                ", kichThuocMan=" + kichThuocMan +
                '}';
    }
}
