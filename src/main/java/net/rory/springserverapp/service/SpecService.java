package net.rory.springserverapp.service;


import net.rory.springserverapp.model.Spec;

public interface SpecService {
    Spec loadSpecByName(String specName);
}
