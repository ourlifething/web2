package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BestFruitsDAO;
import model.DatetimeLogic;
import model.FruitsJB;

/**
 * Servlet implementation class Recomend
 */
@WebServlet("/Recommend")
public class Recommend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login.jspより
		request.setCharacterEncoding("UTF-8");
		String recommendFruits = request.getParameter("recommend");
		if(recommendFruits != null && recommendFruits.length() != 0) {
			DatetimeLogic dateTimelogic = new DatetimeLogic();
			String dateTime =dateTimelogic.dateTime();
			FruitsJB fruitsjb = new FruitsJB(recommendFruits,dateTime);
			
			System.out.println("デバッグRecommend.java:fruitsJB getNmae"+fruitsjb.getName());
			System.out.println("デバッグRecommend.java:fruitsJB getMonth"+fruitsjb.getMonth());
			
			BestFruitsDAO fruitsdao = new BestFruitsDAO();
			
			fruitsdao.insertOne(fruitsjb);
			
			response.sendRedirect("/favFruits/Read");
		}else {
			System.out.println("空もじ");
			request.setAttribute("errorMsg", "おすすめが入力されていません");
			RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/view/login.jsp");
			rd.forward(request, response);
		}
		
		
	
		
	}

}
