package io2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestWebServer {

	public static void main(String[] args) throws Exception {
		// 지배인이 가게문 연다
		ServerSocket server = new ServerSocket(5555);
		
		System.out.println(server);
		
		// blocked io
		// 손님을 열번 받고 손님 받을 때마다 직원(소켓) 한명씩 할당
		// 총 i번의 호출을 받을 수 있다.
		for ( int i = 0; i < 100; i++) {
		
			Socket socket = server.accept();
		
			System.out.println(socket);
			
			InputStream in = socket.getInputStream();
			// 줄바꿈을 이용해서 빨아들인다
			Scanner scanner = new Scanner(in);
			String str = scanner.nextLine();    // 다시 보내는게 아니니까 \n 필요 없다.
			System.out.println("BROWSER: "+str);
			
			OutputStream out = socket.getOutputStream();
			
			String msg = "<h1>Hello World</h1>";
			// http 프로토콜에 맞게 메시지를 보내는데 필요한 몇 개의 문장을 추가해준 것
			
			// 응답 바디와 헤더
			// 200 ok -> 응답 끝
			// 헤더부분
			out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); 
			out.write(new String("Cache-Control: private\r\n").getBytes()); 
			// 얼마의 길이를 가진 건지3
			out.write(new String("Content-Length: "+msg.getBytes().length+"\r\n").getBytes()); 
			// 지금 보내는 컨텐츠가 어떤 종류인지 -> 만약 브라우저가 이 컨텐츠를 표시할 수 없으면 다운로드가 걸린다
			out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());
			
			// 바디부분
			out.write(msg.getBytes());
			
			System.out.println("--------------------------");
			
			out.close();
			scanner.close();
			in.close();
			socket.close();
			
		} // end for
	}
}
	

