package QLCB;

public class engineer extends Users {
	private String nganhDaoTao;

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}

	public engineer(String name, byte age, String address, String nganhDaoTao) {
		super(name, age, address);
		this.nganhDaoTao = nganhDaoTao;
	}

}
