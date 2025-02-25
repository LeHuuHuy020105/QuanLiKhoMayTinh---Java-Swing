package model;

public class Branch {
    public int maChiNhanh;
    public String diaChi;
    public String soDienThoai;

    public Branch() {
    }

    public Branch(String diaChi, int maChiNhanh, String soDienThoai) {
        this.diaChi = diaChi;
        this.maChiNhanh = maChiNhanh;
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(int maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "diaChi='" + diaChi + '\'' +
                ", maChiNhanh=" + maChiNhanh +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
