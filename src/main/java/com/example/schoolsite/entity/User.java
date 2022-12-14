package com.example.schoolsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_login")
})
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long id;
    @Column(name = "user_login", nullable = false)
    private String login;
    @Column(name = "user_password", nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @Column(name = "user_status", nullable = false)
    private String status;
    @Column(name = "user_link", nullable = true)
    private String link;

    public User(String login, String password, String status) {
        super();
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public User(String login, String password, String status, String link) {
        this.login = login;
        this.password = password;
        this.status = status;
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(roles, user.roles) && Objects.equals(status, user.status) && Objects.equals(link, user.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, roles, status, link);
    }
}
