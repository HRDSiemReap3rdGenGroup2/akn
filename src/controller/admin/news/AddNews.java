package controller.admin.news;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class AddNews
 */
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNews() {
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
		String UPLOAD_DIRECTORY = request.getServletContext().getRealPath("img"+File.separator+"upload"+File.separator);
		
		try {
		if(ServletFileUpload.isMultipartContent(request)){
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              System.out.println("I love cambodia");
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        //get file name
                    	String filename = new File(item.getName()).getName();//+new Date();
                        System.out.println("MyFileName: "+filename);
                        
                        //copy image to folder
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + filename));
                        UPLOAD_DIRECTORY = UPLOAD_DIRECTORY + File.separator + filename;
                        response.getWriter().write(request.getContextPath()+"/"+"img"+"/"+"upload"+"/"+filename);
                     }
                }
			}else{
				request.setAttribute("message",
						"Sorry this Servlet only handles file upload request");
			}
        } catch (Exception ex) {
           request.setAttribute("message", "File Upload Failed due to " + ex);
        }          
	}

}
