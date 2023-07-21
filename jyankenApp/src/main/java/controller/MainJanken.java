package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Janken;
import model.JankenLogic;

@WebServlet("/MainJanken")
public class MainJanken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/top.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String myHand = request.getParameter("hand");
		HttpSession session = request.getSession();
		
		Janken jan = (Janken)session.getAttribute("janken");
		if(jan == null) {
			jan = new Janken(myHand);
		}
		
		JankenLogic janken = new JankenLogic();
		janken.execute(jan);
		

		session.setAttribute("janken",jan);
		doGet(request,response);
		
	}

}
