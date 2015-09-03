package controller.admin.source;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SourceDAO;
import model.dto.Source;

/**
 * Servlet implementation class EditSource
 */
public class GetSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int source_id = Integer.parseInt(request.getParameter("id"));
		System.out.println(source_id);
		
		try {
			Source source = new SourceDAO().getSource(source_id);
			source.setSource_status(1);
			request.setAttribute("updatesource", source);
			request.getRequestDispatcher("addsource.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
