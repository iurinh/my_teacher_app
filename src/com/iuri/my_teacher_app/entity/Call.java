package com.iuri.my_teacher_app.entity;

public class Call {

	private Long id;
	private Long classId;
	private Long studentId;
	private Boolean presence;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Boolean getPresence() {
		return presence;
	}
	public void setPresence(Boolean presence) {
		this.presence = presence;
	}
	
}
