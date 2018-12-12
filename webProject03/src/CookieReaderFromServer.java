

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
 * Servlet implementation class CookieReaderFromServer
 */
@WebServlet("/CookieReaderFromServer")
public class CookieReaderFromServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieReaderFromServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC_KR");
		System.out.println(request.getRemoteAddr() + "에서 접속.");
		PrintWriter writer = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		if(cookies == null || cookies.length == 0){
			System.out.println("This is the first time visit.");
			Cookie cookie = new Cookie("id", URLEncoder.encode("junhojohn"));
			cookie.setMaxAge(60);
			writer.println("<html><head><title>Cookie session created.</title></head>");
			writer.println("<body>Cookie has been created.(60 seconds)</body>");
			writer.println("</html>");
			response.addCookie(cookie);
		}else{
			System.out.println("You've been visited this web site before.");
			writer.println("<html><head><title>Cookie session alread exists.</title></head>");
			writer.println("<body>");
			for(int i = 0 ; i < cookies.length ; i ++){
				writer.println("cookie session age : " + cookies[i].getMaxAge() + "<br>");				
				writer.println("cookie session value : " + cookies[i].getValue() + "<br>");
				writer.println("cookie session name : " + cookies[i].getName() + "<br>");
				writer.println("cookie session comment : " + cookies[i].getComment() + "<br>");
				writer.println("cookie session domain : " + cookies[i].getDomain() + "<br>");
				writer.println("cookie session path : " + cookies[i].getPath() + "<br>");
				writer.println("cookie session version : " + cookies[i].getVersion() + "<br>");
				writer.println("cookie session secure : " + cookies[i].getSecure() + "<br>");
				writer.println("<h1><br>");
			}
			writer.println("</body>");
			writer.println("</html>");
		}
		writer.flush();
		writer.close();
	}

}
