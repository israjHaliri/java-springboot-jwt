package com.haliri.israj.domain;

import java.util.Set;

/**
 * Created by israjhaliri on 8/25/17.
 */
public class Role {

    private Long id;
    private String role;
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
