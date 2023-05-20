package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Customer;

@WebServlet("/sell")
public class Sell extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	Customer customer=(Customer) req.getSession().getAttribute("customer");
	if(customer==null)
	{
		res.getWriter().print("<h1>First login to sell an item</h1>");
		req.getRequestDispatcher("Home.jsp").include(req, res);
	}
	else
	{
		req.getRequestDispatcher("addproduct.html").forward(req, res);
	}
}
}
