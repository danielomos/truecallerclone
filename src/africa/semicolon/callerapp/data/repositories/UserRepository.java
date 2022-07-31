package africa.semicolon.callerapp.data.repositories;

import africa.semicolon.callerapp.data.models.User;

import java.util.List;

public interface UserRepository {
    User addUser(User user);
    void delete(User user);
    void delete(int id);
    User findById(int id);
    List<User> findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
    public int count();
}
