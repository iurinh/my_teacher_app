package com.iuri.my_teacher_app.entity;

import java.util.Date;

/**Turma*/
public class Team {

	private Long id;
	private Long schoolId;
	private String serie;
	private String name;
	private Date dtInit;
	private Date dtEnd;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDtInit() {
		return dtInit;
	}
	public void setDtInit(Date dtInit) {
		this.dtInit = dtInit;
	}
	public Date getDtEnd() {
		return dtEnd;
	}
	public void setDtEnd(Date dtEnd) {
		this.dtEnd = dtEnd;
	}
}
