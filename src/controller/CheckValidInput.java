package controller;

import DAO.BrandDAO;
import DAO.CustomerDAO;
import DAO.ProducersDAO;
import DAO.UserDAO;

import javax.swing.*;

public class CheckValidInput {
    private static JFrame jFrame;

    public CheckValidInput(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public static boolean kiemTraNameUser(String fullname) {
        if (fullname.trim().isEmpty() || fullname.equals("null")) {
            return false;
        }
        String regex = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s]+$";

        return fullname.matches(regex);
    }

    public static boolean checkConfirmPassword(String password, String confirmPassword) {
        if (password == null || confirmPassword == null) {
            JOptionPane.showMessageDialog(jFrame, "Mật khẩu không được để trống!");
            return false;
        }

        boolean match = password.equals(confirmPassword);

        if (!match) {
            JOptionPane.showMessageDialog(jFrame, "Mật khẩu và mật khẩu xác nhận không khớp!");
        }
        return match;
    }

    public static boolean checkEmail(String email) {
        if (email == null || email.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Email không được để trống!");
            return false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        boolean match = email.matches(emailRegex);
        if (!match) {
            JOptionPane.showMessageDialog(jFrame, "Email không đúng định dạng!");
            return false;
        }
        return match;
    }

    public static boolean checkValidAccount(String nameAccount) {
        if (nameAccount == null || nameAccount.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Tài khoản không được để trống!");
            return false;
        }
        boolean flag = CustomerDAO.getInstance().checkDataAccount(nameAccount);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Tên tài khoản đã tồn tại!");
            return false;
        }
        return true;
    }
    public static boolean checkValidPhone(String phoneNumber , String loaiTaiKhoan) {
        if (phoneNumber == null || phoneNumber.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại không được để trống!");
            return false;
        }
        String regex = phoneNumber.replaceAll("[^0-9]", "");
        if (!regex.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(jFrame,"Số điện thoại không đúng định dạng !");
            return false;
        }
        boolean flag = CustomerDAO.getInstance().checkSdt(phoneNumber,loaiTaiKhoan);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại đã tồn tại!");
            return false;
        }
        return true;
    }

    public static boolean checkValidPhoneBranch(String phoneNumber ) {
        if (phoneNumber == null || phoneNumber.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại không được để trống!");
            return false;
        }
        String regex = phoneNumber.replaceAll("[^0-9]", "");
        if (!regex.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(jFrame,"Số điện thoại không đúng định dạng !");
            return false;
        }
        boolean flag = BrandDAO.getInstance().checkSdt(phoneNumber);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại đã tồn tại!");
            return false;
        }
        return true;
    }

    public static boolean checkValidNameBranch(String name) {
        boolean flag = BrandDAO.getInstance().checkName(name);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Tên chi nhánh đã tồn tại!");
            return false;
        }
        return true;
    }

    public static boolean checkValidPhoneProducer(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại không được để trống!");
            return false;
        }
        String regex = phoneNumber.replaceAll("[^0-9]", "");
        if (!regex.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(jFrame,"Số điện thoại không đúng định dạng !");
            return false;
        }
        boolean flag = ProducersDAO.getInstance().checkSdt(phoneNumber);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại đã tồn tại!");
            return false;
        }
        return true;
    }
    public static boolean checkValidPhoneUser(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại không được để trống!");
            return false;
        }
        String regex = phoneNumber.replaceAll("[^0-9]", "");
        if (!regex.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(jFrame,"Số điện thoại không đúng định dạng !");
            return false;
        }
        boolean flag = UserDAO.getInstance().checkSdt(phoneNumber);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại đã tồn tại!");
            return false;
        }
        return true;
    }

    public static boolean checkValidAccountUser(String nameAccount) {
        if (nameAccount == null || nameAccount.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Tài khoản không được để trống!");
            return false;
        }
        boolean flag = UserDAO.getInstance().checkDataAccount(nameAccount);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Tên tài khoản đã tồn tại!");
            return false;
        }
        return true;
    }
    public static boolean checkEmailUser(String email) {
        if (email == null || email.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Email không được để trống!");
            return false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        boolean match = email.matches(emailRegex);
        if (!match) {
            JOptionPane.showMessageDialog(jFrame, "Email không đúng định dạng!");
            return false;
        }
        boolean flag = UserDAO.getInstance().checkEmail(email);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Email đã tồn tại!");
            return false;
        }
        return match;
    }

}
