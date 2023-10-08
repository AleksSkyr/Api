package com.example.Hw.service;

import com.example.Hw.Faculty;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final Map<Long, Faculty> storage = new HashMap<>();
    private long counter = 0;

    public Faculty add(Faculty faculty) {
        faculty.setId(counter);
        storage.put(counter, faculty);
        counter++;
        return faculty;
    }

    public Faculty get(long id) {
        return storage.get(id);
    }

    public boolean remove(long id) {
        return storage.remove(id) != null;
    }

    public Faculty update(Faculty faculty) {
        if (storage.containsKey(faculty.getId())) {
            storage.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Collection<Faculty> filterByColor(String color) {
        return storage.values()
                .stream()
                .filter(f -> f.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}