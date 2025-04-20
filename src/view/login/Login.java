package view.login;

import DAO.UserDAO;
import model.User;
import view.Icon;
import view.User.Dashboard;
import view.User.QLTaiKhoanNguoiDung.ThemTaiKhoanNguoiDung;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField input_username;
    private JPasswordField input_password;
    private boolean isPasswordVisible=false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 532);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(100, 149, 237));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Icon.logo));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNewLabel.setBounds(0, 0, 470, 493);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1.setBounds(502, 118, 141, 32);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Login");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_2.setBounds(591, 35, 251, 54);
        contentPane.add(lblNewLabel_2);

        input_username = new JTextField();
        input_username.setBounds(527, 161, 402, 32);
        contentPane.add(input_username);
        input_username.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Password ");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(502, 220, 141, 32);
        contentPane.add(lblNewLabel_1_1);

        input_password = new JPasswordField();
        input_password.setBounds(527, 263, 402, 32);
        contentPane.add(input_password);

        JLabel showPass = new JLabel("");
        showPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isPasswordVisible = !isPasswordVisible;
                if (isPasswordVisible) {
                    input_password.setEchoChar((char) 0); // Show password
                    showPass.setIcon(new ImageIcon("C:\\Users\\Hoc\\IdeaProjects\\JAVA\\project\\Java\\QuanLiKhoMayTinh---Java-Swing\\src\\icon\\open_view.png"));
                } else {
                    input_password.setEchoChar('•'); // Hide password
                    showPass.setIcon(new ImageIcon("C:\\Users\\Hoc\\IdeaProjects\\JAVA\\project\\Java\\QuanLiKhoMayTinh---Java-Swing\\src\\icon\\hide_view.png"));
                }
            }
        });
        showPass.setHorizontalAlignment(SwingConstants.CENTER);
        showPass.setIcon(new ImageIcon(Icon.hiddenpassword));
        showPass.setBounds(937, 270, 44, 22);
        contentPane.add(showPass);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                LoginMouseClicked();
            }
        });
        btnNewButton.setForeground(new Color(255, 0, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(535, 347, 394, 41);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_2_1 = new JLabel("X");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2_1.setBounds(935, 11, 46, 14);
        contentPane.add(lblNewLabel_2_1);
    }

    public void LoginMouseClicked() {
        String username = input_username.getText();
        String password = new String(input_password.getPassword());
        User currentUser = null;
        try {
            currentUser = UserDAO.getInstance().getCurrentUser(username, password);
            System.out.println("cur: "+currentUser);
            if(currentUser.getStatus()==1){
                System.out.println("huyyy");
                Dashboard dashboard = new Dashboard(currentUser);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị khoá !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu của bạn bị sai !");
        }
    }
}
