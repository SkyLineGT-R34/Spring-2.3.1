package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoImp;
import web.model.User;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserDaoImp userDaoImp;

    public UserServiceImp(UserDaoImp userDaoImp) { this.userDaoImp = userDaoImp; }

    //CRUD
    @Override
    public void create(User user) {
        userDaoImp.create(user);
    }

    @Override
    public User read(long id){
        return userDaoImp.read(id);
    }

    @Override
    public void update(long id, User user) {
        userDaoImp.update(id, user);
    }

    @Override
    public void delete(long id) {
        userDaoImp.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDaoImp.readAll();
    }
}