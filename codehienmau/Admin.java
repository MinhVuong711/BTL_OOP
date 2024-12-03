package codehienmau;

public class Admin {
	private static final String adminUsername = "Poly";
	private static final String adminPassword = "longlaconcho";

	public static boolean login(String username, String password) {
		return adminUsername.equals(username) && adminPassword.equals(password);
	}

	public static void deleteUser(User user) {
		User.getUsers().remove(user);
		System.out.println("User đã bị xóa.");
	}
}
