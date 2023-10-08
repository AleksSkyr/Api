package com.example.Hw.controller;

import com.example.Hw.Faculty;
import com.example.Hw.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @PostMapping
    public Faculty add(@RequestBody Faculty faculty) {
        return service.add(faculty);
    }

    @GetMapping("/{id}")
    public Faculty get(@PathVariable long id) {
        return service.get(id);
    }

    @PutMapping
    public Faculty update(@RequestBody Faculty faculty) {
        return service.update(faculty);
    }

    @DeleteMapping("/{id}")
    public boolean remove(@PathVariable long id) {
        return service.remove(id);
    }

    @GetMapping("/byColor")
    public Collection<Faculty> byColor(@RequestParam String color){
        return service.filterByColor(color);
    }
}