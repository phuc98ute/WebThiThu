package Objects;

public class TaiKhoanLopHoc {
	private int MaLopHoc;
	private String TenLopHoc;
	private int HocKy;
	private int MaTK;
	private String TenSV;
	private String GioiTinh;
	private String SDT;

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
	
	public int getMaLopHoc() {
		return MaLopHoc;
	}
	public void setMaLopHoc(int maLopHoc) {
		MaLopHoc = maLopHoc;
	}
	public int getHocKy() {
		return HocKy;
	}
	public void setHocKy(int hocKy) {
		HocKy = hocKy;
	}

	public String getTenLopHoc() {
		return TenLopHoc;
	}
	public void setTenLopHoc(String tenLopHoc) {
		TenLopHoc = tenLopHoc;
	}
	public TaiKhoanLopHoc(int maLopHoc, String tenLopHoc, int hocKy, int maTK, String tenSV, String gioiTinh,
			String sDT) {
		super();
		MaLopHoc = maLopHoc;
		TenLopHoc = tenLopHoc;
		HocKy = hocKy;
		MaTK = maTK;
		TenSV = tenSV;
		GioiTinh = gioiTinh;
		SDT = sDT;
	}
	public TaiKhoanLopHoc() {
		super();
	
	}
	
}
