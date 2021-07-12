package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import valueObject.VUser;

@WebServlet("/Apply")
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao;
	
    public Apply() {
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

		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("error.jsp");
		}else {
		VUser student = (VUser)session.getAttribute("student");
		
		String message = null;
		String Errmessage = null;
		
		String action = request.getParameter("action");
		int LectureID = Integer.parseInt(request.getParameter("LectureID"));

		if(action.equals("미리담기")) {
			if(dao.insertApply("Reservation", LectureID, student.getStudentID())) {
				message = "미리담기 완료";
			}else {
				Errmessage = "이미 미리담기한 과목입니다.";
			}			
		}else if(action.equals("수강신청")) {
			if(dao.checkLectureLimit(LectureID)!= true) {
				Errmessage = "수강신청 인원 초과.";
			}else {
				if(dao.insertApply("Apply", LectureID, student.getStudentID())) {
					dao.updateNumApplyPerson(1, LectureID);
					message = "수강신청 완료";			
				}else {
					Errmessage = "이미 수강신청한 과목입니다.";
				}
			}
		}else if(action.equals("삭제")) {
			String value = request.getParameter("value");
			
			if(dao.deleteApply(value, LectureID, student.getStudentID())) {
				dao.updateNumApplyPerson(-1, LectureID);
				message = "해당 과목이 삭제 완료";		
			}else {
				Errmessage = "해당 과목 삭제 실패";
			}
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(Errmessage!=null) {
			out.println("alert('" + Errmessage+ "');");
			out.println("history.back();");
		}else {
			out.println("alert('" + message+ "');");
			String url = "/SugangMain.jsp";
			RequestDispatcher disp = request.getRequestDispatcher(url);
			disp.forward(request, response);	
		}
		out.println("</script>");	
	}
	}
}
