package com.jap.oops;

import java.util.HashSet;
import java.util.Scanner;

public class StudentManagementSystem {

	private static int listAndValidateStudentChoice(Scanner sc, Student[] students) {
		listStudents(students);
		System.out.print("Enter Student number: ");
		int studentChoice = sc.nextInt();
		if((studentChoice > students.length) || (studentChoice <= 0)) {
			System.out.println("Invalid Choice");
			return -1;
		}
		return studentChoice - 1;
	}

	private static int listAndValidateCourseChoice(Scanner sc, Course[] courses) {
		listCourses(courses);
		System.out.print("Enter Student number: ");
		int courseChoice = sc.nextInt();
		if((courseChoice > courses.length) || (courseChoice <= 0)) {
			System.out.println("Invalid Choice");
			return -1;
		}
		return courseChoice - 1;
	}
	private static void listStudents(Student[] students) {
		System.out.println("Available Students:");
		int index = 1;
		for(Student student: students) {
			System.out.println(index + ". " + student.getStudentName() + " " + student.getStudentId());
			index++;
		}
	}

	private static void listCourses(Course[] courses) {
		System.out.println("Available courses:");
		int index = 1;
		for(Course course: courses) {
			System.out.println(index + ". " + course.getCourseName());
			index++;
		}
	}
	static void displayMenu(Scanner scanner, Student[] students, Course[] courses) {
		boolean available = true;
		System.out.println("Student Management System Menu:");
		System.out.println("1. Enroll in a Course");
		System.out.println("2. View Enrollment Details");
		System.out.println("3. View Enrolled Students in a Course");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		switch (choice) {
			case 1: {
				int studentChoice = listAndValidateStudentChoice(scanner, students);
				if (studentChoice == -1) {
					break;
				}
				int courseChoice = listAndValidateCourseChoice(scanner, courses);
				if (courseChoice == -1) {
					break;
				}
				if (enrollStudentInCourse(students[studentChoice], courses[courseChoice])) {
					System.out.println(students[studentChoice].getStudentName() + " has been enrolled in " + courses[courseChoice].getCourseName());
				} else {
					System.out.println(students[studentChoice].getStudentName() + " has already been enrolled in " + courses[courseChoice].getCourseName());
				}
				break;
			}

			case 2:
			{
				System.out.println("View Enrollment Details:");
				int studentChoice = listAndValidateStudentChoice(scanner, students);
				if(studentChoice == -1) {
					break;
				}
				String details = viewStudentEnrollmentDetails(students[studentChoice], students);
				System.out.println(details);
				break;
			}
			case 3:
			{
				System.out.println("Select a course to view enrolled students: ");
				int courseChoice = listAndValidateCourseChoice(scanner, courses);
				if(courseChoice == -1) {
					break;
				}
				String details = viewEnrolledStudentsInCourse(courses[courseChoice], courses);
				System.out.println(details);
				break;
			}
			case 4:{
				available=false;
				break;
			}
			default:
				System.out.println("Invalid choice.");
				break;
		}

	}

	private static Student getStudent(Scanner scanner, Student[] students) {
		System.out.print("Enter the student ID: ");
		int studentId = scanner.nextInt();
		scanner.nextLine(); // Consume newline character
		for (Student student : students) {
			if (student != null && student.getStudentId() == studentId) {
				return student;
			}
		}
		System.out.println("Student not found.");
		return null;
	}

	private static Course getCourse(Scanner scanner, Course[] courses) {
		System.out.print("Enter the course ID: ");
		int courseId = scanner.nextInt();
		scanner.nextLine(); // Consume newline character
		for (Course course : courses) {
			if (course != null && course.getCourseID() == courseId) {
				return course;
			}
		}
		System.out.println("Course not found.");
		return null;
	}

	public static boolean enrollStudentInCourse(Student selectedStudent, Course selectedCourse) {
		String expected = selectedStudent.getStudentName() + " has been added to the course: " + selectedCourse.courseName;
		String received = selectedCourse.addStudent(selectedStudent);
		return expected.equals(received);
	}

	public static String viewStudentEnrollmentDetails(Student selectedStudent, Student[] students) {
		StringBuilder returnString = new StringBuilder("\nView Enrollment Details:\n");
		returnString.append("Enrollment Details for ").append(selectedStudent.getStudentName()).append(":\n");
		HashSet<Course> courses = selectedStudent.getEnrolledCourses();
		for(Course course: courses) {
			returnString.append(course.getCourseDetails()).append("\n");
			returnString.append("-----------------------\n");
		}
		return returnString.toString();
	}

	public static String viewEnrolledStudentsInCourse(Course selectedCourse, Course[] courses) {
		return selectedCourse.viewEnrolledStudents();
	}
}