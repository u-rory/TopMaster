package net.rory.springserverapp.service;

import net.rory.springserverapp.dao.SpecUserDao;
import net.rory.springserverapp.model.SpecUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpecUserServiceImpl implements SpecUserService {

    @Autowired
    SpecUserDao specUserDao;

    @Override
    public SpecUser getSpecUserById(Long id) {
        return specUserDao.findOne(id);
    }
}
