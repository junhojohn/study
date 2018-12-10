

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDataATagServletMapping
 */
@WebServlet("/GetDataATagServletMapping")
public class GetDataATagServletMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataATagServletMapping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() 메소드 실행.");
		System.out.println(request.getRemoteAddr() + "에서 접속.");
		request.setCharacterEncoding("EUC_KR");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>return page</title></head>");
		writer.println("<body>");
		writer.println("<body>");
		writer.println("name:" + name);
		writer.println("addr:" + addr);
		writer.println("</body>");
		writer.println("</html>");
		
	}

}
