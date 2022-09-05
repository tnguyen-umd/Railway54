package QLCB;

public class worker extends Users {
	private byte level;// levels from 1 to 10

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public worker(String name, byte age, String address, byte level) {
		super(name, age, address);
		this.level = level;
	}

}
