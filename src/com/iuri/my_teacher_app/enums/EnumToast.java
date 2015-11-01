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
			return "This login not exist";
		}
	}, LOGIN_EXIST(6){
		@Override
		public String toString(){
			return "Congratulations! This Login Exist!";
		}
	}, DO_NOT_EQUAL_PASSWORD(7){
		@Override
		public String toString(){
			return "The 'password' and 'confirm password' fields need to be equals";
		}
	}, ERROR_SENDING_NEW_CODE(8){
		@Override
		public String toString(){
			return "Error sending new code by email";
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
