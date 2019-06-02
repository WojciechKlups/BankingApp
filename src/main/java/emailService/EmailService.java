package emailService;

import model.User;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {
    private String username="java13poz@gmail.com";
    private String password="JAV13sda";

    public void sendEmail(User user) throws EmailException {
        try {
            Email email = new SimpleEmail();
            email.setSmtpPort(587);
            email.setHostName("smtp.gmail.com");
            email.setAuthentication(username, password);
            email.setStartTLSEnabled(true);
//        email.setSSLOnConnect(true);
            email.setFrom("java13poz@gmail.com", "JAVA POZ");
            email.setSubject("Testing email");
            email.setMsg("Activation link:" + "\n\n http://localhost:9090/activate?code=" + user.getActivationCode());
            email.addTo(user.getEmail());
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public void sendEmail2(User user){
        final String username = "java13poz@gmail.com";
        final String password = "JAV13sda";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("banking@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject("Activation link");
            message.setText("Activation link:"
                    + "\n\n http://localhost:8080/activate?code=" + user.getActivationCode());

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
