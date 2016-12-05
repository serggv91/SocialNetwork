package ru.sbrf.authentification;

public class AuthentificationInfo {
    private String name;
    private String password;

    public AuthentificationInfo(String name, String password){
        this.name = name;
        this. password = password;
    }

    public String getName() {return name;};
    public String getPassword() {return password;};

}
