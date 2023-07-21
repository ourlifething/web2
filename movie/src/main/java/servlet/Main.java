package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Movie;
import model.PostCommentLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		List<Movie> movie = (List<Movie>)application.getAttribute("movieComment");
		
		if(movie == null) {
			movie = new ArrayList<>();
			application.setAttribute("movieComment",movie);
		}
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("LoginUser");
		
		if(loginUser == null) {
			response.sendRedirect("index.jsp");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Main.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String comment = request.getParameter("comment");
		String userName = request.getParameter("userName");
		
		if(comment != null && comment.length() != 0) {
			ServletContext application = this.getServletContext();
			
			List<Movie> movie = (List<Movie>)application.getAttribute("movieComment");
			
		///////
			
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("LoginUser");
		
		Movie movieInfo = new Movie(userName,title,comment);
		
		
		PostCommentLogic postcommentlogic = new PostCommentLogic();
		postcommentlogic.execute(movieInfo, movie);
		
		application.setAttribute("movieList", movie);
		}else {
			request.setAttribute("errorMsg", "コメントが入力されてません");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Main.jsp");
		dispatcher.forward(request, response);
	}

}
