package model.services;

import java.time.Duration;
import java.util.Locale;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerDay;
	private Double pricePerHOur;
	
	private TaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHOur,TaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHOur = pricePerHOur;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		
		double  minutes = Duration.between(carRental.getStart(),carRental.getFinish()).toMinutes();
		double hours = minutes / 60.0;
		
		double basicPayment;
		
		if(hours <= 12.0) {
			
			basicPayment = pricePerHOur * Math.ceil(hours);
		}
		else {
			double days = Math.ceil(hours/24.0);
			basicPayment = pricePerDay * days;
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment,tax));
	}
	
	

}
