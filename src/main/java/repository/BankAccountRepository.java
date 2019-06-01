package repository;

import lombok.extern.slf4j.Slf4j;
import model.BankAccount;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

@Slf4j
public class BankAccountRepository extends GenericRepository<BankAccount, Long>{

}
