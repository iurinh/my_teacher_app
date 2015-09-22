package com.iuri.my_teacher_app.enums;

public enum EnumToast{
	
	SAVE_SUCCESSFULL(0){
		@Override
		public String toString(){
			return "Save Successfull";
		}
	}, REGISTER_CANCELED(1){
		@Override
		public String toString(){
			return "Register Canceled";
		}
	}, CHANGE_PASSWORD(2){
		@Override
		public String toString(){
			return "Change your password";
		}
	}, NEW_CODE_SENT(3){
		@Override
		public String toString(){
			return "New code sent for your e-mail";
		}
	}, ERROR_DIGGEST(4){
		@Override
		public String toString(){
			return "Error creating the criptography";
		}
	}, LOGIN_NOT_EXIST(5){
		@Override
		public String toString(){
			return "This login not user";
		}
	}, LOGIN_EXIST(6){
		@Override
		public String toString(){
			return "Congratulations! This Login Exist!";
		}
	};

	private Integer option;
	
	private EnumToast(Integer option) {
		this.option = option;
	}
	
	public Integer getValue(){
		return option;
	}
}
