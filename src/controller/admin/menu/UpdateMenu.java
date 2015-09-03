package controller.admin.menu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MenuDAO;

/**
 * Servlet implementation class UpdateMenu
 */
public class UpdateMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		//category_id
		int index0 = Integer.parseInt(request.getParameter("index0")); 
		int index1 = Integer.parseInt(request.getParameter("index1"));
		int index2 = Integer.parseInt(request.getParameter("index2"));
		int index3 = Integer.parseInt(request.getParameter("index3"));
		int index4 = Integer.parseInt(request.getParameter("index4"));

		ArrayList<Integer> category_id  = new ArrayList<Integer>();
		
		category_id.add(index0);
		category_id.add(index1);
		category_id.add(index2);
		category_id.add(index3);
		category_id.add(index4);
		
		try {
			new MenuDAO().updateMenu(category_id);
			response.sendRedirect("fixedmenu");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
