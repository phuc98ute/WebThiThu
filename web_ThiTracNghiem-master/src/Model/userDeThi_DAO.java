package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Objects.BaiLam;
import Objects.DeThiTheoUser;

public class userDeThi_DAO {
	private Connection conn;
	public userDeThi_DAO(String username,String password)throws Exception {
		ConnectDB database = new ConnectDB();
		conn=database.Connect(username,password);
	}
	public List<DeThiTheoUser> getListExamByUser(int maTaiKhoan) throws SQLException {
		List<DeThiTheoUser> ds= new ArrayList<>();
		String sql ="select TenSV, lophoc.HocKy, TenLopHoc, dethi.MaDeThi,dethi.IsActive,(dethi.SoCHDe+dethi.SoCHTrungBinh+dethi.SoCHKho)as TongSoCauHoi, dethi.ThangDiem, dethi.ThoiGianBatDau,dethi.ThoiLuong\r\n" + 
				"from ((((taikhoan inner join chitietlophoc on taikhoan.MaTK=chitietlophoc.MaTK)\r\n" + 
				"inner join lophoc on chitietlophoc.MaLopHoc=lophoc.MaLopHoc)\r\n" + 
				"inner join phongthi on lophoc.MaLopHoc=phongthi.MaLopHoc))\r\n" + 
				"inner join dethi on phongthi.MaDeThi=dethi.MaDeThi\r\n" + 
				"where taikhoan.MaTK="+maTaiKhoan+ " order by TenLopHoc,dethi.ThoiGianBatDau asc";
		Statement stm= conn.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next()) {
			DeThiTheoUser dt= new DeThiTheoUser();
			dt.setTenSV(rs.getString(1));
			dt.setHocKy(rs.getInt(2));
			dt.setTenLopHoc(rs.getString(3));
			dt.setMaDeThi(rs.getInt(4));
			dt.setActive(rs.getBoolean(5));
			dt.setTongSoCauHoi(rs.getInt(6));
			dt.setThangDiem(rs.getFloat(7));
			java.util.Date date = null;
			 Timestamp timestamp = rs.getTimestamp(8);
			 if (timestamp != null)
			     date = new java.util.Date(timestamp.getTime());
			 SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
			
			 dt.setThoiGianBatDau(ft.format(date));
			dt.setThoiLuong(rs.getInt(9));
			ds.add(dt);
		}
		return ds;
		
	}
	
	//xoa
	public int layMaCauHoiTheoThuTu(int maDe, int stt) throws SQLException {
		String sql="select MaDeThi from chitietdethi where MaDeThi ="+maDe+" limit "+stt+",1";
		Statement stm = conn.createStatement();
		ResultSet rs= stm.executeQuery(sql);
		int ma=0;
		while (rs.next()) {
			ma=rs.getInt(1);
		}
		return ma;
	}
	
	// lay dap an dung
	public List<BaiLam> layDapAnTheoDe(int maDe) throws SQLException{
		List<BaiLam> ds = new ArrayList<>();
		String sql="select * from (dethi inner join chitietdethi on dethi.madethi=chitietdethi.madethi)\r\n" + 
				"inner join cauhoi on cauhoi.macauhoi=chitietdethi.macauhoi\r\n" + 
				"where dethi.madethi="+maDe+"\r\n" + 
				"order by chitietdethi.machitiet";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		int i=1;
		while(rs.next()) {
			BaiLam bl = new BaiLam();
			bl.setMaCH(String.valueOf(i));
			bl.setDapAnChon(rs.getString("DapAnDung"));
			ds.add(bl);
		}
		return ds;
	}
}
