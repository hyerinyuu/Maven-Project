package com.biz.oracle.exec;

import java.util.Map;
import java.util.Set;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_03 {

	public static void main(String[] args) {
		
		// os의 환경변수값을 가져와서 map에 저장하기
		Map<String,String> systemENV = System.getenv();
		Set<String> keys = systemENV.keySet();
		for(String s : keys) {
			
			System.out.printf("%s = %s\n",s,systemENV.get(s));
		}
		String user = "iolist2";
		String password = "iolist2";
		
		// salt값을 외부에 노출하지 않기 위해 system(os)의 환경변수 중 일부 값을 가져와서 사용하기
		// 암호화키를 최소한 소스코드에서는 감추겠다
		String salt = systemENV.get("USERNAME");
		
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

		
		String encUser = pbEnc.encrypt(user);
		String encPassword = pbEnc.encrypt(password);
		
		System.out.printf("%s -> %s\n",encUser,user);
		System.out.printf("%s -> %s\n",encPassword,password);
		/*
  		 *MqvYV5vjr3FLGoNFe0XPIA== -> iolist2
		 *bgkMCpVxdxNAu10NaY1atw== -> iolist2
		 */
		
		
	}

}

