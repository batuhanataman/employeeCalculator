package application;


public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;

	public BasePlusCommissionEmployee(String firstName, String lastName, String SSN, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, SSN, grossSales, commissionRate);
		if(baseSalary>=0) {
			this.baseSalary = baseSalary;
		}else {
			System.exit(0);
		}
	
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if(baseSalary>=0) {
			this.baseSalary = baseSalary;
		}else {
			System.exit(0);
		}
	}

	public double getPaymentAmount() {
		
		return (getCommissionRate()*getGrossSales())+baseSalary;
	}
	
	
	@Override
	public String toString() {
		return "base-salaried commission employee : "+getFirstName()+" "+getLastName()
		+"\nsocial security number : "+getSSN()+"\ngross sales : $"+getGrossSales()+
		"; commision rate : "+getCommissionRate()+"; base salary : "+baseSalary;
	}
	
}
