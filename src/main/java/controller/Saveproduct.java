package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Customerdao;
import dto.Product;
@WebServlet("/saveproduct")
@MultipartConfig
public class Saveproduct extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	Product product=new Product();
	product.setName(req.getParameter("pname"));
	product.setDescription(req.getParameter("pdesc"));
	product.setPrice(Double.parseDouble(req.getParameter("pprice")));
	
	byte[]pic =null;
   Part filepart=req.getPart("pimage");
   	if(filepart!=null)
   	{
   		InputStream inputstream=filepart.getInputStream();
   		pic= new byte[inputstream.available()];
   		inputstream.read(pic);
   		
   	}
   	product.setIamge(pic);
   	 Customerdao dao=new Customerdao();
   	 dao.save(product);
}
}
