package com.example.Hw.service;

import com.example.Hw.model.Faculty;
import com.example.Hw.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository repository;

    public FacultyService(FacultyRepository repository) {
        this.repository = repository;
    }

    public Faculty add(Faculty faculty) {
        Faculty seved = repository.save(faculty);
        return seved;
    }

    public Faculty get(long id) {
        return repository.findById(id).orElse(null);
    }

    public void remove(long id) {
        var entity = repository.findById(id).orElse(null);
        if (entity != null) {
            repository.delete(entity);
        }
        return entity;
    }


        public Faculty update (Faculty faculty){
            return repository.findById(faculty.getId())
                    .map(entity = > repository.save(faculty))
            .orElse(null);

        }


        public Collection<Faculty> filterByColor (String color){
            return repository.findAllByColor(color);
        }
    }


