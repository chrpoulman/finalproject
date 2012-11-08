import java.io.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ImageModify extends HttpServlet{
    int i = 0; //separate For Each Servlet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
         PrintWriter out = response.getWriter();
        
        String action = request.getParameter("act"); 
       if (action.equals("modify"))  {
            String image =request.getParameter("image");
			int img = Integer.parseInt(image);
			if((img>3)||(img<1)){
                out.println("<h1>Chose from 1 to 3</h1>");
				return;
            }
            String width =request.getParameter("width");
            String height =request.getParameter("height");
            out.println("<img src=\"http://83.212.97.36:8080/project3/images/img"+image+".jpg\"  width="+width+" height="+height+"/>");
            out.println("<h3>image "+image +" has "+ width +"pixels and "+ height+"pixels</h3>");
       }
 }
}