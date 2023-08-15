package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EJWord;
import model.EJWordLogic;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int LIMIT = 20;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchWord = request.getParameter("searchWord");//<input>より入力された文字
		
		System.out.println("ログ：Main ,serchWord:"+searchWord);
		EJWord ejw;
		if(searchWord != null) {
			String mode = request.getParameter("mode");//<select>より
			System.out.println("ログ：Main ,mode:"+mode);
			if( mode == null) {
				mode = "startWith";
			}
		    //searchWordがnullでない処理
		    String page = (String)request.getParameter("page");
		    
		    System.out.println("ログ：Main ,page:"+page);
		    
		    int pageNo = page == null? 1:Integer.parseInt(page);//urlから叩かれ他時にpageを空白にされることがあるからその場合はnullで１が入る
		    
		    System.out.println("ログ：Main ,pageNo"+pageNo);

			ejw = new EJWord(searchWord,mode,pageNo,LIMIT);
			EJWordLogic logic = new EJWordLogic();
			logic.execute(ejw);
			System.out.println("ログ: Main: ejw.getPager():"+ejw.getPager());
				
		}else { 
			ejw = new EJWord();
		}
		request.setAttribute("ejw", ejw);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}
}
















