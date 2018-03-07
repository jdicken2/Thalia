package service;
//Service Class for Section
public class Section
{
	private int sid;
	private String section_name;
	private int price;
	
	public Section()
	{
		
	}
	
	public Section(int si, String sn, int pr)
	{
		sid=si;
		section_name=sn;
		price=pr;
	}

	public int getSid() {
		return sid;
	}

	public String getSection_name() {
		return section_name;
	}

	public int getPrice() {
		return price;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public void setPrice(int price) {
		this.price = price;
	}	
}
