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
import Model.PHONGTHI_DAO;
import Objects.dsDeThi;
import Objects.dsPhongThi;

/**
 * Servlet implementation class redirectGanDeThi
 */
@WebServlet("/redirectGanDeThi")
public class redirectGanDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public redirectGanDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		HttpSession ss= request.getSession();
		String s= (String)ss.getAttribute("username");
		if(s==null||s=="") {
	        RequestDispatcher rd=request.getRequestDispatcher("Login_test.jsp");  
	        rd.forward(request,response); 
		}
		else {
			RequestDispatcher dispatcher=null;
			if(ss.getAttribute("role").equals("qldethi")) {
				PHONGTHI_DAO pt = null;
				try {
					pt = new PHONGTHI_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dsPhongThi ds = new dsPhongThi();
				try {
					ds.setDs(pt.xemDSPhongThi());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("dsPT",ds );
				 dispatcher = request.getRequestDispatcher("WEB-INF/cPanel/ganDeThi.jsp");
				
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
