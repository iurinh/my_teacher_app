package com.iuri.my_teacher_app.entity;

import java.util.Date;

/**Aula*/
public class Class {

	private Long id;
	private Long teamId;
	private Long dayWeek;
	private Date hourInit;
	private Date hourEnd;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public Long getDayWeek() {
		return dayWeek;
	}
	public void setDayWeek(Long dayWeek) {
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
