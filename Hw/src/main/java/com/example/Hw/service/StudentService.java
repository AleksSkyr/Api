package com.example.Hw.service;

import com.example.Hw.model.Faculty;
import com.example.Hw.model.Student;
import com.example.Hw.repository.FacultyRepository;
import com.example.Hw.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student add(Student fstudent) {
        return repository.save(student);
    }

    public Student get(long id) {
        return repository.findById(id).orElse(null);
    }

    public void remove(long id) {
        var entity = repository.findById(id).orElse(null);
        if (entity != null) {
            repository.delete(entity);
        }
        return entity;
    }


    public Student update(Student student) {
        return repository.findById(student.getId())
                .map(entity = > repository.save(student))
            .orElse(null);

    }

    public Collection<Student> filterByAge(int age) {
        return repository.findByAge(age);
    }
}