package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Authentication filter");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(true);
        
                if (session.getAttribute("email") != null) {
                    System.out.println("Session and user is valid");
                    chain.doFilter(req, resp);
                } else {
                    HttpServletResponse response = (HttpServletResponse) resp;
                    System.err.println("Session or user not valid");
                    response.sendRedirect("/index.jsp");
                }
            }

    public void init(FilterConfig config) throws ServletException {

    }

}
