package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Transactional
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public List<User> listUsers() {
        return userRepository.listUsers();
    }

    @Override
    public User getUser(long id) {
        return userRepository.getUser(id);
    }
    @Override
    public void updateUser(User user) {userRepository.updateUser(user);}
}