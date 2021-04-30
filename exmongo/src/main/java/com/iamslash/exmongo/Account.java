package com.iamslash.exmongo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Account {
    String email;
    String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
