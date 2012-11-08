import java.io.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class XmlEditor extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String image = null;
        String width = null;
        String height = null;
        String caption = null;
        
        String action = request.getParameter("act"); 
        if (action.equals("modify"))  {
              image =request.getParameter("image");
			  int img = Integer.parseInt(image);
			 if((img>3)||(img<1)){
                out.println("<h1>Chose from 1 to 3</h1>");
				return;
            }
              width =request.getParameter("width");
              height =request.getParameter("height");
              caption =request.getParameter("caption");
        }
        try{
        SAXBuilder builder = new SAXBuilder();
	File xmlFile = new File("/usr/share/apache-tomcat-6.0.36/webapps/finalproject/images/img"+image+".xml");
 
        Document doc = (Document) builder.build(xmlFile);
	    Element rootNode = doc.getRootElement();
        
        rootNode.getChild("width").setText(width);
        rootNode.getChild("length").setText(height);
        rootNode.getChild("caption").setText(caption);
        
        //out.println(rootNode.getChild("width").getText());
        
        XMLOutputter xmlOutput = new XMLOutputter();
 
	xmlOutput.setFormat(Format.getPrettyFormat());
	xmlOutput.output(doc, new FileWriter("/usr/share/apache-tomcat-6.0.36/webapps/finalproject/images/img"+image+".xml"));
 
	out.println("<h1>File updated!</h1>");
       // out.println(rootNode.getChild("width").getText());
        }
        
        catch (IOException io) {
		out.println("<h1>lathos megale io</h1>");
		io.printStackTrace();
	  } 
        catch (JDOMException e) {
		out.println("<h1>lathos megale jdom</h1>");
		e.printStackTrace();
	  }
 }
}
