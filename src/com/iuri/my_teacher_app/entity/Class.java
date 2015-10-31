package com.iuri.my_teacher_app.entity;

import java.util.Date;

/**Aula*/
public class Class {

	private Integer id;
	private Integer teamId;
	private Integer dayWeek;
	private Date hourInit;
	private Date hourEnd;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public Integer getDayWeek() {
		return dayWeek;
	}
	public void setDayWeek(Integer dayWeek) {
		this.dayWeek = dayWeek;
	}
	public Date getHourInit() {
		return hourInit;
	}
	public void setHourInit(Date hourInit) {
		this.hourInit = hourInit;
	}
	public Date getHourEnd() {
		return hourEnd;
	}
	public void setHourEnd(Date hourEnd) {
		this.hourEnd = hourEnd;
	}
	
	
}
