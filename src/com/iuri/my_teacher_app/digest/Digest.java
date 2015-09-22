package com.iuri.my_teacher_app.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {

	public String getDigestMD5(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digested = md.digest(text.getBytes());
			return new String(hexCodes(digested));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Esta logica de transformação de texto para hexCode pode ser encontrada em:
	 * http://www.devmedia.com.br/criptografia-md5/2944
	 * Data de Acesso: 20/09/2015
	 * @param text
	 * @return array com conteudo criptografado
	 */
	private char[] hexCodes(byte[] text) {
		char[] hexOutput = new char[text.length * 2];
		String hexString;
		for (int i = 0; i < text.length; i++) {
			hexString = "00" + Integer.toHexString(text[i]);
			hexString.getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
		}
		return hexOutput;
	}

}
