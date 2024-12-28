package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Students;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Students[] student = new Students[10]; 
		
		System.out.print("How many rooms will be rented ?");
		int rented = sc.nextInt();
		
		for ( int i = 1; i <=rented; i++ ) {
			
			System.out.println("Rent #"+i+":");
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email:");
			String email = sc.next();
			System.out.print("Room:");
			int room = sc.nextInt();
			student[room] = new Students(name,email,room);
		}
		
		System.out.println();
		System.out.println("Busy rooms");
		
		for ( int i = 0; i < student.length; i++ ) {
			
			if (student[i]!= null) {
				
				System.out.println(student[i]);
			}
		}
		
		sc.close();

	}

}
