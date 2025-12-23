package soket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
	
	public static void main(String[] args) {
		String serverAddress = "localhost";
		int port = 9999;
		
		try ( 
				Socket socket = new Socket(serverAddress, port);
				Scanner sc = new Scanner(System.in);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(
		                new InputStreamReader(socket.getInputStream())
		            );
			) {
			System.out.println("서버에 연결됨");
			
			// 서버에서 오는 메시지 입력
			Thread receiver = new Thread(() -> {
				try {
					String response;
					while( (response = in.readLine() ) != null ) {
						System.out.println(response);
					}
				} catch (Exception e) {
					System.out.println("서버 연결 종료");
				}
			});
			receiver.start();
			
			// 서버로 출력
			while(true) {
				String input = sc.nextLine();
				out.println(input);		// 서버로 채팅 보냄
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}








