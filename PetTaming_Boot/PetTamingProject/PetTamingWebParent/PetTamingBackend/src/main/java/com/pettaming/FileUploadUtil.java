package com.pettaming;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
	public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException{
		
		Path uploadPath = Paths.get(uploadDir);
		
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try (InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException ex) {
			throw new IOException("Could not save file : " + fileName, ex);
		}
	}

	public static void cleanDir(String uploadDir) {
		
		Path dirPath = Paths.get(uploadDir);
		
		try {
			Files.list(dirPath).forEach(file -> {
				//디렉토리가 Folder면 true File이면 false
				if(!Files.isDirectory(file)) {
					try {
						Files.delete(file);// DB에는 없지만 디렉토리만 있는 파일들을 지우기
					}catch(IOException ex) {
						System.out.println("해당 " + file + " 지울 수 없습니다");
					}
				}
			});
		}catch(IOException ex) {
			System.out.println("해당 " + dirPath + "가 디렉토리에 존재하지 않습니다.");
		}
		
	}

}
