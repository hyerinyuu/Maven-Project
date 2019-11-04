package com.biz.oracle.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_02 {

	public static void main(String[] args) {

		String user = "iolist2";
		String password = "iolist2";
		String salt = "com.biz.oracle";
		
		String encUser = "MqvYV5vjr3FLGoNFe0XPIA==";
		String encPassword = "bgkMCpVxdxNAu10NaY1atw==";
			
		
		// 문자열을 암호화 시키기 위한 Class
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		// 암호화 Type
		// MD5 또는 DES형식의 암호화 Type
		// 자바에서 가장 쉽게 접근 가능한 암호화 Type
		// jasypt만으로 암호화 할 수 있음.
		String encType = "PBEWithMD5AndDES";
		
		
		// MD5, DES방식으로 암호화를 하고, key값으로 salt문자열을 사용하라 
		pbEnc.setAlgorithm(encType);
		// key값
		pbEnc.setPassword(salt);
		
		user = pbEnc.decrypt(encUser);
		password = pbEnc.decrypt(encPassword);
		
		System.out.printf("%s -> %s\n",encUser,user);
		System.out.printf("%s -> %s\n",encPassword,password);
		

		/*
  		 *MqvYV5vjr3FLGoNFe0XPIA== -> iolist2
		 *bgkMCpVxdxNAu10NaY1atw== -> iolist2
		 */
		
		
	}

}

