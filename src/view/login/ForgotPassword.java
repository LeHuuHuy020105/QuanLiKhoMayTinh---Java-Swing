package view.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_emailForgotPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(0, 0, 603, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblForgotPassword = new JLabel("KHÔI PHỤC TÀI KHOẢN");
		lblForgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblForgotPassword.setBounds(0, 0, 497, 59);
		panel.add(lblForgotPassword);
		
		JLabel lblNewLabel = new JLabel("Nhập địa chỉ email tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 100, 204, 27);
		contentPane.add(lblNewLabel);
		
		textField_emailForgotPass = new JTextField();
		textField_emailForgotPass.setBounds(10, 137, 310, 38);
		contentPane.add(textField_emailForgotPass);
		textField_emailForgotPass.setColumns(10);
		
		JButton btn_sendEmail = new JButton("New button");
		btn_sendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_sendEmail.setBounds(342, 137, 112, 35);
		contentPane.add(btn_sendEmail);
	}
}
