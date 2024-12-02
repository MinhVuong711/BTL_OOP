package codehienmau;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserInfoForm extends JFrame {
	private JTextField nameField;
	private JTextField dateOfBirthField;
	private JTextField bloodTypeField;
	private JTextField phoneNumberField;

	public UserInfoForm() {
		setTitle("Thông tin người dùng");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel(new GridLayout(5, 2));
		inputPanel.add(new JLabel("Tên:"));
		nameField = new JTextField();
		inputPanel.add(nameField);

		inputPanel.add(new JLabel("Ngày sinh (yyyy-mm-dd):"));
		dateOfBirthField = new JTextField();
		inputPanel.add(dateOfBirthField);

		inputPanel.add(new JLabel("Nhóm máu:"));
		bloodTypeField = new JTextField();
		inputPanel.add(bloodTypeField);

		inputPanel.add(new JLabel("Số điện thoại:"));
		phoneNumberField = new JTextField();
		inputPanel.add(phoneNumberField);

		// Vô hiệu hóa các trường nhập liệu khi khởi động
		setFieldsEditable(false);

		add(inputPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();

		JButton saveButton = new JButton("Lưu");
		saveButton.setFont(new Font("Arial", Font.BOLD, 30));
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateUser();
			}
		});
		buttonPanel.add(saveButton);

		JButton editButton = new JButton("Sửa");
		editButton.setFont(new Font("Arial", Font.BOLD, 30));
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setFieldsEditable(true);
			}
		});
		buttonPanel.add(editButton);

		JButton cancelButton = new JButton("Hủy Bỏ");
		cancelButton.setFont(new Font("Arial", Font.BOLD, 30));
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setFieldsEditable(false);
				loadUserInfo();
			}
		});
		buttonPanel.add(cancelButton);

		JButton logoutButton = new JButton("Đăng Xuất");
		logoutButton.setFont(new Font("Arial", Font.BOLD, 30));
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HelloForm();
			}
		});
		buttonPanel.add(logoutButton);

		add(buttonPanel, BorderLayout.SOUTH);

		loadUserInfo();

		setVisible(true);
	}

	private void setFieldsEditable(boolean editable) {
		nameField.setEditable(editable);
		dateOfBirthField.setEditable(editable);
		bloodTypeField.setEditable(editable);
		phoneNumberField.setEditable(editable);
	}

	private void updateUser() {
		User loggedInUser = UserManager.getLoggedInUser();
		if (loggedInUser != null) {
			if (!nameField.getText().isEmpty()) {
				loggedInUser.setName(nameField.getText());
			}
			if (!dateOfBirthField.getText().isEmpty()) {
				loggedInUser.setDateOfBirth(dateOfBirthField.getText());
			}
			if (!bloodTypeField.getText().isEmpty()) {
				loggedInUser.setBloodType(bloodTypeField.getText());
			}
			if (!phoneNumberField.getText().isEmpty()) {
				loggedInUser.setPhoneNumber(phoneNumberField.getText());
			}
			setFieldsEditable(false);
			JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!");
		}
	}

	private void loadUserInfo() {
		User loggedInUser = UserManager.getLoggedInUser();
		if (loggedInUser != null) {
			nameField.setText(loggedInUser.getName());
			dateOfBirthField.setText(loggedInUser.getDateOfBirth());
			bloodTypeField.setText(loggedInUser.getBloodType());
			phoneNumberField.setText(loggedInUser.getPhoneNumber());
		}
	}

	public static void main(String[] args) {
		new HelloForm();
	}
}
