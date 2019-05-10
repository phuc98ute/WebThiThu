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

import Model.PHONGTHI_DAO;


/**
 * Servlet implementation class ganPhongThi
 */
@WebServlet("/ganPhongThi")
public class ganPhongThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ganPhongThi() {
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
			PHONGTHI_DAO pt = null;
			try {
				pt = new PHONGTHI_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			int lop= Integer.parseInt(request.getParameter("a_taoDeLopHoc"));
			int de= Integer.parseInt(request.getParameter("a_taoDeDeThi"));
			try {
				pt.themPhongThi(lop, de);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("redirectGanDeThi");
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
