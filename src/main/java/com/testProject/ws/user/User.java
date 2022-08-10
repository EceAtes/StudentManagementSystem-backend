package com.testProject.ws.user;

import com.sun.istack.NotNull;
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
    //@Size(min = 8, max = 255)
    @Column(unique = true)
    @UniqueUsername
    private String username;
    @NotNull
    /*@Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")*///Size'ı ve patter'i bulamıyor?
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

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
                '}';
    }
}
