package com.example.elearningsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "username")
public class User{
    @Id
    @Column(name = "username", length = 50, nullable = false)
    private String username;
    @Column(name = "password", length = 200, nullable = false)
    private String password;
    @Column(name = "email", length = 200, nullable = false)
    private String email;
    @Column(name = "name", length = 50, nullable = false)
    private String  name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "User_Role",
            joinColumns = {@JoinColumn(name = "username")},
            inverseJoinColumns = {@JoinColumn(name = "roleid")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "roleid"})}
    )
    @JsonBackReference
    private Set<Role> roles = new HashSet<>();

    @ManyToMany()
    @JoinTable(
            name = "User_Category",
            joinColumns = {@JoinColumn(name = "username")},
            inverseJoinColumns = {@JoinColumn(name = "categoryid")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "categoryid"})}
    )

    private Collection<Category> categories;

    @OneToMany(mappedBy = "user")
    private Collection<UserWord> userWords;
}
