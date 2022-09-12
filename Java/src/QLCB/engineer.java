package QLCB;

public class engineer extends User {
	private String nganhDaoTao;

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}

	public engineer(String name, byte age, double salaryRatio, String address, String nganhDaoTao) {
		super(name, age, salaryRatio, address);
		this.nganhDaoTao = nganhDaoTao;
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
