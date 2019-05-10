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

import Model.DETHI_DAO;
import Objects.BaiLam;
import Objects.CauHoi;
import Objects.dsCauBaiLam;
import Objects.dsCauHoi;


/**
 * Servlet implementation class vaoThi
 */
@WebServlet("/vaoThi")
public class vaoThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vaoThi() {
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
			// phan trang thi sua lai
			String thoiLuong= request.getParameter("thoiLuong");
			ss.setAttribute("thoiLuong", thoiLuong);
			String tongSoCau= request.getParameter("tongSoCau");
			ss.setAttribute("tongSoCau", tongSoCau);
			String ma= (String)ss.getAttribute("maDeThi");
			if(ma==null) {
				ma= (String)request.getParameter("maDeThi");
				ss.setAttribute("maDeThi", ma);
			}
			dsCauBaiLam bl= (dsCauBaiLam) ss.getAttribute("baiLam");
			if (bl == null) {
				bl= new dsCauBaiLam();
				ss.setAttribute("baiLam", bl);
			}
			int maDT=Integer.parseInt(ma);
			DETHI_DAO dt = null;
			try {
				dt = new DETHI_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			List<CauHoi> dsch =new ArrayList<>();
			try {
				dsch= dt.layCauHoiTuDeThi(maDT);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dsCauHoi ds = new dsCauHoi();
			ds.setDs(dsch);
			request.setAttribute("dsCH",ds );
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/client/baiLam.jsp");
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
