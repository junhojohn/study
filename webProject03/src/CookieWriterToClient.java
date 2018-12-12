

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieWriterToClient
 */
@WebServlet("/CookieWriterToClient")
public class CookieWriterToClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieWriterToClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRemoteAddr() + "에서 접속.");
		request.setCharacterEncoding("EUC_KR");
		
		Cookie[] cookies = request.getCookies();
		PrintWriter writer = response.getWriter();
		if(cookies == null || cookies.length == 0){
			System.out.println("This is the first time visit.");
			Cookie cookie = new Cookie("id", URLEncoder.encode("junhojohn"));
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			
			writer.println("<html><head><title>Cookie Session created.</title></head>");
			writer.println("<body>Saving Cookie completed.</body>");
			writer.println("</html>");
			writer.flush();
			writer.close();
		}else{
			System.out.println("You've been visited this site.");
			writer.println("<html><head><title>Cookie Session already exist!</title></head>");
			writer.println("<body>No creation of cookie.</body>");
			writer.println("</html>");
			writer.flush();
			writer.close();
		}
	}

}
