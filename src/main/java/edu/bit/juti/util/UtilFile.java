package edu.bit.juti.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.bit.juti.vo.ProductVO;

public class UtilFile {
    String fileName = "";

    //  fileUpload() 메소드에서 전체 경로를 DB에 경로 그대로 저장 한다.  
    public String fileUpload(MultipartHttpServletRequest req, MultipartFile uploadFile, ProductVO productVO) {
        String path = "";
        String fileName = "";

        OutputStream out = null;
        PrintWriter printWriter = null;

        try {
            fileName = uploadFile.getOriginalFilename();
            byte[] bytes = uploadFile.getBytes();
            path  = req.getSession().getServletContext().getRealPath("/resources/upload") + "files/";

            File file = new File(path);

            // 파일명이 중복체크
            if (fileName != null && !fileName.equals("")) {
                if (file.exists()) {
            // 파일명 앞에 구분(예)업로드 시간 초 단위)을 주어 파일명 중복을 방지한다.
                fileName = System.currentTimeMillis() + "_" + fileName;
                file = new File(path + fileName);
                }
            }
            out = new FileOutputStream(file);

            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path + fileName;
    }
}   