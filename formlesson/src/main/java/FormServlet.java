

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//文字化けしないようにsetCharacterEncoding
		String name = request.getParameter("name");//name属性nameを受け取る
		String gender = request.getParameter("gender");
		/*
		String[] genders = {"男", "女"};
		String genJa = genders[Integer.parseInt(gender)];
		*/
		//System.out.println("名前" + name +"性別" + gender); //デバック:取得の確認
		response.setContentType("text/plane;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		out.printf("ようこそ%sさん%n", name);
		out.printf("あなたは%s性です%n",gender);
	}
	
}
