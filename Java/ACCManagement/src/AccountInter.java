
public class AccountInter extends AccountVip{
	private boolean coThanhToanQuocTe;

	public boolean isCoThanhToanQuocTe() {
		return coThanhToanQuocTe;
	}

	public void setCoThanhToanQuocTe(boolean coThanhToanQuocTe) {
		this.coThanhToanQuocTe = coThanhToanQuocTe;
	}

	@Override
	public String toString() {
		return super.toString() + " [coThanhToanQuocTe=" + coThanhToanQuocTe + "]";
	}
	
	public void thanhToanQuocTe(float soTien) {
		if(coThanhToanQuocTe) {
			this.soDu -= soTien;
		} else {
			System.out.println("Tai khoan khong co chuc nang thanh toan quoc te");
		}

	}
}
