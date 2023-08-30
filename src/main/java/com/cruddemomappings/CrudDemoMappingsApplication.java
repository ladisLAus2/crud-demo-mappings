package com.cruddemomappings;

import com.cruddemomappings.entity.Course;
import com.cruddemomappings.entity.Instructor;
import com.cruddemomappings.entity.InstructorDetail;
import com.cruddemomappings.entity.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoMappingsApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("vlad", "sema", "email.com");

		InstructorDetail instructorDetail = new InstructorDetail("my_channel","anime");

		Course course = new Course("anime course");
		Course course2 = new Course("anime 2");
		Course course3 = new Course("anime course 3");
		instructor.setInstructorDetail(instructorDetail);
		instructor.add(course);
		instructor.add(course2);
		instructor.add(course3);
		appDAO.save(instructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(3);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		System.out.println(appDAO.findInstructorDetailById(2));
		System.out.println(appDAO.findInstructorDetailById(2).getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		appDAO.deleteInstructor(1);
	}

	private void findInstructor(AppDAO appDAO) {
		System.out.println(appDAO.findInstructorById(1));
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("vlad", "sema", "email.com");

		InstructorDetail instructorDetail = new InstructorDetail("my_channel","anime");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println(instructor);
		appDAO.save(instructor);
	}
}
