package Objects;
public class ChiTietDeThi {
	private int MaChiTiet;
	private int MaDeThi;
	private int MaCauHoi;
	public int getMaDeThi() {
		return MaDeThi;
	}
	public void setMaDeThi(int maDeThi) {
		MaDeThi = maDeThi;
	}
	public int getMaChiTiet() {
		return MaChiTiet;
	}
	public void setMaChiTiet(int maChiTiet) {
		MaChiTiet = maChiTiet;
	}
	public int getMaCauHoi() {
		return MaCauHoi;
	}
	public void setMaCauHoi(int maCauHoi) {
		MaCauHoi = maCauHoi;
	}
	public ChiTietDeThi(int maChiTiet,int maDeThi,int maCauHoi)
	{
		super();
		MaChiTiet = maChiTiet;
		MaDeThi=maDeThi;
		MaCauHoi = maCauHoi;
	}
	public ChiTietDeThi()
	{
		super();
	}
}

