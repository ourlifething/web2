package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BestFruitsDAO;
import model.DatetimeLogic;
import model.FruitsJB;
@WebServlet("/SelectBest")
public class SelectBest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BestFruitsDAO bestFruits = new BestFruitsDAO();
		System.out.println("デバッグ:selectBest");
		DatetimeLogic dateTimelogic = new DatetimeLogic();
		String dateTime =dateTimelogic.dateTime();
		List<FruitsJB> bestOne = bestFruits.findBest(Integer.parseInt(dateTime));
		String bestFruitname = bestOne.get(0).getName();
		request.setAttribute("bestFruitname", bestFruitname);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/recommend.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
