package com.example.elearningsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "Category")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;

    @ManyToMany(mappedBy = "categories" ,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JsonBackReference
    private Collection<User> users;

    @OneToMany(mappedBy = "category" ,   cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })

    private Collection<Lession> lessions;
}
