package ua.lviv.lgs.javaadvanced16.Service;

import ua.lviv.lgs.javaadvanced16.domain.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);
    String readAll();
    void update(Student student, Integer id);
    void delete(Integer id);

    Integer idSetter();
}
