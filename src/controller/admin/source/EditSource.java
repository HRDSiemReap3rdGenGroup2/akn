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
@WebServlet("/EditSource")
public class EditSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSource() {
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

		int source_id = Integer.parseInt(request.getParameter("source_id"));
		String source_name = request.getParameter("source_name");
		String source_code = request.getParameter("source_code");
		System.out.println(source_id);
		
		Source source = new Source();
		source.setSource_id(source_id);
		source.setSource_name(source_name);
		source.setSource_code(source_code);
		
		try {
			if(new SourceDAO().editSource(source)){
				//request.getRequestDispatcher("listsource").forward(request, response);
				response.sendRedirect("listsource");
				System.out.println("Update SUCCESS");
				response.getWriter().write("success");
			}else{
				System.err.println("Update FAIL");
				response.getWriter().write("fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
