package ua.lviv.lgs.javaadvanced16.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.lviv.lgs.javaadvanced16.domain.Student;

@Configuration
public class SpringConfig {
    @Bean(name="student")
    public Student getStudent() {
        return new Student();
    }
}
