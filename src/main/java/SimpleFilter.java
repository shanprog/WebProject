import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "SimpleFilter", initParams =
        {
                @WebInitParam(name = "filterparam1", value = "filtervalue1")
        },
        urlPatterns = "/InitParamsServlet")
public class SimpleFilter implements Filter {

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        servletContext.log("Входим в doFilter()");
        servletContext.log("инициализируем параметры: ");
        Enumeration<String> initParametersNames = filterConfig.getInitParameterNames();
        String parameterName;
        String parameterValue;
        while (initParametersNames.hasMoreElements()) {
            parameterName = initParametersNames.nextElement();
            parameterValue = filterConfig.getInitParameter(parameterName);
            servletContext.log(parameterName + " = " + parameterValue);
        }
        servletContext.log("Вызываем сервлет...");
        filterChain.doFilter(servletRequest, servletResponse);
        servletContext.log("Возвращаемся из вызова сервлета");
    }

    public void destroy() {
        filterConfig = null;
    }
}
