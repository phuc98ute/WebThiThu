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

import Model.DETHI_DAO;

/**
 * Servlet implementation class xoaDeThi
 */
@WebServlet("/xoaDeThi")
public class xoaDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int MaDeThi= Integer.parseInt(request.getParameter("maDT"));
		DETHI_DAO dt = null;
		HttpSession ss = request.getSession();
		try {
			dt = new DETHI_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			dt.XoaDeThi(MaDeThi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("redirectDeThi");
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
