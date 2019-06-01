package repository;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

@Slf4j
public abstract class GenericRepository<T, K> {

    Class<T> type;

    public GenericRepository() {
        type = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void create(T t) {

        try (Session session = HibernateUtil.openSession()) {
            session.getTransaction().begin();
            session.save(t);
            session.getTransaction().commit();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public Optional<T> get(K key) {
        try (Session session = HibernateUtil.openSession()) {
            return Optional.ofNullable(session.find(type, key));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Optional.empty();
        }
    }
}
