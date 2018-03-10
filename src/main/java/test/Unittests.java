package test;


import static org.junit.Assert.*;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Dickens.CS445Project.*;
import database.DatabaseClass;
import differentSeating.Seating;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.Map;

import managers.*;
import service.*;
import differentSeating.*;

public class Unittests {

	private ByteArrayOutputStream println=new ByteArrayOutputStream();
	private PrintStream oldSystemOut=System.out;
	
	ShowBoundaryInterface sb=new ShowManager();
	seatingBoundaryInterface seb=new SeatingManager();
	orderBoundaryInterface ob=new OrderManager();
	reportBoundaryInterface rb=new reportManager();
	donationBoundaryInterface db=new DonationManager();
	sectionBoundaryInterface secb=new SectionManager();
	searchBoundaryInterface seab=new searchManager();
	ticketBoundaryInterface tb=new TicketManager();
	
	public Map<Integer, Show> shows=DatabaseClass.getShow();
	public Map<Integer, Order> orders=DatabaseClass.getOrders();
	public Map<Integer, specificOrder> specificOrders=DatabaseClass.getSpecificOrders();
	public Map<Integer, bodyPostOrder> bodyPostOrders=DatabaseClass.getBodyPostOrders();
	public Map<Integer, Donations> donations=DatabaseClass.getDonations();
	public Map<Integer, Subscription> subscriptions=DatabaseClass.getSubsciptions();
	public Map<Integer, Section> sections=DatabaseClass.getSections();
	public ArrayList <specifiedReport> specifiedReports=DatabaseClass.getSpecifiedReports();
	public Ticket tickets=DatabaseClass.getTicket();
	private Subscription s;
	private String stringS;
	//public Map<Integer, >
	
	@Before
	public void setUpStreams()
	{
		System.setOut(new PrintStream(println));
	}
	
	@After
	public void cleanUpStreams()
	{
		System.setOut(oldSystemOut);
	}

	//Show Tests
	@Test
	public void getShowTest(){	
		
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		ArrayList <Seating_Info> seatArray=new ArrayList <Seating_Info>();
		Seating_Info seat1=new Seating_Info(123, 60);
		Seating_Info seat2=new Seating_Info(124, 75);
		Seating_Info seat3=new Seating_Info(125, 60);
		seatArray.add(seat1);
		seatArray.add(seat2);
		seatArray.add(seat3);
		Show s=new Show(308,si,seatArray);
		shows.put(308,s);
		Show returnShow=sb.getShow(308);
		assertEquals(s,returnShow);
		
	}
	@Test
	public void getShowInfoTest()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		ArrayList <Seating_Info> seatArray=new ArrayList <Seating_Info>();
		Seating_Info seat1=new Seating_Info(123, 60);
		Seating_Info seat2=new Seating_Info(124, 75);
		Seating_Info seat3=new Seating_Info(125, 60);
		seatArray.add(seat1);
		seatArray.add(seat2);
		seatArray.add(seat3);
		Show s=new Show(308,si,seatArray);
		shows.put(308,s);
		someShowInfo ssi=new someShowInfo(308, si);
		ArrayList <someShowInfo> expectedShowInfo=new ArrayList <someShowInfo>();
		expectedShowInfo.add(ssi);
		
		
		ArrayList <someShowInfo> actualShowInfo=sb.getAllShows();//shows.get(308).getShowInfo();
		
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String st=gson.toJson(expectedShowInfo);
		
