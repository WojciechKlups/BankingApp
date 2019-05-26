package listener;


import lombok.extern.slf4j.Slf4j;
import model.BankAccount;
import model.Currency;
import model.User;
import repository.BankAccountRepository;
import repository.UserRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class ContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {

        final UserRepository repository = new UserRepository();
        User user = User.builder()
                .firstname("Wojciech")
                .lastname("Klupś")
                .build();
        User user1 = User.builder()
                .firstname("Andrzej")
                .lastname("Kowalski")
                .build();
        repository.create(user1);
        repository.create(user);

        log.info("Creating user with details {}", user);
        log.info("Creating user with details {}", user1);

        final BankAccountRepository repository1 = new BankAccountRepository();
            BankAccount bankAccount = BankAccount.builder()
                    .accountNumber("1927734712673812")
                    .balance(923748732L)
                    .freeFunds(12341243)
                    .currency(Currency.ZLOTY)
                    .owner(user)
                    .build();
            BankAccount bankAccount1 = BankAccount.builder()
                .accountNumber("34897923874923")
                .balance(34245L)
                .freeFunds(3456)
                .currency(Currency.ZLOTY)
                .owner(user1)
                .build();


            repository1.create(bankAccount);
            repository1.create(bankAccount1);

            log.info("Creating bank account with details {}", bankAccount);
            log.info("Creating bank account with details {}", bankAccount1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
