package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BestFruitsDAO;
import model.FruitsJB;

@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String inlineRadioOptions = request.getParameter("inlineRadioOptions");
		
		System.out.println("デバッグresultよりinlineRadioOptionsの値"+inlineRadioOptions);
		BestFruitsDAO bfdao = new BestFruitsDAO();
		if(!"いいえ".equals(inlineRadioOptions)) {
			 System.out.println("いいえではありません");
			 Date today = new Date();
			 SimpleDateFormat sdf = new SimpleDateFormat("M");
			 String dateTime = sdf.format(today);
			 FruitsJB fjb = new FruitsJB(inlineRadioOptions,dateTime);
			 
			 System.out.println("デバッグresultよりfjb.getName"+fjb.getName());
			
			 bfdao.insertOne(fjb);
		}
			
		List<FruitsJB> bestTen = bfdao.findLimit();
		request.setAttribute("bestTen", bestTen);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/result.jsp");
		rd.forward(request, response);
		
	
	}

}
