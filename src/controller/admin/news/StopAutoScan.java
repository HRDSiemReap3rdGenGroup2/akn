package controller.admin.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StopAutoScan extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8944037595114595543L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req,resp);
	}

	private void doPro(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().getServletContext().setAttribute("autoscan", 0);
		
	}

}
