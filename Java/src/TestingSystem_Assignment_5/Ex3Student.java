package TestingSystem_Assignment_5;

public class Ex3Student extends Person {
	private int id;
	private int averageGrade;
	private String email;

	public Ex3Student(String name, String sex, String dateOfBirth, String address, int id, int averageGrade,
			String email) {
		super(name, sex, dateOfBirth, address);
		this.id = id;
		this.averageGrade = averageGrade;
		this.email = email;

	}

	@Override
	public String toString() {
		return "Ex3Student [id=" + id + ", averageGrade=" + averageGrade + ", email=" + email + ", getName()="
				+ getName() + ", getSex()=" + getSex() + ", getDateOfBirth()=" + getDateOfBirth() + ", getAddress()="
				+ getAddress() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

	@Override
	public void inputInfo() {
//		super.setName("B");
//		super.setSex("nam");
//		super.setDateOfBirth("2012-2-18");
//		super.setAddress("Nguyen Thai Hoc");
//
//		id = 1;
//		averageGrade = 4;
//		email = "hello@gmail.com";

	}

	@Override
	public void showInfo() {
		System.out.println(toString());
		if (averageGrade >= 8) {
			System.out.println(super.getName() + " duoc hoc bong");
		} else {
			System.out.println(super.getName() + " khong duoc hoc bong");
		}
	}

}

//Tạo class Student thừa kế Person, lưu trữ các thông tin một sinh viên: 
// Mã sinh viên, Điểm trung bình, Email
// a) Override phương thức inputInfo(), nhập thông tin Student từ
// bàn phím
// b) Override phương thức showInfo(), hiển thị tất cả thông tin
// Student
// c) Viết phương thức xét xem Student có được học bổng không?
// Điểm trung bình từ 8.0 trở lên là được học bổng