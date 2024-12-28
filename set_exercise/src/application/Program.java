package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ente file full path: ");
		String path =  sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Set <LogEntry> set = new HashSet<>();
			
			String log = br.readLine();
			while(log != null) {
			   
				String [] fields = log.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				set.add(new LogEntry(username, moment));
				log = br.readLine();
			
			}
			
			System.out.println("Total users: "+set.size());
			
		}
		catch (IOException e ) {
			
			System.out.println("Error :"+ e.getMessage());
		}
				
		
		sc.close();
	}

}