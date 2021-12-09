package edu.neiu.hw06.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(unique = true, nullable = false)
    private String schoolEmail;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String password;



    private String firstName;
    private String lastName;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNotExpired;

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<Role> roles;


    public enum Role { ROLE_ADMIN, ROLE_USER }

    public User() {
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNotExpired = true;
    }

    public User(String schoolEmail, String username, String password) {
        this.schoolEmail = schoolEmail;
        this.username = username;
        this.password = password;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNotExpired = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role: roles) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.toString());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNotExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