		String str=gson.toJson(actualShowInfo);
		assertEquals(str, st);
	}
	
	@Test
	public void getWid()
	{
		int wid=sb.getWid();
		assertEquals(308, wid);
	}
	@Test
	public void updateShowTest()
	{
		Show_Info si1=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		ArrayList <Seating_Info> seatArray1=new ArrayList <Seating_Info>();
		Seating_Info seat4=new Seating_Info(123, 60);
		Seating_Info seat5=new Seating_Info(124, 75);
		Seating_Info seat6=new Seating_Info(125, 60);
		seatArray1.add(seat4);
		seatArray1.add(seat5);
		seatArray1.add(seat6);
		Show s1=new Show(308, si1, seatArray1);
		Show returnShow=sb.updateShow(s1);	
		assertEquals(s1,returnShow);
	}
	
	@Test
	public void updateShowFailTest()
	{
		Show_Info si1=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		ArrayList <Seating_Info> seatArray1=new ArrayList <Seating_Info>();
		Seating_Info seat4=new Seating_Info(123, 60);
		Seating_Info seat5=new Seating_Info(124, 75);
		Seating_Info seat6=new Seating_Info(125, 60);
		seatArray1.add(seat4);
		seatArray1.add(seat5);
		seatArray1.add(seat6);
		Show s1=new Show(-1, si1, seatArray1);
		Show returnShow=sb.updateShow(s1);	
		assertEquals(null, returnShow);
	}
	
	
	
	@Test
	public void addShowTest()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		ArrayList <Seating_Info> seatArray=new ArrayList <Seating_Info>();
		Seating_Info seat1=new Seating_Info(123, 60);
		Seating_Info seat2=new Seating_Info(124, 75);
		Seating_Info seat3=new Seating_Info(125, 60);
		seatArray.add(seat1);
		seatArray.add(seat2);
		seatArray.add(seat3);
		Show s=new Show(309,si,seatArray);
		Show sho=sb.addShow(s);
		assertEquals(s,sho);
	}	
	//Seating Tests
	@Test
	public void getFirstInitialSeatingTest()
	{
		FirstInitialSeating fis1=new FirstInitialSeating(123, "Front right");
		FirstInitialSeating fis2=new FirstInitialSeating(124, "Front center");
		FirstInitialSeating fis3=new FirstInitialSeating(125, "Front left");
		FirstInitialSeating fis4=new FirstInitialSeating(126, "Main right");
		FirstInitialSeating fis5=new FirstInitialSeating(127, "Main center");
		FirstInitialSeating fis6=new FirstInitialSeating(128, "Main left");
		ArrayList <FirstInitialSeating> fisArray=new ArrayList <FirstInitialSeating>();
		fisArray.add(fis6);
		fisArray.add(fis1);
		fisArray.add(fis2);
		fisArray.add(fis3);
		fisArray.add(fis4);
		fisArray.add(fis5);
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String s=gson.toJson(fisArray);
		String st=gson.toJson(seb.getAllInitialSeating());
		assertEquals(s, st);
	}
	
	@Test
	public void getDetailedInitialSeatingTest()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		//123 Front Right
		//Row 1
		Seats seat1=new Seats(201, "1", "available");
		Seats seat2=new Seats(202, "2", "available");
		Seats seat3=new Seats(203, "3", "available");
		Seats seat4=new Seats(204, "4", "available");
	
		
		/*ArrayList <Integer> specificSeat1=new ArrayList <Integer>();
		specificSeat1.add(1);
		specificSeat1.add(2);
		specificSeat1.add(3);
		specificSeat1.add(4);*/
		
		
		//Row 2
		Seats seat5=new Seats(213, "1", "available");
		Seats seat6=new Seats(214, "2", "available");
		Seats seat7=new Seats(215, "3", "available");
		Seats seat8=new Seats(216, "4", "available");
		//Same as SpecificSeat 1
		
		
		
		//Row 3
		Seats seat9=new Seats(225, "1", "available");
		Seats seat10=new Seats(226, "2", "available");
		Seats seat11=new Seats(227, "3", "available");
		Seats seat12=new Seats(228, "4", "available");
		//Same as SpecificSeat 1
		
		
		//Row 4
		Seats seat13=new Seats(238, "1", "available");
		Seats seat14=new Seats(239, "2", "available");
		Seats seat15=new Seats(240, "3", "available");
		Seats seat16=new Seats(241, "4", "available");
		//Same as SpecificSeat 1
		
		ArrayList <Seats> seats1=new ArrayList <Seats>();
		seats1.add(seat1);
		seats1.add(seat2);
		seats1.add(seat3);
		seats1.add(seat4);
		
		ArrayList <Seats> seats2=new ArrayList <Seats>();
		seats2.add(seat5);
		seats2.add(seat6);
		seats2.add(seat7);
		seats2.add(seat8);
		
		ArrayList <Seats> seats3=new ArrayList <Seats>();
		seats3.add(seat9);
		seats3.add(seat10);
		seats3.add(seat11);
		seats3.add(seat12);
		
		ArrayList <Seats> seats4=new ArrayList <Seats>();
		seats4.add(seat13);
		seats4.add(seat14);
		seats4.add(seat15);
		seats4.add(seat16);
		
		service.Seating firstSeat1=new service.Seating(1, seats1);
		service.Seating secondSeat1=new service.Seating(2, seats2);
		service.Seating thirdSeat1=new service.Seating(3, seats3);
		service.Seating fourthSeat1=new service.Seating(4, seats4);
		
		ArrayList <service.Seating> seating1=new ArrayList<service.Seating>();
		
		seating1.add(firstSeat1);
		seating1.add(secondSeat1);
		seating1.add(thirdSeat1);
		seating1.add(fourthSeat1);
		
		InitialSeating is=new InitialSeating(308,si,123,"Front right",60,seating1);
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String s=gson.toJson(is);
		String st=gson.toJson(seb.getInitialSeating(123));
		assertEquals(s,st);	
	}
	
	@Test
	public void getSeatingTest()
	{
		
				ArrayList <Integer> specificSeat1=new ArrayList <Integer>();
				specificSeat1.add(1);
				specificSeat1.add(2);
				specificSeat1.add(3);
				specificSeat1.add(4);
					
				Seating s1=new Seating(1, specificSeat1);
				Seating s2=new Seating(2, specificSeat1);
				Seating s3=new Seating(3, specificSeat1);
				Seating s4=new Seating(4, specificSeat1);
				ArrayList <Seating> sArray=new ArrayList <Seating>();
				sArray.add(s1);
				sArray.add(s2);
				sArray.add(s3);
				sArray.add(s4);
				
				specificInitialSeating se1=new specificInitialSeating(123, "Front right", sArray);
				
				
				seb.makeSeating();
				
				Gson gson=new GsonBuilder().setPrettyPrinting().create();
				
				String s=gson.toJson(se1);
				String st=gson.toJson(seb.getSpecificSeating(123));
			
				assertEquals(s,st);
	}
	
	//Order Test
	@Test
	public void getOidTest()
	{
		int oid=ob.getOid();
		assertEquals(411, oid);
	}
	
	@Test
	public void getOid2Test()
	{
		int oid2=ob.getOid2();
		assertEquals(411, oid2);
	}
	
	@Test
	public void setOidTest()
	{
		ob.setOid(411);
		assertEquals(411, ob.getOid());
	}
	
	@Test
	public void setOid2Test()
	{
		ob.setOid2(411);
		assertEquals(411, ob.getOid2());
	}
	
	@Test
	public void getBpoidTest()
	{
		int bpoid=ob.getBpoid();
		
		assertEquals(1, bpoid);
	}
	
	@Test
	public void getBpoTest()
	{
		differentSeating.seats s1=new differentSeating.seats(201, 1);
		differentSeating.seats s2=new differentSeating.seats(202, 2);
		differentSeating.seats s3=new differentSeating.seats(203, 3);
		ArrayList <differentSeating.seats> sArray=new ArrayList <differentSeating.seats>();
		sArray.add(s1);
		sArray.add(s2);
		sArray.add(s3);
		Patron_Info pi=new Patron_Info("John Doe", 
									   "123-456-7890",
									   "john.doe@example.com",
									   "123 Main ST, Anytown, IL 45678",
									   "1234567890987654",
									   "12/21");
		bodyPostOrder bpo=new bodyPostOrder(308, 123, sArray, pi);
		bodyPostOrders.put(1, bpo);
		assertEquals(bpo,ob.getBodyPostOrder(1) );
	}

	@Test
	public void getAllBpoTest()
	{
		differentSeating.seats s1=new differentSeating.seats(201, 1);
		differentSeating.seats s2=new differentSeating.seats(202, 2);
		differentSeating.seats s3=new differentSeating.seats(203, 3);
		ArrayList <differentSeating.seats> sArray=new ArrayList <differentSeating.seats>();
		sArray.add(s1);
		sArray.add(s2);
		sArray.add(s3);
		Patron_Info pi=new Patron_Info("John Doe", 
									   "123-456-7890",
									   "john.doe@example.com",
									   "123 Main ST, Anytown, IL 45678",
									   "1234567890987654",
									   "12/21");
		bodyPostOrder bpo=new bodyPostOrder(308, 123, sArray, pi);
		
		ArrayList <bodyPostOrder> bpoArray= new ArrayList <bodyPostOrder>();
		bpoArray.add(bpo);
		
		bodyPostOrders.put(1, bpo);
		assertEquals(bpoArray, ob.getAllBodyPostOrders());
	}
	@Test
	public void getOrderTest()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String realStringDate=sd.format(d);
		int orderAmount=180;
		int numberofTickets=3;
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		Order o=new Order(411, 308, si, realStringDate, orderAmount, numberofTickets,pi);
		orders.put(411, o);
		
		
		assertEquals(o, ob.getOrder(411));
	}
	
	@Test
	public void getAllOrdersTest()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String realStringDate=sd.format(d);
		int orderAmount=180;
		int numberofTickets=3;
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		Order o=new Order(411, 308, si, realStringDate, orderAmount, numberofTickets,pi);
		ArrayList <Order> oArray=new ArrayList <Order>();
		oArray.add(o);
		orders.put(411, o);
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String s=gson.toJson(oArray);
		String st=gson.toJson(ob.getAllOrders());
		assertEquals(s, st);
	}
	
	@Test
	public void getSpecificOrder()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String realStringDate=sd.format(d);
		int orderAmount=180;
		int numberofTickets=3;
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		ArrayList <Integer> tickets=new ArrayList <Integer>();
		ArrayList <Tickets> tic=new ArrayList <Tickets>();
		
		int startingTicket=729;
		for(int i=0;i<3;i++)
		{		
			Tickets tick=new Tickets();
			tickets.add(startingTicket);
			tick.setTid(startingTicket);
			tick.setStatus("open");
			tic.add(tick);
			startingTicket++;
		}
		
		specificOrder so=new specificOrder(411, 308, si, realStringDate, orderAmount, numberofTickets, pi,tic);
		specificOrders.put(411, so);
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String s=gson.toJson(so);
		String st=gson.toJson(ob.getSpecificOrder(411));
	
		assertEquals(s, st);
	}
	
	
	@Test
	public void addBodyPostOrder()
	{
		differentSeating.seats s1=new differentSeating.seats(201, 1);
		differentSeating.seats s2=new differentSeating.seats(202, 2);
		differentSeating.seats s3=new differentSeating.seats(203, 3);
		ArrayList <differentSeating.seats> sArray=new ArrayList <differentSeating.seats>();
		sArray.add(s1);
		sArray.add(s2);
		sArray.add(s3);
		Patron_Info pi=new Patron_Info("John Doe", 
									   "123-456-7890",
									   "john.doe@example.com",
									   "123 Main ST, Anytown, IL 45678",
									   "1234567890987654",
									   "12/21");
		bodyPostOrder bpo=new bodyPostOrder(308, 123, sArray, pi);
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String s=gson.toJson(bpo);
		String st=gson.toJson(ob.addBodyPostOrder(bpo));
		assertEquals(s, st);
		}
	
	
	@Test
	public void addOrderTest()
	{
		
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String realStringDate=sd.format(d);
		int orderAmount=180;
		int numberofTickets=3;
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		Order o=new Order(411, 308, si, realStringDate, orderAmount, numberofTickets,pi);
		//ob.addOrder(o);
		assertEquals(o, ob.addOrder(o));
	
	}
	
	@Test
	public void addSpecificOrderTest()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String realStringDate=sd.format(d);
		int orderAmount=180;
		int numberofTickets=3;
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		ArrayList <Integer> tickets=new ArrayList <Integer>();
		ArrayList <Tickets> tic=new ArrayList <Tickets>();
		
		int startingTicket=729;
		for(int i=0;i<3;i++)
		{		
			Tickets tick=new Tickets();
			tickets.add(startingTicket);
			tick.setTid(startingTicket);
			tick.setStatus("open");
			tic.add(tick);
			startingTicket++;
		}
		
		specificOrder so=new specificOrder(411, 308, si, realStringDate, orderAmount, numberofTickets, pi,tic);
		assertEquals(so, ob.addSpecificOrder(so));
	}
	
	@Test
	public void addPostOrder()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String realStringDate=sd.format(d);
		int orderAmount=180;
		ArrayList <Integer> tickets=new ArrayList <Integer>();
		ArrayList <Tickets> tic=new ArrayList <Tickets>();
		
		int startingTicket=729;
		for(int i=0;i<3;i++)
		{		
			Tickets tick=new Tickets();
			tickets.add(startingTicket);
			tick.setTid(startingTicket);
			tick.setStatus("open");
			tic.add(tick);
			startingTicket++;
		}
		PostOrder po=new PostOrder(411,308, si, realStringDate, orderAmount, tickets);
		assertEquals(po, ob.addPostOrder(po));
	}
	
	//Donation Tests
	@Test
	public void getSubscriptionTest()
	{
		ArrayList <Integer> tickets=new ArrayList <Integer>();	
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		Donations d=new Donations(308, 1, pi);
		
		Subscription s=new Subscription(308, d.getCount(),"pending", tickets, d.getPatron_info());
		subscriptions.put(759, s);
		
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		String str=gson.toJson(db.getSubscription(759));
		String st=gson.toJson(s);

		assertEquals(st, str);
	}
	
	@Test
	public void getAllSubscriptionsTest()
	{
		ArrayList <Integer> tickets=new ArrayList <Integer>();	
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		Donations d=new Donations(308, 1, pi);
		Subscription s=new Subscription(308, d.getCount(),"pending", tickets, d.getPatron_info());
		//subscriptions.put(759, s);
		ArrayList <Subscription> sArray=new ArrayList <Subscription>();
		sArray.add(s);
		
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String st=gson.toJson(sArray);
		String str=gson.toJson(db.getAllSubscriptions());
		assertNotEquals(st, str);
		
	}
	@Test
	public void addDonationsTest()
	{	
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		Donations d=new Donations(308, 1, pi);
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String st=gson.toJson(d);
		
		Donations don=db.addDonations(d);
		String str=gson.toJson(don);
		s=db.getSingleSubscription();
		stringS=gson.toJson(s);
		assertEquals(st, str);	
		
		
		ArrayList <Integer> tickets=new ArrayList <Integer>();
		Subscription su=new Subscription(308, 1, "pending", tickets, pi);
		su.setDid(759);
		String stringSu=gson.toJson(su);
		assertEquals(stringS, stringSu);
	}
	
	
	@Test
	public void getAllSectionsTest()
	{
		ArrayList <Section> sect= new ArrayList<Section>();

		int sid0=123;
		String sn0="Front right";
		int price0=60;
		Section se0=new Section(sid0,sn0,price0);
		sect.add(se0);
		sections.put(123, se0);
		
		
		int sid1=124;
		String sn1="Front center";
		int price1=75;
		Section se1=new Section(sid1,sn1,price1);
		sect.add(se1);
		sections.put(124, se1);
		
		int sid2=125;
		String sn2="Front left";
		int price2=60;
		Section se2=new Section(sid2,sn2,price2);
		sect.add(se2);
		sections.put(125, se2);
		
		
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String st=gson.toJson(sect);
		String str=gson.toJson(secb.getSection());
		
		assertEquals(st, str);
	}
	
	//Tests Front right Section
	@Test
	public void getFrontRightSectionTest()
	{
		int sid0=123;
		String sn0="Front right";
		int price0=60;
		Section se0=new Section(sid0,sn0,price0);
		sections.put(123, se0);
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String st=gson.toJson(se0);
		String str=gson.toJson(secb.getFromSectionDatabase(123));
		
		assertEquals(st, str);
	}
	
	//Tests to observe if another section is sufficient
	@Test
	public void getFrontLeftSectionTest()
	{
		int sid0=124;
		String sn0="Front left";
		int price0=75;
		Section se1=new Section(sid0,sn0,price0);
		sections.put(124, se1);
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String st=gson.toJson(se1);
		String str=gson.toJson(secb.getFromSectionDatabase(124));
		
		assertEquals(st, str);
	}
	
	
	
	//Report tests
	@Test
	public void allReportTest()
	{
		specifiedReport r1=new specifiedReport(801, "Theatre occupancy");
		specifiedReport r2=new specifiedReport(802, "Revenue from ticket sales");
		specifiedReport r3=new specifiedReport(803, "Donated tickets report");
		
		specifiedReports.add(r1);
		specifiedReports.add(r2);
		specifiedReports.add(r3);
		//ArrayList <specifiedReport> sr=new ArrayList <specifiedReport>();
		//sr.add(r1);
		//sr.add(r2);
		//sr.add(r3);
		
		
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String s=gson.toJson(specifiedReports);
		String st=gson.toJson(rb.getAllSpecifiedReports());
		
		
		assertEquals(s, st);
		
	}
	
	
	//Search tests
	@Test
	public void searchOrderTest()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String realStringDate=sd.format(d);
		int orderAmount=180;
		int numberofTickets=3;
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		Order o=new Order(411, 308, si, realStringDate, orderAmount, numberofTickets,pi);
		ArrayList <Order> os=new ArrayList <Order>();
		os.add(o);
		searchOrders so=new searchOrders();
		so.setOrders(os);
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String st=gson.toJson(so);
		String str=gson.toJson(seab.orderSearch(411));
		assertEquals(st, str);
	}
	
	//Ticket tests
	@Test
	public void ticketTest()
	{
		ArrayList <Integer> tic=new ArrayList<Integer>();
		tic.add(730);
		tic.add(731);
		Ticket ticke=new Ticket(tic);
	
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		String st=gson.toJson(ticke);
		
		ArrayList <Integer> tickets=new ArrayList <Integer>();	
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		Donations d=new Donations(308, 1, pi);
		
		Subscription s=new Subscription(308, d.getCount(),"pending", tickets, d.getPatron_info());
		subscriptions.put(759,s);
	
		
		
		Subscription s2=new Subscription(308, d.getCount(),"pending", tickets, d.getPatron_info());
		subscriptions.put(760,s2);
		
		
		
		String str=gson.toJson(tb.addTickets(ticke));
		
		assertEquals(st, str);
	}
	
	/*@Test
	public void conditionTicketTest()
	{
		Show_Info si=new Show_Info("King Lear", "http://www.example.com/shows/king-lear", "2017-12-05", "13:00");
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String realStringDate=sd.format(d);
		int orderAmount=180;
		int numberofTickets=3;
		Patron_Info pi=new Patron_Info("John Doe", 
				   "123-456-7890",
				   "john.doe@example.com",
				   "123 Main ST, Anytown, IL 45678",
				   "1234567890987654",
				   "12/21");
		ArrayList <Integer> tickets=new ArrayList <Integer>();
		ArrayList <Tickets> tic=new ArrayList <Tickets>();
		
		int startingTicket=729;
		for(int i=0;i<3;i++)
		{		
			Tickets tick=new Tickets();
			tickets.add(startingTicket);
			tick.setTid(startingTicket);
			tick.setStatus("open");
			tic.add(tick);
			startingTicket++;
		}
		
		Subscription s1=new Subscription(308, 1,"pending", tickets, pi);
		//subscriptions.put(759,s1);
		
		Subscription s2=new Subscription(308, 1,"pending", tickets, pi);
		//subscriptions.put(760,s2);
		
		Subscription s3=new Subscription(308, 1,"pending", tickets, pi);
		//subscriptions.put(761,s3);
		
		
		specificOrder so=new specificOrder(411, 308, si, realStringDate, orderAmount, numberofTickets, pi,tic);
		//specificOrders.put(411, so);
		ob.addSpecificOrder(so);
		
		ArrayList <Integer> tic2=new ArrayList<Integer>();
		tic2.add(729);
		tic2.add(730);
		tic2.add(731);
		Ticket ticke=new Ticket(tic2);
		tb.addTickets(ticke);
		
		int startingTicket2=729;
		ArrayList <Integer> tickets3=new ArrayList <Integer>();
		ArrayList <Tickets> tic3=new ArrayList <Tickets>();
		for(int i=0;i<3;i++)
		{		
			Tickets tick3=new Tickets();
			tickets3.add(startingTicket2);
			tick3.setTid(startingTicket2);
			tick3.setStatus("donated");
			tic3.add(tick3);
			startingTicket2++;
		}
		
		specificOrder so2=new specificOrder(411, 308, si, realStringDate, orderAmount, numberofTickets, pi,tic3);
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		String s=gson.toJson(ob.getSpecificOrder(411));
		String st=gson.toJson(so2);
		
		assertNotEquals(s, st);
	}*/
	
	
}

