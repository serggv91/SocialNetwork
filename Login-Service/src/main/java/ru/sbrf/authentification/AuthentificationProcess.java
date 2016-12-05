package ru.sbrf.authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.dao.springdao.AccountSpringJDBCImpl;

import java.util.Optional;

@Component
public class AuthentificationProcess {
    private final AccountSpringJDBCImpl userDao;

    @Autowired
    public AuthentificationProcess(AccountSpringJDBCImpl userDao) {
        this.userDao = userDao;
    }

    public Optional<Long> signUp(AuthentificationInfo authentificationInfo) {
        try {
            if (!userDao.getIdbyName(authentificationInfo.getName()).isEmpty())
                return Optional.empty();
            else
                return Optional.of(userDao.add(authentificationInfo));
        } catch (Exception e) {
            return Optional.empty();
        }
    }


    public Optional<Long> signIn(AuthentificationInfo authentificationInfo) {
        try {
            Long userID = userDao.getID(authentificationInfo);
            return Optional.of(userID);
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
