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


import Model.PHONGTHI_DAO;

/**
 * Servlet implementation class xoaPhongThi
 */
@WebServlet("/xoaPhongThi")
public class xoaPhongThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaPhongThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int MaPhongThi= Integer.parseInt(request.getParameter("maPT"));
		PHONGTHI_DAO pt = null;
		HttpSession ss = request.getSession();
		try {
			pt = new PHONGTHI_DAO(ss.getAttribute("username").toString(),ss.getAttribute("pass").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pt.xoaPhongThi(MaPhongThi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("redirectGanDeThi");
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
