package com.biz.network.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerThreadEx_01 {

	public static void main(String[] args) throws IOException {

		// 여기서 만든 Socket을 ServerThread에게 넘김
		ServerSocket server = new ServerSocket();
		InetSocketAddress iSocket = new InetSocketAddress(8085);
		server.bind(iSocket);
		
		ServerThreadV1 tServer = new ServerThreadV1(server);
		Thread tRun = new Thread(tServer);
		tRun.start();
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			
			System.out.print("Server >> ");
			String strSend = scan.nextLine();
			
			System.out.println("Server : " + strSend);
			
		}
		
	}

}
