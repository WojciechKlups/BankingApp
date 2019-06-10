package servlets;


import com.sun.org.apache.xpath.internal.operations.Bool;
import model.User;
import repository.UserRepository;
import services.HashingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserRepository userRepository;
    private HashingService hashingService;

    @Override
    public void init() throws ServletException {
        super.init();
        userRepository = new UserRepository();
        hashingService = new HashingService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Optional<User> byEmail = userRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            User user = byEmail.get();
            String passwordHashCodeFromRequest = hashingService.getHashedPassword(password, user.getSalt());
            if (user.getPassword().equals(passwordHashCodeFromRequest)) {
                session.setAttribute("email", email);
                if (Boolean.parseBoolean(request.getParameter("remember-me"))) {
                    session.setMaxInactiveInterval(3600);
                } else {
                    session.setMaxInactiveInterval(60);
                    System.err.println("Session time expired!");
                }
                response.sendRedirect("/myAccountServlet");
            } else {
                System.err.println("Password is invalid!");
                response.sendRedirect("/login.jsp");
            }
        } else {
            System.err.println("There's no such user!");
            response.sendRedirect("/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
