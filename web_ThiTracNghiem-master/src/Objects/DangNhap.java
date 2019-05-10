package Objects;

public class DangNhap {
	private int MaDangNhap;
	private String MatKhau;
	private String Email;
	private int LoaiTaiKhoan;
	public int getMaDangNhap() {
		return MaDangNhap;
	}
	public void setMaDangNhap(int maDangNhap) {
		MaDangNhap = maDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getLoaiTaiKhoan() {
		return LoaiTaiKhoan;
	}
	public void setLoaiTaiKhoan(int loaiTaiKhoan) {
		LoaiTaiKhoan = loaiTaiKhoan;
	}
	public DangNhap(int maDangNhap,String matKhau,String email,int loaiTaiKhoan)
	{
		super();
		MaDangNhap = maDangNhap;
		MatKhau = matKhau;
		Email = email;
		LoaiTaiKhoan = loaiTaiKhoan;
	}
	public DangNhap()
	{
		super();
	}
}

