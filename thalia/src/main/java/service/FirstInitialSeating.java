package service;
//Seating that is first viewed in the theater
public class FirstInitialSeating {
	private int sid;
	private String section_name;
	
	public FirstInitialSeating()
	{
	
	}
	
	public FirstInitialSeating(int si, String sn)
	{
		sid=si;
		section_name=sn;
	}

	public int getSid() {
		return sid;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	
	
}
