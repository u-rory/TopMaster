package net.rory.springserverapp.service;


import net.rory.springserverapp.model.SpecUser;

import java.util.List;

public interface SpecUserService {
    SpecUser getSpecUserById(Long id);

    void saveSpecUser(SpecUser specUser);
}
