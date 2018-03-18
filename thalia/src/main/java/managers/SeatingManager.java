package managers;
import java.util.*;
import database.DatabaseClass;
import service.*;
//Manager for Seats
//Creates initial seating in the theater
//Some not best practice, such as show manager being used instead of show boundary interface
public class SeatingManager implements seatingBoundaryInterface{
	//Various hashmaps, Seating, and FirstInitialSeating to be used later in the program 
	public Map<Integer, InitialSeating> initialSeating=DatabaseClass.getInitialSeating();
	public Map<InitialSeating, ArrayList <service.Seating>> seating=DatabaseClass.getSeating();
	public Map<Integer, FirstInitialSeating> firstInitialSeating=DatabaseClass.getFirstInitialSeating();
	public Map<Integer, specificInitialSeating> specificInitialSeating=DatabaseClass.getSpecificInitialSeating();
	public Map<Integer, Show> shows=DatabaseClass.getShow();
	public Map<Integer, Section> sections=DatabaseClass.getSections();
	ShowManager sm=new ShowManager();
	
	public service.Seating firstSeat1=new service.Seating();
	public service.Seating secondSeat1=new service.Seating();
	public service.Seating thirdSeat1=new service.Seating();
	public service.Seating fourthSeat1=new service.Seating();

	public differentSeating.Seating specificFirstSeat1=new differentSeating.Seating();
	public differentSeating.Seating specificFirstSeat3=new differentSeating.Seating();
	public differentSeating.Seating specificFirstSeat4=new differentSeating.Seating();
	public differentSeating.Seating specificFirstSeat5=new differentSeating.Seating();
	public differentSeating.Seating specificFirstSeat6=new differentSeating.Seating();
	
	private FirstInitialSeating fse1=new FirstInitialSeating();
	private FirstInitialSeating fse2=new FirstInitialSeating();
	private FirstInitialSeating fse3=new FirstInitialSeating();
	private FirstInitialSeating fse4=new FirstInitialSeating();
	private FirstInitialSeating fse5=new FirstInitialSeating();
	private FirstInitialSeating fse6=new FirstInitialSeating();
	
	  
	ArrayList <differentSeating.Seating> specificSeating1=new ArrayList<differentSeating.Seating>();
	ArrayList <differentSeating.Seating> specificSeating2=new ArrayList<differentSeating.Seating>();
	ArrayList <differentSeating.Seating> specificSeating3=new ArrayList<differentSeating.Seating>();
	ArrayList <differentSeating.Seating> specificSeating4=new ArrayList<differentSeating.Seating>();
	ArrayList <differentSeating.Seating> specificSeating5=new ArrayList<differentSeating.Seating>();
	ArrayList <differentSeating.Seating> specificSeating6=new ArrayList<differentSeating.Seating>();
	ArrayList <service.Seating> seating1=new ArrayList<service.Seating>();
	ArrayList <service.Seating> seating2=new ArrayList<service.Seating>();
	ArrayList <service.Seating> seating3=new ArrayList<service.Seating>();
	ArrayList <service.Seating> seating4=new ArrayList<service.Seating>();
	ArrayList <service.Seating> seating5=new ArrayList<service.Seating>();
	ArrayList <service.Seating> seating6=new ArrayList<service.Seating>();
	
	public SeatingManager()
	{
		
	}
	
