package com.githrd.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/")
public class TestIndex extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// 이 서블릿의 할일은 아바타 리스트 페이지를 보여주기만 하면 된다.
	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/index.jsp");
	rd.forward(req, resp);
	}

}
