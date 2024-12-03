package codehienmau;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

	private static final String FILE_NAME = "nhap.txt";
	private static List<User> users = new ArrayList<>();

	public User(String userId, String name, String email, String password, String bloodType, String dateOfBirth,
			String phoneNumber) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.bloodType = bloodType;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
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

	public static List<User> getUsers() {
		return users;
	}

	public static void loadUsersFromFile() {
		users.clear();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 7) {
					User user = new User(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
					users.add(user);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveUsersToFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (User user : users) {
				writer.write(user.getUserId() + "," + user.getName() + "," + user.getEmail() + "," + user.getPassword()
						+ "," + user.getBloodType() + "," + user.getDateOfBirth() + "," + user.getPhoneNumber());
				writer.newLine();
			}
			System.out.println("Dữ liệu đã được ghi vào file " + FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void register() {
		users.add(this);
		saveUsersToFile();
	}

	public static void deleteUser(User user) {
		users.remove(user);
		saveUsersToFile();
	}

	public static User login(String email, String password) {
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public static String getFileName() {
		return FILE_NAME;
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

}
