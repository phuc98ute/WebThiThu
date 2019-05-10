package Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ConnectDB;
import Model.userDeThi_DAO;
import Objects.DeThiTheoUser;
import Objects.dsDeThiTheoUser;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.JasperRunManager;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * Servlet implementation class xuatPDF
 */
@WebServlet("/xuatPDF")
public class xuatPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xuatPDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("application/pdf");
//		response.setCharacterEncoding("utf-8");
//		HttpSession ss= request.getSession();
//		String s= (String)ss.getAttribute("username");
//		if(s==null||s=="") {
//	        RequestDispatcher rd=request.getRequestDispatcher("redirectLogin");  
//	        rd.include(request,response); 
//		}
//		else {
//			try {
//				String tk= (String) ss.getAttribute("mataikhoan");
//				int maTK = Integer.parseInt(tk);
//				int maDeThi	= Integer.parseInt(request.getParameter("maDT"));
//				int maKetQua= Integer.parseInt(request.getParameter("maKQ"));
//				JasperReport jasperReport = null;
//				JasperDesign jasperDesign = null;
//				Map<String, Object> parameters = new HashMap<String,Object>();
//				parameters.put("Parameter1", maTK);
//				parameters.put("Parameter2", maDeThi);
//				parameters.put("Parameter3", maKetQua);
//
//				String path = getServletContext().getRealPath("/WEB-INF/");
//				jasperDesign = JRXmlLoader.load(path + "/xemKetQua.jrxml");
//				jasperReport = JasperCompileManager.compileReport(jasperDesign);
//				ConnectDB con = new ConnectDB();
//				try {
//					con.Connect("root", "root");
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				} catch (InstantiationException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				}
//				byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters, con.getConn() );
//				OutputStream outStream = response.getOutputStream();
//				response.setContentType("application/pdf");
//				response.setContentLength(byteStream.length);
//				outStream.write(byteStream, 0, byteStream.length);
//			}
//			catch(JRException e) {
//				e.printStackTrace();
//			}
//		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
