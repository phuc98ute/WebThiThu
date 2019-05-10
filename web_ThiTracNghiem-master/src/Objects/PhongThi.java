package Objects;

public class PhongThi {
	private int MaPhong;
	private int MaLopHoc;
	private int MaDeThi;
	public int getMaLopHoc() {
		return MaLopHoc;
	}
	public void setMaLopHoc(int maLopHoc) {
		MaLopHoc = maLopHoc;
	}

	public int getMaPhong() {
		return MaPhong;
	}
	public void setMaPhong(int maPhongThi) {
		MaPhong = maPhongThi;
	}
	
	public int getMaDeThi() {
		return MaDeThi;
	}
	public void setMaDeThi(int maDeThi) {
		MaDeThi = maDeThi;
	}
	public PhongThi(int maPhong,int maLopHoc,int maDeThi)
	{
		super();
		MaPhong =maPhong;
		MaLopHoc=maLopHoc;
		MaDeThi = maDeThi;
	}
	public PhongThi()
	{
		super();
	}
}