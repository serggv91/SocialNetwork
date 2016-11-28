package model.accounts;

import model.messages.Message;
import model.photos.Photo;

import java.time.LocalDate;
import java.util.List;

/**
 * The class represents a user of the social network.
 */

public class User {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String city;
    private String email;
    private List<User> friends;
    private List<Photo> photos;
    private List<Message> messages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
