package socket;

import java.io.*;
import java.net.*;

public class SimpleServer {

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
    }
}

// 클라이언트와의 통신을 담당하는 클래스
class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("[" + socket.getInetAddress() + "] 메시지: " + message);

                // 클라이언트에 echo 응답
                out.println("서버: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("[" + socket.getInetAddress() + "] 연결 종료 요청");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("클라이언트 연결 오류: " + e.getMessage());
        } finally {
            try {
                socket.close();
                System.out.println("클라이언트 연결 종료됨: " + socket.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}