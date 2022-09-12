package QLCB;

public class worker extends User {
	private byte level;// levels from 1 to 10

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public worker(String name, byte age, double salaryRatio, String address, byte level) {
		super(name, age, salaryRatio, address);
		this.level = level;
	}

	@Override
	public void calculatePay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayInfor() {
		// TODO Auto-generated method stub

	}

}
