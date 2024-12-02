package codehienmau;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame {
	private JTextField emailField;
	private JPasswordField passwordField;

	public LoginForm() {
		setTitle("Đăng nhập");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel(new GridLayout(3, 2));
		JLabel emailLabel = new JLabel("Email/Username:");
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 32));
		inputPanel.add(emailLabel);
		emailField = new JTextField();
		emailField.setFont(new Font("Arial", Font.PLAIN, 32));
		inputPanel.add(emailField);

		JLabel passwordLabel = new JLabel("Mật khẩu:");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 32));
		inputPanel.add(passwordLabel);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 32));
		inputPanel.add(passwordField);

		add(inputPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		JButton loginButton = new JButton("Đăng nhập");
		loginButton.setFont(new Font("Arial", Font.BOLD, 32));
		loginButton.setPreferredSize(new Dimension(200, 100)); // Tăng kích thước nút
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String emailOrUsername = emailField.getText();
				String password = new String(passwordField.getPassword());

				if (UserManager.loginAdmin(emailOrUsername, password)) {
					JOptionPane.showMessageDialog(null, "Đăng nhập Admin thành công!");
					dispose();
					new AdminForm();
				} else if (UserManager.loginUser(emailOrUsername, password) != null) {
					JOptionPane.showMessageDialog(null, "Đăng nhập User thành công!");
					dispose();
					new UserInfoForm();
				} else {
					JOptionPane.showMessageDialog(null, "Email hoặc mật khẩu không đúng.");
				}
			}
		});
		buttonPanel.add(loginButton);

		JButton backButton = new JButton("Trở Về");
		backButton.setFont(new Font("Arial", Font.BOLD, 32));
		backButton.setPreferredSize(new Dimension(200, 100)); // Tăng kích thước nút
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HelloForm();
			}
		});
		buttonPanel.add(backButton);

		add(buttonPanel, BorderLayout.SOUTH);

		setVisible(true);
	}
}