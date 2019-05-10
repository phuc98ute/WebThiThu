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

import Model.LOPHOC1_DAO;
import Objects.dsLopHoc;
@WebServlet("/TimLopHoc")
public class TimLopHoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TimLopHoc() {
        super();

    }

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
			if(ss.getAttribute("role").equals("qlthisinh")) {
				LOPHOC1_DAO lh = null;
				try {
					lh = new LOPHOC1_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dsLopHoc ds= new dsLopHoc();
				try {
					String tenLopHoc=request.getParameter("tenLopHoc");
					ds.setDs(lh.xemDSLopHocTimKiem(tenLopHoc));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("dsLH",ds );
				dispatcher = request.getRequestDispatcher("WEB-INF/cPanel/quanliLopHoc.jsp");
			}
			else {
				 dispatcher = request.getRequestDispatcher("WEB-INF/permission.jsp");
			}
			dispatcher.forward(request, response);
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
