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

@WebServlet("/redirectLuuCauHoi")
public class redirectLuuCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public redirectLuuCauHoi() {
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
	        rd.forward(request,response); 
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
					int MaCauHoi = Integer.parseInt(request.getParameter("e_maCH"));
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
					String DapAn_B=request.getParameter("b");
					String DapAn_C=request.getParameter("c");
					String DapAn_D=request.getParameter("d");
					String DapAn_Dung=request.getParameter("e_daDung");
					if(request.getParameter("a").equals("dapAn_A"))
					{
						DapAn_Dung="A";
					}
					if(request.getParameter("a").equals("dapAn_B"))
					{
						DapAn_Dung="B";
					}
					if(request.getParameter("a").equals("dapAn_C"))
					{
						DapAn_Dung="C";
					}
					if(request.getParameter("a").equals("dapAn_D"))
					{
						DapAn_Dung="D";
					}
					ch.suaCauHoi(MaCauHoi,NoiDungCauHoi,MaMucDo,DapAn_A,DapAn_B,DapAn_C,DapAn_D,DapAn_Dung);
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
