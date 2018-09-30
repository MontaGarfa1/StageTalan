package com.stageMonta.TalanTunisie.model;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Scope("session")
    public class AppUser implements Serializable ,UserDetails{
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue
        private Long id;
        @Column(unique = true)
        private String username;
        private String password;

        @ManyToMany(fetch = FetchType.EAGER)
        private Collection<AppRole> roles = new ArrayList<>();

        public AppUser() {
            super();

        }



        public AppUser(String username, String password, Collection<AppRole> roles) {
            super();
            this.username = username;
            this.password = password;
            this.roles = roles;
        }



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
            this.username = username;
        }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Collection<AppRole> getRoles() {
            return roles;
        }

        public void setRoles(Collection<AppRole> roles) {
            this.roles = roles;
        }


    }