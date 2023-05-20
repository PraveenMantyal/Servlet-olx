package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Customerdao;
import dto.Customer;

@WebServlet("/login")
public class Login extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		int custid=Integer.parseInt(req.getParameter("cid"));
		String password = req.getParameter("password");
		
		Customerdao c=new Customerdao();
		Customer customer = c.find(custid);
		
		if(customer==null)
		{
			res.getWriter().print("<h1 style='color:red'>Incorrect customer id</h1>");
			req.getRequestDispatcher("Login.html").include(req, res);
		}
		else
		{
			
			if(customer.getPassword().equals(password))
			{
				req.getSession().setAttribute("customer", customer);
				res.getWriter().print("<h1 style='color:green'>Login Sucess</h1>");
				req.getRequestDispatcher("Home.jsp").include(req, res);
			}
			else
			{
				res.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, res);
			}
		}
	}
}
