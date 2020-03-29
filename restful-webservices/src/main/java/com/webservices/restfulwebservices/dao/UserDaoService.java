package com.webservices.restfulwebservices.dao;

import com.webservices.restfulwebservices.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCounter = 3;

    static {
        users.add(new User(1, "Merlin", new Date()));
        users.add(new User(2, "Meliodas", new Date()));
        users.add(new User(3,"Hawk", new Date()));
    }

    public User findById(Integer id) {
        for (User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return users;
    }

    public User addUser(User user) {
        if(user.getId() == null) {
            user.setId(++userCounter);
        }
        users.add(user);
        return user;
    }

    public User deleteUserById(int id) {
        Iterator<User> iterator = users.iterator();
        User user;
        while (iterator.hasNext()) {
            user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
