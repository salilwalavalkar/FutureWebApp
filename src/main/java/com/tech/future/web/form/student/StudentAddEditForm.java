package com.tech.future.web.form.student;

import com.tech.future.web.form.IForm;

public class StudentAddEditForm implements IForm {

	private static final long serialVersionUID = 6802534272545187629L;

	private String sid;
	
	private String firstName;

	private String lastName;

	private String age;
	
	private String actionPerformed;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getActionPerformed() {
		return actionPerformed;
	}

	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
}
