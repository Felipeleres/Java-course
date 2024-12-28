package entities;

public class Company extends Contribuinte{
	
	private Integer employeeNumber;
	
	public Company () {
		super();
	}
	
	public Company(String name, Double anualIncome, Integer employeeNumber) {
		super(name, anualIncome);
		this.employeeNumber = employeeNumber;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	@Override
	public Double tax() {

		if (employeeNumber <= 10) {

			return super.getAnualIncome() * 0.16;

		} else {
			return super.getAnualIncome() * 0.14;
		}

	}
	
public String toString () {
		
		return super.getName()+": $ "+ String.format("%.2f",tax());
	}

}
