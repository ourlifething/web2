package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MutterDAO;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		String s_id = request.getParameter("id");
		String delete = request.getParameter("action");
		if(s_id != null) {
			MutterDAO dao = new MutterDAO();
			dao.deleteOne(Integer.parseInt(s_id));
		}
		if(delete != null) {
			MutterDAO dao = new MutterDAO();
			dao.deleteAll();
		}
	
		response.sendRedirect("/dokoTsubuDB/Main");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
