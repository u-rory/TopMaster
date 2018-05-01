package net.rory.springserverapp.service;


import net.rory.springserverapp.dao.SpecDao;
import net.rory.springserverapp.model.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecServiceImpl implements SpecService {

    @Autowired
    SpecDao specDao;

    @Override
    public Spec loadSpecByName(String specName) {
        return specDao.findSpecByName(specName);
    }
}
