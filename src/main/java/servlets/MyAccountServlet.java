package servlets;

import model.User;
import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "MyAccountServlet", urlPatterns = "/myAccountServlet")
public class MyAccountServlet extends HttpServlet {

    UserRepository userRepository = new UserRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Object email = session.getAttribute("email");
        Optional<User> loggedUser = userRepository.findByEmail((String) email);

        loggedUser.ifPresent(user -> request.setAttribute("user", user));

        request.getRequestDispatcher("/account.jsp").forward(request, response);

    }
}
