

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://localhost:8080/slot(プロジェクト名)/main(マッピング名)
//マッピング名
@WebServlet("/main")
public class Main extends HttpServlet {
	//dogetメソッドのオーバーライドurl直打ち、リンク
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Random rand = new Random();
		int[] nums = new int[3];
		for(int i =0; i<3; i++) {
			nums[i] = rand.nextInt(3);
		}
		boolean isWin = true;
		for(int i=1; i<3;i++) {
			if(nums[i] !=nums[0]) {
				isWin = false;
				break;
			}
		}
		
		response.setContentType("text/html;charset=utf-8");//出力の設定コンテンツタイプを指定
	
		PrintWriter out = response.getWriter();//printWriterを取得
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>slot</title>");
		out.println("<link rel='stylesheet' href='/slot/css/main.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.printf("<td>%d</td>%n",nums[0]);
		out.printf("<td>%d</td>%n",nums[1]);
		out.printf("<td>%d</td>%n",nums[2]);
		out.println("</tr>");
		out.println("</table>");
		out.printf("<p>%s</p>%n",isWin?"Win!":"Lose...");
		out.println("</body>");
		out.println("</html>");
	}
}
