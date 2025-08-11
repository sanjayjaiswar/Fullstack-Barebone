package com.baseline.app.controller;

import com.baseline.app.dto.OrganizationDto;
import com.baseline.app.service.OrganizationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public List<OrganizationDto> all() {
        return organizationService.findAll();
    }

    @GetMapping("/{id}")
    public OrganizationDto get(@PathVariable Long id) {
        return organizationService.findById(id);
    }

    @PostMapping
    public OrganizationDto create(@RequestBody OrganizationDto dto) {
        return organizationService.create(dto);
    }

    @PutMapping("/{id}")
    public OrganizationDto update(@PathVariable Long id, @RequestBody OrganizationDto dto) {
        return organizationService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        organizationService.delete(id);
    }
}