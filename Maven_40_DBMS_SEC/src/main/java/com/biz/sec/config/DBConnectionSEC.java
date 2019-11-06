package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnectionSEC {

	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		
		// Map을 이용해서 전체 환경변수 읽어오기
		Map<String,String> envList = System.getenv();
		
		// 전체 환경변수 중 BIZ키 변수값 추출
		String saltPass = System.getenv().get("BIZ");
		
		// 환경변수중 BIZ 키값만 가져오기
		saltPass = System.getenv("BIZ");
		
		String configFile = "com/biz/sec/config/mybatis-config.xml";
		
		// java.io
		InputStream is = null;
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		String userName = "TqmoP2RKTXG+pAe/sYNSvg==";
		String password = "bJD2Trg1DH1pavstWbAZnQ==";
	
		/*
		 * Properties : java에서 어떤 setting값들을 모아서 어떤 설정을 하는 용도로 사용함 
		 * setting 값들을 쉽게 관리할 수 있도록 도와주는 class
		 */
		Properties props = new Properties();
				
		props.put("username", pbEnc.decrypt(userName));
		props.put("password", pbEnc.decrypt(password));
		
		
		try {
			is = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			if(sqlSessionFactory == null) {
				// 매개변수로 props 전달
				// config파일을 읽어 DBConnection을 만들때 읽어온 파일 내의 변수로 설정된 곳이 있으면(username, password)
				// 문자열을 찾아 일치하는 문자열에 value값을 대치함
				// == .xml에 있는 값을 동적으로 변경 가능
				// is와 props를 합해서 Connection을 만든다는 개념으로 이해하기
				sqlSessionFactory = builder.build(is,props);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getInstance() {
		
		return sqlSessionFactory;
		
	}
}
