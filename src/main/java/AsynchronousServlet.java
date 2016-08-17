import org.omg.CORBA.INV_FLAG;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name="AsynchronousServlet", urlPatterns = "/asyncServlet", asyncSupported = true)
public class AsynchronousServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Logger logger = Logger.getLogger(AsynchronousServlet.class.getName());
        logger.log(Level.INFO, "--- Data of doGet()");
        final AsyncContext ac = req.startAsync();
        logger.log(Level.INFO, "---- Call ac.start()");
        ac.start(new Runnable() {
            public void run() {
                logger.log(Level.INFO, "inside flow");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ie) {
                    Logger.getLogger(AsynchronousServlet.class.getName()).log(Level.SEVERE, null, ie);
                }

                try {
                    ac.getResponse().getWriter().println("You must see this after short time");
                    ac.complete();
                } catch (IOException ioe) {
                    Logger.getLogger(AsynchronousServlet.class.getName()).log(Level.SEVERE, null, ioe);
                }
            }
        });
        logger.log(Level.INFO, "Leave doGet()");
    }
}
