package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products:");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char ch = sc.next().charAt(0);
			
			sc.nextLine();

			if (ch == 'c') {
				System.out.print("Name:");
				String name = sc.nextLine();
				System.out.print("Price:");
				double price = sc.nextDouble();

				list.add(new Product(name, price));
			} else if (ch == 'i') {

				System.out.print("Name:");
				String name = sc.nextLine();
				System.out.print("Price:");
				double price = sc.nextDouble();
				System.out.print("Customs Fee:");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			} else if (ch == 'u'){

				System.out.print("Name:");
			    String name = sc.nextLine();
			    System.out.print("Price:");
			    double price = sc.nextDouble();
			    sc.nextLine();
			    System.out.print("Manufacture date:");
			    Date manufactureDate = sdf.parse(sc.nextLine());
			    list.add(new UsedProduct(name,price,manufactureDate));
		}
		
			
	}
		
		System.out.println();
		System.out.println("PRICE TAGS");
		
		for ( Product product : list) {
			
			System.out.println(product.priceTag());
		}
		
	sc.close();
}
}
