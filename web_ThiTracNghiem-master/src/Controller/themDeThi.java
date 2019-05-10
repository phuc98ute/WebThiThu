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

import Model.DETHI_DAO;

/**
 * Servlet implementation class themDeThi
 */
@WebServlet("/themDeThi")
public class themDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8"); 
		HttpSession ss= request.getSession();
		String s= (String)ss.getAttribute("username");
		if(s==null||s=="") {
	        RequestDispatcher rd=request.getRequestDispatcher("redirectLogin");  
	        rd.include(request,response); 
		}
		else {
			DETHI_DAO dt = null;
			try {
				dt = new DETHI_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				int hocKy= Integer.parseInt(request.getParameter("a_hocKy"));
				String batdau= request.getParameter("a_thoiGianBatDau");
				int thoiLuong= Integer.parseInt(request.getParameter("a_thoiLuong"));
				int chDe= Integer.parseInt(request.getParameter("a_soCHDe"));
				int chTb= Integer.parseInt(request.getParameter("a_soCHTB"));
				int chKho= Integer.parseInt(request.getParameter("a_soCHKho"));
				Float thangDiem= Float.parseFloat(request.getParameter("a_thangDiem"));
				boolean isActive= Boolean.parseBoolean(request.getParameter("a_isActive"));
				dt.themDeThi(hocKy, batdau, thoiLuong, chDe, chTb, chKho, thangDiem, isActive);
				dt.TaoChiTietDeThi(chDe, chTb, chKho);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("redirectDeThi");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
