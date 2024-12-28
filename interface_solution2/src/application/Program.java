package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Instalment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println("Enter contract Data: ");
		System.out.print("Enter contract number: ");
		int contractNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter contract data(dd/MM/yyyy): ");
		LocalDate contractDate = LocalDate.parse(sc.next(),fmt);
		System.out.print("Enter contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(contractNumber, contractDate, totalValue);
		
		System.out.print("Enter the numbers of installments: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, n);
		
		System.out.println("Installments");
		
		for(Instalment stal : contract.getInstalments()) {
			
			System.out.println(stal);
		}
		
		sc.close();
	}

}
