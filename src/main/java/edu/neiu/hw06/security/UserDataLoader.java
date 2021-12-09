package edu.neiu.hw06.security;

import edu.neiu.hw06.data.UserRepository;
import edu.neiu.hw06.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

public class UserDataLoader implements CommandLineRunner {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataLoader(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("lhjaved@neiu.edu","lhjaved", "Neiu0718");
    }
}
