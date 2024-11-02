package com.jap.oops;

import java.util.LinkedHashSet;

public class Student {
	//declare the attributes enrolledCoursesCount,studentID,studentName,enrolledCourses
	private int studentId;
	private String studentName;
	private LinkedHashSet<Course> enrolledCourses;
	private final int enrolledCoursesCount=5;

	public LinkedHashSet<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(LinkedHashSet<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public int getEnrolledCoursesCount() {
		return enrolledCoursesCount;
	}

	public Student(){

	}
	// generate the Constructor with studentId and studentName
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.enrolledCourses = new LinkedHashSet<Course>();
	}

	//generate the getter and setter

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String enrollInCourse(Course enrolledCourse) {
		if (enrolledCourses.size() >= enrolledCoursesCount) {
			return this.studentName + " has enrolled for maximum courses";
		}

		if (isEnrolled(enrolledCourse)) {
			return this.studentName + " is already enrolled in " + enrolledCourse.getCourseName();
		}
		enrolledCourses.add(enrolledCourse);

		return this.studentName + " has been enrolled in " + enrolledCourse.getCourseName();
	}

	// Check if already enrolled in a course
		public boolean isEnrolled(Course course) {
			return enrolledCourses.contains(course);
		}

}
