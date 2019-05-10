package Objects;

public class LoaiTaiKhoan {
	private int MaLoaiTK;
	private String TenLoaiTK;
	public String getTenLoaiTK() {
		return TenLoaiTK;
	}
	public void setTenLoaiTK(String tenLoaiTK) {
		TenLoaiTK = tenLoaiTK;
	}
	public int getMaLoaiTK() {
		return MaLoaiTK;
	}
	public void setMaLoaiTK(int maLoaiTK) {
		MaLoaiTK = maLoaiTK;
	}
	public LoaiTaiKhoan(int maLoaiTK,String tenLoaiTK) {
		super();
		MaLoaiTK = maLoaiTK;
		TenLoaiTK=tenLoaiTK;
	}
	public LoaiTaiKhoan() {
		super();
	}
}
