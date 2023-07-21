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

import model.Product;
import model.ProductLogic;



@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//最初にアプリケーションスコープを展開
		ServletContext application = this.getServletContext();
		//"data"という空のオブジェクトインスタンスを代入
		List<Product> data = (List<Product>)application.getAttribute("data");
		//null判定
		if(data==null) {
			//nullならArrayListオブジェクトをインスタンス化してdataに代入
			data = new ArrayList<>();
			//からのインスタンスdataをアプリケーションスコープへセット
			application.setAttribute("data",data );
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String price = request.getParameter ("price");
		
		String msg;
		if((name != null && name.length() > 0) && (price != null && price.length() > 0 )) {	
			msg="";
			
			//javaBeansのインスタンス化
			Product product = new Product(name, price);	
			//logicをインスタンス化
			ProductLogic pLogic = new ProductLogic();
			//アプリケーションスコープを展開
			ServletContext application = this.getServletContext();
			//doGetスコープから”data"インスタンスをget
			List<Product> data = (List<Product>)application.getAttribute("data");
			
			pLogic.execute(product,data);
				
			application.setAttribute("data",data);
		}else {
			msg="未入力の項目があります";
		}
		request.setAttribute("msg",msg);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
		
		
	}
}
