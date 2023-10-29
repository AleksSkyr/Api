package com.example.Hw.Repositoriy;

import com.example.Hw.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAge(int age);

    Collection<Student> findAllByAgeBetween(int min, int max);

    Collection<Student> findAllByFaculty_Id(long facultyId);
}