package Objects;

public class TaiKhoan {
	private int MaTK;
	private String TenSV;
	private String GioiTinh;
	private String SDT;
	private String Lop;
	private int MaDangNhap;
	public int getMaTK() {
		return MaTK;
	}
	public void setMaTK(int maTK) {
		MaTK = maTK;
	}
	public String getTenSV() {
		return TenSV;
	}
	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getLop() {
		return Lop;
	}
	public void setLop(String lop) {
		Lop = lop;
	}
	public int getMaDangNhap() {
		return MaDangNhap;
	}
	public void setMaDangNhap(int maDangNhap) {
		MaDangNhap = maDangNhap;
	}
	public TaiKhoan(int maTK,String tenSV,String gioiTinh,String sdt,String lop,int maDangNhap) {
		super();
		MaTK = maTK;
		TenSV=tenSV;
		GioiTinh=gioiTinh;
		SDT = sdt;
		Lop = lop;
		MaDangNhap=maDangNhap;
	}
	public TaiKhoan() {
		super();
	}
}
