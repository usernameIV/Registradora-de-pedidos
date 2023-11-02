package OrderRegister;

import java.util.Scanner;

class Order {
	private int orderNumber;
	private int serviceType;
	private String clientName;
	private double orderPrice;

	public Order(int orderNumber, int serviceType, String clientName, double orderPrice) {
		this.orderNumber = orderNumber;
		this.serviceType = serviceType;
		this.clientName = clientName;
		this.orderPrice = orderPrice;
	}

	@Override
	public String toString() {
		return "Order number: " + orderNumber + ", Service type: " + serviceType + "\nClient name: " + clientName
				+ ", Order price: $" + orderPrice;
	}

	public String getName() {
		return clientName;
	}

	public int getNumber() {
		return orderNumber;
	}

	public int getType() {
		return serviceType;
	}

	public double getPrice() {
		return orderPrice;
	}
}

class Store {

	private Scanner scanner_d;
	private Scanner scanner_l;
	private Order[] orders = new Order[10];
	private int orderCount = 0;
	private Scanner scan;

	public void includeOrder(int orderNumber, int serviceType, String clientName, double orderPrice) {

		scanner_d = new Scanner(System.in);
		scanner_l = new Scanner(System.in);
		scan = new Scanner(System.in);

		System.out.println("Service selected: 1 - Include order");

		System.out.println("Enter order service type: \n");
		System.out.println("1 to Store serving");
		System.out.println("2 to Delivey serving");
		System.out.println("3 to Cancel service selected 'Include order'");

		int tipo = scan.nextInt();
		if (orderCount < 10) {
			orderNumber++;
			Order order = new Order(orderNumber, serviceType, clientName, orderPrice);
			orders[orderCount] = order;
		} else {
			System.out.println("The list is full. Cannot add more orders.");
			return;
		}
		switch (tipo) {
		case 1:
			System.out.println("Store serving");
			System.out.println("Order number: " + (orderCount + 1));
			serviceType = tipo;
			System.out.println("Insert client name: ");
			clientName = scanner_l.nextLine();
			System.out.println("Insert order price: ");
			orderPrice = scanner_d.nextDouble();

			Order order = new Order(orderNumber, serviceType, clientName, orderPrice);
			System.out.println(order.toString());
			orders[orderCount] = order;

			System.out.println("\nOrder added successfully...");
			for (int i = 0; i <= orderCount; i++) {
				System.out.println("Current orders: " + (i + 1));
			}
			orderCount++;

			break;
		case 2:
			System.out.println("Delivery Serving");
			System.out.println("Order number: " + (orderCount + 1));
			serviceType = tipo;
			System.out.println("Insert client name: ");
			clientName = scanner_l.nextLine();
			System.out.println("Insert order price: ");
			orderPrice = scanner_d.nextDouble();

			Order order1 = new Order(orderNumber, serviceType, clientName, orderPrice);
			orders[orderCount] = order1;
			System.out.println(order1.toString());

			System.out.println("\nOrder added successfully...");
			for (int i = 0; i <= orderCount; i++) {
				System.out.println("Current orders: " + (i + 1));
			}
			orderCount++;
			break;
		case 3:
			System.out.println("Order inclusion canceled...");
			return;
		default:
			System.out.println("Invalid order value...");
			System.out.println("Please, insert a valid digit...\n");
			return;
		}

	}

	public void attendOrder() {
		System.out.println("2 - Attend order");

		if (orderCount > 0) {
			Order orderAttended = orders[0];
			for (int i = 0; i < orderCount - 1; i++) {
				orders[i] = orders[i + 1];
			}
			orderCount--;
			System.out.println("The order number " + orderAttended.getNumber() + " was attended...");
			System.out.println("Current orders to be attended: " + (orderCount));
		} else {
			System.out.println("Empty list - There is no orders...");
		}

	}

	public void listOrder() {
		System.out.println("3 - List order ");

		if (orderCount > 0) {
			System.out.println("Orders that still awaiting attending: ");
			for (int i = 0; i < orderCount; i++) {
				System.out.println("\nOrder number: " + (i + 1));
				System.out.println("Client name: " + orders[i].getName());
				System.out.println("Service type: " + orders[i].getType());
				System.out.println("Order price: $" + orders[i].getPrice());
			}
		} else {
			System.out.println("Empty list - There is no orders...");
		}
	}

	public void searchOrder() {
		System.out.println("4 - Search order");

		if (orderCount > 0) {
			System.out.println("Insert any order number (1 - 10)");

			int escolha = scan.nextInt();
			if (escolha >= 1 && escolha <= orderCount) {
				Order order = orders[escolha - 1];
				System.out.println("\nOrder number: " + escolha);
				System.out.println("Client name: " + order.getName());
				System.out.println("Service type: " + order.getType());
				System.out.println("Order price: $" + order.getPrice());
			} else {
				System.out.println("The program could not find this order number...");
				searchOrder();
			}
		} else {
			System.out.println("Empty list - There is no orders...");
		}

	}

	public void quitOrdering() {
		if (orderCount == 0) {
			System.out.println("Service ended...");
			System.exit(0);
		} else if (orderCount > 0) {
			System.out
					.println("You're not able to end the service " + "\nbecause there is still orders to attend to...");
		}
	}

}
