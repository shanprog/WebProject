import entities.Customer;
import entities.LoginInfo;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import java.io.IOException;

@WebServlet(name = "OneToOneDemoServlet", urlPatterns = "one2onerel")
public class OneToOneRelDemoServlet extends HttpServlet {

    @PersistenceUnit(unitName = "customerPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer;
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginInfoId(1L);
        loginInfo.setLoginName("charlesj");
        loginInfo.setPassword("iwonttellyou");
        try {
            userTransaction.begin();
            customer = entityManager.find(Customer.class, 4L);
            loginInfo.setCustomer(customer);
            entityManager.persist(loginInfo);
            userTransaction.commit();
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println("База данных успешно обновлена");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
