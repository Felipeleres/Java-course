package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
			
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name:");
		String name = leitor.nextLine();
		System.out.print("Email:");
		String email = leitor.nextLine();
		System.out.print("Birth date:");
		Date birthDate = sdf1.parse(leitor.next());
		leitor.nextLine();
		
		Client client = new Client(name, email, birthDate); 
		
		System.out.println("Enter order data:");
		System.out.print("Status:");
		OrderStatus status = OrderStatus.valueOf(leitor.nextLine());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order?");
		int n = leitor.nextInt();
		leitor.nextLine();
		
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name:");
			String  productName = leitor.nextLine();
			System.out.print("Product price:");
			double productPrice = leitor.nextDouble();
			System.out.print("Quantity:");
			int quantity = leitor.nextInt();
			leitor.nextLine();
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(quantity,productPrice, product);
			order.addItem(item);
		}
		
		
		
		System.out.println();
		System.out.println("Order summary:");
		System.out.println(order);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		leitor.close();
	}

}
