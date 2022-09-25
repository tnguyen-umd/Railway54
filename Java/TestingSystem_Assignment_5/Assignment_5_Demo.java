package TestingSystem_Assignment_5;

public class Assignment_5_Demo {

	public static void main(String[] args) {
		Ex3Student student1 = new Ex3Student("Mr. A", "male", "2012-1-4", "40 nguyen thai hoc", 1, 4,
				"Hello@gmail.com");

		// student1.inputInfo();
		// student1.toString();
		// student1.showInfo();

//		MyMath math = new MyMath();
//		System.out.println(math.sum(1, 2));

		SmartPhone smartPhone = new SmartPhone();
		smartPhone.use3G();
		smartPhone.takePhoto();
		smartPhone.sendMessage();
		smartPhone.receiveMessage();
		smartPhone.weapon();
		System.out.println();

		OldPhone oldPhone = new OldPhone();
		oldPhone.listenRatio();
		oldPhone.sendMessage();
		oldPhone.receiveMessage();
		oldPhone.weapon();
	}
}
