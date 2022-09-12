package TestingSystem_Assignment_5;

public class HinhChuNhat {

	public float chuVi(float a, float b) {
		return 2 * (a + b);
	}

	public float dienTich(float a, float b) {
		return a * b;
	}

}

//Question 3: This & Super, Overriding
//Tạo 1 class HinhChuNhat có 2 method: tính chu vi và tính diện tích. 
//Hãy implement 2 method này.
//Tiếp theo hãy tạo 1 class HinhVuong extends HinhChuNhat, có 2 
//method tính chu vi và tính diện tích
//Chú ý:
//Không implement method trong class HinhVuong theo công 
//thức tính diện tích, chu vi hình vuông mà sẽ gọi theo 
//HinhChuNhat.tinhChuVi(), HinhChuNhat.tinhDienTich() )
//Và trong mỗi method print thêm dòng "Tính diện tích/ chu vi 
//theo Hình Vuông/ Hình Chữ Nhật"