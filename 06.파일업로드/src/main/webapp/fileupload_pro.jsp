
<%@page import="org.apache.tomcat.util.http.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload2.jakarta.JakartaServletRequestContext"%>
<%@page import="org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload"%>
<%@page import="org.apache.commons.fileupload2.jakarta.JakartaServletDiskFileUpload"%>
<%@page import="org.apache.commons.fileupload2.core.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload2.core.FileItemFactory"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 파일 업로드 경로
String uploadPath = "C:/upload/";
File uploadDir = new File(uploadPath); // 해당 경로에 대한 File 객체 생성

// 해당 경로가 존재하지 않으면 폴더 생성
if (!uploadDir.exists()) {
    uploadDir.mkdirs();
}

// 클라이언트 요청의 문자 인코딩 설정
request.setCharacterEncoding("UTF-8");

//임시 파일 저장 경로 설정
File repository = new File(System.getProperty("java.io.tmpdir"));
//FileItemFactory 설정 : 업로드된 항목을 생성하는 팩토리 객체
FileItemFactory factory = DiskFileItemFactory.builder().setFile(repository).get();
//Servlet 기반 파일 업로드 객체 생성
JakartaServletFileUpload<DiskFileItem, FileItemFactory<DiskFileItem>> upload
= new JakartaServletFileUpload<>(factory);
//request 를 변환하기 위한 Context 객체 생성
JakartaServletRequestContext context = new JakartaServletRequestContext(request);