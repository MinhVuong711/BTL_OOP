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
		inputPanel.add(createLabel("Tên:"));
		nameField = createTextField();
		inputPanel.add(nameField);

		inputPanel.add(createLabel("Ngày sinh (yyyy-mm-dd):"));
		dateOfBirthField = createTextField();
		inputPanel.add(dateOfBirthField);

		inputPanel.add(createLabel("Nhóm máu:"));
		bloodTypeField = createTextField();
		inputPanel.add(bloodTypeField);

		inputPanel.add(createLabel("Số điện thoại:"));
		phoneNumberField = createTextField();
		inputPanel.add(phoneNumberField);

		// Vô_hiệu_hóa_các_trường_nhập_liệu_khi_khởi_động
		setFieldsEditable(false);

		add(inputPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();

		JButton saveButton = new JButton("Lưu");
		saveButton.setFont(new Font("Arial", Font.BOLD, 30));
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validateFields()) {
					updateUser();
				}
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

	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Arial", Font.BOLD, 21)); // Tăng_kích_thước_chữ
		return label;
	}

	private JTextField createTextField() {
		JTextField textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 21)); // Tăng_kích_thước_chữ
		return textField;
	}

	private void setFieldsEditable(boolean editable) {
		nameField.setEditable(editable);
		dateOfBirthField.setEditable(editable);
		bloodTypeField.setEditable(editable);
		phoneNumberField.setEditable(editable);
	}

	private boolean validateFields() {
		if (nameField.getText().isEmpty() || dateOfBirthField.getText().isEmpty() || bloodTypeField.getText().isEmpty()
				|| phoneNumberField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Không được để trống bất kỳ trường nào!");
			return false;
		}
		return true;
	}

	private void updateUser() {
		User loggedInUser = UserManager.getLoggedInUser();
		if (loggedInUser != null) {
			loggedInUser.setName(nameField.getText());
			loggedInUser.setDateOfBirth(dateOfBirthField.getText());
			loggedInUser.setBloodType(bloodTypeField.getText());
			loggedInUser.setPhoneNumber(phoneNumberField.getText());

			setFieldsEditable(false);
			JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!");
			User.saveUsersToFile(); // Cập_nhật_file_sau_khi_chỉnh_sửa_thông_tin
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
		UserManager.loadUsersFromFile();
		new UserInfoForm();
	}
}
