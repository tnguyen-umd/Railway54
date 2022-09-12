
package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//Exercise 3 (Optional): File
//Tạo class FileManager ở package utils, sau đó tất cả các Question trong Exercise này 
//sẽ viết vào trong class FileManager, với mỗi Question sẽ viết demo ở front-end
//Chú ý: tất cả các error message nên để là constant (static final String)

//Question 2: Create new file
//Tạo 1 method để có thể tạo được file.
//Chú ý:
//Kiểm tra xem file đã tồn tại hay chưa, nếu file đã tồn tại thì sẽ 
//throw ra Exception "Error! File Exist."
//Gợi ý: 
//Tạo method void createNewFile(String pathFile)
//Vào tạo thêm method void createNewFile(String path, String 
//fileName)

//Question 4: Delete file
//Tạo 1 method để có thể delete file
//Chú ý: 
//4
//Kiểm tra xem file đã tồn tại hay chưa, nếu file chưa tồn tại thì 
//sẽ throw ra Exception "Error! File Not Exist."
//Gợi ý: Tạo method void deleteFile(String pathFile)

//Question 5: Check path is File or Folder
//Tạo 1 method để kiểm tra xem path có thể là File hay Folder.
//Gợi ý: Tạo method boolean isFolder(String path)

//Question 6: Get all File name of Folder
//Tạo 1 method để lấy ra tất cả các tên file trong 1 Folder.
//Chú ý: 
//Kiểm tra xem path nhập vào có phải là folder hay không, nếu
//không phải thì sẽ throw ra Exception "Error! Path is not 
//folder."
//Gợi ý: Tạo method List<String> getAllFileName(String path)

//Question 7: Copy File
//Tạo 1 method để copy file.
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! Source 
//File Not Exist."
//Nếu file đích đã tồn tại thì sẽ throw ra Exception "Error! 
//newPath has File same name."
//Gợi ý: 
//Tạo method void copyFile(String sourceFile, String 
//distinationPath, String newName)
//Và tạo method void copyFile(String sourceFile, String 
//newPath). Với File mới sẽ có tên cùng với file cũ 

//Question 8: Moving file
//Tạo 1 method để di chuyển file sang folder khác.
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! File 
//Not Exist.".
//Phải xóa file cũ đi
//Gợi ý: 
//Tạo method void moveFile(String sourceFile, String 
//destinationPath)

//Question 9: Rename File
//Tạo 1 method để đổi tên file.
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! File 
//Not Exist.".
//5
//Nếu newName đã tồn tại thì sẽ throw ra Exception "Error!
//Name is Exist.".
//Gợi ý: 
//Tạo method void renameFile(String pathFile, String 
//newName)

public class FileManager {
	public static final String FOLDER_NOT_EXIST = "This folder does not exist";
	public static final String FILE_NOT_EXIST = "This file does not exist";

	public static void main(String[] args) throws Exception {
		checkFileExist("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\Test.txt");
//		createFile("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\", "Test.txt");
//		// deleteFile("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\Test.txt");
//		checkPath("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\Test.txt");
//		getAllFileNames("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\");

		// Using copy file: original file name, destination folder, new file name
//		copyFile("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\Test.txt",
//				"C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\","Test.txt");

		// Using moveFile: original file path name, new path+name
//		moveFile("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\Test.txt",
//				"C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Test1.txt");

		// Using moveFile: original file path name, new path+name
//		renameFile("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Test1.txt",
//				"C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Test10.txt");

		// Question 10: Create new folder
		// Tạo 1 method để có thể tạo được folder.
		// Chú ý:
		// Kiểm tra xem folder đã tồn tại hay chưa, nếu folder đã tồn tại
		// thì sẽ throw ra Exception "Error! Folder Exist."
		// Gợi ý: Tạo method void createNewFolder(String newPathFolder)

		createFolder("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\NewFolder");

	}

