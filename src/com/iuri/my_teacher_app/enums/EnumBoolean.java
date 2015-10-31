package com.iuri.my_teacher_app.enums;

import android.util.Log;

public enum EnumBoolean {

	FALSE(0, false){
		@Override
		public String toString(){
			return "false";
		}
	}, TRUE(1, true){
		@Override
		public String toString(){
			return "true";
		}
	};

	private Integer option;
	private Boolean value;

	private EnumBoolean(Integer option, Boolean value) {
		this.option = option;
		this.value = value;
	}

	public Integer getValue(){
		return option;
	}
	
	public Boolean getBoolean(){
		return value;
	}

	public static Integer getOption(Boolean presence) {
		for(EnumBoolean value : values()){
			if(value.getBoolean() == presence)
				return value.getValue();
		}
		Log.d("EnumBoolean", "Do not fount option in EnumBoolean");
		return null;
	}
	
	public static Boolean getValue(Integer presence) {
		for(EnumBoolean value : values()){
			if(value.getValue() == presence)
				return value.getBoolean();
		}
		Log.d("EnumBoolean", "Do not fount value in EnumBoolean");
		return null;
	}
}
