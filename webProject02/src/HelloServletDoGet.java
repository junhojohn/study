

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServletDoGet
 */
@WebServlet("/HelloServletDoGet")
public class HelloServletDoGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServletDoGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1. servlet doGet() 시작");
		System.out.println("Client IP : " + request.getRemoteAddr() + "에서 접속.");
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>Hello Servlet Do Get</title></head>");
		writer.println("<body>");
		writer.println("English : Hello Servlet<br>");
		writer.println("Korean : 안녕 서블릿");
		writer.println("</body>");
		writer.println("</html>");
		writer.flush();
		writer.close();
	}

}
