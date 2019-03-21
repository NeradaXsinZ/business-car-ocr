package businesscardocr;

public class ContactInfo {
	private String name;
	private String emailAddress;
	private String phoneNumber;

	public ContactInfo(String name, String phoneNumber, String emailAddress) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s%nPhone: %s%nEmail: %s", name, phoneNumber, emailAddress);
	}

}
