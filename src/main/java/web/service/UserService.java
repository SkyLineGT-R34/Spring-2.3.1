package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    void create(User user);
    User read(long  id);
    void update(long  id, User user);
    void delete(long  id);
    List<User> readAll();
}
