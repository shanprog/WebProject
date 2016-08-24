import beans.UsStateBean;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "JDBCSelectServlet", urlPatterns = "/jdbcselect")
public class JDBCSelectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "SELECT us_state_nm, us_state_cd FROM us_states ORDER BY us_state_nm";
        ArrayList<UsStateBean> statelist = new ArrayList<UsStateBean>();
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/PostgreDataSource");
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                statelist.add(new UsStateBean(resultSet.getString("us_state_nm"), resultSet.getString("us_state_cd")));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

            request.setAttribute("stateList", statelist);
            request.getRequestDispatcher("us_states.jsp").forward(request, response);
        }
        catch (NamingException ne){
            ne.printStackTrace();
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
