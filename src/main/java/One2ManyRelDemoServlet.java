import entities.Customer;
import entities.Order;

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


@WebServlet(name = "One2ManyRelDemoServlet", urlPatterns = "one2manyrel")
public class One2ManyRelDemoServlet extends HttpServlet {

    @PersistenceUnit(unitName = "customerPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer;
        Order order1;
        Order order2;
        order1 = new Order();
        order1.setOrderId(1L);
        order1.setOrderNumber("SFX12345");
        order1.setOrderDescription("Незаполненный заказ");

        order2 = new Order();
        order2.setOrderId(2L);
        order2.setOrderNumber("SFX23456");
        order2.setOrderDescription("Еще один незаполненный заказ");

        try {
            userTransaction.begin();
            customer = entityManager.find(Customer.class, 4L);
            order1.setCustomer(customer);
            order2.setCustomer(customer);
            entityManager.persist(order1);
            entityManager.persist(order2);
            userTransaction.commit();
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println("База данных успешно обновлена One2Many");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
