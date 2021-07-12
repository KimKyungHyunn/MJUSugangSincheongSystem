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

		if(action.equals("�̸����")) {
			if(dao.insertApply("Reservation", LectureID, student.getStudentID())) {
				message = "�̸���� �Ϸ�";
			}else {
				Errmessage = "�̹� �̸������ �����Դϴ�.";
			}			
		}else if(action.equals("������û")) {
			if(dao.checkLectureLimit(LectureID)!= true) {
				Errmessage = "������û �ο� �ʰ�.";
			}else {
				if(dao.insertApply("Apply", LectureID, student.getStudentID())) {
					dao.updateNumApplyPerson(1, LectureID);
					message = "������û �Ϸ�";			
				}else {
					Errmessage = "�̹� ������û�� �����Դϴ�.";
				}
			}
		}else if(action.equals("����")) {
			String value = request.getParameter("value");
			
			if(dao.deleteApply(value, LectureID, student.getStudentID())) {
				dao.updateNumApplyPerson(-1, LectureID);
				message = "�ش� ������ ���� �Ϸ�";		
			}else {
				Errmessage = "�ش� ���� ���� ����";
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
