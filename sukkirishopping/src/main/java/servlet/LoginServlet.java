package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		if((userId != null && userId.length() > 0) && (pass != null && pass.length() > 0)) {
			
			Login login = new Login(userId, pass);
			LoginLogic bo = new LoginLogic();
			boolean result = bo.execute(login);
			System.out.println("ok1");
			
			if(result) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				System.out.println("ok2");
			}else {
				response.sendRedirect("LoginServlet");
				System.out.println("Redirect:LoginServlet");
			}
				
		}else {
			request.setAttribute("errorMsg", "未入力の項目があります");
			System.out.println("errorMsgあり");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginOK.jsp");
		dispatcher.forward(request, response);
	}

}
