package QLCB;

public class employee extends User {
	private String congViec;
	private double salary;

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}

	public employee(String name, byte age, double salaryRatio, String address, String congViec) {
		super(name, age, salaryRatio, address);
		this.congViec = congViec;
	}

	@Override
	public void calculatePay() {
		salary = salaryRatio * 420;
	}

	@Override
	public void displayInfor() {
		// TODO Auto-generated method stub

	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
