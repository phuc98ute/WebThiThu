package Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Objects.LopHoc;
public class LOPHOC1_DAO {
	private Connection conn;
	public LOPHOC1_DAO(String username,String password)throws Exception 
	{
		ConnectDB database = new ConnectDB();
		conn=database.Connect(username,password);
	}
	public void ThemLopHoc(String tenLopHoc,int hocKy) throws SQLException {
		String sql = "insert into lophoc(MaLopHoc,TenLopHoc,HocKy) \n" + 
				"select(select coalesce((max(MaLopHoc)+1),1) from lophoc order by MaLopHoc),\n" + 
				"'"+tenLopHoc+"',"+hocKy;
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	public void XoaLopHoc( int maLopHoc) throws SQLException {
		String sql = "delete from LopHoc where lophoc.MaLopHoc="+ maLopHoc;
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	public void SuaLopHoc(int maLopHoc,String tenLopHoc,int hocKy) throws SQLException {
		String sql = "update lophoc set lophoc.TenLopHoc = '"+tenLopHoc+"',lophoc.HocKy="+hocKy+" where lophoc.MaLopHoc="+maLopHoc;
			Statement st = conn.createStatement();
			st.executeUpdate(sql);}
	public List<LopHoc> xemDSLopHoc() throws SQLException {
		List<LopHoc> ds = new ArrayList<LopHoc>();
		Statement st= conn.createStatement();
		String sql = "select * from LopHoc";
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) 
		{
		LopHoc lh = new LopHoc();
		 lh.setMaLopHoc(rs.getInt("MaLopHoc"));
		 lh.setTenLopHoc(rs.getString("TenLopHoc"));
		 lh.setHocKy(rs.getInt("HocKy"));
		 ds.add(lh);
		}
		return ds;
	}
	public List<LopHoc> xemDSLopHocTimKiem(String tenLopHoc) throws SQLException 
	{
			List<LopHoc> ds = new ArrayList<LopHoc>();
			Statement st= conn.createStatement();
			String sql = "select * from LopHoc where TenLopHoc like '%"+tenLopHoc+"%'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) 
			{
			LopHoc lh = new LopHoc();
			 lh.setMaLopHoc(rs.getInt("MaLopHoc"));
			 lh.setTenLopHoc(rs.getString("TenLopHoc"));
			 lh.setHocKy(rs.getInt("HocKy"));
			 ds.add(lh);
			}
		return ds;
	}
}