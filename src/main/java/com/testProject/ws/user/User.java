package com.testProject.ws.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import com.testProject.ws.shared.View;
import org.hibernate.engine.jdbc.Size;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity// @Table ile databasedeki tablo adını istediğimiz şekilde belirleyebiliriz
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private long Id;

    @NotNull
    //@JsonView(View.Base.class)
    @Column(unique = true)
    private String username;


    private String password;

    @NotNull
    //@JsonView(View.Base.class)
    private String accountType;

    public User(String username, String password, String accountType) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public User() {

    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
