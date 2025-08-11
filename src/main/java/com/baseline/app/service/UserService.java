package com.baseline.app.service;

import com.baseline.app.dto.PageResponse;
import com.baseline.app.dto.UserDto;
import com.baseline.app.entity.Organization;
import com.baseline.app.entity.User;
import com.baseline.app.repository.OrganizationRepository;
import com.baseline.app.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, OrganizationRepository organizationRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public PageResponse<UserDto> findAll(int page, int size) {
        Page<User> p = userRepository.findAll(PageRequest.of(page, size));
        return new PageResponse<>(p.map(this::toDto).getContent(), page, size, p.getTotalElements());
    }

    public UserDto findById(Long id) {
        return toDto(userRepository.findById(id).orElseThrow());
    }

    public UserDto create(UserDto dto, String rawPassword) {
        User user = new User();
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEmail(dto.email());
        user.setRole(User.Role.valueOf(dto.role()));
        user.setStatus(User.Status.valueOf(dto.status()));
        user.setPassword(passwordEncoder.encode(rawPassword));
        Organization org = organizationRepository.findById(dto.organizationId()).orElseThrow();
        user.setOrganization(org);
        return toDto(userRepository.save(user));
    }

    public UserDto update(Long id, UserDto dto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setRole(User.Role.valueOf(dto.role()));
        user.setStatus(User.Status.valueOf(dto.status()));
        if (dto.organizationId() != null) {
            Organization org = organizationRepository.findById(dto.organizationId()).orElseThrow();
            user.setOrganization(org);
        }
        return toDto(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRole().name(),
                user.getStatus().name(),
                user.getOrganization().getId()
        );
    }
}
