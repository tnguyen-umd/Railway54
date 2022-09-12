package entity;

import backend.ScannerUtils;

public class Department2 {
	// private Scanner scanner = new Scanner(System.in);
	private int id;
	private String name;

	public Department2() throws Exception {
		ScannerUtils su = new ScannerUtils();
		System.out.print("Please input your name: ");
		this.name = su.inputString();
		System.out.print("Please input your id: ");
		this.id = su.inputInt("Wrong input, use integers only");
	}

	@Override
	public String toString() {
		System.out.println("Department info: ");
		return "id =" + id + " & name = " + name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
