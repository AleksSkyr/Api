package com.example.Hw.repository;

import com.example.Hw.model.Faculty;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collation<Faculty> findAllByColor(String color);
}

