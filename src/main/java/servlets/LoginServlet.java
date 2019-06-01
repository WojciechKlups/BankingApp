package servlets;

import listener.ContextListener;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Object email = session.getAttribute("email");
        Object password = session.getAttribute("password");

        String email1 = request.getParameter("email");
        String password1 = request.getParameter("password");


        if(email.equals(email1) && password.equals(password1)) {

            session.setAttribute("email", email);
            session.setAttribute("password", password);
            response.sendRedirect("/account.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
