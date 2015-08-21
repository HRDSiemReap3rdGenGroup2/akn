package controller.admin.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dao.SourceDAO;
import model.dto.Category;
import model.dto.Source;


/**
 * Servlet implementation class FormNews
 */
public class FormNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setCharacterEncoding("utf-8");
			ArrayList<Category> list = new CategoryDAO().getAllCategory();
			
			ArrayList<Source> source = new SourceDAO().getAllSource();
			request.setAttribute("source", source);	
			
			request.setAttribute("category", list);
			request.getRequestDispatcher("addnews.jsp").forward(request, response);
		} catch (Exception e) {
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
