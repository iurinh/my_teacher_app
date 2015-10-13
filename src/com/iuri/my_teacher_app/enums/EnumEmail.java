package com.iuri.my_teacher_app.enums;

public enum EnumEmail {

	SUBJECT_SEND_CODE(0){
		@Override
		public String toString(){
			return "The code for your MyTeacher app";
		}
	}, BODY_SEND_CODE(1){
		@Override
		public String toString(){
			return "Please, insert this code in your MyTeacher app, for you can to change your password. Thank you! CODE: ";
		}
	}, SEND_EMAIL(2){
		@Override
		public String toString(){
			return "Send Email";
		}
	};

	private Integer option;

	private EnumEmail(Integer option) {
		this.option = option;
	}

	public Integer getValue(){
		return option;
	}
}
