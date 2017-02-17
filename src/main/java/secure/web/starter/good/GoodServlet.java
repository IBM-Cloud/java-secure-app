package secure.web.starter.good;

import java.io.*;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.owasp.encoder.*;

@WebServlet("/GoodServlet")
public class GoodServlet extends HttpServlet {

    // example patterns for input validation
    private static final Pattern alphanumPattern = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern strongPasswordPattern = Pattern.compile("(?=^.{6,}$)((?=.*[A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z]))^.*");

    public void init() throws ServletException {
    }
    
    // use Post to avoid sensitive data disclosed in URL parameters
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
           String username = request.getParameter("username");
           
           // validate input
           if ( username == null || !alphanumPattern.matcher( username ).matches()) {
               throw new Exception( "Improper name format." );
           }
           String password = request.getParameter("password");
           if ( password == null || !strongPasswordPattern.matcher( password ).matches()) {
               throw new Exception(     "Improper password format." );
           }
           // Use the input data to do something
           // ...
           // ...
           
           // prepare a response page
           // set up Header for security
           response.setContentType("text/html;charset=UTF-8");
              // if returns a json array
              // response.setContentType("application/json");
              // response.setCharacterEncoding("UTF-8");
           response.setHeader("Content-Security-Policy", "script-src 'self'");
           Cookie[] cookies = request.getCookies();
           if (cookies != null){
              for (int i = 0; i < cookies.length; i++) {
                  cookies[i].setHttpOnly(true);
                  cookies[i].setSecure(true);
                  response.addCookie(cookies[i]);
              }
           }
           
           // Encode output
           response.getWriter().println("<html><body>Welcome! " +
               Encode.forHtmlContent(username) + "</body></html>");
       } catch(Exception e ) {
           response.sendError( response.SC_BAD_REQUEST, e.getMessage() );
       }
    
    }
    
    public void destroy() {
    }
}
