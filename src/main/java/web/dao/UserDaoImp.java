package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import web.model.User;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(User user){
        entityManager.persist(user);
    }
    @Override
    public User read(long id){
        return entityManager.find(User.class, id);
    }
    @Override
    public void update(long id, User updatedUser) {
        entityManager.merge(updatedUser);
    }
    @Override
    public void delete(long id) {
        entityManager.remove(read(id));
    }
    @Override
    public List<User> readAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
