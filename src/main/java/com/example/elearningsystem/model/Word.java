package com.example.elearningsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Entity
@Table(name = "Word")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@ToString
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "term", nullable = false)
    private String term;
    @Column(name = "definition", nullable = false)
    private String definition;

    @ManyToOne
    @JoinColumn(name = "lessionid")
    @JsonBackReference
    private Lession lession;

    @OneToMany(mappedBy = "word")
    @JsonBackReference
    private Collection<UserWord> userWords;



}
