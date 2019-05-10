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


import Model.CAUHOI_DAO;


@WebServlet("/redirectXoaCauHoi")
public class redirectXoaCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public redirectXoaCauHoi() {
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
		String s= (String)ss.getAttribute("username");
		if(s==null||s=="") {
	        RequestDispatcher rd=request.getRequestDispatcher("Login_test.jsp");  
	        rd.forward(request,response); 
		}
		else {
			RequestDispatcher dispatcher=null;
			if(ss.getAttribute("role").equals("qlcauhoi")) {
				CAUHOI_DAO ch = null;
				try {
					ch = new CAUHOI_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					int MaCauHoi = Integer.parseInt(request.getParameter("maCH"));
					
					    	ch.XoaCauHoi(MaCauHoi);
					  
					  
				} catch (SQLException e) {
					e.printStackTrace();
				}
				dispatcher = request.getRequestDispatcher("redirectCauHoi");
			}
			else {
				 dispatcher = request.getRequestDispatcher("WEB-INF/permission.jsp");
			}
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
