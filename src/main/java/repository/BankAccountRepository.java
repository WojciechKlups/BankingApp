package repository;

import lombok.extern.slf4j.Slf4j;
import model.BankAccount;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

@Slf4j
public class BankAccountRepository {

    public void create(BankAccount bankAccount) {

        try (Session session = HibernateUtil.openSession()) {
            session.getTransaction().begin();
            session.persist(bankAccount);
            session.getTransaction().commit();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
