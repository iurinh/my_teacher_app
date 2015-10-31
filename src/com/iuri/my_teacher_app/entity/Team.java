package com.iuri.my_teacher_app.entity;

import java.util.Date;

/**Turma*/
public class Team {

	private Integer id;
	private Integer schoolId;
	private String serie;
	private String name;
	private Date dtInit;
	private Date dtEnd;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
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
