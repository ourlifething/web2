package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/healthCheck.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String weight =request.getParameter("weight");
		String height = request.getParameter("height");//入力を受け取る
		
		Health health = new Health();//初期値は０とnullのインスタンスができる
		health.setHeight(Double.parseDouble(height));//webブラウザから入力された受け取った情報でセット
		health.setWeight(Double.parseDouble(weight));
		
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();//インスタンスメソットなのでここで生成してメソッドを実行
		healthCheckLogic.execute(health);//Healthインスタンスを完成させる
		
		request.setAttribute("health",health);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/healthCheckResult.jsp");
		dispatcher.forward(request, response);
	}

}
