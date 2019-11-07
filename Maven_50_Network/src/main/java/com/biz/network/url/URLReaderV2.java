package com.biz.network.url;

import java.io.IOException;
import java.net.URL;

public class URLReaderV2 {

	public static void main(String[] args) throws IOException {

		URL callor = new URL("https://callor.com:12200/main?name=korea");
		
		System.out.println("Protocal : " + callor.getProtocol());
		System.out.println("Authority : " + callor.getAuthority() );
		System.out.println("Host : " + callor.getHost());
		System.out.println("Port : " + callor.getPort());
		System.out.println("Path : " + callor.getPath()); // = URI
		System.out.println("Query : " + callor.getQuery() );
		System.out.println("File : " + callor.getFile()); 
		System.out.println("Reference : " + callor.getRef());
		
		// ex) naver.com/news ? title=박
		// ==> news : key
		// ==> ?title=박 : Query = WHERE title = 박;
	}

}
