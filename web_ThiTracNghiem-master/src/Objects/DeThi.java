package Objects;
public class DeThi {
	private int MaDeThi;
	private int HocKy;
	private String ThoiGianBatDau;
	private int ThoiLuong;
	private int SoCHDe;
	private int SoCHTB;
	private int SoCHKho;
	private float ThangDiem;
	private boolean IsActive;
	public int getMaDeThi() {
		return MaDeThi;
	}
	public void setMaDeThi(int maDeThi) {
		MaDeThi = maDeThi;
	}
	public int getHocKy() {
		return HocKy;
	}
	public void setHocKy(int hocKy) {
		HocKy = hocKy;
	}

	public String getThoiGianBatDau() {
		return ThoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		ThoiGianBatDau = thoiGianBatDau;
	}
	public int getThoiLuong() {
		return ThoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		ThoiLuong = thoiLuong;
	}
	public int getSoCHDe() {
		return SoCHDe;
	}
	public void setSoCHDe(int soCHDe) {
		SoCHDe = soCHDe;
	}
	public int getSoCHTB() {
		return SoCHTB;
	}
	public void setSoCHTB(int soCHTB) {
		SoCHTB = soCHTB;
	}
	public int getSoCHKho() {
		return SoCHKho;
	}
	public void setSoCHKho(int soCHKho) {
		SoCHKho = soCHKho;
	}
	public float getThangDiem() {
		return ThangDiem;
	}
	public void setThangDiem(float thangDiem) {
		ThangDiem = thangDiem;
	}
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public DeThi(int maDeThi, int hocKy, String thoiGianBatDau, int thoiLuong, int soCHDe, int soCHTB, int soCHKho,
			float thangDiem, boolean isActive) {
		super();
		MaDeThi = maDeThi;
		HocKy = hocKy;
		ThoiGianBatDau = thoiGianBatDau;
		ThoiLuong = thoiLuong;
		SoCHDe = soCHDe;
		SoCHTB = soCHTB;
		SoCHKho = soCHKho;
		ThangDiem = thangDiem;
		IsActive = isActive;
	}
	public DeThi() {
	}
	
}
