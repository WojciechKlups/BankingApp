package repository;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;


@Slf4j
public class UserRepository extends GenericRepository<User, Long>{

}
