package com.example.elearningsystem.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @OneToMany(mappedBy = "lession" )
    private Collection<Word> words;
}
