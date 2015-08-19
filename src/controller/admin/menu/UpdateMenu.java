package controller.admin.menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MenuDAO;
import model.dto.Menu;

/**
 * Servlet implementation class UpdateMenu
 */
@WebServlet("/UpdateMenu")
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

		String menu0 = request.getParameter("menu0");
		String menu1 = request.getParameter("menu1");
		String menu2 = request.getParameter("menu2");
		String menu3 = request.getParameter("menu3");
		String menu4 = request.getParameter("menu4");
		String menu5 = request.getParameter("menu5");
		String menu6 = request.getParameter("menu6");

		Menu menu = new Menu();
		menu.setIndex0(menu0);
		menu.setIndex1(menu1);
		menu.setIndex2(menu2);
		menu.setIndex3(menu3);
		menu.setIndex4(menu4);
		menu.setIndex5(menu5);
		menu.setIndex6(menu6);

		try {
			boolean status = new MenuDAO().updateMenu(menu);
			if (status)
				System.out.println("success");
			response.sendRedirect("fixedmenu");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
