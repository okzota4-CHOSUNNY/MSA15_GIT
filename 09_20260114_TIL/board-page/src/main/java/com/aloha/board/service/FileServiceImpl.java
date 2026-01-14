package com.aloha.board.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aloha.board.dto.Files;
import com.aloha.board.dto.ParentTable;
import com.aloha.board.mapper.FileMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

  private final FileMapper fileMapper;

  @Value("${spring.servlet.multipart.location}")
  private String uploadPath;
  
  @Override
  public List<Files> list() throws Exception {
    List<Files> files = fileMapper.list();
    return files;
  }

  @Override
  public Files select(Integer no) throws Exception {
    Files file = fileMapper.select(no);
    return file;
  }
  
  @Override
  public Files selectById(String id) throws Exception {
    Files file = fileMapper.selectById(id);
    return file;
  }

  @Override
  public boolean insert(Files board) throws Exception {
    int result = fileMapper.insert(board);
    return result > 0;
  }
  
  @Override
  public boolean update(Files board) throws Exception {
    int result = fileMapper.update(board);
    return result > 0;
  }
  
  @Override
  public boolean updateById(Files board) throws Exception {
    int result = fileMapper.updateById(board);
    return result > 0;
  }
  
  @Override
  public boolean delete(Integer no) throws Exception {
    int result = fileMapper.delete(no);
    return result > 0;
  }
  
  @Override
  public boolean deleteById(String id) throws Exception {
    Files file = fileMapper.selectById(id);
    // 파일 삭제
    File realFile = new File(file.getPath());
    if( realFile.exists() ) {
      realFile.delete();
    }
    // DB 삭제
    int result = fileMapper.deleteById(id);

    // 파일 순서 재배열
    List<Files> fileList = fileMapper.listByParent(file);
    updateFileSortOrder(fileList);

    return result > 0;
  }

  @Override
  public int upload(List<MultipartFile> files, ParentTable parentTable, Integer parentNo) throws Exception {
    Files fileSort = new Files();
    fileSort.setParentTable(parentTable.value());
    fileSort.setParentNo(parentNo);
    // 다음 정렬 순서 - sortOrder : 0 또는 기존 파일 마지막순서+1
    int sortOrder = fileMapper.nextSortOrderByParent(fileSort);
    if( files != null ) {
      for (MultipartFile file : files) {
        // ⚡ 빈 파일 체크
        if( file.isEmpty() ) {
          continue;
        }
        String fileName = file.getOriginalFilename(); // 원본파일명
        String path = uploadPath + UUID.randomUUID().toString() + "_" + fileName;
        // 파일 저장
        File realFile = new File(path);
        byte[] fileData = file.getBytes();
        FileCopyUtils.copy(fileData, realFile);
        
        // DB 저장
        Files newFile = new Files();
        newFile.setParentNo(parentNo);
        newFile.setParentTable(parentTable.value());
        newFile.setName(fileName);
        newFile.setPath(path);
        newFile.setSize(file.getSize());
        newFile.setContentType(file.getContentType());
        newFile.setSortOrder(sortOrder++);
        if( sortOrder == 1 )
          newFile.setIsMain(true);
        fileMapper.insert(newFile);
      }
    }
    return sortOrder;
  }

  @Override
  public List<Files> listByParent(Files files) throws Exception {
    List<Files> fileList = fileMapper.listByParent(files);
    return fileList;
  }

  @Override
  public int deleteByParent(Files files) throws Exception {
    // 파일 목록 조회
    List<Files> fileList = listByParent(files);
    // 파일 삭제
    for (Files file : fileList) {
      // 실제 파일 삭제
      File realFile = new File(file.getPath());
      if( realFile.exists() ) {
        realFile.delete();
      }
    }
    // DB 파일 삭제
    int result = fileMapper.deleteByParent(files);
    return result;
  }

  @Override
  public boolean updateSortOrder(List<Map<String, Object>> sortOrderList) throws Exception {
    int index = 0;
    int result = 0;
    for (Map<String,Object> map : sortOrderList) {
      String id = (String) map.get("key");

      Files file = new Files();
      file.setId(id);
      // index 0 이면 메인파일
      if( index == 0 ) {
        file.setIsMain(true);
      } else {
        file.setIsMain(false);
      }
      file.setSortOrder(index++);
      result += fileMapper.updateById(file);
    }
    return result == sortOrderList.size();
  }

  @Override
  public boolean updateFileSortOrder(List<Files> fileList) throws Exception {
    int index = 0;
    int result = 0;
    for (Files file : fileList) {
      String id = file.getId();

      Files updateFile = new Files();
      updateFile.setId(id);
      // index 0 이면 메인파일
      if( index == 0 ) {
        updateFile.setIsMain(true);
      } else {
        updateFile.setIsMain(false);
      }
      updateFile.setSortOrder(index++);
      result += fileMapper.updateById(updateFile);
    }
    return result == fileList.size();
  }
  
}