package com.jap.oops;

public class MathCourse extends Course {
	private boolean calculusRequired;

	// Constructor
	public MathCourse(int courseId, String courseName, boolean calculusRequired) {
		super(courseId, courseName);
		this.calculusRequired = calculusRequired;

	}

	// Getter and setter for calculusRequired
	public boolean isCalculusRequired() {
		return calculusRequired;
	}

	public void setCalculusRequired(boolean calculusRequired) {
		this.calculusRequired = calculusRequired;
	}

	// Override getCourseDetails method to provide math course details
	@Override
	public String getCourseDetails() {
		return "Math Course Details:"+"\n"+"Course ID: " + getCourseID() + "\n" +
				"Course Name: " + getCourseName() + "\n" +
				"Calculus Required: " + calculusRequired;
	}
}