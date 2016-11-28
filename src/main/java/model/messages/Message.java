package model.messages;

import model.accounts.User;

import java.time.LocalDateTime;


public class Message {
    private Long id;
    private User sender;
    private User recipient;
    private String text;
    private LocalDateTime sendingDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSendingDateTime() {
        return sendingDateTime;
    }

    public void setSendingDateTime(LocalDateTime sendingDateTime) {
        this.sendingDateTime = sendingDateTime;
    }
}