	//Makes the detailed seating if the user would like to view  
	@Override
	public void makeSeating()
	{	
				//123 Front Right
				//Row 1
				Seats seat1=new Seats(201, "1", "available");
				Seats seat2=new Seats(202, "2", "available");
				Seats seat3=new Seats(203, "3", "available");
				Seats seat4=new Seats(204, "4", "available");
			
				
				ArrayList <Integer> specificSeat1=new ArrayList <Integer>();
				specificSeat1.add(1);
				specificSeat1.add(2);
				specificSeat1.add(3);
				specificSeat1.add(4);
				
				
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
				
				//124
				//Row 1
				Seats seat17=new Seats(205, "5", "available");
				Seats seat18=new Seats(206, "6", "available");
				Seats seat19=new Seats(207, "7", "available");
				Seats seat20=new Seats(208, "8", "available");
				
				ArrayList <Integer> specificSeat2=new ArrayList <Integer>();
				specificSeat2.add(5);
				specificSeat2.add(6);
				specificSeat2.add(7);
				specificSeat2.add(8);
				
				//Row 2
				Seats seat21=new Seats(217, "5", "available");
				Seats seat22=new Seats(218, "6", "available");
				Seats seat23=new Seats(219, "7", "available");
				Seats seat24=new Seats(220, "8", "available");
				
				//Uses specificSeat2
				
				//Row 3
				Seats seat25=new Seats(229, "5", "available");
				Seats seat26=new Seats(230, "6", "available");
				Seats seat27=new Seats(231, "7", "available");
				Seats seat28=new Seats(232, "8", "available");
				Seats seat29=new Seats(233, "9", "available");
				//Use specificSeat3
				ArrayList <Integer> specificSeat3=new ArrayList <Integer>();
				specificSeat3.add(5);
				specificSeat3.add(6);
				specificSeat3.add(7);
				specificSeat3.add(8);
				specificSeat3.add(9);
				
				
				//Row 4
				Seats seat30=new Seats(242, "5", "available");
				Seats seat31=new Seats(243, "6", "available");
				Seats seat32=new Seats(244, "7", "available");
				Seats seat33=new Seats(245, "8", "available");
				Seats seat34=new Seats(246, "9", "available");
				Seats seat35=new Seats(247, "10", "available");
				ArrayList <Integer> specificSeat4=new ArrayList <Integer>();
				specificSeat4.add(5);
				specificSeat4.add(6);
				specificSeat4.add(7);
				specificSeat4.add(8);
				specificSeat4.add(9);
				specificSeat4.add(10);
				
				//125
				//Row 1
				Seats seat36=new Seats(209, "9", "available");
				Seats seat37=new Seats(210, "10", "available");
				Seats seat38=new Seats(211, "11", "available");
				Seats seat39=new Seats(212, "12", "available");
				
				ArrayList <Integer> specificSeat5=new ArrayList <Integer>();
				specificSeat5.add(9);
				specificSeat5.add(10);
				specificSeat5.add(11);
				specificSeat5.add(12);
				
				
				//Row 2
				Seats seat40=new Seats(221, "9", "available");
				Seats seat41=new Seats(222, "10", "available");
				Seats seat42=new Seats(223, "11", "available");
				Seats seat43=new Seats(224, "12", "available");
				//Same as specificSeat5
				
				//Row 3
				Seats seat44=new Seats(234, "10", "available");
				Seats seat45=new Seats(235, "11", "available");
				Seats seat46=new Seats(236, "12", "available");
				Seats seat47=new Seats(237, "13", "available");
				ArrayList <Integer> specificSeat6=new ArrayList <Integer>();
				specificSeat6.add(10);
				specificSeat6.add(11);
				specificSeat6.add(12);
				specificSeat6.add(13);
				
				//Row 4
				Seats seat48=new Seats(248, "11", "available");
				Seats seat49=new Seats(249, "12", "available");
				Seats seat50=new Seats(250, "13", "available");
				Seats seat51=new Seats(251, "14", "available");
				ArrayList <Integer> specificSeat7=new ArrayList <Integer>();
				specificSeat7.add(11);
				specificSeat7.add(12);
				specificSeat7.add(13);
				specificSeat7.add(14);
				
				//126
				//Row 5
				Seats seat52=new Seats(252, "1", "available");
				Seats seat53=new Seats(253, "2", "available");
				Seats seat54=new Seats(254, "3", "available");
				Seats seat55=new Seats(255, "4", "available");
				Seats seat56=new Seats(256, "5", "available");
				ArrayList <Integer> specificSeat8=new ArrayList <Integer>();
				specificSeat8.add(1);
				specificSeat8.add(2);
				specificSeat8.add(3);
				specificSeat8.add(4);
				specificSeat8.add(5);
				
				//Row 6
				Seats seat57=new Seats(268, "1", "available");
				Seats seat58=new Seats(269, "2", "available");
				Seats seat59=new Seats(270, "3", "available");
				Seats seat60=new Seats(271, "4", "available");
				Seats seat61=new Seats(272, "5", "available");
				//Same as Specific Seat 8
				
				
				//Row 7
				Seats seat62=new Seats(285, "1", "available");
				Seats seat63=new Seats(286, "2", "available");
				Seats seat64=new Seats(287, "3", "available");
				Seats seat65=new Seats(288, "4", "available");
				Seats seat66=new Seats(289, "5", "available");
				//Same as Specific Seat 8
				
				
				//127
				//Row 5
				Seats seat67=new Seats(257, "6", "available");
				Seats seat68=new Seats(258, "7", "available");
				Seats seat69=new Seats(259, "8", "available");
				Seats seat70=new Seats(260, "9", "available");
				Seats seat71=new Seats(261, "10", "available");
				Seats seat72=new Seats(262, "11", "available");
				ArrayList <Integer> specificSeat9=new ArrayList <Integer>();
				specificSeat9.add(6);
				specificSeat9.add(7);
				specificSeat9.add(8);
				specificSeat9.add(9);
				specificSeat9.add(10);
				specificSeat9.add(11);
				
				//Row 6
				Seats seat73=new Seats(273, "6", "available");
				Seats seat74=new Seats(274, "7", "available");
				Seats seat75=new Seats(275, "8", "available");
				Seats seat76=new Seats(276, "9", "available");
				Seats seat77=new Seats(277, "10", "available");
				Seats seat78=new Seats(278, "11", "available");
				Seats seat79=new Seats(279, "12", "available");
				ArrayList <Integer> specificSeat10=new ArrayList <Integer>();
				specificSeat10.add(6);
				specificSeat10.add(7);
				specificSeat10.add(8);
				specificSeat10.add(9);
				specificSeat10.add(10);
				specificSeat10.add(11);
				specificSeat10.add(12);
				
				//Row 7
				Seats seat80=new Seats(290, "6", "available");
				Seats seat81=new Seats(291, "7", "available");
				Seats seat82=new Seats(292, "8", "available");
				Seats seat83=new Seats(293, "9", "available");
				Seats seat84=new Seats(294, "10", "available");
				Seats seat85=new Seats(295, "11", "available");
				Seats seat86=new Seats(296, "12", "available");
				Seats seat87=new Seats(297, "13", "available");
				ArrayList <Integer> specificSeat11=new ArrayList <Integer>();
				specificSeat11.add(6);
				specificSeat11.add(7);
				specificSeat11.add(8);
				specificSeat11.add(9);
				specificSeat11.add(10);
				specificSeat11.add(11);
				specificSeat11.add(12);
				specificSeat11.add(13);
				
				//128
				//Row 5
				Seats seat88=new Seats(263, "12", "available");
				Seats seat89=new Seats(264, "13", "available");
				Seats seat90=new Seats(265, "14", "available");
				Seats seat91=new Seats(266, "15", "available");
				Seats seat92=new Seats(267, "16", "available");
				ArrayList <Integer> specificSeat12=new ArrayList <Integer>();
				specificSeat12.add(12);
				specificSeat12.add(13);
				specificSeat12.add(14);
				specificSeat12.add(15);
				specificSeat12.add(16);
				
				//Row 6
				Seats seat93=new Seats(280, "13", "available");
				Seats seat94=new Seats(281, "14", "available");
				Seats seat95=new Seats(282, "15", "available");
				Seats seat96=new Seats(283, "16", "available");
				Seats seat97=new Seats(282, "17", "available");
				ArrayList <Integer> specificSeat13=new ArrayList <Integer>();
				specificSeat13.add(13);
				specificSeat13.add(14);
				specificSeat13.add(14);
				specificSeat13.add(16);
				specificSeat13.add(17);
				
				//Row 7
				Seats seat98=new Seats(298, "14", "available");
				Seats seat99=new Seats(299, "15", "available");
				Seats seat100=new Seats(300, "16", "available");
				Seats seat101=new Seats(301, "17", "available");
				Seats seat102=new Seats(302, "18", "available");
				ArrayList <Integer> specificSeat14=new ArrayList <Integer>();
				specificSeat14.add(14);
				specificSeat14.add(15);
				specificSeat14.add(16);
				specificSeat14.add(17);
				specificSeat14.add(18);
				
				
				
				//123
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
				
				//124
				ArrayList <Seats> seats5=new ArrayList<Seats>();
				seats5.add(seat17);
				seats5.add(seat18);
				seats5.add(seat19);
				seats5.add(seat20);
				
				ArrayList <Seats> seats6=new ArrayList<Seats>();
				seats6.add(seat21);
				seats6.add(seat22);
				seats6.add(seat23);
				seats6.add(seat24);
				
				ArrayList <Seats> seats7=new ArrayList<Seats>();
				seats7.add(seat25);
				seats7.add(seat26);
				seats7.add(seat27);
				seats7.add(seat28);
				seats7.add(seat29);
				
				ArrayList <Seats> seats8=new ArrayList<Seats>();
				seats8.add(seat30);
				seats8.add(seat31);
				seats8.add(seat32);
				seats8.add(seat33);
				seats8.add(seat34);
				seats8.add(seat35);
				
				//125
				ArrayList <Seats> seats9=new ArrayList<Seats>();
				seats9.add(seat36);
				seats9.add(seat37);
				seats9.add(seat38);
				seats9.add(seat39);
				
				ArrayList <Seats> seats10=new ArrayList<Seats>();
				seats10.add(seat40);
				seats10.add(seat41);
				seats10.add(seat42);
				seats10.add(seat43);
				
				ArrayList <Seats> seats11=new ArrayList<Seats>();
				seats11.add(seat44);
				seats11.add(seat45);
				seats11.add(seat46);
				seats11.add(seat47);
				
				ArrayList <Seats> seats12=new ArrayList<Seats>();
				seats12.add(seat48);
				seats12.add(seat49);
				seats12.add(seat50);
				seats12.add(seat51);
				
				//126
				ArrayList <Seats> seats13=new ArrayList<Seats>();
				seats13.add(seat52);
				seats13.add(seat53);
				seats13.add(seat54);
				seats13.add(seat55);
				seats13.add(seat56);
				
				ArrayList <Seats> seats14=new ArrayList<Seats>();
				seats14.add(seat57);
				seats14.add(seat58);
				seats14.add(seat59);
				seats14.add(seat60);
				seats14.add(seat61);
				
				ArrayList <Seats> seats15=new ArrayList<Seats>();
				seats15.add(seat62);
				seats15.add(seat63);
				seats15.add(seat64);
				seats15.add(seat65);
				seats15.add(seat66);
				
				//127
				ArrayList <Seats> seats16=new ArrayList<Seats>();
				seats16.add(seat67);
				seats16.add(seat68);
				seats16.add(seat69);
				seats16.add(seat70);
				seats16.add(seat71);
				seats16.add(seat72);
				
			
				ArrayList <Seats> seats17=new ArrayList<Seats>();
				seats17.add(seat73);
				seats17.add(seat74);
				seats17.add(seat75);
				seats17.add(seat76);
				seats17.add(seat77);
				seats17.add(seat78);
				seats17.add(seat79);
				
				ArrayList <Seats> seats18=new ArrayList<Seats>();
				seats18.add(seat80);
				seats18.add(seat81);
				seats18.add(seat82);
				seats18.add(seat83);
				seats18.add(seat84);
				seats18.add(seat85);
				seats18.add(seat86);
				seats18.add(seat87);
				
				//128
				ArrayList <Seats> seats19=new ArrayList<Seats>();
				seats19.add(seat88);
				seats19.add(seat89);
				seats19.add(seat90);
				seats19.add(seat91);
				seats19.add(seat92);
				
				ArrayList <Seats> seats20=new ArrayList<Seats>();
				seats20.add(seat93);
				seats20.add(seat94);
				seats20.add(seat95);
				seats20.add(seat96);
				seats20.add(seat97);
				
				ArrayList <Seats> seats21=new ArrayList<Seats>();
				seats21.add(seat98);
				seats21.add(seat99);
				seats21.add(seat100);
				seats21.add(seat101);
				seats21.add(seat102);
				
				//123
				service.Seating firstSeat1=new service.Seating(1, seats1);
				service.Seating secondSeat1=new service.Seating(2, seats2);
				service.Seating thirdSeat1=new service.Seating(3, seats3);
				service.Seating fourthSeat1=new service.Seating(4, seats4);
				
				differentSeating.Seating specificFirstSeat1=new differentSeating.Seating(1, specificSeat1);
				differentSeating.Seating specificSecondSeat1=new differentSeating.Seating(2, specificSeat1);
				differentSeating.Seating specificThirdSeat1=new differentSeating.Seating(3, specificSeat1);
				differentSeating.Seating specificFourthSeat1=new differentSeating.Seating(4, specificSeat1);
				
				//124
				service.Seating firstSeat2=new service.Seating(1, seats5);
				service.Seating secondSeat2=new service.Seating(2, seats6);
				service.Seating thirdSeat2=new service.Seating(3, seats7);
				service.Seating fourthSeat2=new service.Seating(4, seats8);
				
				
				differentSeating.Seating specificFirstSeat2=new differentSeating.Seating(1, specificSeat2);
				differentSeating.Seating specificSecondSeat2=new differentSeating.Seating(2, specificSeat2);
				differentSeating.Seating specificThirdSeat2=new differentSeating.Seating(3, specificSeat3);
				differentSeating.Seating specificFourthSeat2=new differentSeating.Seating(4, specificSeat4);
				
				
				//125
				service.Seating firstSeat3=new service.Seating(1, seats9);
				service.Seating secondSeat3=new service.Seating(2, seats10);
				service.Seating thirdSeat3=new service.Seating(3, seats11);
				service.Seating fourthSeat3=new service.Seating(4, seats12);
				
				differentSeating.Seating specificFirstSeat3=new differentSeating.Seating(1, specificSeat5);
				differentSeating.Seating specificSecondSeat3=new differentSeating.Seating(2, specificSeat5);
				differentSeating.Seating specificThirdSeat3=new differentSeating.Seating(3, specificSeat6);
				differentSeating.Seating specificFourthSeat3=new differentSeating.Seating(4, specificSeat7);
				
				//126
				service.Seating firstSeat4=new service.Seating(5, seats13);
				service.Seating secondSeat4=new service.Seating(6, seats14);
				service.Seating thirdSeat4=new service.Seating(7, seats15);
				
				differentSeating.Seating specificFirstSeat4=new differentSeating.Seating(5, specificSeat8);
				differentSeating.Seating specificSecondSeat4=new differentSeating.Seating(6, specificSeat8);
				differentSeating.Seating specificThirdSeat4=new differentSeating.Seating(7, specificSeat8);
				
				//127
				service.Seating firstSeat5=new service.Seating(5, seats16);
				service.Seating secondSeat5=new service.Seating(6, seats17);
				service.Seating thirdSeat5=new service.Seating(7, seats18);
				
				differentSeating.Seating specificFirstSeat5=new differentSeating.Seating(5, specificSeat9);
				differentSeating.Seating specificSecondSeat5=new differentSeating.Seating(6, specificSeat10);
				differentSeating.Seating specificThirdSeat5=new differentSeating.Seating(7, specificSeat11);
				
				//128
				service.Seating firstSeat6=new service.Seating(5, seats19);
				service.Seating secondSeat6=new service.Seating(6, seats20);
				service.Seating thirdSeat6=new service.Seating(7, seats21);
				
				differentSeating.Seating specificFirstSeat6=new differentSeating.Seating(5, specificSeat12);
				differentSeating.Seating specificSecondSeat6=new differentSeating.Seating(6, specificSeat13);
				differentSeating.Seating specificThirdSeat6=new differentSeating.Seating(7, specificSeat14);
				
				//123
				seating1.add(firstSeat1);
				seating1.add(secondSeat1);
				seating1.add(thirdSeat1);
				seating1.add(fourthSeat1);
				
				//124
				seating2.add(firstSeat2);
				seating2.add(secondSeat2);
				seating2.add(thirdSeat2);
				seating2.add(fourthSeat2);
				
				
				//125
				seating3.add(firstSeat3);
				seating3.add(secondSeat3);
				seating3.add(thirdSeat3);
				seating3.add(fourthSeat3);
				
				//126
				seating4.add(firstSeat4);
				seating4.add(secondSeat4);
				seating4.add(thirdSeat4);
				
				//127
				seating5.add(firstSeat5);
				seating5.add(secondSeat5);
				seating5.add(thirdSeat5);
				
				//128
				seating6.add(firstSeat6);
				seating6.add(secondSeat6);
				seating6.add(thirdSeat6);
				
				//123
				specificSeating1.add(specificFirstSeat1);
				specificSeating1.add(specificSecondSeat1);
				specificSeating1.add(specificThirdSeat1);
				specificSeating1.add(specificFourthSeat1);
				
				//124
				specificSeating2.add(specificFirstSeat2);
				specificSeating2.add(specificSecondSeat2);
				specificSeating2.add(specificThirdSeat2);
				specificSeating2.add(specificFourthSeat2);
				
				//125
				specificSeating3.add(specificFirstSeat3);
				specificSeating3.add(specificSecondSeat3);
				specificSeating3.add(specificThirdSeat3);
				specificSeating3.add(specificFourthSeat3);
				
				//126
				specificSeating4.add(specificFirstSeat4);
				specificSeating4.add(specificSecondSeat4);
				specificSeating4.add(specificThirdSeat4);
				
				//127
				specificSeating5.add(specificFirstSeat5);
				specificSeating5.add(specificSecondSeat5);
				specificSeating5.add(specificThirdSeat5);
			
				//128
				specificSeating6.add(specificFirstSeat6);
				specificSeating6.add(specificSecondSeat6);
				specificSeating6.add(specificThirdSeat6);
				
				
				
				
				fse1=new FirstInitialSeating(123, "Front right");
				specificInitialSeating specInitSeat1=new specificInitialSeating(fse1.getSid(),fse1.getSection_name(), specificSeating1);
				
				fse2=new FirstInitialSeating(124, "Front center");
				specificInitialSeating specInitSeat2=new specificInitialSeating(fse2.getSid(), fse2.getSection_name(), specificSeating2);
				

				fse3=new FirstInitialSeating(125, "Front left");
				specificInitialSeating specInitSeat3=new specificInitialSeating(fse3.getSid(), fse3.getSection_name(),specificSeating3);
				

				fse4=new FirstInitialSeating(126, "Main right");
				specificInitialSeating specInitSeat4=new specificInitialSeating(fse4.getSid(), fse4.getSection_name(), specificSeating4);
				
				
				ArrayList <service.Seating> seating5=new ArrayList<service.Seating>();
				seating5.add(firstSeat5);
				seating5.add(secondSeat5);
				seating5.add(thirdSeat5);
				fse5=new FirstInitialSeating(127, "Main center");
			
				specificInitialSeating specInitSeat5=new specificInitialSeating(fse5.getSid(), fse5.getSection_name(),specificSeating5);
			
				
				fse6=new FirstInitialSeating(128, "Main left");
				specificInitialSeating specInitSeat6=new specificInitialSeating(fse6.getSid(), fse6.getSection_name(), specificSeating6);
				
		
				firstInitialSeating.put(fse1.getSid(), fse1);
				firstInitialSeating.put(fse2.getSid(), fse2);
				firstInitialSeating.put(fse3.getSid(), fse3);
				firstInitialSeating.put(fse4.getSid(), fse4);
				firstInitialSeating.put(fse5.getSid(), fse5);
				firstInitialSeating.put(fse6.getSid(), fse6);
				
				
				
				specificInitialSeating.put(specInitSeat1.getSid(), specInitSeat1);
				specificInitialSeating.put(specInitSeat2.getSid(), specInitSeat2);
				specificInitialSeating.put(specInitSeat3.getSid(), specInitSeat3);
				specificInitialSeating.put(specInitSeat4.getSid(), specInitSeat4);
				specificInitialSeating.put(specInitSeat5.getSid(), specInitSeat5);
				specificInitialSeating.put(specInitSeat6.getSid(), specInitSeat6);
	}
	
	
	//Gets all InitialSeating, used for first Functional Test
	@Override
	public List <FirstInitialSeating> getAllInitialSeating()
	{
		makeSeating();
		List <FirstInitialSeating> seatingWithSomeValues= new ArrayList<FirstInitialSeating>(firstInitialSeating.values());
		return seatingWithSomeValues;
	}
	
