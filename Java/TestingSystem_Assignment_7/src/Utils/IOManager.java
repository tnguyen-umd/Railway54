
package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOManager {
	static FileManager fileManager = new FileManager();

	public static void main(String[] args) throws IOException {

		// for write file, if you want to keep writing the content---> use true,
		// otherwise use false to replace the content
		writeFile("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\Test.txt", ". Hello there ", true);
		readFile("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\Test.txt");

	}

	// Exercise 4 (Optional): IO Stream
	// Tạo class IOManager ở package utils, sau đó tất cả các Question trong
	// Exercise này
	// sẽ viết vào trong class IOManager, với mỗi Question sẽ viết demo ở front-end
	// Chú ý: tất cả các error message nên để là constant (static final String)

	// Question 1: Tạo method read File
	// Tạo 1 method có đầu vào là String filePath và return ra nội dung trong
	// file.
	// Chú ý:
	// Nếu file không tồn tại thì sẽ throw ra Exception "Error! File
	// Not Exist." (sử dụng FileManager ở trên đẻ check)
	// Gợi ý: Tạo method String readFile(String pathFile)

	// Question 2: Tạo method write content to File
	// Tạo 1 method để write file
	// Chú ý:
	// Nếu file không tồn tại thì sẽ throw ra Exception "Error! File
	// Not Exist." (sử dụng FileManager ở exercise trên để check)
	// Gợi ý: Tạo method void writeFile(String pathFile, isContinuing
	// String content)
	// Nếu isContinuing = false thì sẽ xóa hết nội dung trong file đi và
	// write content mới vào
	// Nếu isContinuing = true thì sẽ ghi content vào cuối file

	public static void readFile(String filePath) {

		byte[] b = new byte[1024];
		try {

			FileManager.checkFileExist(filePath);
			FileInputStream fileInputStream = new FileInputStream(filePath);

			int length = fileInputStream.read(b);
			System.out.print("Length of the file is ");
			System.out.println(length);

			// read content
			while (length > -1) {
				String content = new String(b, 0, length);
				System.out.println("Content: ");
				System.out.println(content);
				System.out.println("---------------------------------");

				// continue reading file from position read(b)
				length = fileInputStream.read(b);
			}
			fileInputStream.close();
		} catch (Exception e) {
		}

	}

	public static void writeFile(String filePath, String content, boolean isContinuing) {
		try {
			FileManager.checkFileExist(filePath);
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, isContinuing);

			fileOutputStream.write(content.getBytes());
			System.out.println("File has been modified successfully");
			fileOutputStream.close();
		} catch (Exception e) {
		}

	}
}

//Question 3: Tạo method write Object
//Hãy viết 1 method để có thể write object
//Chú ý: 
//Nếu object = null thì sẽ throw ra Exception "Error! Object is 
//Null."
//Nếu folder không tồn tại thì sẽ tạo folder.
//Nếu file đã tồn tại trong folder thì sẽ ghi đè lên file cũ
//Gợi ý: Tạo method void writeObject(Object object, String path, 
//String fileName)

//Question 4: Tạo method read Object
//Tạo 1 method có đầu vào là String filePath và return ra Object
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! File 
//Not Exist." (sử dụng FileManager ở trên để check)
//Gợi ý: Tạo method Object readObject(String filePath)

//Exercise 5: Demo File & IO Stream
//Question 1: Tạo class Student có property id, name. 
//a) Sau đó khởi 3 instance từ console (sử dụng ScannerUtils)
//b) Write 3 student này ra file tên là StudentInformation.txt
//c) Sau đó đọc thông tin file StudentInformation.txt và in ra màn hình

//Question 2: Tạo LogUtils (sử dụng write Object Exception)
//Tạo 1 custom Exception Object, sau đó tại hàm main sẽ bắt exception 
//ko mong muốn và lưu thông tin Exception.ser file
//Các bước làm sẽ như sau:
//B1: Tạo 1 object MyException sẽ extends Exception, trong 
//MyException sẽ chứa các thông tin như: message, reason, StackTrace, 
//time (thời gian bị Exception), …
//B2: Sau đó tạo class LogUtils có 1 vài method như sau:
//1. void writeLog (String message, String reason, StackTrace, 
//Datetime time) (gợi ý: sử dụng IOManager ở trên để write file)
//2. void writeLog (MyException exception)
//B3: đặt try catch ở method main() hoặc ở bất kỳ chỗ nào muốn lưu lại 
//thông tin exception
//B4: Tạo method để đọc thông tin trong file Exception và in ra màn 
//hình
//B5: Demo chương trình
