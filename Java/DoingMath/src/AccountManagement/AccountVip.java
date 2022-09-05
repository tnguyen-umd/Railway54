package AccountManagement;


public class AccountVip extends Account{
	
	private boolean coGioiHan;
	
	public boolean isCoGioiHan() {
		return coGioiHan;
	}


	public void setCoGioiHan(boolean coGioiHan) {
		this.coGioiHan = coGioiHan;
	}


	@Override
	public String toString() {
		return super.toString() + " [coGioiHan=" + coGioiHan + "]";
	}


	public void chuyenTienKhongGioiHan(float soTienChuyen) {
		if(coGioiHan == true) {
			this.soDu -= soTienChuyen;
		}else {
			System.out.println("Tai khoan khong co chuc nang chuyen khoan so tien lon");
		}
	
	
	
	}
}
	
/*
public enum Gender {
	NAM("nam"), NU("nu"), KHAC("khac");

	String gender;
	Gender(String gender) {
		this.gender = gender;
	}
	
	public static Gender fromValue(String gender) {
		for (Gender category : values()) {
			if(category.gender.equalsIgnoreCase(gender)) {
				return category;
			}
		}
		throw new IllegalArgumentException("Khong phai loai ENUM tuong ung");
	}
}
*/