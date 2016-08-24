import entities.Customer;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.IOException;

@WebServlet(name = "JpaDemoServlet", urlPatterns = "/jpademo")
public class JpaDemoServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer = new Customer();
        Customer customer2 = new Customer();
        Customer customer3;

        customer.setCustomerId(3L);
        customer.setFirstName("James");
        customer.setLastName("McKenzie");
        customer.setEmail("jamesmk@fake.com");
        customer2.setCustomerId(4L);
        customer2.setFirstName("Charles");
        customer2.setLastName("Jonson");
        customer2.setEmail("chjonson@fake.com");
        try{
            userTransaction.begin();
            entityManager.persist(customer);
            entityManager.persist(customer2);
            customer3 = entityManager.find(Customer.class, 4L);
            customer3.setLastName("Johnson");
            entityManager.persist(customer3);
            entityManager.remove(customer);
            userTransaction.commit();
        }
        catch (NotSupportedException nse){
            nse.printStackTrace();
        }
        catch (SystemException syse) {
            syse.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("База данных успешно обновлена");
    }
}
