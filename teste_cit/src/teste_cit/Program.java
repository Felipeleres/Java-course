package teste_cit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath  = sc.nextLine();
		
		File path = new File(strPath);
		
		System.out.println("getname: "+path.getName());
		
		sc.close();



	}

}