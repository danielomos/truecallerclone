package africa.semicolon.callerapp.data.repositories;

import africa.semicolon.callerapp.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private int counter;
    List<User> users = new ArrayList<User>();
    @Override
    public User addUser(User user) {
        if (user.getId() == 0) {
                ++counter;
                user.setId(counter);
                users.add(user);
            }
            else {
                User olduser = findById(user.getId());
                user.setId(olduser.getId());
                users.remove(olduser);
                users.add(user);

            }
            return user;
        }




//    public void setContacts( Users) {
//        this.users = users;
//    }

    @Override
    public void delete(User user)  {

        users.remove(user);

    }


    @Override
    public void delete(int id) {
        User finduser = findById(id);
        users.remove(finduser);

   }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findByUsername(String username) {
        ArrayList<User> users = new ArrayList<User>();
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
               users.add(user);

            }
        }

        return users;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }

        }
        return  null;
    }


    @Override
    public List<User> findAll() {
        return users;
    }
    public int count(){
        return users.size();
    }
}
