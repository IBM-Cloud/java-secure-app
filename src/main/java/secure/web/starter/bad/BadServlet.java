package secure.web.starter.bad;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/BadServlet")
public class BadServlet extends HttpServlet {

	public void init() throws ServletException {
    }
    
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=UTF-8");
        // The input is not validated. When added to the returning HTML page without being encoded, 
        // a malicious script embedded in the input may be executed in the Browser.
        // A XSS vulnerability is present. 
        response.getWriter().println("<html><body>Welcome! " + username + "</body></html>");
    }
    
    public void destroy() {
    }
}
