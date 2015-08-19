package controller.admin.module;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ModuleDAO;
import model.dto.Module;

/**
 * Servlet implementation class UpdateModule
 */
@WebServlet("/UpdateModule")
public class UpdateModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateModule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int module_id = Integer.parseInt(request.getParameter("id"));
		try {
			response.setCharacterEncoding("utf-8");
			Module module = new ModuleDAO().getModule(module_id);
			module.setStatus(1);
			request.setAttribute("module", module);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ArrayList<Module> list = new ModuleDAO().getAllModuleName();
			response.setCharacterEncoding("utf-8");
			request.setAttribute("source", list);
			request.getRequestDispatcher("addmodule.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
