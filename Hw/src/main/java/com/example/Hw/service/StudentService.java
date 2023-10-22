package com.example.Hw.service;

import com.example.Hw.Repositoriy.StudentRepository;
import com.example.Hw.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student add(Student student) {
        return repository.save(student);
    }

    public Student get(long id) {
        return repository.findById(id).orElse(null);
    }

    public Student remove(long id) {
        var studentTemporary = repository.findById(id).orElse(null);
        if (studentTemporary != null) {
            repository.delete(studentTemporary);
        }
        return studentTemporary;
    }

    public Student update(Student student) {
        var studentTemporary = repository.findById(student.getId()).orElse(null);
        if (studentTemporary != null) {
            repository.save(student);;
        }
        return student;
    }

    public Collection<Student> filterByAge(int age) {
        return  repository.findAllByAge(age);
    }

    public Collection<Student> returnAll() {
        return repository.findAllBy();
    }


}