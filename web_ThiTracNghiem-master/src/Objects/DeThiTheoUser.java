package Objects;

public class DeThiTheoUser {
	private String tenSV;
	private int hocKy;
	private String tenLopHoc;
	private int maDeThi;
	private boolean isActive;
	private int tongSoCauHoi;
	private float thangDiem;
	private String thoiGianBatDau;
	private int thoiLuong;
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public int getHocKy() {
		return hocKy;
	}
	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}
	public String getTenLopHoc() {
		return tenLopHoc;
	}
	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}
	public int getMaDeThi() {
		return maDeThi;
	}
	public void setMaDeThi(int maDeThi) {
		this.maDeThi = maDeThi;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getTongSoCauHoi() {
		return tongSoCauHoi;
	}
	public void setTongSoCauHoi(int tongSoCauHoi) {
		this.tongSoCauHoi = tongSoCauHoi;
	}
	public float getThangDiem() {
		return thangDiem;
	}
	public void setThangDiem(float thangDiem) {
		this.thangDiem = thangDiem;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public int getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public DeThiTheoUser(String tenSV, int hocKy, String tenLopHoc, int maDeThi, boolean isActive, int tongSoCauHoi,
			float thangDiem, String thoiGianBatDau, int thoiLuong) {
		super();
		this.tenSV = tenSV;
		this.hocKy = hocKy;
		this.tenLopHoc = tenLopHoc;
		this.maDeThi = maDeThi;
		this.isActive = isActive;
		this.tongSoCauHoi = tongSoCauHoi;
		this.thangDiem = thangDiem;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiLuong = thoiLuong;
	}
	public DeThiTheoUser() {
		super();
	}
	
}
