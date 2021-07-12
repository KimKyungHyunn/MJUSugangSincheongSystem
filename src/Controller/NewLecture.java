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

import DAO.DAO;
import valueObject.VDirectory;
import valueObject.VLecture;

@WebServlet("/NewLecture")
public class NewLecture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao;
	
    public NewLecture() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.dao = new DAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=euc-kr");	
        
		String action = request.getParameter("action");
		String url = "";
		
		if(action.equals("Insertfirst")) {
			url = "/InsertNewLecture.jsp";
			Vector<VDirectory> VecDepartment = this.dao.getAllDepartment();
			request.setAttribute("VecDepartment", VecDepartment);
			
		}else if(action.equals("Insertsecond")) {	
			int maxID = this.dao.maxID();
			boolean flag = this.dao.insertNewLecture(maxID, request.getParameter("DepartmentName"), request.getParameter("Name"), request.getParameter("Professor"),
			request.getParameter("Time"), request.getParameter("GradeSize"), request.getParameter("NumLimited"));
			
			if(flag==true) {
				url = "/masterMain.jsp";	
				Vector<VLecture> VecLecture  = dao.getAllLecture();		
				request.setAttribute("VecLecture", VecLecture);
			}else {
				url =  "/InsertNewError.jsp";
			}
			
		}
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);	
	}
}
