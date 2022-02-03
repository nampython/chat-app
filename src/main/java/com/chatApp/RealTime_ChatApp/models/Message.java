package com.chatApp.RealTime_ChatApp.models;

public class Message {
    private String sender;
    private String content;
    private String timestamp;
    public Message() {
    }
    public Message(String sender, String content){
        this.sender = sender;
        this.content = content;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + this.sender + '\'' +
                ", content='" + this.content + '\'' +
                ", timestamp='" + this.timestamp + '\'' +
                '}';
    }
}
