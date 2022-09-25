package AccountManagement;

import java.time.LocalDate;

public class Account {
	private String soTaiKhoan;
	String hoTen;
	private String soCMT;
	private String sDT;
	private String queQuan;
	protected float soDu;
	private String email;
	private LocalDate ngayThangNamSinh;

	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoCMT() {
		return soCMT;
	}

	public void setSoCMT(String soCMT) {
		this.soCMT = soCMT;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public float getSoDu() {
		return soDu;
	}

	public void setSoDu(float soDu) {
		this.soDu = soDu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNgayThangNamSinh() {
		return ngayThangNamSinh;
	}

	public void setNgayThangNamSinh(LocalDate ngayThangNamSinh) {
		this.ngayThangNamSinh = ngayThangNamSinh;
	}

	public float soTienVay(float tienVay) {
		this.soDu += tienVay;
		return tienVay;
	}

	public void truyVanSoDu() {
		System.out.println("Số dư tài khoản " + this.soTaiKhoan + "la: " + this.soDu);
	}

	public float chuyenKhoan(float tienCK) {
		this.soDu -= tienCK;
		return tienCK;
	}

	@Override
	public String toString() {
		return "Thông tin Account [soTaiKhoan=" + soTaiKhoan + ", hoTen=" + hoTen + ", soCMT=" + soCMT + ", sDT=" + sDT
				+ ", queQuan=" + queQuan + ", soDu=" + soDu + ", email=" + email + ", ngayThangNamSinh="
				+ ngayThangNamSinh + "]";
	}

}

//btap lập trình: https://shareprogramming.net/tong-hop-bai-tap-lap-trinh-huong-doi-tuong-trong-java/
