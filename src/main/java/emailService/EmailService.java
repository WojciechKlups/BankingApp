package emailService;

import model.User;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {
    private String username="java13poz@gmail.com";
    private String password="JAV13sda";

    public void sendEmail(User user) throws EmailException {
        Email email = new SimpleEmail();
        email.setSmtpPort(587);
        email.setHostName("smtp.gmail.com");
        email.setAuthentication(username, password);
        email.setStartTLSEnabled(true);
        email.setFrom("java13poz@gmail.com", "JAVA POZ");
        email.setSubject("Testing email");
        email.setMsg("Activation link:" + "\n\n http://localhost:9090/activate?code=" + user.getActivationCode());
        email.addTo(user.getEmail());
        email.send();
    }
}
