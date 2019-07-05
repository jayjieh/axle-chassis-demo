package com.axle.chassisdemo.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "user", uniqueConstraints = @UniqueConstraint(name = "uc_username", columnNames = {"username"}))
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class UsersDO extends BaseDO {

    @Column(nullable = false)
    @NotNull(message = "Username can not be null!")
    protected String username;
    @Column(nullable = false)
    @NotNull(message = "Password can not be null!")
    @JsonIgnore
    protected String password;

    public UsersDO(String userName) {
        this.username = userName;
    }

    public UsersDO() {
    }

}
