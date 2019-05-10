package Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Objects.CauHoi;
public class CAUHOI_DAO {
	private Connection conn;
	public CAUHOI_DAO(String username,String password)throws Exception {
		ConnectDB database = new ConnectDB();
		conn=database.Connect(username,password);
	}
	public void themCauHoi(String noiDungCauHoi, int maMucDo, String dapAn_A,String dapAn_B,String dapAn_C,String dapAn_D,String dapAnDung) throws SQLException {
		String sql = "insert into cauhoi(MaCauHoi,NoiDungCauHoi,MaMucDo,DapAn_A,DapAn_B,DapAn_C,DapAn_D,DapAnDung) "
				+ "select(select coalesce((max(MaCauHoi)+1),1) from cauhoi order by MaCauHoi),"
				+ "'"+noiDungCauHoi+"',"+maMucDo+",'"+dapAn_A+"','"+dapAn_B+"','"+dapAn_C+"','"+dapAn_D+"','"+dapAnDung+"'";
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	public void XoaCauHoi( int maCauHoi) throws SQLException {
		String sql = "delete from cauhoi where cauhoi.MaCauHoi="+maCauHoi;
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	public void suaCauHoi( int maCauHoi, String noiDungCauHoi, int maMucDo, String dapAn_A,String dapAn_B,String dapAn_C,String dapAn_D,String dapAnDung) throws SQLException {
		String sql = "update cauhoi set cauhoi.NoiDungCauHoi=N'"+noiDungCauHoi+ 
				"',cauhoi.maMucDo="+maMucDo+
				",cauhoi.DapAn_A=N'"+dapAn_A + 
				"',cauhoi.DapAn_B=N'"+dapAn_B+ 
				"',cauhoi.DapAn_C=N'"+dapAn_C + 
				"',cauhoi.DapAn_D=N'"+dapAn_D+
				"',cauhoi.DapAnDung=N'"+dapAnDung+"'where cauhoi.MaCauHoi="+maCauHoi;
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
	}
	public List<CauHoi> xemDSCauHoi1() throws SQLException {
		List<CauHoi> ds = new ArrayList<CauHoi>();
		Statement st= conn.createStatement();
		String sql = "select * from cauhoi";
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
		 CauHoi ch= new CauHoi();
		 ch.setMaCauHoi(rs.getInt("MaCauHoi"));
		 ch.setNoiDungCauHoi(rs.getString("NoiDungCauHoi"));
		 ch.setMaMucDo(rs.getInt("MaMucDo"));
		 ch.setDapAn_A(rs.getString("DapAn_A"));
		 ch.setDapAn_B(rs.getString("DapAn_B"));
		 ch.setDapAn_C(rs.getString("DapAn_C"));
		 ch.setDapAn_D(rs.getString("DapAn_D"));
		 ch.setDapAnDung(rs.getString("DapAnDung"));
		 ds.add(ch);
		}
		return ds;
	}
	
	public List<CauHoi> xemDSCauHoi(int giaTriDau, int soLuong) throws SQLException {
		List<CauHoi> ds = new ArrayList<CauHoi>();
		Statement st= conn.createStatement();
		String sql = "select * from cauhoi"+" limit "+giaTriDau+","+soLuong;
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
		 CauHoi ch= new CauHoi();
		 ch.setMaCauHoi(rs.getInt("MaCauHoi"));
		 ch.setNoiDungCauHoi(rs.getString("NoiDungCauHoi"));
		 ch.setMaMucDo(rs.getInt("MaMucDo"));
		 ch.setDapAn_A(rs.getString("DapAn_A"));
		 ch.setDapAn_B(rs.getString("DapAn_B"));
		 ch.setDapAn_C(rs.getString("DapAn_C"));
		 ch.setDapAn_D(rs.getString("DapAn_D"));
		 ch.setDapAnDung(rs.getString("DapAnDung"));
		 ds.add(ch);
		}
		return ds;
	}
	public List<CauHoi> xemDSCauHoiTimKiem(int giaTriDau, int soLuong,String noiDungCauHoi) throws SQLException {
		List<CauHoi> ds = new ArrayList<CauHoi>();
		Statement st= conn.createStatement();
		String sql = "select * from cauhoi where NoiDungCauHoi like '%"+noiDungCauHoi+"%' limit "+giaTriDau+","+soLuong;
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
		 CauHoi ch= new CauHoi();
		 ch.setMaCauHoi(rs.getInt("MaCauHoi"));
		 ch.setNoiDungCauHoi(rs.getString("NoiDungCauHoi"));
		 ch.setMaMucDo(rs.getInt("MaMucDo"));
		 ch.setDapAn_A(rs.getString("DapAn_A"));
		 ch.setDapAn_B(rs.getString("DapAn_B"));
		 ch.setDapAn_C(rs.getString("DapAn_C"));
		 ch.setDapAn_D(rs.getString("DapAn_D"));
		 ch.setDapAnDung(rs.getString("DapAnDung"));
		 ds.add(ch);
		}
		return ds;
	}
	
	public int xemTongSoCauHoi() throws SQLException {
		int count=0;
		Statement st= conn.createStatement();
		String sql = "select count(MaCauHoi) from cauhoi";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			count=rs.getInt(1);
		}
		return count;
	}
}
