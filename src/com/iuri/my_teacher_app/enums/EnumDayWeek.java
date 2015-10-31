package com.iuri.my_teacher_app.enums;

public enum EnumDayWeek {

	SUNDAY(0){
		@Override
		public String toString(){
			return "Sunday";
		}
	}, MONDAY(1){
		@Override
		public String toString(){
			return "Monday";
		}
	}, TUESDAY(2){
		@Override
		public String toString(){
			return "Tuesday";
		}
	}, WEDNESDAY(3){
		@Override
		public String toString(){
			return "Wednesday";
		}
	}, THURSDAY(4){
		@Override
		public String toString(){
			return "Thursday";
		}
	}, FRIDAY(5){
		@Override
		public String toString(){
			return "Friday";
		}
	}, SATURDAY(6){
		@Override
		public String toString(){
			return "Saturday";
		}
	};

	private Integer option;

	private EnumDayWeek(Integer option) {
		this.option = option;
	}

	public Integer getValue(){
		return option;
	}
}