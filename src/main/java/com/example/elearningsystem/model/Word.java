package com.example.elearningsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "Word")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "term", nullable = false)
    private String term;
    @Column(name = "definition", nullable = false)
    private String definition;

    @ManyToOne
    @JoinColumn(name = "lessionid")
    private Lession lession;

    @OneToMany(mappedBy = "word")
    private Collection<UserWord> userWords;



}
