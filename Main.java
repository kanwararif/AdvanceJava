import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
	static Logger logging = Logger.getLogger(Main.class.getName());
	static Handler handler;
	public static void main(String[] args) throws SecurityException, IOException {
		System.out.println("Welcome to my Store");
		
		char input = 0;
		Products product = new Products();
		
		do {
			System.out.println("=======================");
			System.out.println("Please make your selection");
			System.out.println("Press g to search for product");
			System.out.println("Press a to add product");
			System.out.println("press u to update product");
			System.out.println("Press s to search for product");
			System.out.println("Press q to quit ");
			System.out.println("=======================\n");
			
			//get user selection
			Scanner kb = new Scanner(System.in);
			input = kb.next().charAt(0);
			System.out.println("Your selection is:" + input + "\n");
			
			if (input == 'a' || input == 'A') {
				
			}else if (input == 'u' || input == 'U'){
				
				
			}else if (input == 'g' || input == 'G'){
				System.out.println("Getting all Products");
				product.getAll();
			}
			else if (input == 's' || input == 's') {
				
			}else if (input == 'q' || input == 'Q') {
				System.out.println("Thank you for using online inventory system");
			}
			logging .info("Click Successfull");
			
			
		}while(input != 'q');
		logging .info("Click Successfull");
		
		logging.addHandler(new ConsoleHandler());
		if(logging.isLoggable(Level.INFO)) {
			logging.info(" This is Information Message");}
		   ConsoleHandler consoleHandler1 = new ConsoleHandler();
		   consoleHandler1.setLevel(Level.INFO);
		   logging.addHandler(consoleHandler1);
		   logging.setLevel(Level.INFO);
		   
		   LogManager logManager =
				   LogManager.getLogManager();
		   System.out.println("Global LogManager object:" + logManager);
		   
		   
		   try {
		      FileHandler fileHandler = new FileHandler("log.xml");
		      fileHandler.setLevel(Level.INFO);
		      logging.addHandler(fileHandler);
		  
		      }catch (SecurityException | IOException e) {
			   e.printStackTrace();
		   }
	}
}