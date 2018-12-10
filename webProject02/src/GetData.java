

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetData
 */
@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 메소드 실행.");
		System.out.println(request.getRemoteAddr() + "에서 접속.");
		request.setCharacterEncoding("EUC_KR");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>return page</title></head>");
		writer.println("<body>");
		writer.println("name : " + name);
		writer.println("addr : " + addr);
		writer.println("</body>");
		writer.println("</html>");
		
	}

}
