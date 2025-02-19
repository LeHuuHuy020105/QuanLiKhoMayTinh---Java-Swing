package model;

public class Branch {
    private String maChiNhanh;
    private String diaChi;

    public Branch() {
    }

    public Branch(String diaChi, String maChiNhanh) {
        this.diaChi = diaChi;
        this.maChiNhanh = maChiNhanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "diaChi='" + diaChi + '\'' +
                ", maChiNhanh='" + maChiNhanh + '\'' +
                '}';
    }
}
