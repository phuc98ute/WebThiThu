package Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Objects.TaiKhoan;
public class LOPHOC_DAO {
	private Connection conn;
	public LOPHOC_DAO(String username,String password)throws Exception 
	{
		ConnectDB database = new ConnectDB();
		conn=database.Connect(username,password);
	}
	public void ThemSinhVien(String tenSV,String gioiTinh,String SDT) throws SQLException {
		String sql = "insert into taikhoan(MaTK,TenSV,GioiTinh,SDT) \n" + 
				"select(select coalesce((max(MaTK)+1),1) from taikhoan order by MaTK),\n" + 
				"'"+tenSV+"','"+gioiTinh+"','"+SDT+"'";
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	public void XoaSinhVien( int maTK) throws SQLException {
		String sql = "delete from taikhoan where taikhoan.MaTK="+maTK;
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	public void SuaSinhVien(int maTK,String tenSV,String gioiTinh,String sdt) throws SQLException {
		String sql = "update taikhoan set taikhoan.TenSV = '"+tenSV+"',taikhoan.GioiTinh='"+gioiTinh+"',taikhoan.SDT='"+sdt+"'where taikhoan.MaTK="+maTK;
			Statement st = conn.createStatement();
			st.executeUpdate(sql);}
	public List<TaiKhoan> xemDSTaiKhoan() throws SQLException {
		List<TaiKhoan> ds = new ArrayList<TaiKhoan>();
		Statement st= conn.createStatement();
		String sql = "select * from taikhoan";
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
		TaiKhoan tk= new TaiKhoan();
		 tk.setMaTK(rs.getInt("MaTK"));
		 tk.setTenSV(rs.getString("TenSV"));
		 tk.setGioiTinh(rs.getString("GioiTinh"));
		 tk.setSDT(rs.getString("SDT"));
		/* lh.setHocKy(rs.getInt("HocKy"));
		 lh.setMaLopHoc(rs.getInt("MaLopHoc"));*/
		 ds.add(tk);
		}
		return ds;
	}
	public List<TaiKhoan> xemDSTaiKhoanTimKiem(String tenSV) throws SQLException {
		List<TaiKhoan> ds = new ArrayList<TaiKhoan>();
		Statement st= conn.createStatement();
		String sql = "select * from taikhoan where TenSV like N'%"+tenSV+"%'";
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
		TaiKhoan tk= new TaiKhoan();
		 tk.setMaTK(rs.getInt("MaTK"));
		 tk.setTenSV(rs.getString("TenSV"));
		 tk.setGioiTinh(rs.getString("GioiTinh"));
		 tk.setSDT(rs.getString("SDT"));
		/* lh.setHocKy(rs.getInt("HocKy"));
		 lh.setMaLopHoc(rs.getInt("MaLopHoc"));*/
		 ds.add(tk);
		}
		return ds;
	}
}