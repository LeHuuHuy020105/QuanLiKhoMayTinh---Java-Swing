package model;

public class User {
    private int idUser;
    private String fullName;
    private String userName;
    private String password;
    private String role;
    private int status;
    private String email;

    public User() {
    }

    public User(String email, String fullName, String password, String role, int status, String userName,int idUser) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
        this.status = status;
        this.userName = userName;
        this.idUser = idUser;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
                ", role='" + role + '\'' +
                ", status=" + status +
                '}';
    }
}
