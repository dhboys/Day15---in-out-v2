package io2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		// 지배인이 가게문 연다
		ServerSocket server = new ServerSocket(5555);
		
		System.out.println(server);
		// 손님을 열번 받고 손님 받을 때마다 직원(소켓) 한명씩 할당
		for ( int i = 0; i < 10; i++) {
		
			Socket socket = server.accept();
		
			System.out.println(socket);
			
			InputStream in = socket.getInputStream();
			// 줄바꿈을 이용해서 빨아들인다
			Scanner scanner = new Scanner(in);
			String str = scanner.nextLine() + "\n";
			
			OutputStream out = socket.getOutputStream();
			out.write(str.getBytes());
			
			
			System.out.println("--------------------------");
			
			out.close();
			scanner.close();
			in.close();
			socket.close();
			
		} // end for
	}
	
}
