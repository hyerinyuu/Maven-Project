package com.biz.oracle.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * static sqlSessionFactory 클래스를 객채로 선언하고
 * static{} 생성자에서 sqlSessionFactory 객체를 생성
 * getSqlSessionFactory() method에서 sqlSessionFactory를 return
 */
public class DBConnection {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		String configFile = "com/biz/oracle/config/mybatis-config.xml";
		InputStream inputStream = null;
		
		String encType = "PBEWithMD5AndDES";
		
		String encUser = "/DE9CZ6mgvUU0kTlQqq6xA==";
		String encPassword = "2+OvjmJUgqiFFcUJa4trQQ==";
		
		// 암호화된 encUser, encPassword를 복호화 하기 위한 준비
		Map<String,String> systemENV = System.getenv();
		StandardPBEStringEncryptor pbENC = new StandardPBEStringEncryptor();
		pbENC.setAlgorithm(encType);
		pbENC.setPassword(systemENV.get("USERNAME"));
		
		
		// 복호화된 문자열을 mybatis-config.xml에 전달하기 위한 절차
		Properties pros = new Properties();
		pros.put("username",pbENC.decrypt(encUser));
		pros.put("password",pbENC.decrypt(encPassword));
		
		try {
			inputStream = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			if(sqlSessionFactory == null) {
				
				sqlSessionFactory = builder.build(inputStream,pros);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		
		return sqlSessionFactory;
	}

}
