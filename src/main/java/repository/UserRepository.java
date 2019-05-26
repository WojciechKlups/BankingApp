package repository;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;


@Slf4j
public class UserRepository {

    public void create(User user){

        try(Session session = HibernateUtil.openSession()){
            session.getTransaction().begin();
            session.persist(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

}
