package com.pwi.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pwi.constants.ApplicationCodes;
import com.pwi.constants.FrameNames;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.ui.pageHandlers.ActionHandler;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet(name = "ApplicationServlet", loadOnStartup = 1, urlPatterns = "/ApplicationServlet")
public class ApplicationServlet extends HttpServlet
{

	private static final long	serialVersionUID	= -6794613072287644667L;

	/**
	 * Default constructor.
	 */
	public ApplicationServlet()
	{}

	// private Thread thread = null;

		

		/**
		 * @see Servlet#init(ServletConfig)
		 */
		public void init(ServletConfig config) throws ServletException
		{
			System.out.println("server started");

			

		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			processRequest(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			processRequest(request, response);
		}
		private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			IResponseHandler pageResponse = null;
			Integer action = request.getParameter(ApplicationCodes.ACTION) != null ? Integer.parseInt(request
					.getParameter(ApplicationCodes.ACTION)) : null;

			IPageHandler pageHandler = new ActionHandler().getPageHandler(request);
			if (ApplicationCodes.ACTION_READ.equals(action))
			{
				pageResponse = pageHandler.executeRead(request);
			}
			else if (ApplicationCodes.ACTION_WRITE.equals(action))
			{
				pageResponse = pageHandler.executeWrite(request);
			}
			else if (ApplicationCodes.ACTION_DELETE.equals(action))
			{
				pageResponse = pageHandler.executeDelete(request);
			}
			else if (ApplicationCodes.ACTION_UPDATE.equals(action))
			{
				pageResponse = pageHandler.executeUpdate(request);
			}

			if (pageResponse == null)
				return;

			if (!FrameNames.SIGN_OUT.equals(request.getParameter(ApplicationCodes.PAGE_NAME)))
			{
			
			}
			
			
			if (pageResponse.bForward())
				request.getRequestDispatcher(pageResponse.getNavURL()).forward(request, response);
			else
				response.sendRedirect(pageResponse.getNavURL());
		}
		
}
