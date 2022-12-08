package com.example.elearningsystem.repository;

import com.example.elearningsystem.model.Category;
import com.example.elearningsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
