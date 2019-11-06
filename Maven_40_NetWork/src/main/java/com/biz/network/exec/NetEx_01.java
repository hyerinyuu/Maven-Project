package com.biz.network.exec;

import java.io.IOException;
import java.net.InetAddress;

public class NetEx_01 {

	public static void main(String[] args) throws IOException {

		/*
		 * 		[ Inet.getByName() Method]
		 * www.naver.com : Domain Name을 DNS에게 조회하여 IPAdress를 가져오는 method
		 */
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println(naver);
		
		
		InetAddress daum = InetAddress.getByName("www.daum.net");
		System.out.println(daum);
		
		// ip Adress만 추출하는 method
		System.out.println(naver.getHostAddress());
		// domain만 추출하는 method
		System.out.println(naver.getHostName());
		
		// 내 컴퓨터의 NIC(Network Interface Card : 랜카드)에 설정된 IP
		InetAddress local = InetAddress.getLocalHost();
		
		// 통신 text용으로 만들어진 특별한 IP
		InetAddress loopBack = InetAddress.getLoopbackAddress();
		
		System.out.println("local : " + local);
		System.out.println("loopBack : " + loopBack);
		
		/*
		 * 			[PORT]
		 * TCP/IP 프로토콜에서 1개의 IP주소에 다수의 어플리케이션이 통신할 수 있도록 하는 구조
		 * 0~65535 개의 PORT를 사용할 수 있고,
		 * 그중 0 ~ 1023까지는 국제 프로토콜 웅앵에서 이미 정해놓아서(예 WEB은 80번 PORT)
		 * 사용자가 임의로 설정하여 사용할 수 없다.
		 * 사용자 PORT를 임의로 설정하여 사용하면
		 * 1개의 컴퓨터에서 여러개의 통신어플리케이션을 작동시킬 수 있다.
		 * 
		 */
		
	}

}
