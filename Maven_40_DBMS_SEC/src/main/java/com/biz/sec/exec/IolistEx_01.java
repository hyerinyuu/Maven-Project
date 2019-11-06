package com.biz.sec.exec;

import com.biz.sec.config.DBConnection;
import com.biz.sec.dao.IolistDao;

public class IolistEx_01 {

	public static void main(String[] args) {
		
		// myBatis-config.xml DBConnection, iolist-mapper.xml 테스트 코드
		DBConnection.getInstance().openSession(true);
		
		System.out.println("Test OK!");
		
		
		
	}

}
