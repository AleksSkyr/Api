package com.example.Hw.Repositoriy;

import com.example.Hw.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Collection<Student> findAllByAge(int age);

    Collection<Student> findAllBy ();

}