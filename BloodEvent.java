package oopPTIT;

import java.util.List;

public class BloodEvent { // ThongTin_Event_Hienmau_Dangtochuc
	private String nameEvent;
	private String location;
	private String date;
	private List<Users> participants;

	BloodEvent(String nameEvent, String location, String date, List<Users> participants) {
		this.nameEvent = nameEvent;
		this.location = location;
		setDate(date);
		this.participants = participants;
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
		StringBuilder sb = new StringBuilder(date);
		if (sb.charAt(1) == '/') {
			sb.insert(0, "0");
		}
		if (sb.charAt(4) == '/') {
			sb.insert(3, "0");
		}
		this.date = date;
	}

	public List<Users> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Users> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "BloodEvent [nameEvent=" + nameEvent + ", location=" + location + ", date=" + date + ", participants="
				+ participants + "]";
	}

}