	//Returns DetailedSeating 
	@Override
	public void makeDetailedSeating()
	{
		makeSeating();
		int wid0=sm.getWid();
		Show_Info sh0=shows.get(sm.getWid()).getShowInfo();
		int sid0=fse1.getSid();
		String sectionName0=fse1.getSection_name();
		int price0=shows.get(sm.getWid()).getSeatingInfo().get(0).getPrice();
		InitialSeating se1=new InitialSeating(wid0, sh0, sid0, sectionName0, price0, seating1);
		initialSeating.put(fse1.getSid(), se1);
		
		int sid1=fse2.getSid();
		String sectionName1=fse2.getSection_name();
		int price1=shows.get(sm.getWid()).getSeatingInfo().get(1).getPrice();
		InitialSeating se2=new InitialSeating(wid0, sh0, sid1, sectionName1, price1, seating2);
		initialSeating.put(fse2.getSid(), se2);
		
		int sid2=fse3.getSid();
		String sectionName2=fse3.getSection_name();
		int price2=shows.get(sm.getWid()).getSeatingInfo().get(2).getPrice();
		InitialSeating se3=new InitialSeating(wid0, sh0, sid2, sectionName2, price2, seating3);
		initialSeating.put(fse3.getSid(), se3);
	}
	@Override
	public InitialSeating getInitialSeating(int id)
	{
		makeDetailedSeating();
		return initialSeating.get(id);
	}
	@Override
	public specificInitialSeating getSpecificSeating(int id)
	{
		return specificInitialSeating.get(id);
	}
}
