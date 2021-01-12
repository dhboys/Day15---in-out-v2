package io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy2 {
	
	// bad code
	public static void main(String[] args) throws Exception{
		
		InputStream fin = new FileInputStream("C:\\zzz\\sample.jpg");
		
		OutputStream fos = new FileOutputStream("C:\\zzz\\copy2.jpg");
		// 루프전 시간체크
		long start = System.currentTimeMillis();
		
		byte[] buffer = new byte[1024*8];
		
		// while
		while(true) {
							// 매개변수로 계란판을 넣어줘야한다.
			int count = fin.read(buffer);

			if ( count == -1 ) {break;}
			fos.write(buffer,0,count);  // buffer에 담긴 것을 읽는다.
			
		}
		
		// 루프후 시간체크
		long end = System.currentTimeMillis();
		
		long time = end - start;
		
		System.out.println(time);
		
		// 쉽게 말해서 빨대를 뽑는 것
		fin.close();
		fos.close();
		
	}
	
}
