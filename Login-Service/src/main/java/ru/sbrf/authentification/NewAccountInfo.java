package ru.sbrf.authentification;

/**
 * Created by Sergei on 05.12.2016.
 */
public class NewAccountInfo {
    private final String name;
    private final String password;
    private final String id;

    public NewAccountInfo(AuthentificationInfo info, Long id){
        this.name = info.getName();
        this.password = info.getPassword();
        this.id = id.toString();
    }

    public String getId() {return id;};
    public String getName() {return name;};
    public String getPassword() {return password;};
}
