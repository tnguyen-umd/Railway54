package QLCB;

//Question 2 (Optional):
//Hãy xây dựng 1 class User với các thuộc tính name kiểu String và
//salary ratio kiểu double.------
//a) Viết các hàm cho phép nhập và trả về name, salary ratio.----
//b) Viết hàm calculatePay() dạng abstract trả về thu nhập của nhân
//viên, kiểu double.
//c) Viết hàm displayInfor()
public abstract class User {
	private String name;
	private byte age;
	protected double salaryRatio;

	private enum sex {
		FEMALE, MALE, UNKNOWN
	};

	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(String name, byte age, double salaryRatio, String address) {
		super();
		this.name = name;
		this.age = age;
		this.salaryRatio = salaryRatio;
		this.address = address;
	}

	public double getSalaryRatio() {
		return salaryRatio;
	}

	public void setSalaryRatio(double salaryRatio) {
		this.salaryRatio = salaryRatio;
	}

	public abstract void calculatePay();

	public abstract void displayInfor();

}
