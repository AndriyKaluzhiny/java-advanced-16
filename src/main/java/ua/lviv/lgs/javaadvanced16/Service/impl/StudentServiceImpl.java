package ua.lviv.lgs.javaadvanced16.Service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.lviv.lgs.javaadvanced16.Configurations.SpringConfig;
import ua.lviv.lgs.javaadvanced16.Service.StudentService;
import ua.lviv.lgs.javaadvanced16.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
    List<Student> students = new ArrayList<>();

    private     Integer id = 0;

    @Override
    public void create(Student student) {
        students.add(student);
    }

    @Override
    public String readAll() {
        return students.toString();
    }


    @Override
    public void update(Student student, Integer id) {
        Student studentToUpdate = students.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);

        if (student != null) {
            studentToUpdate.setName(student.getName());
            studentToUpdate.setAge(student.getAge());
        } else {
            System.err.println("Error happened :(");
        }
    }

    @Override
    public void delete(Integer id) {
        Student student = students.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);

        students.remove(student);
    }

    @Override
    public Integer idSetter() {
        return id++;
    }
}
