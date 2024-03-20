package application;


public class HourlyEmployee extends Employee {
	
	private double hours;
	private double wage;
	
	
	public HourlyEmployee(String firstName, String lastName, String SSN, double wage, double hours) {
		super(firstName, lastName, SSN);
		if(wage>=0 && hours>=0 && hours<168) {
			this.wage = wage;
			this.hours = hours;
		}else {
			System.exit(0);
		}
		
	}
	
	double payment ;
	
	public double getPaymentAmount() {
	
		if(hours <= 40) {
			payment = wage*hours;
		}else if(hours>40) {
			payment = 40*wage+(hours-40)*wage*1.5;
		}
		return payment;
	}



	@Override
	public String toString() {
		return "hourly employee : "+getFirstName()+" "+getLastName()+
				"\nsocial security number :"+getSSN()+"\nhourly wage : $"+wage+";"+" hours worked : "+hours;
	}



	public double getHours() {
		return hours;
	}
	
	public void setHours(double hours) {
		if(hours>=0 && hours<168) {
			this.hours = hours;
		}else {
			System.exit(0);
		}
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		if(wage>=0 ) {
			this.wage = wage;
		}else {
			System.exit(0);
		}
	}
	
	


}
