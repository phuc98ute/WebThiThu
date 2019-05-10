package Controller;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class suaDeThi
 */
@WebServlet("/suaDeThi")
public class suaDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suaDeThi() {
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
				int maDT= Integer.parseInt(request.getParameter("e_maDT"));
				int hocKy= Integer.parseInt(request.getParameter("e_hocKy"));
				String batdau= request.getParameter("e_thoiGianBatDau");
				int thoiLuong= Integer.parseInt(request.getParameter("e_thoiLuong"));
				int chDe= Integer.parseInt(request.getParameter("e_soCHDe"));
				int chTb= Integer.parseInt(request.getParameter("e_soCHTB"));
				int chKho= Integer.parseInt(request.getParameter("e_soCHKho"));
				Float thangDiem= Float.parseFloat(request.getParameter("e_thangDiem"));
				boolean isActive= Boolean.parseBoolean(request.getParameter("e_isActive"));
				dt.suaDeThi(maDT, hocKy, batdau, thoiLuong, chDe, chTb, chKho, thangDiem, isActive);
				dt.xoaChiTietDeThi(maDT);
				dt.TaoChiTietDeThiVoiParam(maDT,chDe, chTb, chKho);
				
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
