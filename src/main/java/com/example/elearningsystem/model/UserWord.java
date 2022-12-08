package com.example.elearningsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User_Word")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    @ManyToOne
    @JoinColumn(name = "wordid")
    private Word word;
    @Column(name = "status")
    private boolean status;
}
