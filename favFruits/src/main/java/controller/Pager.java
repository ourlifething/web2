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
import model.FruitsJB;
import model.PagerLogic;

@WebServlet("/Pager")
public class Pager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pageLink = request.getParameter("name");
		
		System.out.println("デバッグPager:IN "+pageLink+"が選択");
		PagerLogic pagerLogic = new PagerLogic();
		String month = pagerLogic.monthPage(pageLink);
		
	/*	
		String month="";
		switch(pageLink) {
			case "1":
				month = pageLink;
				break;
			case "2":
				month = pageLink;
				break;
			case "3":
				month = pageLink;
				break;
			case "4":
				month = pageLink;
				break;
			case "5":
				month = pageLink;
				break;
			case "6":
				month = pageLink;
				break;
			case "7":
				month = pageLink;
				break;
			case "8":
				month = pageLink;
				break;
			case "9":
				month = pageLink;
				break;
			case "10":
				month = pageLink;
				break;
			case "11":
				month = pageLink;
				break;
			case "12":
				month = pageLink;
				break;
		}
		*/
		System.out.println(month+"月をforward");
		
		BestFruitsDAO bfdao = new BestFruitsDAO();
		request.setAttribute("month",month);
		List<FruitsJB> fruitsListMonth = bfdao.findLimit(Integer.parseInt(month));
		request.setAttribute("fruitsListMonth", fruitsListMonth);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/result.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}		

}
