package OrderRegister;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu extends Store {

	private Scanner scanner_d;


	public Menu() {
		scanner_d = new Scanner(System.in);

	}

	public void attendingMenu() {
		boolean exit = false;
		do {
			try {
				System.out.println("#  Welcome to our store #");
				System.out.println("#  1 – Include order    #");
				System.out.println("#  2 - Attend order     #");
				System.out.println("#  3 - List orders      #");
				System.out.println("#  4 – Search orders    #");
				System.out.println("#  5 – Quit             #");
				System.out.println("#  #  #  #  #  #  #  #  #");

				int escolha = scanner_d.nextInt();
				int orderNumber = 0;
				int serviceType = 0;
				double orderPrice = 0;

				switch (escolha) {
				case 1:
					includeOrder(orderNumber, serviceType, null, orderPrice);
					break;
				case 2:
					attendOrder();
					break;
				case 3:
					listOrder();
					break;
				case 4:
					searchOrder();
					break;
				case 5:
					quitOrdering();
					
					break;				
				default:
					System.out.println("Invalid option");
					attendingMenu();
				}
			} catch (InputMismatchException e) {
				System.out.println("Thats not an option");
				scanner_d.next();
			}
		} while (!exit);

	}


	

	

	

}
