package com.example.Hw.service;
import com.example.Hw.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Map<Long, Student> storage = new HashMap<>();
    private long counter = 0;

    public Student add(Student student) {
        student.setId(counter);
        storage.put(counter, student);
        counter++;
        return student;
    }

    public Student get(long id) {
        return storage.get(id);
    }

    public boolean remove(long id) {
        return storage.remove(id) != null;
    }

    public Student update(Student student) {
        if (storage.containsKey(student.getId())) {
            storage.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Collection<Student> filterByAge(int age) {
        return storage.values().stream()
                .filter(s -> s.getAge() == age)
                .collect(Collectors.toList());
    }
}