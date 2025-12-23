package socket;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {
	
	// 모든 클라이언트들의 출력 스트림을 저장할 리스트 (Thread safe)
	private static List<PrintWriter> clientWriterList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        int port = 9999;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버 대기 중: " + port);

            // 여러 클라이언트를 계속 받기 위해 무한 루프
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

                // 각 클라이언트를 별도 스레드로 처리
                new Thread(new ClientHandler(clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    } // main() 끝
    
    // 브로드캐스트 : 모든 클래이언트에 메시지 전송
    public static void broadcast(String message, PrintWriter sender) {
    	for (PrintWriter writer : clientWriterList) {
			if( writer != sender ) {
				writer.println(message);
			}
		}
    }
    
    // 클라이언트와의 통신을 담당하는 클래스
    static class ClientHandler implements Runnable {
    	private Socket socket;
    	private PrintWriter out;
    	private BufferedReader in;
    	private String clientName;
    	
    	public ClientHandler(Socket socket) {
    		this.socket = socket;
    	}
    	@Override
    	public void run() {
    		try {
    			in = new BufferedReader(
    					new InputStreamReader(socket.getInputStream())
    					);
    			out = new PrintWriter(socket.getOutputStream(), true);
    			
    			// 개별 클라이언트의 출력스트림을 리스트에 추가
    			clientWriterList.add(out);
    			
    			out.println("이름 : ");
    			clientName = in.readLine();
    			System.out.println("* " + clientName + "님 입장!");
    			
    			// 입장
    			broadcast("* " + clientName + "님 입장!", out);
    			
    			// 계속 채팅
    			String message;
    			while ((message = in.readLine()) != null) {
    				System.out.println("[" + clientName + "] 메시지: " + message);
    				
    				// 브로드캐스트
    				broadcast("[" + clientName + "] 메시지: " + message, out);
    				
    				if (message.equalsIgnoreCase("exit")) {
    					System.out.println("[" + socket.getInetAddress() + "] 연결 종료 요청");
    					break;
    				}
    			}
    			
    		} catch (IOException e) {
    			System.out.println("클라이언트 연결 오류: " + e.getMessage());
    		} finally {
    			try {
    				if(out != null) clientWriterList.remove(out);
    				if( clientName != null ) {
    					broadcast(clientName + "님이 퇴장했습니다.", out);
    				}
    				socket.close();
    				System.out.println("클라이언트 연결 종료됨: " + socket.getInetAddress());
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    
    
}
