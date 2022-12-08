package com.example.elearningsystem.repository;

import com.example.elearningsystem.model.Lession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessionRepository extends JpaRepository<Lession, Long> {
}
