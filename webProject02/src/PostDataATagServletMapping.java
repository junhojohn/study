

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostDataATagServletMapping
 */
@WebServlet("/PostDataATagServletMapping")
public class PostDataATagServletMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDataATagServletMapping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1. servlet doPost()시작");
		System.out.println("Client IP : " + request.getRemoteAddr() + "에서 접속.");
		request.setCharacterEncoding("EUC_KR");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>Return Page</title></head>");
		writer.println("<body>");
		writer.println("name is " + name);
		writer.println("address is " + addr);
		writer.println("</body>");
		writer.println("</html>");
		writer.flush();
		writer.close();
	}

}
