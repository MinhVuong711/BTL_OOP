package codehienmau;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String userId;
	private String name;
	private String email;
	private String password;
	private String bloodType;
	private String dateOfBirth;
	private String phoneNumber;

	// List người dùng đã đăng ký
	private static List<User> users = new ArrayList<>();

	User() {
	}

	User(String userId, String name, String email, String password, String bloodType, String dateOfBirth,
			String phoneNumber) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.bloodType = bloodType;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
	}

	public void register() {
		for (User user : users) {
			if (user.getEmail().equals(this.email)) {
				System.out.println("Email này đã được sử dụng.");
				return;
			}
		}
		users.add(this);
		System.out.println("Đăng ký thành công!");
	}

	public static User login(String email, String password) {
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				System.out.println("Đăng nhập thành công!");
				return user;
			}
		}
		System.out.println("Email hoặc mật khẩu không đúng.");
		return null;
	}

	public void updateProfile(String name, String email, String bloodType, String dateOfBirth, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.bloodType = bloodType;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		System.out.println("Cập nhật thông tin thành công!");
	}

	@Override
	public String toString() {
		return "User{" + "userId='" + userId + '\'' + ", name='" + name + '\'' + ", email='" + email + '\''
				+ ", bloodType='" + bloodType + '\'' + ", dateOfBirth='" + dateOfBirth + '\'' + ", phoneNumber='"
				+ phoneNumber + '\'' + '}';
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getBloodType() {
		return bloodType;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static void setUsers(List<User> users) {
		User.users = users;
	}

	public static List<User> getUsers() {
		return users;
	}
}