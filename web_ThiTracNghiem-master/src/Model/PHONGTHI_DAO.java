package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Objects.DeThi;
import Objects.PhongThi;

public class PHONGTHI_DAO {
	private Connection conn;

	public PHONGTHI_DAO(String username, String password) throws Exception {
		ConnectDB database = new ConnectDB();
		conn = database.Connect(username, password);
	}

	public void themPhongThi(int maLopHoc, int maDeThi) throws SQLException {
		String sql="INSERT INTO `phongthi`\r\n" + 
				"(MaPhong,MaLopHoc,MaDeThi)\r\n" + 
				"\r\n" + 
				"select(select COALESCE((max(MaPhong)+1),1) AS LONNHAT  from phongthi order by MaPhong)," + maLopHoc+","+maDeThi;	
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
	}

	public void xoaPhongThi(int maPhong) throws SQLException {
		Statement st= conn.createStatement();
		String sql = "delete from phongthi where MaPhong="+maPhong;
		st.executeUpdate(sql);
	}
	public List<PhongThi> xemDSPhongThi() throws SQLException {
		List<PhongThi> ds = new ArrayList<PhongThi>();
		Statement st= conn.createStatement();
		String sql = "select * from  phongthi order by MaDeThi ASC";
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
		 PhongThi pt= new PhongThi();
		 pt.setMaPhong(rs.getInt(1));
		 pt.setMaLopHoc(rs.getInt(2));
		 pt.setMaDeThi(rs.getInt(3));
		 ds.add(pt);
		}
		return ds;
	}
}
