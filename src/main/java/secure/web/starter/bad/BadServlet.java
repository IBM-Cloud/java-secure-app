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
        response.getWriter().println("<html><body>Welcome! " + username + "</body></html>");
    }
    
    public void destroy() {
    }
}
