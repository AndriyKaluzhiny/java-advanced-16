package ua.lviv.lgs.javaadvanced16.App;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.lviv.lgs.javaadvanced16.Service.StudentService;
import ua.lviv.lgs.javaadvanced16.Service.impl.StudentServiceImpl;
import ua.lviv.lgs.javaadvanced16.domain.Student;

import java.util.Scanner;

@SpringBootApplication
public class Application {

	public static void menu() {
		System.out.println("Enter 1 to create a student");
		System.out.println("Enter 2 to read all students");
		System.out.println("Enter 3 to update a student");
		System.out.println("Enter 4 to delete a student");
		System.out.println("Enter 0 to exit	");
	}


	public static void main(String[] args) {

		StudentService studentService = new StudentServiceImpl();

		while (true) {
			menu();

			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();

			switch (input) {
				case 1: {
					System.out.println("Enter student name: ");
					Scanner scName = new Scanner(System.in);
					String name = scName.next();

					System.out.println("Enter student age: ");
					Scanner scAge = new Scanner(System.in);
					int age = scAge.nextInt();

					Student student = new Student();
					student.setId(studentService.idSetter());
					student.setAge(age);
					student.setName(name);

					studentService.create(student);
					break;
				}

				case 2: {
					System.out.println(studentService.readAll());
					break;
				}

				case 3: {
					System.out.println("Enter student id to update: ");
					Scanner scId = new Scanner(System.in);
					int id = scId.nextInt();

					System.out.println("Enter student updated name: ");
					Scanner scName = new Scanner(System.in);
					String updatedName = scName.next();

					System.out.println("Enter student updated age: ");
					Scanner scAge = new Scanner(System.in);
					int updatedAge = scAge.nextInt();

					Student student = new Student();
					student.setAge(updatedAge);
					student.setName(updatedName);

					studentService.update(student, id);
					break;
				}

				case 4: {
					System.out.println("Enter student id to delete: ");
					Scanner scId = new Scanner(System.in);
					int id = scId.nextInt();

					studentService.delete(id);
					break;
				}

				case 0: {
					System.exit(1);
				}
			}
		}
	}

}
