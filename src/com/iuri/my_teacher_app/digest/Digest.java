package com.iuri.my_teacher_app.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.iuri.my_teacher_app.enums.EnumToast;

import android.content.Context;
import android.widget.Toast;

public class Digest {

	public String getDigestMD5(String md5, Context context) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String digested = md.digest(md5.getBytes()).toString();
			return digested;
		} catch (NoSuchAlgorithmException e) {
			Toast.makeText(context, EnumToast.ERROR_DIGGEST.toString(), Toast.LENGTH_SHORT).show();
		}
		return null;
	}
}
