package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class redirectLogin
 */
@WebServlet("/redirectLogin")
public class redirectLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public redirectLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher=null;
		HttpSession ss= request.getSession();
		String s= (String)ss.getAttribute("username");
		if(s==null||s.equals("")) {
			dispatcher = request.getRequestDispatcher("Login_test.jsp");
		}
		else {
			String role = (String)ss.getAttribute("role");
			if(role.equals("thisinh")) {
				dispatcher=request.getRequestDispatcher("redirectTrangThi");
			}
			if(role.equals("qlcauhoi")) {
				dispatcher=request.getRequestDispatcher("redirectCpanel");
			}
			if(role.equals("qldethi")) {
				dispatcher=request.getRequestDispatcher("redirectCpanel");
			}
			if(role.equals("qlthisinh")) {
				dispatcher=request.getRequestDispatcher("redirectCpanel");
			}
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
