
package com.jap.oops;

public class ProgrammingCourse extends Course {
	private String programmingLanguage;

	// Constructor
	public ProgrammingCourse(int courseId, String courseName, String programmingLanguage) {
		super(courseId, courseName);
		this.courseID = courseId;
		this.programmingLanguage=programmingLanguage;
}

	// Getter and setter for programmingLanguage

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	// Override getCourseDetails method to provide programming course details
	@Override
	public String getCourseDetails() {
		return "Programming Course Details:"+"\n"+ "Course ID: " + getCourseID() + "\n" +
				"Course Name: " + getCourseName() + "\n" +
				"Programming Language: " + getProgrammingLanguage();
	}
}
