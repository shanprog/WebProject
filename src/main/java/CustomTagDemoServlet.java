import beans.AddressBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ctagdemo2", urlPatterns = "/ctagdemo2")
public class CustomTagDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AddressBean addressBean = new AddressBean();
        addressBean.setLine1("43623 Park Ridge Ct");
        addressBean.setCity("Orlando");
        addressBean.setState("FL");
        addressBean.setZip("00303");
        req.setAttribute("address", addressBean);
        try {
            req.getRequestDispatcher("customtagdemo2.jsp").forward(req, resp);
        } catch (ServletException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
