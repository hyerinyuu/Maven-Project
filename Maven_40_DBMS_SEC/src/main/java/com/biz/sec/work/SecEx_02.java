package com.biz.sec.work;

import java.util.Map;

// saltpass암호화

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * jasypt 도구를 사용하여 문자열을 암호화 하는 Test 수행
 * 
 * 평문 문자열(plan Text) : 읽을 수 있는 문자열
 * 암호화된 문자열(crypt Text) : 읽을수는 있지만 무슨 내용인지 알 수 없는 형태 
 * 
 */
public class SecEx_02 {

	public static void main(String[] args) {
		
		// java 환경변수를 사용해서 가져오기
		Map<String, String> envList = System.getenv();
		
		
		/*
		 * 
		 * 						[StandardPBEStringEncryptor]
		 * 
		 * Java에서 쉽게 사용할 수 있는 암호화, 복호화를 수행하는 Class
		 * 암호화와 복호화를 동시에 수행할 수 있다.
		 * 
		 * 1. 암호화의 종류 : 단방향, 양방향
		 * 
		 * 		가. 단방향 암호화란 : 평문 -> 암호문 으로의 변경은 가능하나 
		 * 							평문 <- 암호문 으로의 변경은 불가능
		 * 			단방향 암호화 장점 : 보안성에 유리함
		 * 						  단점 : 사용에 제약이 따름
		 *  
		 *  	나. 양방향 암호화란 : 평문 -> 암호문,
		 *  						  평문 <- 암호문 의 양방향 암호화, 복호화가 가능
		 *  		      	   장점 : 사용 편리성이 단방향보다 높음
		 *  				   단점 : 만약 salt Key가 노출된다면 의미 없는 암호화가 됨(보안에 취약)	 	
		 *  
		 *  
		 *  						  	
		 *  jasypt는 "양방향" 암호화를 수행하고 쉽게 사용할 수 있는 형태임
		 *  java에서 DBMS에 접근하기 위해 userID와 password를 사용해야 하는데,
		 *  jdbc Connection코드에 userID와 password가 노출되어 보안에 매우 취약하다.
		 *  
		 *  최소한 소스코드차원에서만이라도 userID와 password를 암호화하여 보안을 유지하기 위한 방법을 사용한다.
		 *  하니만, 이 방법으로는 단방향 암호화 기법은 사용이 불가능하다.
		 *  
		 *  jdbc에서 DBMS로 userID와 password를 전송하는 과정에서
		 *  평문으로 해당 데이터를 보내야하기 때문에 
		 *  암호화된 문자열을 다시 평문으로 복호화하여 전송해야한다.
		 *  
		 *  이런 용도로 주로 사용하는 도구가 Jasypt 이고,
		 *  그중에서 StandardPBEStringEncryptor를 많이 사용한다. 
		 */
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		
		// 환경변수를 이용해 salt값 암호화(일종의 우회)
		String slatPass = envList.get("BIZ");
		
		String planText1 = "java";
		String planText2 = "Republic of Korea";
		
		String encText1 = "";
		String encText2 = "";
		
		// 암호화를 수행하는 코드
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(slatPass);
		
		encText1 = pbEnc.encrypt(planText1);
		encText2 = pbEnc.encrypt(planText2);
		
		System.out.printf("plan : %s\t\t\t enc : %s\n", planText1, encText1);
		System.out.printf("plan : %s\t enc : %s\n", planText2, encText2);
		
		// 복호화
		String decText1 = pbEnc.decrypt(encText1);
		String decText2 = pbEnc.decrypt(encText2);
		
		System.out.printf("enc : %s, dec %s\n", encText1, decText1);
		System.out.printf("enc : %s, dec %s\n", encText2, decText2);
		
		
		

	}

}
