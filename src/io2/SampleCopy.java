package io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SampleCopy {

	//bad code
	public static void main(String[] args) throws Exception {
		
		InputStream fin = new FileInputStream("C:\\zzz\\target.txt");
		
		OutputStream fos = new FileOutputStream("C:\\zzz\\copy.txt");
		
		// 계란판 개수를 정한다.   보통은 8kbytes
		byte[] buffer = new byte[5];
		
		while(true) {
			
			int count = fin.read(buffer);
			
			if ( count == -1 ) {break;}
			
			System.out.println(count);
			              // 맨 앞부터 새로읽어들인 개수만큼만
			fos.write(buffer , 0 , count);
			
		} // end while
	}
	
}
