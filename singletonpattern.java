import java.util.*;
import java.util.Scanner;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class singletonpattern {
	//We can create java Logger 
	static Logger logging = Logger.getLogger(singletonpattern.class.getName());
	static Handler handler;
	public static singletonpattern p1 = new singletonpattern();
	static String f_name,l_name, m_name;
	private static int input;
	private String e_address;
	private singletonpattern() {
		//private constructor which prevents any other class instantiating
	};
	public static void main(String[] args) {
		String fna,lna,ead;
		//import scanner 
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter your Account Information " );
		System.out.println(" \nEnter first name:");
		fna = sc.nextLine();
		//Adding logger information
		logging.info("Frist added Successfully");
		System.out.println(" \nEnter Last name:");
		lna = sc.nextLine();
		logging.info("Last name added Successfully");
		System.out.println("\nEnter your Email ");
		ead = sc.nextLine();
		logging.info("Email added Successfully");
		
		
		
	//Using singleton pattern 
		singletonpattern p2 = singletonpattern.getInstance();
		logging.info("Information added Successfully");
		
		logging.addHandler(new ConsoleHandler());
		//giving logger a level 
		if(logging.isLoggable(Level.INFO)) {
			logging.info("Information added Successfully");
			}
		// Giving handler and setting the level of it
		   ConsoleHandler consoleHandler1 = new ConsoleHandler();
		   consoleHandler1.setLevel(Level.INFO);
		   logging.addHandler(consoleHandler1);
		   logging.setLevel(Level.INFO);
		   
		p2.setF_name(fna);
		p2.setl_name(lna);
		p2.sete_address(ead);
		fna = p2.getFname();
		lna = p2.getlname();
		ead = p2.getead();
		System.out.println(fna+""+" "+lna+"\n"+""+ead);
	}
		
	//giving private string.
	private String getead() {
		
		return e_address;
	}
	private void sete_address(String ead) {

		e_address = ead;
	}
	//giving protected string 
	protected static void setF_name(String fname) {
		f_name = fname;
		
	}
	protected static void setl_name(String lname) {
		l_name = lname;
		
	}
	
	protected static String getFname() {
		return f_name;
	}
	protected static String getlname() {
		return l_name;
	}
	
	public static singletonpattern getInstance() {
		//adding log manager
		   LogManager logManager =
				   LogManager.getLogManager();
		   System.out.println("Global LogManager object:" + logManager);
		   //adding file handler and create another xml file
		   try {
		      FileHandler fileHandler = new FileHandler("log.xml");
		      fileHandler.setLevel(Level.INFO);
		      logging.addHandler(fileHandler);
		   
		      }catch (SecurityException | IOException e) {
			   e.printStackTrace();
		      }
		   return p1;
	}
	
}