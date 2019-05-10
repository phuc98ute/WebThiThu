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

@WebServlet("/redirectLuuCauHoiThem")
public class redirectLuuCauHoiThem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public redirectLuuCauHoiThem() {
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
		}else {
			RequestDispatcher dispatcher=null;
			if(ss.getAttribute("role").equals("qlcauhoi")) {
				CAUHOI_DAO ch = null;
				try {
					ch = new CAUHOI_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					String NoiDungCauHoi = request.getParameter("e_ndCH");
					int MaMucDo = 1;
					if(request.getParameter("radLevel").equals("easy"))
					{
						MaMucDo = 1;
					}
					if(request.getParameter("radLevel").equals("normal"))
					{
						MaMucDo = 2;
					}
					if(request.getParameter("radLevel").equals("hard"))
					{
						MaMucDo=3;
					}
					String DapAn_A=request.getParameter("daA");
					String DapAn_B=request.getParameter("daB");
					String DapAn_C=request.getParameter("daC");
					String DapAn_D=request.getParameter("daD");
					String DapAn_Dung=null;
					if(request.getParameter("DapAn").equals("dapAn_A"))
					{
						DapAn_Dung="A";
					}
					if(request.getParameter("DapAn").equals("dapAn_B"))
					{
						DapAn_Dung="B";
					}
					if(request.getParameter("DapAn").equals("dapAn_C"))
					{
						DapAn_Dung="C";
					}
					if(request.getParameter("DapAn").equals("dapAn_D"))
					{
						DapAn_Dung="D";
					}
					ch.themCauHoi(NoiDungCauHoi,MaMucDo,DapAn_A,DapAn_B,DapAn_C,DapAn_D,DapAn_Dung);
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
