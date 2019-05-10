package Objects;

public class BaiLam {
	private String maCH;
	private String dapAnChon;
	public String getMaCH() {
		return maCH;
	}
	public void setMaCH(String maCH) {
		this.maCH = maCH;
	}
	public String getDapAnChon() {
		return dapAnChon;
	}
	public void setDapAnChon(String dapAnChon) {
		this.dapAnChon = dapAnChon;
	}
	public BaiLam(String maCH, String dapAnChon) {
		super();
		this.maCH = maCH;
		this.dapAnChon = dapAnChon;
	}
	public BaiLam() {
		this.dapAnChon="0";
	}
	
}
