package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();
		
		for ( int i = 0; i < n; i++) {
			
			System.out.println("Employee #"+(i+1)+":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while(hasid(list,id)) {
				System.out.println("Id already taken! try again:");
				id = sc.nextInt();
			}
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary:");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id,name,salary);
			
			list.add(emp);
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increasy: ");
		int idSalary = sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		
		//Integer pos = position(list,idSalary);
		if(emp == null) {
			System.out.println("This id does not exist");
		}else {
			System.out.print("Enter the percentage: ");
			Double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
			
		}
		System.out.println();
		System.out.println("List of employees:");
		for(Employee empi : list) {
			System.out.println(empi);
		}
		
		System.out.println("fff");
		sc.close();
	}
	
	public static Integer position(List<Employee> list,int id) {
		
		for(int i = 0; i< list.size();i++) {
			if(list.get(i).getId()== id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasid(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId()== id).findFirst().orElse(null);
		return emp != null;
	}
}
