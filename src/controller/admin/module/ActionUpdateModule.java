package controller.admin.module;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ModuleDAO;
import model.dto.Module;

/**
 * Servlet implementation class ActionUpdateModule
 */
public class ActionUpdateModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionUpdateModule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int module_id = Integer.parseInt(request.getParameter("module_id"));
		String module_name = request.getParameter("module_name");
		String module_type = request.getParameter("module_type");
		
		System.out.println(module_name);
		System.out.println(module_type);
		System.out.println(module_id);
		
		Module module = new Module();
		module.setModule_name(module_name);
		module.setModule_type(module_type);
		module.setModule_id(module_id);
		try {
			if(new ModuleDAO().updateModule(module)){
				System.out.println("Updated Successfully..!");
				response.getWriter().write("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
