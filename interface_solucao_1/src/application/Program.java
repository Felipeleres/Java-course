package application;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		
		

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		
		System.out.println("Insert rental data:");
		System.out.print("Vehicle model: ");
		String vehicleModel = sc.nextLine();
		System.out.println("pickup (dd/MM/yyyy HH:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
		System.out.println("return (dd/MM/yyyy HH:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);
		
		CarRental cr = new CarRental(start,finish, new Vehicle(vehicleModel));
		
		System.out.println("Entre com o preço por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.println("Entre com o preço por dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalservice = new RentalService(pricePerDay,pricePerHour,new BrazilTaxServices());

		rentalservice.processInvoice(cr);
		
		System.out.println("Fatura:");
		System.out.println("Pagemento basico:"+ cr.getInvoice().getBasicPayment());
		System.out.println("Imposto:" +  cr.getInvoice().getTax());
		System.out.println("pagamento total:" +  cr.getInvoice().getTotalPayment());
		
		
		sc.close();
	}

}
