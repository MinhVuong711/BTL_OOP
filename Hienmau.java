package oopPTIT;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

class BloodDonor { // ThongTin_Donor
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

	@Override
	public String toString() {
		return "BloodDonor [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", date=" + date
				+ ", bloodType=" + bloodType + "]";
	}

}

class BloodEvent { // ThongTin_Event_Hienmau_Dangtochuc
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

class Appointment { // Lich_Hienmau_Đã_Đặt
	private BloodDonor user;
	private LocalDateTime appointmentTime;
	private String statusAppointment;

	Appointment(BloodDonor user, LocalDateTime appointmentTime, String statusAppointment) {
		this.user = user;
		this.appointmentTime = appointmentTime;
		this.statusAppointment = statusAppointment;
	}

	public BloodDonor getUser() {
		return user;
	}

	public void setUser(BloodDonor user) {
		this.user = user;
	}

	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getStatusAppointment() {
		return statusAppointment;
	}

	public void setStatusAppointment(String statusAppointment) {
		this.statusAppointment = statusAppointment;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", user=" + user + ", appointmentTime=" + appointmentTime
				+ ", statusAppointment=" + statusAppointment + "]";
	}
}

class DonationHistory { // Lichsu_Hienmau
	private BloodDonor donor;
	private LocalDate donationDate;
	private double amount;

	DonationHistory(BloodDonor donor, LocalDate donationDate, double amount) {
		this.donor = donor;
		this.donationDate = donationDate;
		this.amount = amount;
	}

	public BloodDonor getDonor() {
		return donor;
	}

	public void setDonor(BloodDonor donor) {
		this.donor = donor;
	}

	public LocalDate getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DonationHistory [donor=" + donor + ", donationDate=" + donationDate + ", amount=" + amount + "]";
	}
}

class Notification { // Thông_Báo_Về_Appointment_Đã_Đặt
	private BloodDonor recipient;
	private String message;
	private String time; // Thời_gian_gửi_thông_báo

	Notification(BloodDonor recipient, String message, String time) {
		this.recipient = recipient;
		this.message = message;
		this.time = time;
	}

	public void chuanHoaDate() {
		StringBuilder sb = new StringBuilder(time);
		if (sb.charAt(1) == '/') {
			sb.insert(0, "0");
		}
		if (sb.charAt(4) == '/') {
			sb.insert(3, "0");
		}
	}

	public BloodDonor getRecipient() {
		return recipient;
	}

	public void setRecipient(BloodDonor recipient) {
		this.recipient = recipient;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Notification [recipient=" + recipient + ", message=" + message + ", time=" + time + "]";
	}
}

class Admin {
	private String username;
	private String password;

	Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
}

public class Hienmau {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	}

}
