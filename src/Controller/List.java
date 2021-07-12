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
import valueObject.VApply;
import valueObject.VLecture;
import valueObject.VReservation;
import valueObject.VUser;

@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAO dao;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.dao = new DAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=euc-kr");	
        
		HttpSession session = request.getSession(false);		
		if(session==null) {
			response.sendRedirect("error.jsp");
		}else {
		String url = "";
		VUser student = (VUser)session.getAttribute("student");
		
		String action = request.getParameter("action");
		Vector<VApply> VecApply = new Vector<VApply>();
		Vector<VReservation> VecReservation = new Vector<VReservation>();
		Vector<VLecture> VecLecture = new Vector<VLecture>();

		if(action.equals("Apply")) {
			VecApply = (Vector<VApply>) dao.getApplyList("Apply", student.getStudentID());						
			for(VApply apply: VecApply) {
				int lectureID = apply.getLectureID();
				VLecture lecture = (VLecture)dao.getLecture("lectureID", lectureID);
				VecLecture.add(lecture);
			}
			url = "/SugangList.jsp";
			
		}else if(action.equals("Reservation")) {	
			VecReservation = (Vector<VReservation>) dao.getApplyList("Reservation",student.getStudentID());				
			for(VReservation reservation: VecReservation) {
				int lectureID = reservation.getLectureID();
				VLecture lecture = (VLecture)dao.getLecture("lectureID", lectureID);
				VecLecture.add(lecture);
			}
			url = "/MiriList.jsp";
			
		}else if(action.equals("Information")){
			dao.getStudentInfor();
			VUser vUser =  dao.getStudent(student.getUserId());
			request.setAttribute("vUser", vUser);
			url = "/StudentInfor.jsp";
			
		}else if(action.equals("Logout")){
			session.invalidate();
			url = "/Login.jsp";
			
		}
		
		request.setAttribute("VecLecture", VecLecture);
		request.setAttribute("action", action);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);	
		}
	}//
}
