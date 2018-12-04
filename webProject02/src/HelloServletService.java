

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServletService
 */
@WebServlet("/HelloServletService")
public class HelloServletService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServletService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1. servlet service() 시작.");
		System.out.println("Client IP : " + request.getRemoteAddr() + "에서 접속.");
		response.setContentType("text/html;charset=EUC_KR");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>Hello Servlet</title></head>");
		writer.println("<body>");
		writer.println("<body>");
		writer.println("English : HelloServlet<br>");
		writer.println("Korean : 안녕 서블릿<br>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.flush();
		writer.close();
	}

}
