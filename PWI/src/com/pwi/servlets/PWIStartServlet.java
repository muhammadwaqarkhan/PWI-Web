package com.pwi.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.spring.SpringApplicationContext;
import com.pwi.ws.branch.JaxBranchServices;
import com.pwi.ws.product.JaxProductServices;
import com.pwi.ws.store.JaxStoreServices;

/**
 * Servlet implementation class PDFFileReaderServlet. The job of this servlet is
 * to initiate the thread scheduler to read pdf files.
 * 
 * @author Waqar khanw
 */
@WebServlet(name = "PWIStartServlet", loadOnStartup = 1, urlPatterns = "/PWIStartServlet")
public class PWIStartServlet extends HttpServlet
{
	// private Thread thread = null;

	private static final long	serialVersionUID	= 1L;

	/**
	 * Default constructor.
	 */
	public PWIStartServlet()
	{
		System.out.println("server call");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException
	{
		
		 SpringApplicationContext.getInstance();
		 Endpoint.publish("http://localhost:7779/PWI/Products", new JaxProductServices());
		 Endpoint.publish("http://localhost:7779/PWI/Stores", new JaxStoreServices());
		 Endpoint.publish("http://localhost:7779/PWI/Branch", new JaxBranchServices());
		 
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
