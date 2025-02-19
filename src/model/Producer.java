package model;

public class Producer {
    private String maNhaCungCap;
    private String tenNhaCungCap;
    private String sdt;
    private String diaChi;

    public Producer() {
    }

    public Producer(String diaChi, String maNhaCungCap, String sdt, String tenNhaCungCap) {
        this.diaChi = diaChi;
        this.maNhaCungCap = maNhaCungCap;
        this.sdt = sdt;
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "diaChi='" + diaChi + '\'' +
                ", maNhaCungCap='" + maNhaCungCap + '\'' +
                ", tenNhaCungCap='" + tenNhaCungCap + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
