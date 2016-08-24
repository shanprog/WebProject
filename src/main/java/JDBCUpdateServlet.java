import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name="JDBCUpdateServlet", urlPatterns = "/jdbcupdate")
public class JDBCUpdateServlet extends HttpServlet {

    @Resource(lookup = "java:jboss/datasources/PostgreDataSource")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String insertCustomerSql = "INSERT INTO customers (customer_id, first_name, last_name, email) " +
                "VALUES (?,?,?,?)";
        String updateCustomerLastNameSql = "UPDATE customers SET last_name=? WHERE customer_id = ?";
        String deleteCustomerSql = "DELETE FROM customers WHERE customer_id = ?";
        PreparedStatement insertCustomerStatement;
        PreparedStatement updateCustomerLastNameStatement;
        PreparedStatement deleteCustomerStatement;

        try{
            Connection connection = dataSource.getConnection();
            insertCustomerStatement = connection.prepareStatement(insertCustomerSql);
            updateCustomerLastNameStatement = connection.prepareStatement(updateCustomerLastNameSql);
            deleteCustomerStatement = connection.prepareStatement(deleteCustomerSql);

            insertCustomerStatement.setInt(1, 1);
            insertCustomerStatement.setString(2,"Leo");
            insertCustomerStatement.setString(3,"Smith");
            insertCustomerStatement.setString(4, "leosmith@fake.com");
            insertCustomerStatement.executeUpdate();
            insertCustomerStatement.setInt(1, 2);
            insertCustomerStatement.setString(2,"Jane");
            insertCustomerStatement.setString(3,"Davis");
            insertCustomerStatement.setString(4, "janed@fake.com");
            insertCustomerStatement.executeUpdate();
            updateCustomerLastNameStatement.setString(1, "Jones");
            updateCustomerLastNameStatement.setInt(2, 2);
            updateCustomerLastNameStatement.executeUpdate();
            deleteCustomerStatement.setInt(1, 1);
            deleteCustomerStatement.executeUpdate();

            deleteCustomerStatement.close();
            insertCustomerStatement.close();
            updateCustomerLastNameStatement.close();
            connection.close();

            response.getWriter().println("Database update");
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
