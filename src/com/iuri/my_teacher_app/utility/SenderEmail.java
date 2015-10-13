package com.iuri.my_teacher_app.utility;

import com.iuri.my_teacher_app.enums.EnumEmail;

import android.content.Intent;
import android.net.Uri;

public class SenderEmail {
	private String email;
	private int code;

	public SenderEmail(final String number, final int code) {
		this.email = number;
		this.code = code;
	}
	
	public Intent toSend(){

		Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, EnumEmail.SUBJECT_SEND_CODE.toString());
		intent.putExtra(Intent.EXTRA_TEXT, EnumEmail.BODY_SEND_CODE.toString() + code);
		intent.setData(Uri.parse(email));
		
		return Intent.createChooser(intent, "Send mail...");
	}
}
