
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class AccountManagement {

			static Scanner sc = new Scanner(System.in);
			static List<Account> danhSachAccount = new ArrayList<Account>();
			
			public static void main(String[] args) {
				/*
				 Sau khi khởi tạo các đối tượng tiến hành quản lý account với các hành động
		1. Thêm mới Account
		2. Hiển thị danh sách account
		3. Xóa Account theo số tài khoản
		4. Sắp xếp theo số tài khoản
		5. Tìm kiếm theo số tài khoản
		6. Thoát chương trình
				 */
				System.out.println("------------------------ * * * ---------------------------");
				System.out.println("Chao mung ban den voi he thong phan mem quan ly Account!!");
				int idChucNang = 0;
				while (idChucNang != 6){
					System.out.println("1. Thêm mới Account ");
					System.out.println("2. Tìm kiếm Account theo họ tên");
					System.out.println("3. Hiện thị thông tin về danh sách Account ");
					System.out.println("4. Nhập vào tên của Account và delete ");
					System.out.println("5. Sắp xếp Account theo số tài khoản ");
					System.out.println("6. Thoát chương trình");
					System.out.print("Moi ban nhap vao chuc nang: ");
					idChucNang = sc.nextInt();
					
					switch (idChucNang) {
					case 1:
						themMoiAcc();
						break;
					case 2:
						timKiem();
						break;
					case 3:
						hienThiThongTinAccount();
						break;
					case 4:
						xoaAccTheoTen();
						break;
					case 5:
						sapXepTheoSTK();
						break;
					case 6:
						System.out.println("Cám ơn bạn đã sử dụng dịch vụ, xin chào và hẹn gặp lại ");
						break;
					default:
						break;
					}
				}
			}
			
			public static void themMoiAcc() {
				System.out.println("Moi ban nhap vao Acc can them ");
				System.out.println("1. Them moi Account thuong ");
				System.out.println("2. Them moi AccountVip ");
				System.out.println("3. Them moi AccountInter ");
				int loaiThemMoi = sc.nextInt();
				switch (loaiThemMoi) {
				case 1:
					themMoiAccThuong();
					break;
				case 2:
					themMoiAccVip();
					break;
				case 3:
					themMoiAccInter();
					break;
				default:
					break;
				}
				
				
			}
			
			public static void themMoiAccThuong() {
				Account accVip = new Account();
				System.out.println("moi ban nhap vao so tai khoan: " );
			String soTaikhoan = sc.nextLine();
				System.out.println("moi ban nhap vao ho ten: " );
			String hoTen = sc.nextLine();
				System.out.println("moi ban nhap vao so CMT: " );
			String soCMT = sc.nextLine();
				System.out.println("moi ban nhap vao so DT: " );
			String sDT = sc.nextLine();
				System.out.println("moi ban nhap vao que quan: " );
			String queQuan = sc.nextLine();
				System.out.println("moi ban nhap vao so du: " );
			float soDu = sc.nextFloat();
				System.out.println("moi ban nhap vao email: " );
			String email = sc.nextLine();
			
				System.out.println("moi ban nhap vao ngay thang nam sinh theo thu tu nam, thang, ngay: " );
				int year = sc.nextInt();
				int month = sc.nextInt();
				int day = sc.nextInt();
			LocalDate ngayThangNamSinh = LocalDate.of(year, month, day);
			/* C2
			 String ngaySinhString = sc.nextLine();
			 LocalDate ngayThangNamSinh = LocalDate.parse(ngaySinhString);
			 DatetimeFormatter formatter = DatetimeFormatter.ofpattern("dd/MM/yy");
			 */
				
			accVip.setSoTaiKhoan(soTaikhoan);
			accVip.setHoTen(hoTen);
			accVip.setSoCMT(soCMT);
			accVip.setsDT(sDT);
			accVip.setQueQuan(queQuan);
			accVip.setSoDu(soDu);
			accVip.setEmail(email);
			accVip.setNgayThangNamSinh(ngayThangNamSinh);
			danhSachAccount.add(accVip);
				
			}
			
			public static void themMoiAccInter() {
				AccountInter accInter = new AccountInter();
				System.out.println("moi ban nhap vao so tai khoan: " );
			String soTaikhoan = sc.nextLine();
				System.out.println("moi ban nhap vao ho ten: " );
			String hoTen = sc.nextLine();
				System.out.println("moi ban nhap vao so CMT: " );
			String soCMT = sc.nextLine();
				System.out.println("moi ban nhap vao so DT: " );
			String sDT = sc.nextLine();
				System.out.println("moi ban nhap vao que quan: " );
			String queQuan = sc.nextLine();
				System.out.println("moi ban nhap vao so du: " );
			float soDu = sc.nextFloat();
				System.out.println("moi ban nhap vao email: " );
			String email = sc.nextLine();
			
				System.out.println("moi ban nhap vao ngay thang nam sinh theo thu tu nam, thang, ngay: " );
				int year = sc.nextInt();
				int month = sc.nextInt();
				int day = sc.nextInt();
			LocalDate ngayThangNamSinh = LocalDate.of(year, month, day);

				System.out.println("Tai khoan CK co gioi han: ");
			boolean coGioiHan = sc.nextBoolean();
				System.out.println("Tai khoan có phuong thuc thanh toan là thanh toan quoc te: ");
			boolean coThanhToanQuocTe = sc.nextBoolean();
			
			
			accInter.setSoTaiKhoan(soTaikhoan);
			accInter.setHoTen(hoTen);
			accInter.setSoCMT(soCMT);
			accInter.setsDT(sDT);
			accInter.setQueQuan(queQuan);
			accInter.setSoDu(soDu);
			accInter.setEmail(email);
			accInter.setNgayThangNamSinh(ngayThangNamSinh);
			accInter.setCoGioiHan(coGioiHan);;
			accInter.setCoThanhToanQuocTe(coThanhToanQuocTe);
			danhSachAccount.add(accInter);
				
			}
			
			public static void themMoiAccVip() {
				AccountVip accVip = new AccountVip();
				System.out.println("moi ban nhap vao so tai khoan: " );
			String soTaikhoan = sc.nextLine();
				System.out.println("moi ban nhap vao ho ten: " );
			String hoTen = sc.nextLine();
				System.out.println("moi ban nhap vao so CMT: " );
			String soCMT = sc.nextLine();
				System.out.println("moi ban nhap vao so DT: " );
			String sDT = sc.nextLine();
				System.out.println("moi ban nhap vao que quan: " );
			String queQuan = sc.nextLine();
				System.out.println("moi ban nhap vao so du: " );
			float soDu = sc.nextFloat();
				System.out.println("moi ban nhap vao email: " );
			String email = sc.nextLine();
			
				System.out.println("moi ban nhap vao ngay thang nam sinh theo thu tu nam, thang, ngay: " );
				int year = sc.nextInt();
				int month = sc.nextInt();
				int day = sc.nextInt();
			LocalDate ngayThangNamSinh = LocalDate.of(year, month, day);
				System.out.println("Tai khoan CK co gioi han: ");
			boolean coGioiHan = sc.nextBoolean();
			
			accVip.setSoTaiKhoan(soTaikhoan);
			accVip.setHoTen(hoTen);
			accVip.setSoCMT(soCMT);
			accVip.setsDT(sDT);
			accVip.setQueQuan(queQuan);
			accVip.setSoDu(soDu);
			accVip.setEmail(email);
			accVip.setNgayThangNamSinh(ngayThangNamSinh);
			accVip.setCoGioiHan(coGioiHan);
			danhSachAccount.add(accVip);
				
			}
			
			public static void hienThiThongTinAccount() {
				System.out.println("Thong tin Account: ");
				for (Account acc : danhSachAccount) {
					System.out.println(acc);
				}
			}
			
			public static void timKiem() {
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhap ten Account can tim kiem: ");
				String hoTen = sc.nextLine();
				if(hoTen == null || hoTen.equals("")) {
					System.out.println("Khong co Account nao khong co ho ten");
				} else {
					boolean timThay = false;
					for (Account acc : danhSachAccount) {
						if(acc.hoTen.contains(hoTen)) {
							System.out.println(acc);
							timThay = true;
						}
					}
					if(!timThay) {
						System.out.println("Khong co Account nao co ten la: " + hoTen);
					}
				}
			}
			
			public static void xoaAccTheoTen() {
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhap ten Account can xoa: ");
				String hoTen = sc.nextLine();
				if(hoTen == null || hoTen.equals("")) {
					System.out.println("Khong co Account nao khong co ho ten");
				} else {
					List<Account> danhSachXoa = new ArrayList<Account>();
					for (Account acc : danhSachAccount) {
						if(acc.hoTen.equals(hoTen)) {
							danhSachXoa.add(acc);
						}
					}
					if(danhSachXoa.size() > 0) {
						danhSachAccount.removeAll(danhSachXoa);
						System.out.println("Ban da xoa tat ca nhung Account co ten: " + hoTen);
					} else {
						System.out.println("Khong tim thay Account can xoa co ten: " + hoTen);
						xoaAccTheoTen();
					}
				}
			}
			
			public static void sapXepTheoSTK() {
				danhSachAccount.sort(Comparator.comparing(Account::getHoTen));
				System.out.println("Thong tin Account: ");
				for (Account acc : danhSachAccount) {
					System.out.println(acc);
				}
	}
		



}


