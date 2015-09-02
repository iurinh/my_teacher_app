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
	};

	private Integer option;
	
	private EnumToast(Integer option) {
		this.option = option;
	}
	
	public Integer getValue(){
		return option;
	}
}
