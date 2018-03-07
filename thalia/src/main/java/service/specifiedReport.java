package service;
//Service Class for specified Report 
public class specifiedReport {
	private int mrid;
	private String name; 
	
	public specifiedReport()
	{
		
	}
	
	public specifiedReport(int mr, String na)
	{
		mrid=mr;
		name=na;
	}
	
	public int getMrid() {
		return mrid;
	}

	public String getName() {
		return name;
	}

	public void setMrid(int mrid) {
		this.mrid = mrid;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
