package com.example.Hw.service;

import com.example.Hw.model.Faculty;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FacultyServiceTest {


    FacultyService service = new FacultyService(repository);

    private Long id;

    @Test
    void testAdd() {
        var result = service.add(new Faculty(null, "test", "test_color"));
        assertEquals(result.getId(), 0);
        assertEquals(result.getName(), "test");
        assertEquals(result.getColor(), "test_color");
    }

    @Test
    void testGet() {
        var faculty = service.add(new Faculty(null, "test", "test_color"));
        var result = service.get(faculty.getId());

        assertEquals(result.getName(), "test");
        assertEquals(result.getColor(), "test_color");
    }

    @Test
    void testUpdate() {
        var result1 = service.update(new Faculty(779L, "updated", "updated_color"));
        assertNull(result1);

        var addedFaculty = service.add(new Faculty(null, "test", "test_color"));
        addedFaculty.setName("updated_name");
        addedFaculty.setColor("updated_color");

        var result2 = service.update(addedFaculty);
        assertEquals(result2.getName(), "updated_name");
        assertEquals(result2.getColor(), "updated_color");
    }

    @Test
    void testFilterByAge() {
        var added1 = service.add(new Faculty(null, "Pust", "white"));
        var added2 = service.add(new Faculty(null, "Pufik", "green"));
        var added3 = service.add(new Faculty(null, "Java", "Black"));

        var result = service.filterByColor("GREEN");
        Assertions.assertThat(result).containsExactly(added2, added3);
    }

    @Test
    void testRemove() {
        var faculty = service.add(new Faculty(null, "test1", "white"));
        assertNotNull(service.get(faculty.getId()));
        assertTrue(service.remove(faculty.getId()));
        assertFalse(service.remove(9999L));

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
