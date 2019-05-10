package Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Objects.DangNhapInfo;
public class DANGNHAP_DAO {
	private Connection conn;
	public DANGNHAP_DAO(String username,String password)throws Exception {
		ConnectDB database = new ConnectDB();
		conn=database.Connect(username,password);
	}
	public void themDangNhap( int MaTaiKhoan, String Email,String MatKhau  ) throws SQLException {
		String sql="INSERT INTO `dangnhap`(`MaDangNhap`,`Email`,`LoaiTaiKhoan`,`MatKhau`,`MaTaiKhoan`)\r\n" + 
				"select(select COALESCE((max(MaDangNhap)+1),1) AS LONNHAT  from dangnhap order by MaDangNhap),'"+Email+"',1,'"+MatKhau+"',"+MaTaiKhoan;
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
	}

	public DangNhapInfo getUserAccount(String username, String password) throws SQLException {
		String sql ="select * from (dangnhap inner join taikhoan on dangnhap.MaTaiKhoan=taikhoan.MaTK)\r\n" + 
				"where MaTK="+Integer.parseInt(username)+" and MatKhau="+Integer.parseInt(password);
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		DangNhapInfo tk =null;
		while(rs.next()) {
			tk= new DangNhapInfo();
			tk.setMaTaiKhoan(rs.getInt(6));
			tk.setMatKhau(rs.getInt(2));
			tk.setEmail(rs.getString(3));
			tk.setRole(rs.getShort(4));
			tk.setTenTaiKhoan(rs.getString(7));
			tk.setGioiTinh(rs.getString(8));
			tk.setSDT(rs.getString(9));
		}
		return tk;
	}
}
