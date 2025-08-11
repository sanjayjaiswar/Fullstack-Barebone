package com.baseline.app.config;

import com.baseline.app.entity.Organization;
import com.baseline.app.entity.User;
import com.baseline.app.repository.OrganizationRepository;
import com.baseline.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, OrganizationRepository organizationRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        userRepository.findByEmail("admin@local").orElseGet(() -> {
            Organization org = new Organization();
            org.setName("Default Org");
            org.setSubdomain("default");
            organizationRepository.save(org);

            User user = new User();
            user.setFirstName("Admin");
            user.setLastName("User");
            user.setEmail("admin@local");
            user.setPassword(passwordEncoder.encode("Admin#123"));
            user.setRole(User.Role.ADMIN);
            user.setStatus(User.Status.ACTIVE);
            user.setOrganization(org);
            return userRepository.save(user);
        });
    }
}
