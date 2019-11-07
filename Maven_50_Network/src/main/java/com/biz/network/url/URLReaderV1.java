package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReaderV1 {

	public static void main(String[] args) throws IOException {
		
		URL naver = new URL("https://www.naver.com/");
		
		InputStreamReader in = new InputStreamReader(naver.openStream());
		BufferedReader buffer = new BufferedReader(in);
		
		String reader = "";
		
		while(true) {
			
			reader = buffer.readLine();
			if(reader == null) break;
			System.out.println(reader);
		}
		// netWork니까 닫아줘야함
		buffer.close();
		
						
		
		
	}
}
