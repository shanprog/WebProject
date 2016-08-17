import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InitParamsServlet", urlPatterns = "/InitParamsServlet", initParams = {
        @WebInitParam(name = "param1", value = "value1"),
        @WebInitParam(name = "param2", value = "value2")
})
public class InitParamsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String param1Val = servletConfig.getInitParameter("param1");
        String param2Val = servletConfig.getInitParameter("param2");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<p>");
        printWriter.println("Значением param1 явдяется " + param1Val);
        printWriter.println("</p>");
        printWriter.println("<p>");
        printWriter.println("Значением param2 явдяется " + param2Val);
        printWriter.println("</p>");
    }
}
