package servlets;

import services.EmailService;
import model.BankAccount;
import model.Currency;
import model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.mail.EmailException;
import repository.BankAccountRepository;
import repository.UserRepository;
import services.HashingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registrationServlet")
public class RegistrationServlet extends HttpServlet {
    private HashingService hashingService;
    private EmailService service;
    private UserRepository userRepository;
    private BankAccountRepository bankAccountRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new EmailService();
        hashingService = new HashingService();
        userRepository = new UserRepository();
        bankAccountRepository = new BankAccountRepository();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User newUser = createUserFromParameters(request);
        BankAccount newBankAccount = createBankAccount(newUser);
        bankAccountRepository.create(newBankAccount);
        userRepository.create(newUser);
        try {
            service.sendEmail(newUser);
            response.sendRedirect("/login.jsp");
        } catch (EmailException e) {
            System.out.println("Email is not valid");
            e.printStackTrace();
            response.sendRedirect("/registrationServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private User createUserFromParameters(HttpServletRequest request){
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String salt = "123";
        String hashedPassword = hashingService.getHashedPassword(password, salt);
        String newActivationCode = RandomStringUtils.randomAlphanumeric(20);
        return User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .password(hashedPassword)
                .salt(salt)
                .activated(false)
                .activationCode(newActivationCode)
                .build();
    }

    private BankAccount createBankAccount(User user) {
       String newBankAccountNumber = RandomStringUtils.randomNumeric(18);
       BankAccount bankAccount = BankAccount.builder()
                .balance(0L)
                .freeFunds(0)
                .accountNumber(newBankAccountNumber)
                .currency(Currency.DOLAR)
                .build();
        user.setAccounts(Collections.singleton(bankAccount));
        return bankAccount;
    }
}
