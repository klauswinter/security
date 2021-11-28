package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser(Long id, User user);

    User getUserById(Long id);

    User getUserByUsername(String username);

    void removeUserById(Long id);

    List<User> getAllUsers();
}
