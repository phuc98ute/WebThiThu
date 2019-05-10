package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.LOPHOC_DAO;

@WebServlet("/LuuSinhVienThem")
public class LuuSinhVienThem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LuuSinhVienThem() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8"); 
		HttpSession ss= request.getSession();
		String s= (String)ss.getAttribute("username");
		if(s==null||s=="") {
	        RequestDispatcher rd=request.getRequestDispatcher("redirectLogin");  
	        rd.include(request,response); 
		}
		LOPHOC_DAO sv = null;
		try {
			sv = new LOPHOC_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			String TenSV = request.getParameter("tenSV");
			String GioiTinh=request.getParameter("gioiTinh");
			String SDT = request.getParameter("sdt");
			sv.ThemSinhVien(TenSV,GioiTinh,SDT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("redirectThiSinhLopHoc");
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
