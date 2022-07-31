package africa.semicolon.callerapp.data.repositories;

import africa.semicolon.callerapp.data.models.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryImplTest {
    @Test
    void addUser() {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setUsername("dummy");
        user.setEmail("dummy@gmail.com");
        user.setPassword("password");
        userRepository.addUser(user);
        assertEquals(1, userRepository.count());

    }
    @Test
    public void getUser() {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setUsername("dummy");
        user.setEmail("dummy@gmail.com");
        user.setPassword("password");
        userRepository.addUser(user);

        User user1 = new User();
        user1.setUsername("dummy");
        user1.setEmail("dummy@gmail.com");
        user1.setPassword("password");
        userRepository.addUser(user1);

        assertEquals(2, userRepository.count());
        User savedUser = userRepository.findById(2);
        assertEquals("dummy", savedUser.getUsername());
    }
    @Test
    public void deleteuser() {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setUsername("dummy");
        user.setEmail("dummy@gmail.com");
        user.setPassword("password");
        userRepository.addUser(user);

        User user1 = new User();
        user1.setUsername("dummy");
        user1.setEmail("dummy@gmail.com");
        user1.setPassword("password");
        userRepository.addUser(user1);


        assertEquals(2, userRepository.count());
        userRepository.delete(2);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void updateUser() {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setUsername("dummy");
        user.setEmail("dummy@gmail.com");
        user.setPassword("password");
        userRepository.addUser(user);

        User user1 = new User();
        user1.setUsername("dummy");
        user1.setEmail("dummy@gmail.com");
        user1.setPassword("password");
        userRepository.addUser(user1);


        user.setUsername("dummy");
        user.setEmail("dummy3@gmail.com");

        userRepository.addUser(user);
        assertEquals(2, userRepository.count());
        assertEquals("dummy", userRepository.findById(1).getUsername());
    }


}

