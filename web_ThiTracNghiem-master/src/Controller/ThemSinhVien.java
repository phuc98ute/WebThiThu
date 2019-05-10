package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThemSinhVien")
public class ThemSinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThemSinhVien() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession ss = request.getSession();
		RequestDispatcher  dispatcher =null;
		String s = (String) ss.getAttribute("username");
		if (s == null || s == "") {
			RequestDispatcher rd = request.getRequestDispatcher("redirectLogin");
			rd.include(request, response);
		} else {
			if(ss.getAttribute("role").equals("qlthisinh")) {
				dispatcher = request.getRequestDispatcher("WEB-INF/cPanel/themSinhVien.jsp");
			}
			else {
				 dispatcher = request.getRequestDispatcher("WEB-INF/permission.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
