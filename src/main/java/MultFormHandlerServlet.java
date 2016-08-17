import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MultFormHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectedOptions = req.getParameterValues("options");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<p>");
            printWriter.print("Были выбраны следующие опции: ");
            printWriter.println("<br/>");

            if (selectedOptions != null) {
                for (String option : selectedOptions) {
                    printWriter.print(option);
                    printWriter.println("<br/>");
                }
            } else {
                printWriter.println("Никаких опций выбрано не было.");
            }

            printWriter.println("</p>");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
