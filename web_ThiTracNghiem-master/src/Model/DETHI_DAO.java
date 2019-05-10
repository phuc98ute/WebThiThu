package Model;
import java.sql.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Objects.CauHoi;
import Objects.DeThi;
import Objects.dsCauHoi;
public class DETHI_DAO {
	private Connection conn;
	public DETHI_DAO(String username,String password)throws Exception {
		ConnectDB database = new ConnectDB();
		conn=database.Connect(username,password);
	}
	public void themDeThi( int HocKy, String ThoiGian,int thoiLuong,  int SoCHDe,int SoCHTB,int SoCHKho, float ThangDiem,boolean IsActive ) throws SQLException {
		String sql="INSERT INTO `dethi`\r\n" + 
				"(`MaDeThi`,`HocKy`,`ThoiGianBatDau`,`ThoiLuong`,`SoCHDe`,`SoCHTrungBinh`,`SoCHKho`,`ThangDiem`,`IsActive`)\r\n" + 
				"\r\n" + 
				"select(select coalesce((max(MaDeThi)+1),1) from dethi order by MaDeThi),\r\n" + 
				HocKy + ","+ "'"+ThoiGian+"'" + ","+ thoiLuong + ","+ SoCHDe + ","+ SoCHTB + ","+ SoCHKho + ","+ ThangDiem + ","+ IsActive;	
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
	}
	public void XoaDeThi( int MaDeThi) throws SQLException {
		String sql="delete from dethi where MaDeThi="+MaDeThi;
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
	}
	public void suaDeThi(int MaDeThi, int HocKy, String ThoiGianBD,int ThoiLuong, int SoCHDe,int SoCHTB,int SoCHKho, float ThangDiem,boolean IsActive) throws SQLException {
		Statement st= conn.createStatement();
		String sql = "Update dethi \r\n" + 
				"    	Set\r\n" + 
				"     		HocKy = "+HocKy+",\r\n" + 
				"			ThoiGianBatDau = "+"'"+ThoiGianBD+"'"+",\r\n" + 
				"			ThoiLuong="+ThoiLuong+",\r\n" + 
				"			SoCHDe="+SoCHDe+",\r\n" + 
				"			SoCHTrungBinh="+SoCHTB+",\r\n" + 
				"			SoCHKho="+SoCHKho+",\r\n" + 
				"			ThangDiem="+ThangDiem+",\r\n" + 
				"			IsActive="+IsActive+"\r\n" + 
				"where MaDethi="+MaDeThi+";";
		st.executeUpdate(sql);
	}
	public List<DeThi> xemDSDeThi() throws SQLException {
		List<DeThi> ds = new ArrayList<DeThi>();
		Statement st= conn.createStatement();
		String sql = "select * from DeThi order by MaDeThi DESC";
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
		 DeThi dt= new DeThi();
		 dt.setMaDeThi(rs.getInt("MaDeThi"));
		 dt.setHocKy(rs.getInt("HocKy"));
		 java.util.Date date = null;
		 Timestamp timestamp = rs.getTimestamp(3);
		 if (timestamp != null)
		     date = new java.util.Date(timestamp.getTime());
		 SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		
		 dt.setThoiGianBatDau(ft.format(date));
		 dt.setThoiLuong(rs.getInt("ThoiLuong"));
		 dt.setSoCHDe(rs.getInt("SoCHDe"));
		 dt.setSoCHTB(rs.getInt("SoCHTrungBinh"));
		 dt.setSoCHKho(rs.getInt("SoCHKho"));
		 dt.setThangDiem(rs.getFloat("ThangDiem"));
		 dt.setIsActive(rs.getBoolean("IsActive"));
		 ds.add(dt);
		}
		return ds;
	}
	
	public void TaoChiTietDeThi(int soCHDe,int soCHTB, int soCHKho) throws SQLException {
		String sql1 ="select MaCauHoi from cauhoi\r\n" + 
				"where MaMucDo=1\r\n" + 
				"order by rand()\r\n" + 
				"limit "+ soCHDe;
		String sql2 ="select MaCauHoi from cauhoi\r\n" + 
				"where MaMucDo=2\r\n" + 
				"order by rand()\r\n" + 
				"limit "+ soCHTB;
		String sql3 ="select MaCauHoi from cauhoi\r\n" + 
				"where MaMucDo=3\r\n" + 
				"order by rand()\r\n" + 
				"limit "+ soCHKho;
		String MaDT="select(select coalesce((max(MaDeThi)),1) from dethi order by MaDeThi)";
		
		Statement stm1 = conn.createStatement();
		
		ResultSet rsMa= stm1.executeQuery(MaDT);
		int Ma=0;
		while(rsMa.next()) {
			Ma=rsMa.getInt(1);
		}
		//them cau hoi de
		ResultSet rs=stm1.executeQuery(sql1);
		while (rs.next()) {
			Statement stm = conn.createStatement();
			String sqlAdd="INSERT INTO `chitietdethi`(`MaChiTiet`,`MaCauHoi`,`MaDeThi`)\r\n" + 
					"select(select COALESCE((max(MaChiTiet)+1),1) AS LONNHAT  from chitietdethi order by MaChiTiet),"+rs.getInt(1)+","+Ma;
			stm.executeUpdate(sqlAdd);
		}
		//them cau hoi TB
		ResultSet rs2=stm1.executeQuery(sql2);
		while (rs2.next()) {
			Statement stm = conn.createStatement();
			String sqlAdd="INSERT INTO `chitietdethi`(`MaChiTiet`,`MaCauHoi`,`MaDeThi`)\r\n" + 
					"select(select COALESCE((max(MaChiTiet)+1),1) AS LONNHAT from chitietdethi order by MaChiTiet),"+rs2.getInt(1)+","+Ma;
			stm.executeUpdate(sqlAdd);
		}
		//them cau hoi kho
		ResultSet rs3=stm1.executeQuery(sql3);
		while (rs3.next()) {
			Statement stm = conn.createStatement();
			String sqlAdd="INSERT INTO `chitietdethi`(`MaChiTiet`,`MaCauHoi`,`MaDeThi`)\r\n" + 
					"select(select COALESCE((max(MaChiTiet)+1),1) AS LONNHAT  from chitietdethi order by MaChiTiet),"+rs3.getInt(1)+","+Ma;
			stm.executeUpdate(sqlAdd);
		}
	}
	public void TaoChiTietDeThiVoiParam(int maDT,int soCHDe,int soCHTB, int soCHKho) throws SQLException {
		String sql1 ="select MaCauHoi from cauhoi\r\n" + 
				"where MaMucDo=1\r\n" + 
				"order by rand()\r\n" + 
				"limit "+ soCHDe;
		String sql2 ="select MaCauHoi from cauhoi\r\n" + 
				"where MaMucDo=2\r\n" + 
				"order by rand()\r\n" + 
				"limit "+ soCHTB;
		String sql3 ="select MaCauHoi from cauhoi\r\n" + 
				"where MaMucDo=3\r\n" + 
				"order by rand()\r\n" + 
				"limit "+ soCHKho;
		
		Statement stm1 = conn.createStatement();
		
		
		//them cau hoi de
		ResultSet rs=stm1.executeQuery(sql1);
		while (rs.next()) {
			Statement stm = conn.createStatement();
			String sqlAdd="INSERT INTO `chitietdethi`(`MaChiTiet`,`MaCauHoi`,`MaDeThi`)\r\n" + 
					"select(select COALESCE((max(MaChiTiet)+1),1) AS LONNHAT  from chitietdethi order by MaChiTiet),"+rs.getInt(1)+","+maDT;
			stm.executeUpdate(sqlAdd);
		}
		//them cau hoi TB
		ResultSet rs2=stm1.executeQuery(sql2);
		while (rs2.next()) {
			Statement stm = conn.createStatement();
			String sqlAdd="INSERT INTO `chitietdethi`(`MaChiTiet`,`MaCauHoi`,`MaDeThi`)\r\n" + 
					"select(select COALESCE((max(MaChiTiet)+1),1) AS LONNHAT from chitietdethi order by MaChiTiet),"+rs2.getInt(1)+","+maDT;
			stm.executeUpdate(sqlAdd);
		}
		//them cau hoi kho
		ResultSet rs3=stm1.executeQuery(sql3);
		while (rs3.next()) {
			Statement stm = conn.createStatement();
			String sqlAdd="INSERT INTO `chitietdethi`(`MaChiTiet`,`MaCauHoi`,`MaDeThi`)\r\n" + 
					"select(select COALESCE((max(MaChiTiet)+1),1) AS LONNHAT  from chitietdethi order by MaChiTiet),"+rs3.getInt(1)+","+maDT;
			stm.executeUpdate(sqlAdd);
		}
	}
	public void xoaChiTietDeThi(int maDeThi) throws SQLException {
		String sql="delete from chitietdethi where MaDeThi="+maDeThi;
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
	}
	
	public List<CauHoi> layCauHoiTuDeThi(int maDeThi) throws SQLException {
		String sql ="SELECT MaDeThi,chitietdethi.MaCauHoi, NoiDungCauHoi, DapAn_A, DapAn_B, DapAn_C, DapAn_D, DapAnDung\r\n" + 
				"FROM chitietdethi inner join cauhoi on chitietdethi.MaCauHoi=cauhoi.MaCauHoi\r\n" + 
				"where MaDeThi="+maDeThi +" order by chitietdethi.MaChiTiet ASC";
				//+" limit "+giaTriDau+","+soLuong;
		Statement stm=conn.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		List<CauHoi> ds = new ArrayList<>();
		while(rs.next()) {
			CauHoi ch = new CauHoi();
			ch.setMaCauHoi(rs.getInt("MaCauHoi"));
			ch.setNoiDungCauHoi(rs.getString("NoiDungCauHoi"));
			ch.setDapAn_A(rs.getString("DapAn_A"));
			ch.setDapAn_B(rs.getString("DapAn_B"));
			ch.setDapAn_C(rs.getString("DapAn_C"));
			ch.setDapAn_D(rs.getString("DapAn_D"));
			ch.setDapAnDung(rs.getString("DapAnDung"));
			ds.add(ch);
		}
		return ds;
	}
	
	//xoa
	public int demDoCauHoiBangMaDeThi(int maDeThi) throws SQLException {
		String sql ="SELECT MaDeThi,chitietdethi.MaCauHoi, NoiDungCauHoi, DapAn_A, DapAn_B, DapAn_C, DapAn_D, DapAnDung\r\n" + 
				"FROM chitietdethi inner join cauhoi on chitietdethi.MaCauHoi=cauhoi.MaCauHoi\r\n" + 
				"where MaDeThi="+maDeThi;
		Statement stm=conn.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		int count=0;
		while(rs.next()) {
			count=rs.getInt(1);
		}
		return count;
	}
}
