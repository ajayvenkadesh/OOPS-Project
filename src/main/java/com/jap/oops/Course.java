package com.jap.oops;

import java.util.LinkedHashSet;

public abstract class Course {
	int courseID;
	String courseName;
	private final int enrolledStudentsCount = 10;
	private LinkedHashSet<Student> enrolledStudents = new LinkedHashSet<Student>();

	//declare the attributes courseID,courseName,enrolledStudents,enrolledStudentsCount

	// Constructor that accepts only courseId and courseName
	public Course(int courseId, String courseName){

		this.courseID=courseId;
		this.courseName=courseName;


	}

	public int getEnrolledStudentsCount() {
		return enrolledStudentsCount;
	}

	public LinkedHashSet<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(LinkedHashSet<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	// Assuming a maximum of 10 enrolled students initially

	// Getter and Setter Methods

	// Method to add a student to the course
	public String addStudent(Student student) {

		if(this.enrolledStudents.size() >= enrolledStudentsCount) {
			return "Maximum students enrolled. Cannot add more students.";
		}

		if(isEnrolled(student)) {
			return student.getStudentName() + " has already been added to the course: " + courseName;
		}
		this.enrolledStudents.add(student);
		student.enrollInCourse(this);

		return student.getStudentName() + " has been added to the course: " + courseName;
	}

	public boolean isEnrolled(Student student) {
		return enrolledStudents.contains(student);
	}

	// Method to view enrolled students in the course
	public String viewEnrolledStudents() {
		StringBuilder returnString = new StringBuilder();
		returnString.append("Students Enrolled in the course ").append(courseName).append(":\n");
		int index = 1;
		for(Student student: enrolledStudents) {
			returnString.append(index).append(".").append(student.getStudentName()).append("\n");
			index++;
		}
		return returnString.toString();
	}


	// Abstract method to get specific course details (to be implemented by derived classes)
	public abstract String getCourseDetails();
}
