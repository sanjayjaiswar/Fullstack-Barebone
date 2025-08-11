package com.baseline.app.dto;

public record UserDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String role,
        String status,
        Long organizationId
) {}
