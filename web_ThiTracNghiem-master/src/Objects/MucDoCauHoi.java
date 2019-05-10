package Objects;

public class MucDoCauHoi {
	private int MaMucDo;
	private String TenMucDo;
	public int getMaMucDo() {
		return MaMucDo;
	}
	public void setMaMucDo(int maMucDo) {
		MaMucDo = maMucDo;
	}
	public String getTenMucDo() {
		return TenMucDo;
	}
	public void setTenMucDo(String tenMucDo) {
		TenMucDo = tenMucDo;
	}
	public MucDoCauHoi(int maMucDo,String tenMucDo) {
		super();
		MaMucDo=maMucDo;
		TenMucDo=tenMucDo;
	}
	public MucDoCauHoi() {
		super();
	}
}
