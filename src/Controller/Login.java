package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import valueObject.VDirectory;
import valueObject.VLecture;
import valueObject.VLine;
import valueObject.VUser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginCheck")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAO dao; 
	
    public Login() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.dao = new DAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=euc-kr");	
        
		String url = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if (dao.checkLogin(id, pw)) {
				HttpSession session = request.getSession(true);

				long creationTime = session.getCreationTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("H:mm");
				String creationTimeString = dateFormat.format(new Date(creationTime));

				String limitOpen = "20:00";
				String limitClose = "21:00";

				int result1 = limitOpen.compareTo(creationTimeString);
				int result2 = limitClose.compareTo(creationTimeString);

				//if(result1<=0 && result2>0) {

				VUser student = dao.getStudent(id);
				session.setAttribute("student", student);
				url = "/SugangMain.jsp";

				Vector<VLine> VecLine = dao.getAllLine();
				Vector<Vector<VDirectory>> VecDepartments = new Vector<Vector<VDirectory>>();

				for (VLine Line : VecLine) {
					Vector<VDirectory> VecDepartment = dao.getDepartment(Line.getLineID());
					VecDepartments.add(VecDepartment);
				}
				session.setAttribute("VecLine", VecLine);
				session.setAttribute("VecDepartments", VecDepartments);

				/////// session timeout 
				 //session.setMaxInactiveInterval(5);
//			}else {
//				url = "/OpenError.jsp";
//			}

				RequestDispatcher disp = request.getRequestDispatcher(url);
				disp.forward(request, response);
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디 혹은 비밀번호 오류');");
				out.println("history.back();");
				out.println("</script>");
			}
	}

}
