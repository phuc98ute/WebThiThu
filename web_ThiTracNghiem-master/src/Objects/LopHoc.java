package Objects;

public class LopHoc {
	private int MaLopHoc;
	private String TenLopHoc;
	private int HocKy;
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
	public LopHoc(int maLopHoc,String tenLopHoc,int hocKy)
	{
		super();
		TenLopHoc = tenLopHoc;
		HocKy=hocKy;
		MaLopHoc = maLopHoc;
	}
	public LopHoc()
	{
		super();
	}
}
