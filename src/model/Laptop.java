package model;

public class Laptop extends MayTinh{
    private double kichThuocMan;
    private String dungLuongPin;

    public Laptop(String cardManHinh, double gia, String maMay, String ram, String rom, int soLuong, String tenCpu, String tenMay, int trangThai, String xuatXu, String dungLuongPin, double kichThuocMan) {
        super(cardManHinh, gia, maMay, ram, rom, soLuong, tenCpu, tenMay, trangThai, xuatXu);
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
        return "Laptop{" +
                "dungLuongPin='" + dungLuongPin + '\'' +
                ", kichThuocMan=" + kichThuocMan +
                '}';
    }
}
