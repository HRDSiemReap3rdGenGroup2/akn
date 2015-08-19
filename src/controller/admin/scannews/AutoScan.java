package controller.admin.scannews;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoScan extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8439048190712195967L;

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
		try {
			
			while(true){
				//help=applicationScope.getParameter("auto-scan");
				//if(help==1)scannnews
				//if(help==0)break;
				Thread.sleep(1000*60*5);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
