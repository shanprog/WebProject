import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enterdValue;
        enterdValue = req.getParameter("enteredValue");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter;

        try {
            printWriter = resp.getWriter();
            printWriter.println("<p>");
            printWriter.print("Вы ввели: ");
            printWriter.print(enterdValue);
            printWriter.println("</p>");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
