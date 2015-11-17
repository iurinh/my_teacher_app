package com.iuri.my_teacher_app.enums;

public enum EnumDateFormatter {
	SIMPLE(0){
		@Override
		public String toString(){
			return "dd/MM/yyyy";
		}
	};
	
	private Integer option;

	private EnumDateFormatter(Integer option) {
		this.option = option;
	}

	public Integer getValue(){
		return option;
	}
}
