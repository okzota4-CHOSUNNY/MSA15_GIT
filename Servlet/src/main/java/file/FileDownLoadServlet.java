package file;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/download")
public class FileDownLoadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // ----------------------------------------------------
        // 1. 다운로드할 파일명 파라미터 받기
        // ----------------------------------------------------
        String fileName = request.getParameter("fileName");
        PrintWriter writer = response.getWriter();

        if (fileName == null || fileName.isEmpty()) {
            writer.println("파일명이 지정되지 않았습니다.");
            return;
        }

        // ----------------------------------------------------
        // 2. 실제 파일 경로 만들기
        // ----------------------------------------------------
        String downloadDir = "C:\\fileupload";
        String downloadFileString = downloadDir + File.separator + fileName;

        File file = new File(downloadFileString);

        // ----------------------------------------------------
        // 3. 파일 존재 여부 확인
        // ----------------------------------------------------
        if (!file.exists()) {
            writer.println("파일이 존재하지 않습니다.");
            return;
        }

        // ----------------------------------------------------
        // 4. 응답 헤더 설정 (다운로드하게 만드는 부분)
        // ----------------------------------------------------
        response.setContentType("application/octet-stream"); // 오타 수정
        fileName = URLEncoder.encode(fileName, "UTF-8");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=\"" + fileName + "\""
        );

        // ----------------------------------------------------
        // 5. 파일 다운로드 처리
        // Client <-- ServletOutputStream <-- Server <-- FileInputStream <-- 파일 시스템
        // ----------------------------------------------------
        try {
            FileInputStream fis = new FileInputStream(file);
            ServletOutputStream sos = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int data = -1;

            while ((data = fis.read(buffer)) != -1) {
                sos.write(buffer, 0, data);   // burffer → buffer 수정
            }

            fis.close();
            sos.close();

        } catch (Exception e) {
            System.err.println("파일 다운로드 중 에러발생!");
            e.printStackTrace();
        }
    }
}
