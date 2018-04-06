package net.rory.springserverapp.service;


import net.rory.springserverapp.dao.UserDao;
import net.rory.springserverapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.saveAndFlush(user);
    }
}
