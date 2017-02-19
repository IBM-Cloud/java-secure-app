/*******************************************************************************
 * Copyright (c) 2017 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/ 
package secure.web.starter.good;

import java.io.*;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.owasp.encoder.*;

@WebServlet("/GoodServlet")
public class GoodServlet extends HttpServlet {

    // Example patterns for input validation
    private static final Pattern alphanumPattern = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern strongPasswordPattern = Pattern.compile("(?=^.{6,}$)((?=.*[A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z]))^.*");

    public void init() throws ServletException {
    }
    
    // Use Post to avoid sensitive data disclosed in URL parameters instead of Get
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
           String username = request.getParameter("username");
           
           // Validate every input parameter
           if ( username == null || !alphanumPattern.matcher( username ).matches()) {
               throw new Exception( "Improper name format." );
           }
           String password = request.getParameter("password");
           if ( password == null || !strongPasswordPattern.matcher( password ).matches()) {
               throw new Exception(     "Improper password format." );
           }
           // Where validated input parameters are used for processing
           // ...
           // ...
           
           // When prepare a response page
           // Set up the HTTP Header properly for security
           response.setContentType("text/html;charset=UTF-8"); // Always specify proper content type
              // If a json array is returned:
              // response.setContentType("application/json");
              // response.setCharacterEncoding("UTF-8");
           response.setHeader("Content-Security-Policy", "script-src 'self'");  // Apply proper CSP policies 
           Cookie[] cookies = request.getCookies();
           if (cookies != null){
              for (int i = 0; i < cookies.length; i++) {
                  cookies[i].setHttpOnly(true);                // Always restrict script access to cookies
                  cookies[i].setSecure(true);                  // Always use secure transport to send cookies, e.g. HTTPS
                  response.addCookie(cookies[i]);
              }
           }
           
           // Encode output
           response.getWriter().println("<html><body>Welcome! " +
               Encode.forHtmlContent(username) + "</body></html>");  // Encode the input parameters in returning HTML pages
       } catch(Exception e ) {
           response.sendError( response.SC_BAD_REQUEST, e.getMessage() );
       }
    
    }
    
    public void destroy() {
    }
}
