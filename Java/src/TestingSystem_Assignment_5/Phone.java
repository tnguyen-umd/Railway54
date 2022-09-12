package TestingSystem_Assignment_5;

public class Phone implements IPhone {

	public void call() {
		System.out.println("Calling");
	}

	public void listen() {
		System.out.println("Listening");

	}

	public void sendMessage() {
		System.out.println("Sending messages");

	}

	public void receiveMessage() {
		System.out.println("Receiving messages");

	}

	@Override
	public void weapon() {
		System.out.println("Your phone can be used as weapon in case of emergency");
	}

}

//Question 5 (Optional): 

//Dien thoai: call(), listen(), sendMessage(), receiveMessage(), weapon();
//nghe và gọi điện thoại, gửi và nhận tin nhắn văn bản. 
//đều có thể sử dụng làm vũ khí

//Riêng điện thoại thông minh thì có thêm các chức năng: sử dụng 3G, chụp hình. 
//3G(), takePhoto();
//Điện thoại cổ điển có sẵn chức năng nghe đài radio: listenRadio();
//Hãy thiết kế các class, interface, method