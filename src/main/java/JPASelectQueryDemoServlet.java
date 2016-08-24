import beans.UsStateBean;
import entities.UsState;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "JPASelectQueryDemoServlet", urlPatterns = "jpaselect" )
public class JPASelectQueryDemoServlet extends HttpServlet {
    @PersistenceUnit(unitName = "customerPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        List<UsState> matchingStatesList;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT s FROM UsState s WHERE s.usStateNm LIKE :name");
        query.setParameter("name", "New%");
        matchingStatesList = query.getResultList();

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        printWriter.println("Следующие штаты соответствуют критерию:<br/>");
        for (UsState state : matchingStatesList) {
            printWriter.println(state.getUsStateNm() + "<br/>");
        }
    }
}
