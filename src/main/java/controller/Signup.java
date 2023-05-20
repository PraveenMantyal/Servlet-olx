package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Customerdao;
import dto.Customer;

@WebServlet("/signup")
public class Signup extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String mobile = req.getParameter("mobile");
	String password = req.getParameter("password");
	String gender = req.getParameter("gender");
	String dob = req.getParameter("dob");
	String address = req.getParameter("address");
	
	//local date.now() will show todays date and .getYear() we will get recent year - date.getYear() we will get
	Date date = Date.valueOf(dob);
	
	int age=Period.between(date.toLocalDate(), LocalDate.now()).getYears();
	Customerdao dao=new Customerdao();
	if (age<18)
	{
		res.getWriter().print("<h1 style='color:red'> Can not create account,age should be greater than 18 to create account</h1>");
		req.getRequestDispatcher("Signup.html").include(req, res);
	} 
	else 
	{
		if(dao.findm(Long.parseLong(mobile)).isEmpty()&& dao.finde(email).isEmpty()){
			
		Customer customer=new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setMobile(Long.parseLong(mobile));
		customer.setPassword(password);
		customer.setGender(gender);
		customer.setDob(date);
		customer.setAddress(address);
		customer.setAge(age);
		
		
		dao.save(customer);
		
		Customer customer2=dao.finde(email).get(0);
		res.getWriter().print("<h1 style='color:green'>Account created sucessfully.......</h1>");
		res.getWriter().print("<h1 style='color:Blue'> Your customer id is "+customer2.getCustid()+"</h1>");
		req.getRequestDispatcher("Home.jsp").include(req, res);
		}
		else{
			res.getWriter().print("<h1 style='color:red'>Cannot create account, mobile or email already exists....</h1>");
			req.getRequestDispatcher("Signup.html").include(req, res);
		}
	}
		
}
}
