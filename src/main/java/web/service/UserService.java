package web.service;

import java.util.List;

import web.model.User;

public interface UserService {
    void saveUser(User u);
    void deleteById(long id);
    List<User> listUsers();
    User getUser(long id);
    void updateUser(User user);

}
