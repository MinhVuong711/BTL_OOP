package oopPTIT;

public class Users {
	private String id;
	private String name;
	private String phoneNumber;
	private String date;
	private String bloodType;

	Users(String id, String name, String phoneNumber, String date, String bloodType) {
		this.id = id;
		this.name = name;
		setPhoneNumber(phoneNumber);
		setDate(date);
		this.bloodType = bloodType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0' && phoneNumber.matches("\\d{10}")) {
			System.out.println(phoneNumber);
		} else {
			System.out.println("INVALID phoneNumber");
		}
		this.phoneNumber = phoneNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		StringBuilder sb = new StringBuilder(date);
		if (sb.charAt(1) == '/') {
			sb.insert(0, "0");
		}
		if (sb.charAt(4) == '/') {
			sb.insert(3, "0");
		}
		this.date = date;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

}
