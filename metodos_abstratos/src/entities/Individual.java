package entities;

public class Individual extends Contribuinte {

	private Double healthExpenses;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenses) {
		super(name, anualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public Double tax() {

		if (super.getAnualIncome() < 20000.00) {

			return super.getAnualIncome() * 0.15 - (healthExpenses * 0.5);

		} else {
			return super.getAnualIncome() * 0.25 - (healthExpenses * 0.5);
		}

	}
	
	public String toString () {
		
		return super.getName()+": $ "+String.format("%.2f",tax());
	}

}
