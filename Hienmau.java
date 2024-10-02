package oopPTIT;

import java.util.List;
import java.util.Scanner;

class BloodDonor {
	private String id;
	private String name;
	private String phoneNumber;
	private String date;
	private String bloodType;

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

	@Override
	public String toString() {
		return "BloodDonor [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", date=" + date
				+ ", bloodType=" + bloodType + "]";
	}

}

class BloodEvent {
	private int eventID;
	private String nameEvent;
	private String location;
	private String date;
	private List<BloodDonor> participants;

	BloodEvent(int eventID, String nameEvent, String location, String date, List<BloodDonor> participants) {
		this.eventID = eventID;
		this.nameEvent = nameEvent;
		this.location = location;
		this.date = date;
		this.participants = participants;
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

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getName() {
		return nameEvent;
	}

	public void setName(String name) {
		this.nameEvent = nameEvent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<BloodDonor> getParticipants() {
		return participants;
	}

	public void setParticipants(List<BloodDonor> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "BloodEvent [eventID=" + eventID + ", nameEvent=" + nameEvent + ", location=" + location + ", date="
				+ date + ", participants=" + participants + "]";
	}
}

//class 

public class Hienmau {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	}

}
