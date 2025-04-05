package model;

public class User {
    private int idUser;
    private String fullName;
    private String userName;
    private String password;
    private int status;
    private String email;
    private int maChiNhanh;
    private String phone;

    public User() {
    }

    public User(String email, String fullName, int idUser, int maChiNhanh, String password, String phone, int status, String userName) {
        this.email = email;
        this.fullName = fullName;
        this.idUser = idUser;
        this.maChiNhanh = maChiNhanh;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.userName = userName;
    }

    public User(String email, String fullName, String password, int status, String userName, int idUser, int maChiNhanh) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.status = status;
        this.userName = userName;
        this.idUser = idUser;
        this.maChiNhanh = maChiNhanh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(int maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", idUser=" + idUser +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
