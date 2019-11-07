package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConnectionReader02 {

	public static void main(String[] args) throws IOException {

		// 일부 홈페이지(Site)는 주소를 직접 URL로 요청하면
		// 주소변환 과정등의 문제로 접속이 불가능 하다.
		// 이때는 주소를 UTF-8로 Encoding을 수행해 주어야 한다.
		String naverURL = "https://naver.com/";
		String encNaverURL = URLEncoder.encode(naverURL, "UTF-8"); 
		URL naver = new URL(naverURL);
		
		URLConnection naverOpen = naver.openConnection();
		
		// URL에 설정된 url 문자열을 사용하지 말고
		// OUTputStream으로 전송된 encoding URL 문자열을 사용하여 서버에 접속하라
		naverOpen.setDoOutput(true);
		
		
		// URL Encoding에 문제가 발생할 경우(no protocol Exception)
		// Encoding된 URLString을 OutPutStreamWriter로 재전송하기
		naverOpen.connect();
		
		OutputStreamWriter out = new OutputStreamWriter(naverOpen.getOutputStream());
		out.write(encNaverURL);
		out.close();
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(naverOpen.getInputStream()));
		
		String reader = "";
		
		while(true) {
			reader = buffer.readLine();
			if(reader == null) break;
			System.out.println(reader);
		}
		buffer.close();
		
		
		
	}

}
