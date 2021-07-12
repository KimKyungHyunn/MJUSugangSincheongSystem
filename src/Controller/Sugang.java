package Controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import valueObject.VLecture;


@WebServlet("/Sugang")
public class Sugang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao; 
		
    public Sugang() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.dao = new DAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=euc-kr");	
        
		HttpSession session = request.getSession(false);		
		if(session==null) {
			response.sendRedirect("error.jsp");
		}else {
		String DepName = request.getParameter("DepName");
		@SuppressWarnings("unchecked")
		Vector<VLecture> VecLecture = (Vector<VLecture>) this.dao.getLecture("departmentName", DepName);
		request.setAttribute("VecLecture", VecLecture);
		request.setAttribute("action", "sugang");
		RequestDispatcher disp = request.getRequestDispatcher("/Sugang.jsp");
		disp.forward(request, response);	
	}
	}//

}
