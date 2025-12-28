import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SimpleServlet extends HttpServlet {
    public void doGet(HttpServletRequest r, HttpServletResponse res) 
            throws ServletException, IOException {
        res.setContentType("text/html");
        res.getWriter().println("<h1>✅ SERVLET WORKS ON 8082!</h1>");
    }
}
