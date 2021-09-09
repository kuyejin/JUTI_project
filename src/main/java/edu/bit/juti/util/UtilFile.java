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

    //  fileUpload() �޼ҵ忡�� ��ü ��θ� DB�� ��� �״�� ���� �Ѵ�.  
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

            // ���ϸ��� �ߺ�üũ
            if (fileName != null && !fileName.equals("")) {
                if (file.exists()) {
            // ���ϸ� �տ� ����(��)���ε� �ð� �� ����)�� �־� ���ϸ� �ߺ��� �����Ѵ�.
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