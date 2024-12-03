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

public class RegisForm extends JFrame {
	private JTextField userIdField;
	private JTextField nameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JTextField bloodTypeField;
	private JTextField dateOfBirthField;
	private JTextField phoneNumberField;

	public RegisForm() {
		setTitle("Đăng ký");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel(new GridLayout(8, 2));
		JLabel userIdLabel = new JLabel("Mã người dùng:");
		userIdLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(userIdLabel);
		userIdField = new JTextField();
		userIdField.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(userIdField);

		JLabel nameLabel = new JLabel("Tên:");
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(nameLabel);
		nameField = new JTextField();
		nameField.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(nameField);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(emailLabel);
		emailField = new JTextField();
		emailField.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(emailField);

		JLabel passwordLabel = new JLabel("Mật khẩu:");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(passwordLabel);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(passwordField);

		JLabel bloodTypeLabel = new JLabel("Nhóm máu:");
		bloodTypeLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(bloodTypeLabel);
		bloodTypeField = new JTextField();
		bloodTypeField.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(bloodTypeField);

		JLabel dateOfBirthLabel = new JLabel("Ngày sinh (yyyy-mm-dd):");
		dateOfBirthLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(dateOfBirthLabel);
		dateOfBirthField = new JTextField();
		dateOfBirthField.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(dateOfBirthField);

		JLabel phoneNumberLabel = new JLabel("Số điện thoại:");
		phoneNumberLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(phoneNumberLabel);
		phoneNumberField = new JTextField();
		phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 30));
		inputPanel.add(phoneNumberField);

		add(inputPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		JButton registerButton = new JButton("Đăng ký");
		registerButton.setFont(new Font("Arial", Font.BOLD, 32));
		registerButton.setPreferredSize(new Dimension(200, 100)); // Tăng_kích_thước_nút
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isAnyFieldEmpty()) {
					JOptionPane.showMessageDialog(null, "Babe cần điền đủ thông tin");
				} else {
					String userId = userIdField.getText();
					String name = nameField.getText();
					String email = emailField.getText();
					String password = new String(passwordField.getPassword());
					String bloodType = bloodTypeField.getText();
					String dateOfBirth = dateOfBirthField.getText();
					String phoneNumber = phoneNumberField.getText();

					User user = new User(userId, name, email, password, bloodType, dateOfBirth, phoneNumber);
					boolean registrationSuccess = UserManager.registerUser(user);
					if (registrationSuccess) {
						dispose();
						new HelloForm();
					}
				}
			}
		});
		buttonPanel.add(registerButton);

		JButton backButton = new JButton("Trở Về");
		backButton.setFont(new Font("Arial", Font.BOLD, 32));
		backButton.setPreferredSize(new Dimension(200, 100)); // Tăng_kích_thước_nút
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

	private boolean isAnyFieldEmpty() {
		return userIdField.getText().isEmpty() || nameField.getText().isEmpty() || emailField.getText().isEmpty()
				|| passwordField.getPassword().length == 0 || bloodTypeField.getText().isEmpty()
				|| dateOfBirthField.getText().isEmpty() || phoneNumberField.getText().isEmpty();
	}

	public static void main(String[] args) {
		UserManager.loadUsersFromFile();
		new RegisForm();
	}
}
