package com.biz.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Thread에서는 throws가 불가능하기 때문에 try catch만 사용가능
public class ServerThreadV1 implements Runnable{

	ServerSocket server = null;
	
	public ServerThreadV1(ServerSocket server) {
		
		this.server = server;
	}
	
	public void run() {
		
		Socket client = null;
		
		// client 응답 대기
		try {
			client = this.server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// 접속이 되면 client 정보를 표시
		System.out.println("Client : " + client.getInetAddress().toString());
		InputStream is = null;
		
		try {
			is = client.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			
			byte[] reader = new byte[255];
			
			try {
				int msgSize = is.read(reader);
				String message = new String(reader,0,msgSize,"UTF-8");
				System.out.println(message);
				if(message.equals("-Q")) break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Server STOP!");
	}

	
	
}
