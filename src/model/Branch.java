package model;

public class Branch {
    public int maChiNhanh;
    public String tenChiNhanh;
    public String diaChi;
    public String tenQuan;
    public String thanhPho;
    public String soDienThoai;
    public String moTa;

    public Branch() {
    }

    public Branch(String diaChi, int maChiNhanh, String soDienThoai,String tenChiNhanh,String tenQuan,String thanhPho,String moTa) {
        this.diaChi = diaChi;
        this.maChiNhanh = maChiNhanh;
        this.soDienThoai = soDienThoai;
        this.tenChiNhanh=tenChiNhanh;
        this.tenQuan=tenQuan;
        this.thanhPho=thanhPho;
        this.moTa=moTa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }

    public String getTenQuan() {
        return tenQuan;
    }

    public void setTenQuan(String tenQuan) {
        this.tenQuan = tenQuan;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
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
