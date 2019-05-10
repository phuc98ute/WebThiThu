package Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Objects.TaiKhoanLopHoc;

public class TAIKHOANLOPHOC_DAO {
	private Connection conn;
	public TAIKHOANLOPHOC_DAO(String username,String password)throws Exception 
	{
		ConnectDB database = new ConnectDB();
		conn=database.Connect(username,password);
	}
	public void ThemTaiKhoanLopHoc(int maLopHoc,int maTK) throws SQLException {
		String sql1="select * from chitietlophoc where MaTK="+maTK+" and MaLopHoc="+maLopHoc;
		Statement st1=conn.createStatement();
		ResultSet rs = st1.executeQuery(sql1);
		if(!rs.next()) {
			String sql = "insert into chitietlophoc(MaChiTiet,MaLopHoc,MaTK)\r\n" + 
					"select(select coalesce((max(MaChiTiet)+1),1) from chitietlophoc order by MaChiTiet),"+maLopHoc+","+maTK;
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		}
		
	}
	public void XoaTaiKhoanLopHoc(int maLopHoc,int maTK) throws SQLException {
		String sql = "delete from chitietlophoc where MaLopHoc="+ maLopHoc+" and MaTK="+maTK;
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	public List<TaiKhoanLopHoc> xemDSTaiKhoanLopHoc(int maLopHoc) throws SQLException {
		List<TaiKhoanLopHoc> ds = new ArrayList<TaiKhoanLopHoc>();
		Statement st= conn.createStatement();
		String sql = "select taikhoan.MaTK,TenSV,GioiTinh,SDT,HocKy,lophoc.MaLopHoc\r\n" + 
				"from taikhoan inner join chitietlophoc on taikhoan.MaTK=chitietlophoc.MaTK \r\n" + 
				"inner join lophoc on lophoc.MaLopHoc = chitietlophoc.MaLopHoc\r\n" + 
				"where lophoc.MaLopHoc="+maLopHoc+" order by HocKy";
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
		TaiKhoanLopHoc tk = new TaiKhoanLopHoc();
		 tk.setMaLopHoc(rs.getInt("MaLopHoc"));
		 tk.setMaTK(rs.getInt("MaTK"));
		 tk.setTenSV(rs.getString("TenSV"));
		 tk.setGioiTinh(rs.getString("GioiTinh"));
		 tk.setSDT(rs.getString("SDT"));
		 tk.setHocKy(rs.getInt("HocKy"));
		 ds.add(tk);
		}
		return ds;
	}
}