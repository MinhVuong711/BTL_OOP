package codehienmau;

import java.util.List;

import javax.swing.JOptionPane;

public class UserManager {
	private static User loggedInUser;
	private static boolean isAdmin;

	public static boolean registerUser(User user) {
		if (isEmailTaken(user.getEmail())) {
			JOptionPane.showMessageDialog(null, "Email này đã được sử dụng rồi babe ahihi");
			return false;
		} else {
			user.register();
			JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
			return true;
		}
	}

	private static boolean isEmailTaken(String email) {
		for (User u : User.getUsers()) {
			if (u.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	public static User loginUser(String email, String password) {
		User user = User.login(email, password);
		if (user != null) {
			loggedInUser = user;
			isAdmin = false;
		}
		return user;
	}

	public static boolean loginAdmin(String username, String password) {
		if (Admin.login(username, password)) {
			isAdmin = true;
			return true;
		}
		return false;
	}

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static boolean isAdmin() {
		return isAdmin;
	}

	public static List<User> getUsers() {
		return User.getUsers();
	}

	public static void loadUsersFromFile() {
		User.loadUsersFromFile();
	}

	public static void deleteUser(User user) {
		User.deleteUser(user);
	}
}
