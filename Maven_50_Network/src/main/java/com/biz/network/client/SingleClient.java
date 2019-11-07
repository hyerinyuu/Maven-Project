package com.biz.network.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient {

	// 	[네트워크 Client]
	// 필요에 따라서 실행을 하여 Server에게 무엇인가 요청을 하고 결과를 기다리는 구조
	public static void main(String[] args) throws IOException {
		
		// 주소 = 포트 두개가 동시에 맞아야 접속 가능
		String serverIP = "192.168.123.45"; // 접속하려는 서버 주소
		int serverPort = 8085; // 접속하고자 하는 서버의 포트
		
		// Socket os에 관계없이 
		
		Socket mySocket = new Socket(serverIP, serverPort);
		Scanner scan = new Scanner(System.in);
		
		// 서버에서 전송되어올 메시지를 수신하기 위한 코드
		InputStream is = mySocket.getInputStream();
		DataInputStream data = new DataInputStream(is);
		
		// 서버에게 메시지를 전송하기 위한 코드
		OutputStream os = mySocket.getOutputStream();
		
		String msg = "";
		while(true) {

			System.out.print(">> ");
			String sendMsg = scan.nextLine();
			
			// 서버에게 보낼 문자열을 byte형식의 배열값으로 변환하기 위해 
			// 임시로 사용할 메모리 buffer
			// 키보드에서 입력된 문자열을 UTF-8 방식으로 인코딩하여
			// buffer배열 변수에 저장
			byte[] buffer = sendMsg.getBytes("UTF-8");
			os.write(buffer);
			
			// msg = data.readUTF();
			// System.out.println("Server : " + msg);
		}
	}

}
