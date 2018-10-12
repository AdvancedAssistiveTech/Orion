import java.io.*;
import java.util.*;
public class retail {
	public static void main(String[] args) {
		int lcontrol; //Loop controller
		int mmin = 100000;
		int mmax = 999999; //Parameters for manager code generation
		int emin = 1000;
		int emax = 9999; //Parameters for employee code generation
		int arindxa[];//Array of array index to prevent reading errors
		int empnum, uinputi, arindx, expcount; //Number of registered employees, user enters numbers, array indexing value, existing product count //TODO: Show number of currently registered employees when adding new
		int empcode[], exempcode[]; //Array holding employee four digit codes, existing codes saver 4 when editing file
		int procode[], exprocode[]; //Identification code of products, existing products
		String provalue[], exprovalue[]; //Decimal for price of product, existing products (Done as string to preserve precision)
		Boolean valid = false; //To control if an input is valid
		Boolean exit = false; //Controls main running loop
		String proname[], exproname[]; //Product name, existing product name
		String empname[], empsname[], exempname[], exempsname[]; //Employee name and surname, existing for editing file
		String uinput = ""; //user input
		String indr = ""; //Selected installation drive
		File f = null; //To check if contextual file exists
		File blankfile = null; //To create blank files when needed
		Scanner sc = new Scanner(System.in);
		Scanner reader = null; // Scanner to read from files
		Formatter drivemem = null; // Installation drive memoriser
		Formatter writer = new Formatter(); //Variable to write to files
		Random cgen = new Random(); //Generates manager code
		f = new File("C:\\Orion\\impfiles\\instcomp.txt");
		if(!f.exists()) {
			f = new File("D:\\Orion\\impfiles\\instcomp.txt");
			if(!f.exists()) {
				 { //Installer chunk
						while(!valid) {
							System.out.println("Installation has not been performed. Do so now? (y, n)");
							uinput = sc.next();
							if(uinput.startsWith("y") || uinput.startsWith("Y")) {
								while(!valid) {
									 System.out.print("Please specify (c): or (d): drive: ");
									 uinput = sc.next();
									 if(uinput.equals("c") || uinput.equals("c:") || uinput.equals("C") || uinput.equals("C:")) {
										 try {
											 blankfile = new File("C:\\Orion\\impfiles\\instcomp.txt");
											 new File("C:\\Orion").mkdir();
											 System.out.println("Directory C:/Orion created successfully");
											 new File("C:\\Orion\\impfiles").mkdir();
											 System.out.println("Directory C:/Orion/impfiles created successfully");
											 try {
												 blankfile.createNewFile();
												 System.out.println("Installation verification file successfully created");
											 }
											 catch(IOException a) {
												 System.out.println("Unknown error creating installation verifier. Exiting");
												 System.exit(0);
											 }
										 }
										 catch(Exception e) {
											 System.out.println("Unknown error. Exiting");
											 System.exit(0);
										 }
										 try {
											 drivemem = new Formatter("C:\\Orion\\impfiles\\64726976650a.txt"); 
										 }
										 catch(Exception e) {
											 System.out.println("Unknown error. Exiting");
											 System.exit(0);
										 }
										 drivemem.format("%s", "c");
										 valid = true;
										 try {
											 writer = new Formatter("C:\\Orion\\impfiles\\6d616e6167657264657473.txt");
										 }
										 catch(Exception e) {
											 System.out.println("Error creating manager details file");
										 }
										 String mname, msname;
										 int mcode;
										 System.out.println("You will now confirm manegerial details");
										 System.out.print("Name: ");
										 mname = sc.next();
										 System.out.print("Surname: ");
										 msname = sc.next();
										 System.out.print("Six digit ID code: ");
										 mcode = sc.nextInt();
										 int lmcode = String.valueOf(mcode).length();
										 if(lmcode != 6) {
											 System.out.print("Invalid code. ");
											 if(lmcode < 6) {
												 System.out.println("Invalid code. Too short"); 
											 }
											 else {
												 System.out.println("Invalid code. Too long"); 
											 }
											 mcode = cgen.nextInt((mmax - mmin) + 1) + mmin;
											 System.out.println("Your manager code has been automatically generated");
										 }										 
										 writer.format("%s %s %s", mname, msname, mcode);
										 System.out.println("Details Confirmed:\nName and Surname: " + mname + " " + msname + "\nCode: " + mcode
										 		  + "\n\nPlease be sure to write this down");
										 writer.close();
									 }
									 else if(uinput.equals("d") || uinput.equals("d:") || uinput.equals("D") || uinput.equals("D:")) {
										 try {
											 blankfile = new File("D:\\Orion\\impfiles\\instcomp.txt");
											 new File("D:\\Orion").mkdir();
											 System.out.println("Directory D:/Orion created successfully");
											 new File("D:\\Orion\\impfiles").mkdir();
											 System.out.println("Directory D:/Orion/impfiles created successfully");
											 try {
												 blankfile.createNewFile();
												 System.out.println("Installation verification file successfully created");
											 }
											 catch(IOException a) {
												 System.out.println("Unknown error creating installation verifier. Exiting");
												 System.exit(0);
											 }
										 }
										 catch(Exception e) {
											 System.out.println("Unknown error. Exiting");
											 System.exit(0);
										 }
										 try {
											 drivemem = new Formatter("D:\\Orion\\impfiles\\64726976650a.txt"); 
										 }
										 catch(Exception e) {
											 System.out.println("Unknown error. Exiting");
											 System.exit(0);
										 }
										 drivemem.format("%s", "d");
										 valid = true;
										 try {
											 writer = new Formatter("D:\\Orion\\impfiles\\6d616e6167657264657473.txt");
										 }
										 catch(Exception e) {
											 System.out.println("Error creating manager details file");
										 }
										 String mname, msname;
										 int mcode;
										 System.out.println("You will now confirm manegerial details");
										 System.out.print("Name: ");
										 mname = sc.next();
										 System.out.print("Surname: ");
										 msname = sc.next();
										 System.out.print("Six digit ID code: ");
										 mcode = sc.nextInt();
										 int lmcode = String.valueOf(mcode).length(); //Converts mcode to a string in order to determine length
										 if(lmcode != 6) {
											 System.out.print("Invalid code. ");
											 if(lmcode < 6) {
												 System.out.println("Invalid code. Too short"); 
											 }
											 else {
												 System.out.println("Invalid code. Too long"); 
											 }
											 mcode = cgen.nextInt((mmax - mmin) + 1) + mmin; //Automatically generates code between parameters mmax and mmin
											 System.out.println("Your manager code has been automatically generated");
										 }										 
										 writer.format("%s %s %s", mname, msname, mcode);
										 System.out.println("Details Confirmed:\nName and Surname: " + mname + " " + msname + "\nCode: " + mcode
										 		  + "\n\nPlease be sure to write this down");
									 }
									 else {
										 System.out.println("Invalid input. Try again");
									 }
								}
							}
							else if(uinput.startsWith("n") || uinput.startsWith("N")) {
								System.out.println("Installation and therefore usage of appication will be postponed until next execution. Goodbye");
								try {
									Thread.sleep(2000);
								} 
								catch (InterruptedException e) {
								}
								System.exit(0);
							}
					}
					drivemem.close();
					}
		}
		}
		try{//After verification of installation, this reads the selected installation drive
			reader = new Scanner(new File("C:\\Orion\\impfiles\\64726976650a.txt"));
		} 
		catch(Exception e) {
			try{
				reader = new Scanner(new File("D:\\Orion\\impfiles\\64726976650a.txt"));
			}
			catch(Exception e1) {
				System.out.println("Fatal error. DIDF not found"); //Drive identification file
				System.exit(0);
			}
		}
		while(reader.hasNext()) {
			indr = reader.next(); //Reading selected installation drive
		}
		if(indr.equals("c")) {
			try {
				f = new File("C:\\Orion\\impfiles\\6d616e6167657264657473.txt");
			}
			catch(Exception e) { 
				System.out.println("Error retrieving manager details");
			}
		}
		else {
			try {
				f = new File("D:\\Orion\\impfiles\\6d616e6167657264657473.txt");
			}
			catch(Exception e) {
				System.out.println("Error retrieving manager details. Line 201");
			}
		}
		if(!f.exists()) {
			System.out.println("Managerial details file not found. Please uninstall and reinstall apllication");
			System.exit(0);
		}
		if(indr.equals("c")) {
			try {
				f = new File("C:\\Orion\\impfiles\\666972737472756e.txt");
			}
			catch(Exception e) {
				System.out.println("Unknown error. Line 213");
				System.exit(0);
			}
		}
		else {
			try {
				f = new File("D:\\Orion\\impfiles\\666972737472756e.txt");
			}
			catch(Exception e) {
				System.out.println("Unknown error. Line 222");
				System.exit(0);
			}
		}
			System.out.println("Initialising Assistant");
			System.out.println("\r\n" + 
					"   ____       _           \r\n" + 
					"  / __ \\_____(_)___  ____ \r\n" + 
					" / / / / ___/ / __ \\/ __ \\\r\n" + 
					"/ /_/ / /  / / /_/ / / / /\r\n" + 
					"\\____/_/  /_/\\____/_/ /_/  (2018, installed on drive " + indr + ":)" + "\r\n" + 
					"                          \r\n" + 
					"");
			System.out.print("Orion Retail Assistant is ready");
			if(!f.exists()) {
				System.out.println(". First time operation detected. Recommended actions are as follows:");
				System.out.println("1. Utilise the first functionality and register your employees first" + "\n" // Add in tips for new users here
				+ "2. Under the same functionality, register your stock and its associated selling price" + "\n"
				+ ""); 
			}
			else {
				System.out.println(". Welcome back");
			}
			while(!exit) {
				System.out.println("1. Register ancillaries" + "\n" +
								   "2. Resave and view exisisting info" + "\n" + //TODO: Allow user to specify backup directory
								   "3. Perform a sale" + "\n" +
								   "4. Exit"); //First screen user sees after starting confirmed installation
				uinputi = sc.nextInt();
				if(uinputi == 1) {
					uinputi = 0;
					System.out.println("1. Staff" + "\n" 
									 + "2. Stock");
					uinputi = sc.nextInt();
					if(uinputi == 1) {
						uinputi = 0;
						System.out.println("How many employees are you registering?");
						int ecount = sc.nextInt(); //^^
						int execount = 0; //Existing employee count
						arindx = 0;
						empname = new String[ecount];
						empsname = new String[ecount];
						empcode = new int[ecount];
						int lempcode; //Length of employee code
						for(lcontrol = 0; lcontrol < ecount; lcontrol++) {
							System.out.print("Employee Name: ");
							empname[lcontrol] = sc.next();
							System.out.print("Employee Surname: ");
							empsname[lcontrol] = sc.next();
							System.out.print("Four Digit ID Code: ");
							empcode[lcontrol] = sc.nextInt();
							lempcode = String.valueOf(empcode[lcontrol]).length();
							if(lempcode != 4) {
								empcode[lcontrol] = cgen.nextInt((emax - emin) + 1) + emin;
								System.out.println("Invalid code length. Automatically generated code is " + empcode[lcontrol]);
							}
						}
						if(indr.equals("c")) { //This block checks for existing employee information
							try {
								f = new File("C:\\Orion\\impfiles\\456d70696e66.txt");
							}
							catch(Exception e) {
								System.out.println("Error accessing employee details. Line 281");
							}
							if(f.exists()) {
								try {
									reader = new Scanner(new File("C:\\Orion\\impfiles\\456d70696e66.txt"));
								}
								catch(Exception e) {
									System.out.println("Error accessing employee details. Line 288");
								}
							}
						}
						else {
							try {
								f = new File("D:\\Orion\\impfiles\\456d70696e66.txt");
							}
							catch(Exception e) {
								System.out.println("Error accessing employee details. Line 297");
							}
							if(f.exists()) {
								try {
									reader = new Scanner(new File("D:\\Orion\\impfiles\\456d70696e66.txt"));
								}
								catch(Exception e) {
									System.out.println("Error accessing employee details. Line 304");
								}
							}
						}
						if(f.exists()) {
							execount = reader.nextInt();
						}
						else {
							execount = 0;
						}
						exempname = new String[execount];
						exempsname = new String[execount];
						exempcode = new int[execount];
						if(f.exists()) { //This block saves the existing employee details 
							lcontrol = 0;
							while(reader.hasNext()) {
								exempname[lcontrol] = reader.next();
								exempsname[lcontrol] = reader.next();
								exempcode[lcontrol] = reader.nextInt();
								lcontrol++;
							}
						}
						if(indr.equals("c")) {
							try {
								writer = new Formatter("C:\\Orion\\impfiles\\456d70696e66.txt");
							}
							catch(Exception e) {
								System.out.println("Error saving employee details. Try again");
							}
						}
						else {
							try {
								writer = new Formatter("D:\\Orion\\impfiles\\456d70696e66.txt");
							}
							catch(Exception e) {
								System.out.println("Error saving employee details. Try again"); //These blocks prepare the necessary variables 
							}															       //to read from the employee info file
						}
						writer.format("%s %n", (ecount + execount));
						if(f.exists()) {
							for(lcontrol = 0; lcontrol < execount; lcontrol++) {
								writer.format("%s %s %s %n", exempname[lcontrol], exempsname[lcontrol], exempcode[lcontrol]);
							}
						}
						for(lcontrol = 0; lcontrol < ecount; lcontrol++) {
							writer.format("%s %s %s %n", empname[lcontrol], empsname[lcontrol], empcode[lcontrol]);
						}
						System.out.println("Details saved");
					}
					else if(uinputi == 2) {
						System.out.println("How many products will you be registering?");
						int pcount = sc.nextInt();
						expcount = 0;
						arindx = 0;
						proname = new String[pcount];
						procode = new int[pcount];
						provalue = new String[pcount];
						for(lcontrol = 0; lcontrol < pcount; lcontrol++) {
							System.out.print("Product name (one word): ");
							proname[lcontrol] = sc.next();
							System.out.print("Identification code (any length, no letters): ");
							procode[lcontrol] = sc.nextInt();
							System.out.println("Final sale price (Use full stop to show cents): ");
							provalue[lcontrol] = sc.next();
						}
						if(indr.equals("c")) {
							try {
								f = new File("C:\\Orion\\impfiles\\70726f64696e666f.txt");
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 375");
							}
						}
						else {
							try {
								f = new File("D:\\Orion\\impfiles\\70726f64696e666f.txt");
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 383");
							}

						}
						if(f.exists()) {
							if(indr.equals("c")) {
								try {
									reader = new Scanner(new File("C:\\Orion\\impfiles\\70726f64696e666f.txt"));
								}
								catch(Exception e) {
									System.out.println("Unknown error. Line 393");
								}
							}
							else {
								try {
									reader = new Scanner(new File("D:\\Orion\\impfiles\\70726f64696e666f.txt"));
								}
								catch(Exception e) {
									System.out.println("Unknown error. Line 401");
								}
							}
						}
						if(f.exists()) {
							expcount = reader.nextInt();
						}
						else {
							expcount = 0;
						}
						exproname = new String[expcount];
						exprocode = new int[expcount];
						exprovalue = new String[expcount];
						arindxa = new int[expcount];
						if(f.exists()) {
							for(lcontrol = 0; lcontrol < expcount; lcontrol++) {
								exproname[lcontrol] = reader.next();
								exprocode[lcontrol] = reader.nextInt();
								exprovalue[lcontrol] = reader.next();
								arindxa[lcontrol] = reader.nextInt(); //NB: The format for saving products is 1.Name, 2.Code, 3.Monetary value, 4.Array index
							}
						}
						if(indr.equals("c")) {
							try {
								writer = new Formatter("C:\\Orion\\impfiles\\70726f64696e666f.txt");
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 426");
							}
						}
						else {
							try {
								writer = new Formatter("D:\\Orion\\impfiles\\70726f64696e666f.txt");
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 434");
							}
						}
						writer.format("%s %n", (pcount + expcount));
						if(f.exists()) {
							for(lcontrol = 0; lcontrol < expcount; lcontrol++, arindx++) {
								writer.format("%s %s %s %d %n", exproname[lcontrol], exprocode[lcontrol], exprovalue[lcontrol], arindx);
							}
						}
						for(lcontrol = 0; lcontrol < pcount; lcontrol++, arindx++) {
							writer.format("%s %s %s %d %n", proname[lcontrol], procode[lcontrol], provalue[lcontrol], arindx);
						}
						writer.close();
					}
				}
				else if(uinputi == 2) {
					if(indr.equals("c")) {
						try {
							f = new File("C:\\Orion\\impfiles\\70726f64696e666f.txt");
						}
						catch(Exception e) {
							System.out.println("Unknown error. Line 459");
						}
					}
					else {
						try {
							f = new File("D:\\Orion\\impfiles\\70726f64696e666f.txt");
						}
						catch(Exception e) {
							System.out.println("Unknown error. Line 467");
						}
					}
					if(f.exists()) {
						if(indr.equals("c")) {
							try {
								reader = new Scanner(new File("C:\\Orion\\impfiles\\70726f64696e666f.txt"));
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 459");
							}
						}
						else {
							try {
								reader = new Scanner(new File("D:\\Orion\\impfiles\\70726f64696e666f.txt"));
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 467");
							}
						}
						expcount = reader.nextInt();
						exproname = new String[expcount];
						exprocode = new int[expcount];
						exprovalue = new String[expcount];
						arindxa = new int[expcount];
						for(lcontrol = 0; lcontrol < expcount; lcontrol++) {
							exproname[lcontrol] = reader.next();
							exprocode[lcontrol] = reader.nextInt();
							exprovalue[lcontrol] = reader.next();
							arindxa[lcontrol] = reader.nextInt();
						}
						for(lcontrol = 0; lcontrol < expcount; lcontrol++) {
							System.out.printf("%s %d %s %n", exproname[lcontrol], exprocode[lcontrol], exprovalue[lcontrol]);
						}
						if(indr.equals("c")) {
							try {
								writer = new Formatter("C:\\Orion\\impfiles\\70726f64696e666f.txt");
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 507");
							}
						}
						else {
							try {
								writer = new Formatter("D:\\Orion\\impfiles\\70726f64696e666f.txt");
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 515");
							}
						}
						writer.format("%d %n", expcount);
						for(lcontrol = 0; lcontrol < expcount; lcontrol++) {
							writer.format("%s %d %s %d %n", exproname[lcontrol], exprocode[lcontrol], exprovalue[lcontrol], arindxa[lcontrol]);
						}
						System.out.println("Save successful");
					}
					else {
						System.out.println("File not found. Please register details first");
					}
					writer.close();
				}
				else if(uinputi == 3) {
					if(indr.equals("c")) {
						try {
							f = new File("C:\\Orion\\impfiles\\70726f64696e666f.txt");
						}
						catch(Exception e) {
							System.out.println("Unknown error. Line 535");
						}
					}
					else {
						try {
							f = new File("D:\\Orion\\impfiles\\70726f64696e666f.txt");
						}
						catch(Exception e) {
							System.out.println("Unknown error. Line 543");
						}
					}
					if(f.exists()) {
						if(indr.equals("c")) {
							try {
								reader = new Scanner(new File("C:\\Orion\\impfiles\\70726f64696e666f.txt"));
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 552");
							}
						}
						else {
							try {
								reader = new Scanner(new File("D:\\Orion\\impfiles\\70726f64696e666f.txt"));
							}
							catch(Exception e) {
								System.out.println("Unknown error. Line 560");
							}
						}
						expcount = reader.nextInt();
						exproname = new String[expcount];
						exprocode = new int[expcount];
						exprovalue = new String[expcount];
						arindxa = new int[expcount];
						for(lcontrol = 0; lcontrol < expcount; lcontrol++) {
							exproname[lcontrol] = reader.next();
							exprocode[lcontrol] = reader.nextInt();
							exprovalue[lcontrol] = reader.next();
							arindxa[lcontrol] = reader.nextInt();
						}
						float csaleprice = 0; //Current sale price
						float fsaleprice = 0; //Final sale price
						while(true) {
							if(uinput.startsWith("f") || uinput.startsWith("F")){
								break;
							}
							System.out.print("Reference code of item: ");
							uinputi = sc.nextInt();
							lcontrol = 0;
							while(true) {
								if(uinputi == exprocode[lcontrol]) {
									break;
								}
								else if(lcontrol >= (expcount - 1)){
									lcontrol = 0;
									break;
								}
								else {
									lcontrol++;
								}
							}
							if(uinputi == exprocode[lcontrol]) {
								System.out.println("Confirm selected product (" + exproname[lcontrol] + ") (y, n)");
								uinput = sc.next();
								if(uinput.startsWith("y") || uinput.startsWith("Y")) {
									while(true) {
										float epv = Float.valueOf(exprovalue[lcontrol]); //To convert selected array index from string to float
										System.out.print("Please enter amount of " + exproname[lcontrol]);
										if(exproname[lcontrol].endsWith("s")) {
											System.out.print(" ");
										}
										else {
											System.out.print("s ");
										}
										System.out.print("to purchase: ");
										uinputi = sc.nextInt();
										csaleprice = uinputi * epv;
										fsaleprice += csaleprice; 
										System.out.printf("%s %f %n%s", "Value of these products: R", csaleprice, "(P)roceed to next item, (F)inalise sale, (I)ncrease amount of current item: ");
										uinput = sc.next();
										if(uinput.startsWith("p") || uinput.startsWith("P")) {
											break;
										}
										else if(uinput.startsWith("f") || uinput.startsWith("F")) {
											System.out.printf("%n%s %n%n%s%s%n%n", "Total value of sale:", "R", fsaleprice);
											break;
										}
									}
								}
							}
						}
					}
				}
				else if(uinputi == 4) {
					System.out.println("See you soon.");
					exit = true;
				}
			}
			
			if(indr.equals("c")) {
				try {
					blankfile = new File("C:\\Orion\\impfiles\\666972737472756e.txt");
				}
				catch(Exception e) {
					System.out.println("Unknown error. Exiting");
					System.exit(0);
				}
			}
			else {
				try {
					blankfile = new File("D:\\Orion\\impfiles\\666972737472756e.txt");
				}
				catch(Exception e) {
					System.out.println("Unknown error. Exiting");
					System.exit(0);
				}
			}
			if(!blankfile.exists()) {
				try {
					blankfile.createNewFile();
				}
				catch(Exception e) {
					System.out.println("Unknown error. Exiting");
					System.exit(0);
				}
			}
			sc.close();
			reader.close();
			writer.close();
			System.exit(0);
	}
}