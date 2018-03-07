package service;
//Service Class for Show Info
public class Show_Info
{
	private String name;
	private String web;
	private String date;
	private String time;
	
	
	public Show_Info()
	{
	
	}
	
	public Show_Info(String na, String we, String da, String ti)
	{
	
		name=na;
		web=we;
		date=da;
		time=ti;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getWeb()
	{
		return web;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getTime()
	{
		return time;	
	}
	
	public void setName(String na)
	{
		name=na;
	}
	
	public void setWeb(String we)
	{
		web=we;
	}
	
	public void setDate(String da)
	{
		date=da;
	}
	public void setTime(String ti)
	{
		time=ti;
	}
}