	public static void checkFileExist(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println(FILE_NOT_EXIST);
		}

	}

	public static boolean checkFolder(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			return true;
		} else {
			System.out.println(FOLDER_NOT_EXIST);
			return true;
		}

	}

	public static void createFile(String path, String fileName) throws IOException {
		File file = new File(path, fileName);
		if (file.createNewFile()) {
			System.out.println("File created successfully");
		} else {
			System.out.println("Error, file exists");
		}

	}

	public static void deleteFile(String filePath) throws IOException {
		File file = new File(filePath);
		if (file.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("File does not exist");
		}

	}

	public static void checkPath(String filePath) throws IOException {
		File file = new File(filePath);
		System.out.println(file.isDirectory() ? "Path is a folder" : "Path is a file");

	}

	public static void getAllFileNames(String filePath) {
		File file = new File(filePath);
		if (file.isDirectory()) {
			for (String fileName : file.list()) {
				System.out.println(fileName);
			}

		} else {
			System.out.println("Error, this is not a folder");
		}
	}

	public static void copyFile(String original, String destination, String copiedName) throws Exception {
		File file = new File(original);
		if (file.exists()) {

			Path destinationFile = Paths.get(destination, copiedName);
			Path originalFile = file.toPath();
			if (originalFile.equals(destinationFile)) {
				System.out.println("Error, file name exists in folder, overwriting is prohibited");
			} else {
				Files.copy(originalFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Copying success!");
			}

			// System.out.println(e.getMessage());

		}
		if (file.exists() == false)

		{
			System.out.println("Error, source file does not exist");
		}

//		assertThat(copied).exists();
//		assertThat(Files.readAllLines(originalPath).equals(Files.readAllLines(copied)));
	}

	public static void moveFile(String originalFile, String newFile) {

		File file = new File(originalFile);

		// renaming the file and moving it to a new location
		if (file.renameTo(new File(newFile))) {
			// if file copied successfully then delete the original file
			file.delete();
			System.out.println("File moved successfully");
		} else {
			System.out.println("Failed to move the file");
		}
	}

	public static void renameFile(String originalFile, String newFile) {

		File file = new File(originalFile);

		// renaming the file and moving it to a new location
		if (file.renameTo(new File(newFile))) {
			// if file copied successfully then delete the original file
			file.delete();
			System.out.println("File renamed successfully");
		} else {
			System.out.println("Failed to rename the file");
		}
	}

	public static void createFolder(String newFolder) {
		try {

			Path path = Paths.get(newFolder);

			// java.nio.file.Files;
			Files.createDirectories(path);

			System.out.println("Directory is created!");

		} catch (IOException e) {

			System.err.println("Failed to create directory!" + e.getMessage());

		}
	}

}

//Question 11: Download File==========================SKIP FOR NOW===========================================
//Hãy viết 1 method để có thể download được file ở trên mạng
//Chú ý: 
//Nếu folder không tồn tại thì sẽ tạo folder.
//Nếu tên file download đã tồn tại trong folder thì sẽ thêm (1), (2) 
//vào sau tên file (giống download file ở window).
//Gợi ý: 
//Tạo method void downloadFile(String fileLink, String 
//folder)

//Code tham khảo

//Question 3 (Optional):
//Thiết kế bài lô đề của exercise trước với những cải tiến về handling 
//exception, đăt các property static, final cho hợp lý và thêm các chức 
//năng sau đây:
//a) Đăng ký tài khoản (thông tin các tài khoản sẽ lưu vào file)
//Có 2 loại tài khoản admin và user.
//b) Đăng nhập vào hệ thống
//c) Đăng xuất tài khoản
//d) Cho phép nạp tiền vào tài khoản (lưu thông tin vào file)
//e) Lưu thông tin kết quả lô đề từng ngày vào file
//f) Lưu thông tin người dùng chơi lô đề vào file
//g) Tạo thêm chức năng sau:
//1) Chỉ có admin mới có thể xem thông tin tất cả các tài 
//khoản (giống table ở SQL khi SELECT * Account, ẩn 
//mật khẩu đi)
//2) Người dùng có thể xem lại thông tin lô đề từng ngày (hệ 
//thống có hỗ trợ chức năng tìm kiếm theo ngày, và lọc 
//chỉ xem từ ngày nào tới ngày nào)
