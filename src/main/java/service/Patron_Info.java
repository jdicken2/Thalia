package service;
//Service Class for Patron Info
public class Patron_Info {
	private String name;
	private String phone;
	private String email;
	private String billing_address;
	private String cc_number;
	private String cc_expiration_date;
	
	public Patron_Info()
	{
		
	}
	
	public Patron_Info(String na, String ph, String e, String bi, String cc, String cc_e)
	{
		name=na;
		phone=ph;
		email=e;
		billing_address=bi;
		cc_number=cc;
		cc_expiration_date=cc;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getBilling_address() {
		return billing_address;
	}

	public String getCc_number() {
		return cc_number;
	}

	public String getCc_expiration_date() {
		return cc_expiration_date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBilling_address(String billing_address) {
		this.billing_address = billing_address;
	}

	public void setCc_number(String cc_number) {
		this.cc_number = cc_number;
	}

	public void setCc_expiration_date(String cc_expiration_date) {
		this.cc_expiration_date = cc_expiration_date;
	}
	
	
	
}
