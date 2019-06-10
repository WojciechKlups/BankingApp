package listener;


import lombok.extern.slf4j.Slf4j;
import model.BankAccount;
import model.Currency;
import model.User;
import repository.BankAccountRepository;
import repository.UserRepository;
import services.HashingService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import java.util.Collections;

@WebListener
@Slf4j
public class ContextListener implements ServletContextListener {

    private HashingService hashingService = new HashingService();

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        final BankAccountRepository repository1 = new BankAccountRepository();
        BankAccount bankAccount = BankAccount.builder()
                .accountNumber("1927734712673812")
                .balance(923748732L)
                .freeFunds(12341243)
                .currency(Currency.ZLOTY)
                .build();
        BankAccount bankAccount1 = BankAccount.builder()
                .accountNumber("34897923874923")
                .balance(34245L)
                .freeFunds(3456)
                .currency(Currency.ZLOTY)
                .build();

        repository1.create(bankAccount);
        repository1.create(bankAccount1);

        log.info("Creating bank account with details {}", bankAccount);
        log.info("Creating bank account with details {}", bankAccount1);

        final UserRepository repository = new UserRepository();
        String salt = "123";
        String hashedPassword = hashingService.getHashedPassword("1234", salt);
        User user = User.builder()
                .firstname("Wojciech")
                .lastname("Klupś")
                .email("wojciechklups@gmail.com")
                .password(hashedPassword)
                .salt(salt)
                .accounts(Collections.singleton(bankAccount))
                .build();
        String hashedPassword2 = hashingService.getHashedPassword("0987", salt);
        User user1 = User.builder()
                .firstname("Andrzej")
                .lastname("Kowalski")
                .email("kowalski@onet.pl")
                .password(hashedPassword2)
                .salt(salt)
                .accounts(Collections.singleton(bankAccount1))
                .build();
        repository.create(user1);
        repository.create(user);

        log.info("Creating user with details {}", user);
        log.info("Creating user with details {}", user1);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
