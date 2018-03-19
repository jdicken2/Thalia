CS 445 Project (thalia)
Version 1.0
---------------------------------------------------------------------------------
Author and Date
---------------------------------------------------------------------------------
1. Author: Julian Dickens
2. Date: 03/18/2018

Summary
---------------------------------------------------------------------------------
This project gives students an opportunity to learn RESTful Web Servies through Object Oriented Programming. The project serves as a mock theater for a client named, Thalia. The core functionalities of the project are as follows:
1. View the seating within the theater and view changes made to seats when an order is placed, through GET requests
2. View and create shows through GET and POST requests
3. View the sections of certain shows through GET requests
4. Update a show though a PUT request
5. Request seating information through GET search queries
6. Create orders for seats and shows, and view them, through POST and GET requests.
7. View orders by date through GET search queries
8. Subscribe to receive a donation through POST requests
9. Donate tickets through POST requests
10. Check the status of subscriptions through GET requests
11. Get list of available reports and view ticket sales report, through GET requests.
12. Search for orders through a GET request

There are other functionalities that should have been implemented in the project, Some of them include:
1. More options for searching
2. More reports, such as an occupancy report 

Configuration Instructions (Linux, Ubuntu 16.04)
----------------------------------------------------------------------------------
1. Install and Verify Java
 	1. $ sudo apt-get install default-jre
 	2. $ java -version

2. Install Eclipse
	1. Download Eclipse from this link:
	https://www.eclipse.org/downloads/download.php?file=/oomph/epp/mars/R2/eclipse-inst-linux64.tar.gz
	2. Unzip Eclipse
	$ unzip eclipse-inst-linux64.tar.gz
	3. Go to ~/Downloads/eclipse-installer and run the installer
	4. Choose "Eclipse IDE for Java Developers"


3. Import the project in the Eclipse Workspace
	1. File->Import->Existing Projects
	2. Select thalia from the Downloads

4. Create a Server
	1. Right Click in the Server window and create a "Apache Tomcat v7.0 Server"
	2. Add thalia to the server by right clicking it and select "Add or Remove"

Deploy Instructions 
----------------------------------------------------------------------------------
Functional Tests:
1. Start the Tomcat Server
2. cd into the directory "CS 445 Project Test"
3. Type python run-test.py in the command line.
4. The project should pass all tests except for test 21, resulting in a score of 32/33.

Unit Tests:
1. Go to Eclipse, Run the Project as a Java Application
2. To display coverage, go to Eclipse, and choose "Coverage As"

Known Bugs
---------------------------------------------------------------------------------
1. The project does not indicate if a seat has been sold if the seat is not the first row (causing test 21 to fail).
2. The orders are not accurate beyond oid 413.
3. There are no Theatre Occupancy or Donated tickets reports
4. Make test does not run the TestRunner, despite it being in the same folder as the TestRunner class.
5. Requesting seating information only works for rows that only have 4 seats or less. If it has more, the program will assume it only has 4 seats in that row. Therefore, a patron cannot request for 5 or more contiguous seats, in a row that has 5 or seats. 

Credits and Acknowledgements
----------------------------------------------------------------------------------
Credits:
1. Functional Testing Script
	1. Author: Ying Chen
	2. Bug Fixes: Danna Liu 
	3. Slight Changes to accoomodate this project: Julian Dickens 
2. Acknoledgements:
	1. Virgil Bistriceanu for creating the original concept of the project 
	2. Koushik Kothagal of Java Brains for providing a tutorial on RESTful Web Services in Java, using Jersey/JAX-RS







