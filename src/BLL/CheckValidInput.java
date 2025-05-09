package BLL;

import DAO.BrachDAO;
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
    public static boolean checkValidPhone(String phoneNumber , String loaiTaiKhoan , int idCustomer , boolean isUpdate) {
        if (phoneNumber == null || phoneNumber.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại không được để trống!");
            return false;
        }
        String regex = phoneNumber.replaceAll("[^0-9]", "");
        if (!regex.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(jFrame,"Số điện thoại không đúng định dạng !");
            return false;
        }
        if (isUpdate) {
            String currentPhone = CustomerDAO.getInstance().getPhoneByCustomerId(idCustomer);
            if (phoneNumber.equals(currentPhone)) {
                return true; // Phone number unchanged, no need to check for duplicates
            }
        }
        boolean flag = CustomerDAO.getInstance().checkSdt(phoneNumber,loaiTaiKhoan);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại đã tồn tại!");
            return false;
        }
        return true;
    }

    public static boolean checkValidPhoneBranch(String phoneNumber, int idBranch, boolean isUpdate) {
        if (phoneNumber == null || phoneNumber.equals("null") || phoneNumber.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!");
            return false;
        }
        String regex = phoneNumber.replaceAll("[^0-9]", "");
        if (!regex.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng!");
            return false;
        }
        // Skip duplicate check for update if the phone number is unchanged
        if (isUpdate) {
            String currentPhone = BrachDAO.getInstance().getPhoneByBranchId(idBranch);
            if (phoneNumber.equals(currentPhone)) {
                return true; // Phone number unchanged, no need to check for duplicates
            }
        }
        // Check for duplicate phone number
        boolean flag = BrachDAO.getInstance().checkSdt(phoneNumber, idBranch);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại!");
            return false;
        }
        return true;
    }

    public static boolean checkValidNameBranch(String name) {
        boolean flag = BrachDAO.getInstance().checkName(name);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Tên chi nhánh đã tồn tại!");
            return false;
        }
        return true;
    }

    public static boolean checkValidPhoneProducer(String phoneNumber , String idProducer , boolean isUpdate) {
        if (phoneNumber == null || phoneNumber.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại không được để trống!");
            return false;
        }
        String regex = phoneNumber.replaceAll("[^0-9]", "");
        if (!regex.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(jFrame,"Số điện thoại không đúng định dạng !");
            return false;
        }
        if (isUpdate) {
            String currentPhone = ProducersDAO.getInstance().getPhoneByProducerId(idProducer);
            if (phoneNumber.equals(currentPhone)) {
                return true; // Phone number unchanged, no need to check for duplicates
            }
        }
        boolean flag = ProducersDAO.getInstance().checkSdt(phoneNumber);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại đã tồn tại!");
            return false;
        }
        return true;
    }
    public static boolean checkValidPhoneUser(String phoneNumber , int idUser , boolean isUpdate) {
        if (phoneNumber == null || phoneNumber.equals("null")) {
            JOptionPane.showMessageDialog(jFrame, "Số điện thoại không được để trống!");
            return false;
        }
        String regex = phoneNumber.replaceAll("[^0-9]", "");
        if (!regex.matches("^0[0-9]{9}$")) {
            JOptionPane.showMessageDialog(jFrame,"Số điện thoại không đúng định dạng !");
            return false;
        }
        if (isUpdate) {
            String currentPhone = UserDAO.getInstance().getPhoneByUserId(idUser);
            if (phoneNumber.equals(currentPhone)) {
                return true; // Phone number unchanged, no need to check for duplicates
            }
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
    public static boolean checkEmailUser(String email,int idUser , boolean isUpdate) {
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
        if (isUpdate) {
            String currentEmail = UserDAO.getInstance().getEmailByUserId(idUser);
            if (email.equals(currentEmail)) {
                return true; // Phone number unchanged, no need to check for duplicates
            }
        }
        boolean flag = UserDAO.getInstance().checkEmail(email);
        if (flag == true) {
            JOptionPane.showMessageDialog(jFrame, "Email đã tồn tại!");
            return false;
        }
        return match;
    }
}
