package com.example.elearningsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "Lession")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "categoryid"
    )
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "lession",   cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    } )
    private Collection<Word> words;
}
