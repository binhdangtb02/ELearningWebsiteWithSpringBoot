package com.example.elearningsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Role")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleid", nullable = false)
    private int roleid;
    @Column(name = "roleName", length = 20, nullable = false)
    private String roleName;
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Collection<User> users;
}
