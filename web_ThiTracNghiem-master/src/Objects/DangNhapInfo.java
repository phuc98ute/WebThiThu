package Objects;

public class DangNhapInfo {
	private int MaTaiKhoan;
	private int MatKhau;
	private String Email;
	private int Role;
	private String TenTaiKhoan;
	private String GioiTinh;
	private String SDT;
	public int getMaTaiKhoan() {
		return MaTaiKhoan;
	}
	public void setMaTaiKhoan(int maTaiKhoan) {
		MaTaiKhoan = maTaiKhoan;
	}
	public int getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(int matKhau) {
		MatKhau = matKhau;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getRole() {
		return Role;
	}
	public void setRole(int role) {
		Role = role;
	}
	public String getTenTaiKhoan() {
		return TenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		TenTaiKhoan = tenTaiKhoan;
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
	public DangNhapInfo(int maTaiKhoan, int matKhau, String email, int role, String tenTaiKhoan, String gioiTinh,
			String sDT) {
		super();
		MaTaiKhoan = maTaiKhoan;
		MatKhau = matKhau;
		Email = email;
		Role = role;
		TenTaiKhoan = tenTaiKhoan;
		GioiTinh = gioiTinh;
		SDT = sDT;
	}
	public DangNhapInfo() {
		super();
	}
	
}
