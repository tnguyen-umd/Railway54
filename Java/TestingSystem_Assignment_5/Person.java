package TestingSystem_Assignment_5;

public abstract class Person {
	private String name;
	private String sex;
	private String dateOfBirth;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person(String name, String sex, String dateOfBirth, String address) {
		super();
		this.name = name;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public void inputInfo() {
		name = "Mr. A";
		sex = "male";
		dateOfBirth = "2012-11-21";
		address = "20 Thai Hoc";
	}

	public void showInfo() {
		toString();
		System.out.println("Show person info " + name + " gioi tinh " + sex + "date of birth " + dateOfBirth);
		System.out.println("Address " + address);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + ", address=" + address + "]";
	}

}
//Question 2 (Optional): Abstract Management
//Tạo 1 class Person chứa các property sau: tên, giới tính, ngày sinh, địa 
//chỉ với đầy đủ getter setter, constructor không tham số, constructor đầy 
//đủ tham số----
//a) Viết phương thức inputInfo(), nhập thông tin Person từ bàn 
//phím
//b) Viết phương thức showInfo(), hiển thị tất cả thông tin Person
//3
//Tạo class Student thừa kế Person, lưu trữ các thông tin một sinh viên: 
//Mã sinh viên, Điểm trung bình, Email
//a) Override phương thức inputInfo(), nhập thông tin Student từ 
//bàn phím
//b) Override phương thức showInfo(), hiển thị tất cả thông tin 
//Student
//c) Viết phương thức xét xem Student có được học bổng không? 
//Điểm trung bình từ 8.0 trở lên là được học bổng