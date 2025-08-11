package com.baseline.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "organizations")
public class Organization extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String subdomain;

    @Column(columnDefinition = "TEXT")
    private String settings;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSubdomain() { return subdomain; }
    public void setSubdomain(String subdomain) { this.subdomain = subdomain; }
    public String getSettings() { return settings; }
    public void setSettings(String settings) { this.settings = settings; }
}
