package com.baseline.app.service;

import com.baseline.app.dto.OrganizationDto;
import com.baseline.app.entity.Organization;
import com.baseline.app.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<OrganizationDto> findAll() {
        return organizationRepository.findAll().stream().map(this::toDto).toList();
    }

    public OrganizationDto findById(Long id) {
        Organization org = organizationRepository.findById(id).orElseThrow();
        return toDto(org);
    }

    public OrganizationDto create(OrganizationDto dto) {
        Organization org = new Organization();
        org.setName(dto.name());
        org.setSubdomain(dto.subdomain());
        org.setSettings(dto.settings());
        return toDto(organizationRepository.save(org));
    }

    public OrganizationDto update(Long id, OrganizationDto dto) {
        Organization org = organizationRepository.findById(id).orElseThrow();
        org.setName(dto.name());
        org.setSubdomain(dto.subdomain());
        org.setSettings(dto.settings());
        return toDto(organizationRepository.save(org));
    }

    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }

    private OrganizationDto toDto(Organization org) {
        return new OrganizationDto(org.getId(), org.getName(), org.getSubdomain(), org.getSettings());
    }
}
