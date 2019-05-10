package Model;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.TaiKhoan;
public class TAIKHOAN_DAO {
	private Connection conn;
	public TAIKHOAN_DAO(String username,String password)throws Exception {
		ConnectDB database = new ConnectDB();
		conn=database.Connect(username,password);
	}
	public void themTaiKhoan( int MaTK, String TenSV, String GioiTinh, String SDT, String Lop,int MaDangNhap ) throws SQLException {
		String sql = "{call sp_ThemTaiKhoan(?,?,?,?,?,?)}";
		CallableStatement cstm = conn.prepareCall(sql);
		cstm.setInt(1, MaTK);
		cstm.setString(2, TenSV);
		cstm.setString(3, GioiTinh);
		cstm.setString(4, SDT);
		cstm.setString(5,Lop);
		cstm.setInt(6,MaDangNhap);
		cstm.executeUpdate();
	}
	public void XoaTaiKhoan( int MaTK) throws SQLException {
		String sql = "{call sp_XoaTaiKhoan(?)}";
		CallableStatement cstm = conn.prepareCall(sql);
		cstm.setInt(1, MaTK);
		cstm.executeUpdate();
	}
	public void suaTaiKhoan(int MaTK, String TenSV, String GioiTinh, String SDT, String Lop,int MaDangNhap ) throws SQLException {
		String sql = "{call sp_SuaTaiKhoan(?,?,?,?,?,?)}"; 
		CallableStatement cstm = conn.prepareCall(sql);
		cstm.setInt(1, MaTK);
		cstm.setString(2, TenSV);
		cstm.setString(3, GioiTinh);
		cstm.setString(4, SDT);
		cstm.setString(5,Lop);
		cstm.setInt(6,MaDangNhap);
		cstm.executeUpdate();
	}
	public List<TaiKhoan> xemDSTaiKhoan() throws SQLException {
		List<TaiKhoan> ds = new ArrayList<TaiKhoan>();
		Statement st= conn.createStatement();
		String sql = "select * from TaiKhoan";
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
		 TaiKhoan sv= new TaiKhoan();
		 sv.setMaTK(rs.getInt("MaTK"));
		 sv.setTenSV(rs.getString("TenSV"));
		 sv.setGioiTinh(rs.getString("GioiTinh"));
		 sv.setSDT(rs.getString("SDT"));
		 sv.setLop(rs.getString("Lop"));
		 sv.setMaDangNhap(rs.getInt("MaDangNhap"));
		 ds.add(sv);
		}
		return ds;
	}
}
