package com.example.Hw.controller;

import com.example.Hw.model.Student;
import com.example.Hw.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return service.add(student);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable long id) {
        return service.get(id);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }

    // localhost:8080/student/2
    @DeleteMapping("/{id}")
    public Student remove(@PathVariable long id) {
        return service.remove(id);
    }

    // localhost:8080/student/byAge?age=20
    @GetMapping("/byAge")
    public Collection<Student> byAge(@RequestParam int age) {
        return service.filterByAge(age);
    }
    @GetMapping("/byAll")
    public Collection<Student> byAll () {
        return service.returnAll();
    }
}
