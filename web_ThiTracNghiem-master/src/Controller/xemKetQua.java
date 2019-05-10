package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.userKetQuaThi;
import Objects.KetQua;
import Objects.dsKetQua;

/**
 * Servlet implementation class xemKetQua
 */
@WebServlet("/xemKetQua")
public class xemKetQua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xemKetQua() {
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
			String maTKhoan= (String) ss.getAttribute("mataikhoan");
			int maTK= Integer.parseInt(maTKhoan);
			userKetQuaThi kq = null;
			try {
				kq= new userKetQuaThi(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dsKetQua ds= new dsKetQua();
			List<KetQua> lst = new ArrayList<>();
			try {
				lst=kq.layKQTheoThiSinh(maTK);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ds.setDs(lst);
			request.setAttribute("dsKQ", ds);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/client/XemKetQua.jsp");
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
