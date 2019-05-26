package listener;


import lombok.extern.slf4j.Slf4j;
import model.User;
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

        repository.create(user);

        log.info("Creating user with details {}", user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
