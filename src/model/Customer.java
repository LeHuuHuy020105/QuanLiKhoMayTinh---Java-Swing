package model;

public class Customer {
    private int maKhachHang;
    private String userName;
    private String password;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private String fullName;

    public Customer() {
    }

    public Customer(String diaChi, String email, String fullName, int maKhachHang, String password, String soDienThoai, String userName) {
        this.diaChi = diaChi;
        this.email = email;
        this.fullName = fullName;
        this.maKhachHang = maKhachHang;
        this.password = password;
        this.soDienThoai = soDienThoai;
        this.userName = userName;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
