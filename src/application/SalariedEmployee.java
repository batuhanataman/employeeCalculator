package application;


public class SalariedEmployee extends Employee {


	private int weeklySalary;

	public SalariedEmployee(String firstName, String lastName, String SSN, int weeklySalary) {
		super(firstName, lastName, SSN);
		if(weeklySalary >= 0) {
			this.weeklySalary = weeklySalary;
		}else {
			System.exit(0);
		}
		
	}

	public int getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(int weeklySalary) {
		if(weeklySalary >= 0) {
			this.weeklySalary = weeklySalary;
		}else {
			System.exit(0);
		}
	}

	public double getPaymentAmount() {
		return weeklySalary;
	}

	
	
		
	@Override
	public String toString() {
		return "salaried employee : "+getFirstName()+" "+getLastName()+
				"\nsocial security number : "+getSSN()+"\nweekly salary : $"+weeklySalary;
	}


}

