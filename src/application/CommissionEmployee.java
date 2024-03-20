package application;

public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;
	public CommissionEmployee(String firstName, String lastName, String SSN, double grossSales, double commissionRate) {
		super(firstName, lastName, SSN);
		if(grossSales >= 0 && commissionRate<1 && commissionRate>0) {
			this.grossSales = grossSales;
			this.commissionRate = commissionRate;
		}else {
			System.out.println("Yanlis deger");
			System.exit(0);
		}
		
	}
	public double getGrossSales() {
		return grossSales;
	}
	public void setGrossSales(double grossSales) {
		if(grossSales >= 0) {
			this.grossSales = grossSales;
		}else {
			System.exit(0);
		}
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(double commissionRate) {
		if(commissionRate<1 && commissionRate>0) {
			this.commissionRate = commissionRate;
		}else {
			System.exit(0);
		}
	}
		
	
	public double getPaymentAmount() {
		
		return commissionRate*grossSales;
	}
	@Override
	public String toString() {
		return "commision employee : "+getFirstName()+" "+getLastName()+
		"\nsocial security Number : "+getSSN()+"\ngross Sales : $"+getGrossSales()
		+";  commision rate : "+getCommissionRate();
	}
	
	
	
}
