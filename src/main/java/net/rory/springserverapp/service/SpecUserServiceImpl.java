package net.rory.springserverapp.service;

import net.rory.springserverapp.dao.SpecDao;
import net.rory.springserverapp.dao.SpecUserDao;
import net.rory.springserverapp.dao.UserDao;
import net.rory.springserverapp.model.Spec;
import net.rory.springserverapp.model.SpecUser;
import net.rory.springserverapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecUserServiceImpl implements SpecUserService {

    @Autowired
    SpecUserDao specUserDao;

    @Autowired
    UserDao userDao;

    @Autowired
    SpecDao specDao;

    @Override
    @Transactional(readOnly = true)
    public SpecUser getSpecUserById(Long id) {
        return specUserDao.findOne(id);
    }

    @Override
    public void saveSpecUser(SpecUser specUser) {
        User user = userDao.findUserByEmail(specUser.getEmail());
        specUser.setIdUser(user.getIdUser());

        Spec spec = specDao.findSpecByName(specUser.getSpec().getNameSpec());
        specUser.setSpec(spec);
        specUserDao.saveAndFlush(specUser);
    }

    @Override
    public void changeSpecUserInfo(SpecUser specUser) {
        User user = userDao.findUserByEmail(specUser.getEmail());
        specUser.setIdUser(user.getIdUser());

        Spec spec = specDao.findSpecByName(specUser.getSpec().getNameSpec());
        specUser.setSpec(spec);
        specUserDao.save(specUser);
    }
}
