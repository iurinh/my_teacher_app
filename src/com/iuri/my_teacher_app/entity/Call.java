package com.iuri.my_teacher_app.entity;

/**Chamada*/
public class Call {

	private Integer id;
	private Integer classId;
	private Integer studentId;
	private Boolean presence;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Boolean getPresence() {
		return presence;
	}
	public void setPresence(Boolean presence) {
		this.presence = presence;
	}
	
}
