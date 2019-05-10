package Objects;

public class CauHoi {
	private int MaCauHoi;
	private String NoiDungCauHoi;
	private int MaMucDo;
	private String DapAn_A;
	private String DapAn_B;
	private String DapAn_C;
	private String DapAn_D;
	private String DapAnDung;
	public String isDapAn_D() {
		return DapAn_D;
	}
	public void setDapAn_D(String dapAn_D) {
		DapAn_D = dapAn_D;
	}
	public String isDapAn_C() {
		return DapAn_C;
	}
	public void setDapAn_C(String dapAn_C) {
		DapAn_C = dapAn_C;
	}
	public String isDapAn_B() {
		return DapAn_B;
	}
	public void setDapAn_B(String dapAn_B) {
		DapAn_B = dapAn_B;
	}
	public String isDapAn_A() {
		return DapAn_A;
	}
	public void setDapAn_A(String dapAn_A) {
		DapAn_A = dapAn_A;
	}
	public int getMaMucDo() {
		return MaMucDo;
	}
	public void setMaMucDo(int maMucDo) {
		MaMucDo = maMucDo;
	}
	public String getNoiDungCauHoi() {
		return NoiDungCauHoi;
	}
	public void setNoiDungCauHoi(String noiDungCauHoi) {
		NoiDungCauHoi = noiDungCauHoi;
	}
	public CauHoi(int maCauHoi, String noiDungCauHoi,int maMucDo,String dapAn_A,String dapAn_B,String dapAn_C,String dapAn_D) {
		super();
		setMaCauHoi(maCauHoi);
		NoiDungCauHoi=noiDungCauHoi;
		MaMucDo=maMucDo;
		DapAn_A=dapAn_A;
		DapAn_B=dapAn_B;
		DapAn_C=dapAn_C;
		DapAn_D=dapAn_D;
	}
	public CauHoi() {
		super();
	}
	public int getMaCauHoi() {
		return MaCauHoi;
	}
	public void setMaCauHoi(int maCauHoi) {
		MaCauHoi = maCauHoi;
	}
	public String getDapAnDung() {
		return DapAnDung;
	}
	public void setDapAnDung(String dapAnDung) {
		DapAnDung = dapAnDung;
	}
}
