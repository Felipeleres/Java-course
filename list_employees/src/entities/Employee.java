package entities;

public class Employee {
	
	private String name;
	private Double salary;
	private Integer id;
	
	public Employee () {
		
	}
	
	public Employee (Integer id,String name,Double salary ) {
		
		this.name = name;
		this.salary = salary;
		this.id = id;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double Salary) {
		this.salary = salary;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void increaseSalary(double percent) {
		salary += salary * percent/100;
	}
	@Override
	public String toString() {
		
		return id+", "+name+", "+String.format("%.2f",salary);
	}
	
	
}
