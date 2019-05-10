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

import Model.userDeThi_DAO;
import Objects.DeThiTheoUser;
import Objects.dsDeThiTheoUser;

/**
 * Servlet implementation class redirectTrangThi
 */
@WebServlet("/redirectTrangThi")
public class redirectTrangThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public redirectTrangThi() {
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
			RequestDispatcher dispatcher=null;
			if(ss.getAttribute("role").equals("thisinh")) {
				List<DeThiTheoUser> dethi= new ArrayList<>();
				dsDeThiTheoUser ds = new dsDeThiTheoUser();
				userDeThi_DAO thongtin = null;
				try {
					thongtin = new userDeThi_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				String MaTk= (String)ss.getAttribute("mataikhoan");
				try {
					dethi=thongtin.getListExamByUser(Integer.parseInt(MaTk));
					ds.setDs(dethi);
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("dsDeThi", ds);
				dispatcher = request.getRequestDispatcher("WEB-INF/client/ThiTracNghiem.jsp");
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
