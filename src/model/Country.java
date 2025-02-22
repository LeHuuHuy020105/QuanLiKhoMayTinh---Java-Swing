package model;

public class Country {
    private String maQuocGia;
    private String tenQuocGia;

    public Country() {
    }

    public Country(String maQuocGia, String tenQuocGia) {
        this.maQuocGia = maQuocGia;
        this.tenQuocGia = tenQuocGia;
    }

    public String getMaQuocGia() {
        return maQuocGia;
    }

    public void setMaQuocGia(String maQuocGia) {
        this.maQuocGia = maQuocGia;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    @Override
    public String toString() {
        return "Country{" +
                "maQuocGia='" + maQuocGia + '\'' +
                ", tenQuocGia='" + tenQuocGia + '\'' +
                '}';
    }
}
