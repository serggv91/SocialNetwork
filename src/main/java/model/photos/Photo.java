package model.photos;

import model.accounts.User;

import java.time.LocalDateTime;


public class Photo {
    private Long id;
    private String type;
    private Integer size;
    private String name;
    private int[] bytes;
    private User user;
    private LocalDateTime postDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getBytes() {
        return bytes;
    }

    public void setBytes(int[] bytes) {
        this.bytes = bytes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }
}
