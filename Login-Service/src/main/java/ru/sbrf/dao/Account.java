package ru.sbrf.dao;

import ru.sbrf.authentification.AuthentificationInfo;

import java.util.List;


public interface Account {
    Long getID(AuthentificationInfo authentificationInfo);
    Long add(AuthentificationInfo authentificationInfo);
    List<Long> getIdbyName(String name);
}
