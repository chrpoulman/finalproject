import java.io.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SlideShow extends HttpServlet{
    int i = 0;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
         PrintWriter out = response.getWriter();
       
        String action = request.getParameter("act"); 
       if (action.equals("slides"))  {
         for(i=1;i<=3;i++){
            out.println("<h3>image "+i+" is printed</h3>");
           out.println("<img src=\"http://83.212.97.36:8080/project3/images/img"+i+".jpg\"/>");      }  
       }
       out.println("<p></p>");
       out.println("Chose a number of an image and go back in the page if you want to modify in by puttin the images num in the text field");
 
 }
}