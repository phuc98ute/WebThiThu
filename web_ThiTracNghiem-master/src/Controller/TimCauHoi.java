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
import Objects.dsCauHoi;


@WebServlet("/TimCauHoi")
public class TimCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimCauHoi() {
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
				int pages =1, giaTriDau,soLuong;
				if(request.getParameter("pages")!=null) {
					pages= (int) Integer.parseInt(request.getParameter("pages"));
				}
				request.setAttribute("pages", String.valueOf(pages));
				CAUHOI_DAO ch = null;
				try {
					ch = new CAUHOI_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				int total = 0;
				try {
					total = ch.xemTongSoCauHoi();
					request.setAttribute("total", String.valueOf(total) );
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if(total<=4) {
					giaTriDau=1;
					soLuong=total;
				}else {
					giaTriDau=(pages-1)*4;
					soLuong=4;
				}
				dsCauHoi ds= new dsCauHoi();
				try {
					String noiDungCauHoi = request.getParameter("noiDungCauHoi");
					ds.setDs(ch.xemDSCauHoiTimKiem(giaTriDau,soLuong,noiDungCauHoi));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("dsCH",ds );
				dispatcher = request.getRequestDispatcher("WEB-INF/cPanel/quanlyCauHoi.jsp");
				
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
