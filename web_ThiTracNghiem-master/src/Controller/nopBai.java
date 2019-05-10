package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.userDeThi_DAO;
import Model.userKetQuaThi;
import Objects.BaiLam;
import Objects.dsCauBaiLam;

/**
 * Servlet implementation class nopBai
 */
@WebServlet("/nopBai")
public class nopBai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nopBai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession ss= request.getSession();
		String user= (String)ss.getAttribute("username");
		if(user==null||user=="") {
	        RequestDispatcher rd=request.getRequestDispatcher("Login_test.jsp");  
	        rd.forward(request,response); 
		}
		String maDe=(String) ss.getAttribute("maDeThi");
		if(maDe==null||maDe=="") {
	        RequestDispatcher rd=request.getRequestDispatcher("redirectTrangThi");  
	        rd.forward(request,response); 
		}
		String ma=(String) ss.getAttribute("tongSoCau");
		String maTaiKhoan=(String) ss.getAttribute("mataikhoan");
		int maTK= Integer.parseInt(maTaiKhoan);
		int soCau=Integer.parseInt(ma);
		int maDeThi=Integer.parseInt(maDe);
		dsCauBaiLam ds = new dsCauBaiLam();
		List<BaiLam> lst = new ArrayList<>(); 
		float diem=0;
		int soCauDung=0;
		userKetQuaThi kq1 =null;
		try {
			kq1= new userKetQuaThi(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<soCau;i++) {
			String s =request.getParameter(String.valueOf(i));
			BaiLam bl = new BaiLam();
			bl.setMaCH(String.valueOf(i));
			if(s==null) {
				bl.setDapAnChon("0");
			}
			else {
				bl.setDapAnChon(s);
			}
			try {
				int temp=kq1.layMaCauHoiTheoThuTu(maDeThi, i);
				kq1.themChiTietBaiLam(maDeThi, temp, maTK, bl.getDapAnChon());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			lst.add(bl);
		}
		ds.setDs(lst);
		userDeThi_DAO kq=null;
		List<BaiLam> lst1 = new ArrayList<>(); 
		try {
			kq= new userDeThi_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			lst1=kq.layDapAnTheoDe(maDeThi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		for(int i=0;i<soCau;i++) {
			if(lst.get(i).getDapAnChon().equals(lst1.get(i).getDapAnChon())) {
				soCauDung=soCauDung+1;
			}
		}
		diem=(float)soCauDung*10/soCau;
		
		try {
			kq1.themKetQuaThi(maDeThi, maTK,diem);
			kq1.capNhatMaKetQuaKiemTra();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String mess="Chúc mừng bạn đã hoàn thành bài thi";
		request.setAttribute("mess",mess);
		ss.removeAttribute("thoiLuong");
		ss.removeAttribute("tongSoCau");
		ss.removeAttribute("maDeThi");
		ss.removeAttribute("baiLam");
		RequestDispatcher dispatcher = request.getRequestDispatcher("redirectTrangThi");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
