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

import Model.DANGNHAP_DAO;
import Objects.DangNhapInfo;



/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dologin(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dologin(request, response);
	}

	private void dologin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8"); 
		RequestDispatcher rd=null;
		HttpSession ss= request.getSession();
		String s= (String)ss.getAttribute("username");
		if(s==null||s.equals("")) {  
			String userName= request.getParameter("inputUserName");
			String passWord = request.getParameter("inputPassword");
			
			DANGNHAP_DAO dn = null;
			try {
				dn= new DANGNHAP_DAO(userName,passWord);
			} catch (Exception e) {
				e.printStackTrace();
			}
			DangNhapInfo tk=null;
			try {
				 tk = dn.getUserAccount(userName, passWord);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(tk != null) {
				ss.setAttribute("pass", passWord);
				ss.setAttribute("username", userName);
				ss.setAttribute("mataikhoan", String.valueOf(tk.getMaTaiKhoan()));
				if(tk.getRole()==1) {
					ss.setAttribute("role", "thisinh");
					rd=request.getRequestDispatcher("redirectTrangThi");
				}
				if(tk.getRole()==2) {
					ss.setAttribute("role", "qlcauhoi");
					rd=request.getRequestDispatcher("redirectCpanel");  
				}
				if(tk.getRole()==3) {
					ss.setAttribute("role", "qldethi");
					rd=request.getRequestDispatcher("redirectCpanel");  
				}
				if(tk.getRole()==4) {
					ss.setAttribute("role", "qlthisinh");
					rd=request.getRequestDispatcher("redirectCpanel");  
				}
				rd.forward(request,response);  
			}
			else {
				response.sendRedirect("redirectLogin");
			}
		}
		else {
			String role=(String)ss.getAttribute("role");
			if(role.equals("thisinh")) {
				rd=request.getRequestDispatcher("redirectTrangThi");
			}
			if(role.equals("qlcauhoi")) {
				rd=request.getRequestDispatcher("redirectCpanel");
			}
			if(role.equals("qldethi")) {
				rd=request.getRequestDispatcher("redirectCpanel");
			}
			if(role.equals("qlthisinh")) {
				rd=request.getRequestDispatcher("redirectCpanel");
			}
			rd.forward(request, response);
		}
	}

}
