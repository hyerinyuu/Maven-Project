package com.biz.network.server;

import java.io.InputStream;
import java.net.Socket;

/*
 * 여러 client가 접속을 했을 때
 * client별로 thread를 생성하고
 * 메시지 수신을 처리하기 위한 방법
 * 
 * 접속되는 client마다 thread를 생성
 */
public class ServerSubThreadV1 implements Runnable{

	Socket client = null;
	int id = 0;
	
	public ServerSubThreadV1(Socket clinet, int id) {

		this.client = clinet;
		this.id = id;
	}

	public void run() {

		try {
			
			InputStream is = client.getInputStream();
			byte[] reader = new byte[255];
			int msgSize = is.read(reader);
			
			String msg = new String(reader,0,msgSize,"UTF-8");
			System.out.printf("ID(%d) : %s", this.id, msg);
			
		} catch (Exception e) {
			
			// client가 강제로 접속을 멈추면 exception이 발생해서
			// exception대신에 user out 메시지 보여주기
			System.out.println(this.id + "USER OUT!");
		}
		
	}
	
	
	
}
