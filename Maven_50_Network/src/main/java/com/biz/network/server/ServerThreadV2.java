package com.biz.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Thread에서는 throws가 불가능하기 때문에 try catch만 사용가능
public class ServerThreadV2 implements Runnable{

	ServerSocket server = null;
	
	public ServerThreadV2(ServerSocket server) {
		
		this.server = server;
	}
	
	public void run() {
		
		Socket client = null;

		// client 응답 대기
		try {
			
			while(true) {

				// int id = (int)(Math.random() * 100);
				int id = 0;
				client = this.server.accept();
				
				ServerSubThreadV1 ss = new ServerSubThreadV1(client, ++id);
				
				Thread tRun = new Thread(ss);
				tRun.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
