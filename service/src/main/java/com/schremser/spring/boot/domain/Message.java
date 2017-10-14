package com.schremser.spring.boot.domain;

public class Message {
    String author;
    String content;

    public Message() {}

    public Message(String author, String contents) {
        this.author = author;
        this.content = contents;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
