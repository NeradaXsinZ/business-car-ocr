package businesscardocr;

public class ContactInfo {
	private String name;
	private String emailAddress;
	private String phoneNumber;

	public ContactInfo(String name, String emailAddress, String phoneNumber) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
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

}
