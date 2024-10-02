package oopPTIT;

import java.util.Scanner;

class BloodDonor {
	private String id;
	private String name;
	private String phoneNumber;
	private String date;
	private String bloodType;

	BloodDonor() {
		this.id = "";
		this.name = "";
		this.phoneNumber = "";
		this.date = "";
		this.bloodType = "";
	}

	BloodDonor(String id, String name, String phoneNumber, String date, String bloodType) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.bloodType = bloodType;
	}

	public void chuanHoaDate() {
		StringBuilder sb = new StringBuilder(date);
		if (sb.charAt(1) == '/') {
			sb.insert(0, "0");
		}
		if (sb.charAt(4) == '/') {
			sb.insert(3, "0");
		}
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
		this.phoneNumber = phoneNumber;
	}

	public String getAge() {
		return date;
	}

	public void setAge(String date) {
		this.date = date;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

}

class BloodEvent {
	// private String
}

public class Hienmau {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	}

}
