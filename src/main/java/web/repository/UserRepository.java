package web.repository;

import web.model.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User u);
    void deleteById(long id);
    List<User> listUsers();
    User getUser(long id);
    void updateUser(User user);
}
