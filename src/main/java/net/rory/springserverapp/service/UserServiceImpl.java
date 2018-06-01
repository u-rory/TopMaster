package net.rory.springserverapp.service;


import net.rory.springserverapp.dao.AccessDao;
import net.rory.springserverapp.dao.UserDao;
import net.rory.springserverapp.model.Access;
import net.rory.springserverapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AccessDao accessDao;

    @Override
    public void saveUser(User user) {
        Access access = accessDao.findOne(Long.parseLong("1"));
        user.setAccess(access);
        userDao.saveAndFlush(user);
    }

    @Override
    public Long getUser(String surname, String name, String email) {
        return userDao.checkUser(surname, name, email);
    }

    @Override
    public User loadUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public User loadUserById(Long id) {
        return userDao.findOne(id);
    }
}
