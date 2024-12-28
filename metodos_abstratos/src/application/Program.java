package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Contribuinte;
import entities.Individual;

public class Program {

	public static void main(String args[]) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Contribuinte> contribuinte = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or Company (c/i):");
			char cont = sc.next().charAt(0);
			sc.nextLine();
			if (cont == 'i') {

				System.out.print("Name:");
				String name = sc.nextLine();
				System.out.print("Anual Income:");
				double anualIncome = sc.nextDouble();
				System.out.print("Health expenditures");
				double healthExpenses = sc.nextDouble();

				contribuinte.add(new Individual(name, anualIncome, healthExpenses));
			} else {

				System.out.print("Name:");
				String name = sc.nextLine();
				System.out.print("Anual Income:");
				double anualIncome = sc.nextDouble();
				System.out.print("Number of employees:");
				int employeeNumber = sc.nextInt();

				contribuinte.add(new Company(name, anualIncome, employeeNumber));
			}

		}

		System.out.println();
		System.out.println("TAXES PAID:");

		for (Contribuinte c : contribuinte) {

			System.out.println(c);
		}

		System.out.println();

		double totalTax = 0.00;

		for (Contribuinte c : contribuinte) {

			totalTax += c.tax();
		}
		
		System.out.println("TOTAL TAXES: $ "+totalTax);

		sc.close();
	}

}
