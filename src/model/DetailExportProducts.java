package model;

public class DetailExportProducts {
    private int maPhieuXuat;
    private int maMay;
    private int soLuong;


    public DetailExportProducts() {
    }
    public DetailExportProducts(int maMay, int soLuong) {
        this.maMay = maMay;
        this.soLuong = soLuong;
    }
    public DetailExportProducts(int maPhieuXuat, int maMay, int soLuong) {
        this.maPhieuXuat = maPhieuXuat;
        this.maMay = maMay;
        this.soLuong = soLuong;
    }

    public int getMaMay() {
        return maMay;
    }

    public void setMaMay(int maMay) {
        this.maMay = maMay;
    }

    public int getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(int maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "ExportProducts{" +
                "maMay='" + maMay + '\'' +
                ", maPhieuXuat=" + maPhieuXuat +
                ", soLuong=" + soLuong +
                '}';
    }
}
