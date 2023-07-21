package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginJB;
import model.LoginLogic;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/login.jsp");
		rd.forward(request, response);
		System.out.println("!!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		
		System.out.println("デバッグLogin.java"+name);
		System.out.println("デバッグLgin.java"+pass);
		
		LoginJB loginjb = new LoginJB(name, pass);
		LoginLogic loginlogic = new LoginLogic();
		boolean is_true = loginlogic.login(loginjb);
		System.out.println("デバッグLogin.java"+is_true);
		if(is_true == true && name.length() != 0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginok",loginjb);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/login.jsp");
			rd.forward(request, response);
			System.out.println("デバッグLogin.java LoginJBのgetName()"+loginjb.getName());
		}else{
			request.setAttribute("false", "未入力の項目があるかパスワードが違います");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/signin.jsp");
			rd.forward(request, response);
			//response.sendRedirect("Main");
		}
	}

}
