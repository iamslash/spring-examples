package com.iamslash.exvault.secret;

public class Secret {

    private String username;
    private String password;

    public Secret() {

    }

    public Secret(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Credential [username=" + username + ", password=" + password + "]";
    }

}

