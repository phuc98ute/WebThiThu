package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.KetQua;

public class userKetQuaThi {
	private Connection conn;
	public userKetQuaThi(String username,String password)throws Exception {
		ConnectDB database = new ConnectDB();
		conn=database.Connect(username,password);
	}
	public void themChiTietBaiLam(int MaDT, int MaCH , int MaTK, String DapAnChon) throws SQLException {
		String sql1="INSERT INTO chitietbailam(MaChiTietBaiLam, MaDeThi, MaCauHoi,MaTK,DapAnChon)\r\n" + 
				"select(select coalesce((max(MaChiTietBaiLam)+1),1) from chitietbailam),"+MaDT+","+MaCH+","+MaTK+",'"+DapAnChon+"'";
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql1);
	}
	public void capNhatMaKetQuaKiemTra() throws SQLException {
		String sql="update chitietbailam set  MaKQKT= (select(select coalesce((max(MaKetQua)),1) from ketquakiemtra) as lon) where MaKQKT is null";
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
	}
	public void themKetQuaThi(int maDeThi, int maTK, float diem) throws SQLException {

		String sql=" insert into ketquakiemtra (MaKetQua,MaTK,MaDeThi,Diem)\r\n" + 
				"    select(select COALESCE((max(MaKetQua)+1),1) AS LONNHAT  from ketquakiemtra),"+maTK+","+maDeThi+","+diem;
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
	}
	public List<KetQua> layKQTheoThiSinh(int maTK) throws SQLException{
		List<KetQua> ds= new ArrayList<>();
		String sql=" select * from ketquakiemtra where MaTK ="+maTK+" order by MaKetQua DESC";
		Statement stm = conn.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		while (rs.next()) {
			KetQua kq = new KetQua();
			kq.setMaTK(maTK);
			kq.setDiem(rs.getFloat("Diem"));
			kq.setMaDeThi(rs.getInt("MaDeThi"));
			kq.setMaKQ(rs.getInt("MaKetQua"));
			ds.add(kq);
		}
		return ds;
	}
	public int layMaCauHoiTheoThuTu(int maDe, int stt) throws SQLException {
		String sql="select MaCauHoi from chitietdethi where MaDeThi ="+maDe+" order by MaChiTiet limit "+stt+",1 ";
		Statement stm = conn.createStatement();
		ResultSet rs= stm.executeQuery(sql);
		int ma=0;
		while (rs.next()) {
			ma=rs.getInt(1);
		}
		return ma;
	}
	public userKetQuaThi() {
		super();
	}
	
}
