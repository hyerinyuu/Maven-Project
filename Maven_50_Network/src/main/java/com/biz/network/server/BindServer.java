package com.biz.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BindServer {

	public static void main(String[] args) throws IOException {

		// Socket을 생성하고
		ServerSocket server = new ServerSocket();
		// 기다릴 포트 정보를 생성
		// (사용중인 포트인지 검사하는 절차가 내부적으로 수행됨)
		InetSocketAddress iSocket = new InetSocketAddress(8085);
		
		// Socket을 만들때 포트를 지정하지 않고 bind를 이용해 포트를 지정해줌
		server.bind(iSocket); // Serve rSocket에 포트 정보를 연결
		
		System.out.println("Server Wait....");
		Socket client = server.accept();

		// 			[Java의 ~Stream]
		// file, network, console, printer등등 입출력 장치와 연동을 쉽게 하기 위한
		// 여러가지 클래스가 존재하고
		// 각각 기능별로 잘 연결만 하면 최종 사용법은 거의 비슷함
		InputStream is = client.getInputStream();
		
		while(true) {
			
			// 한번에 처리할 메시지의 크기를 지정하는 방식
			byte[] msg = new byte[255];
			
			// 		[is.read()]
			// client에서 전송된 메시지를 msg배열변수에 담고
			// 담긴 byte개수를 return하여 imgSize변수에 담아준다.
			int imgSize = is.read(msg);
			
			// String 클래스를 사용하여 byte배열에 담긴 데이터를 utf-8 방식으로 Decoding하여
			// 읽을 수 있는 문자열ㄹ ㅗ변환
			String strMsg = new String(msg,0,imgSize,"UTF-8");
			System.out.println(strMsg);
			
			if(strMsg.equals("-Q")) break;
			
		}
		System.out.println("Good Bye!! Stop Server");
		
		
		// OutputStream os = client.getOutputStream();
	}

}
