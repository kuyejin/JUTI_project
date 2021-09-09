

package edu.bit.juti.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import edu.bit.juti.vo.ProductVO;


//���Ͼ��ε��� ���ڰ����� MultipartFile, HttpServletRequest �ʿ� 
//���Ͼ��ε� �迭������ �޾Ƽ� DB�� , �������� �־��ټ��ְ� ��������


public class UploadPhoto {
   
   String path="C:\\KUYEJIN\\workspace\\workspace-sts-3.9.13.RELEASE\\JUTI_project\\src\\main\\webapp\\resources\\upload";
   
   
   //���Ͼ��ε� ���ִ¸޼ҵ�
   public String upload(MultipartFile[] files, HttpServletRequest req, ProductVO productVO) {
      
      String agent = req.getHeader("User-Agent");
      String realPath=null;
      
      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
      if(agent.indexOf("chrome")!=-1) {
         realPath=req.getSession().getServletContext().getRealPath("/resources/upload");
      }else {
         realPath=req.getSession().getServletContext().getRealPath("\\resources\\upload");
      }
      
      //������ ���鰪 ����ְ� ,�������� �����ְ� io�۾�
      int i=0;
      String photoName= "";
      for(MultipartFile multi : files) {
         if(multi.getOriginalFilename().isEmpty()) {
            i++;
            continue;
         }
         String filenames =multi.getOriginalFilename();
         String rename=System.currentTimeMillis()+"_"+filenames;
         
         if(i!=files.length-1) {
            photoName+=rename+",";
         }else {
            photoName+=rename;
         }
         File file = null;
         //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
         if(agent.indexOf("chrome")!=-1) {
            file = new File(realPath+"/"+rename);
         }else {
            file = new File(realPath+"\\"+rename);
         }
         System.out.println(file.toString());
         try {
            multi.transferTo(file);
         } catch (IllegalStateException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
         i++;
      }
      
      //������ ,�� ó��
      String[] photo=null;
      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
      if(agent.indexOf("chrome")!=-1) {
         photo=photoName.split(",");
      }else {
         photo=photoName.split("\\,");
      }
      String photos="";
      for(int j=0; j<photo.length; j++) {
         if(j!=photo.length-1) {
            photos+=photo[j]+",";
         }else {
            photos+=photo[j];
         }
      }
      
      return photos;
   }
   

   
//   //���Ͼ��ε� ���ִ¸޼ҵ�
//   public String upload(MultipartFile[] files,HttpServletRequest req, MyPostVo mypost) {
//      
//      String agent = req.getHeader("User-Agent");
//      String realPath=null;
//      
//      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if(agent.indexOf("Mac")!=-1) {
//         realPath=req.getSession().getServletContext().getRealPath("/resources/upload");
//      }else {
//         realPath=req.getSession().getServletContext().getRealPath("\\resources\\upload");
//      }
//      
//      //������ ���鰪 ����ְ� ,�������� �����ְ� io�۾�
//      int i=0;
//      String photoName= "";
//      for(MultipartFile multi : files) {
//         if(multi.getOriginalFilename().isEmpty()) {
//            i++;
//            continue;
//         }
//         String filenames =multi.getOriginalFilename();
//         String rename=System.currentTimeMillis()+"_"+filenames;
//         
//         if(i!=files.length-1) {
//            photoName+=rename+",";
//         }else {
//            photoName+=rename;
//         }
//         File file = null;
//         //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//         if(agent.indexOf("Mac")!=-1) {
//            file = new File(realPath+"/"+rename);
//         }else {
//            file = new File(realPath+"\\"+rename);
//         }
//         System.out.println(file.toString());
//         try {
//            multi.transferTo(file);
//         } catch (IllegalStateException e) {
//            e.printStackTrace();
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
//         i++;
//      }
//      
//      //������ ,�� ó��
//      String[] photo=null;
//      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if(agent.indexOf("Mac")!=-1) {
//         photo=photoName.split(",");
//      }else {
//         photo=photoName.split("\\,");
//      }
//      String photos="";
//      for(int j=0; j<photo.length; j++) {
//         if(j!=photo.length-1) {
//            photos+=photo[j]+",";
//         }else {
//            photos+=photo[j];
//         }
//      }
//      
//      return photos;
//   }
//   // ������ �̹���
//   public String upload(MultipartFile[] files, HttpServletRequest req, ProfileVo profileVo) {
//      String realPath = null;
//      String agent = req.getHeader("User-Agent");
//
//      // ���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if (agent.indexOf("Mac") != -1) {
//         realPath = req.getSession().getServletContext().getRealPath("/resources/upload");
//      } else {
//         realPath = req.getSession().getServletContext().getRealPath("\\resources\\upload");
//      }
//
//      // ������ ���鰪 ����ְ� ,�������� �����ְ� io�۾�
//      int i = 0;
//      String photoName = "";
//      for (MultipartFile multi : files) {
//         if (multi.getOriginalFilename().isEmpty()) {
//            i++;
//            continue;
//         }
//         String filenames = multi.getOriginalFilename();
//         String rename = System.currentTimeMillis() + "_" + filenames;
//
//         if (i != files.length - 1) {
//            photoName += rename + ",";
//         } else {
//            photoName += rename;
//         }
//         File file = null;
//         // ���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//         if (agent.indexOf("Mac") != -1) {
//            file = new File(realPath + "/" + rename);
//         } else {
//            file = new File(realPath + "\\" + rename);
//         }
//
//         System.out.println(file.toString());
//         try {
//            multi.transferTo(file);
//         } catch (IllegalStateException e) {
//            e.printStackTrace();
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
//         i++;
//      }
//
//      // ������ ,�� ó��
//      String[] photo = null;
//      // ���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if (agent.indexOf("Mac") != -1) {
//         photo = photoName.split(",");
//      } else {
//         photo = photoName.split("\\,");
//      }
//
//      String photos = "";
//      for (int j = 0; j < photo.length; j++) {
//         if (j != photo.length - 1) {
//            photos += photo[j] + ",";
//         } else {
//            photos += photo[j];
//         }
//      }
//
//      return photos;
//   }
//
//   // ķ���� ���� ����
//   public String upload(MultipartFile[] files, HttpServletRequest req, CampVo campVo) {
//      String realPath = null;
//      String agent = req.getHeader("User-Agent");
//
//      if (agent.indexOf("Mac") != -1) {
//         realPath = req.getSession().getServletContext().getRealPath("/resources/upload");
//      } else {
//         realPath = req.getSession().getServletContext().getRealPath("\\resources\\upload");
//      }
//
//      // ������ ���鰪 ����ְ� ,�������� �����ְ� io�۾�
//      int i = 0;
//      String photoName = "";
//      for (MultipartFile multi : files) {
//         if (multi.getOriginalFilename().isEmpty()) {
//            i++;
//            continue;
//         }
//         String filenames = multi.getOriginalFilename();
//         String rename = System.currentTimeMillis() + "_" + filenames;
//
//         if (i != files.length - 1) {
//            photoName += rename + ",";
//         } else {
//            photoName += rename;
//         }
//         File file = null;
//         // ���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//         if (agent.indexOf("Mac") != -1) {
//            file = new File(realPath + "/" + rename);
//         } else {
//            file = new File(realPath + "\\" + rename);
//         }
//
//         System.out.println(file.toString());
//         try {
//            multi.transferTo(file);
//         } catch (IllegalStateException e) {
//            e.printStackTrace();
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
//         i++;
//         System.out.println("photoName : " + photoName);
//      }
//
//      // ������ ,�� ó��
//      String[] photo = null;
//      // ���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if (agent.indexOf("Mac") != -1) {
//         photo = photoName.split(",");
//      } else {
//         photo = photoName.split("\\,");
//      }
//
//      String photos = "";
//      for (int j = 0; j < photo.length; j++) {
//         if (j != photo.length - 1) {
//            photos += photo[j] + ",";
//         } else {
//            photos += photo[j];
//         }
//      }
//
//      return photos;
//   }
//   
//   //���Ͼ��ε� ���ִ¸޼ҵ�
//   public String upload(MultipartFile[] files,HttpServletRequest req, GroupPostVo groupPostVo) {
//      
//     String agent = req.getHeader("User-Agent");
//      String realPath=null;
//      
//      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if(agent.indexOf("Mac")!=-1) {
//         realPath=req.getSession().getServletContext().getRealPath("/resources/upload");
//      }else {
//         realPath=req.getSession().getServletContext().getRealPath("\\resources\\upload");
//      }
//      
//      //������ ���鰪 ����ְ� ,�������� �����ְ� io�۾�
//      int i=0;
//      String photoName= "";
//      for(MultipartFile multi : files) {
//         if(multi.getOriginalFilename().isEmpty()) {
//            i++;
//            continue;
//         }
//         String filenames =multi.getOriginalFilename();
//         String rename=System.currentTimeMillis()+"_"+filenames;
//         
//         if(i!=files.length-1) {
//            photoName+=rename+",";
//         }else {
//            photoName+=rename;
//         }
//         File file = null;
//         //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//         if(agent.indexOf("Mac")!=-1) {
//            file = new File(realPath+"/"+rename);
//         }else {
//            file = new File(realPath+"\\"+rename);
//         }
//         System.out.println(file.toString());
//         try {
//            multi.transferTo(file);
//         } catch (IllegalStateException e) {
//            e.printStackTrace();
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
//         i++;
//      }
//      
//      //������ ,�� ó��
//      String[] photo=null;
//      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if(agent.indexOf("Mac")!=-1) {
//         photo=photoName.split(",");
//      }else {
//         photo=photoName.split("\\,");
//      }
//      String photos="";
//      for(int j=0; j<photo.length; j++) {
//         if(j!=photo.length-1) {
//            photos+=photo[j]+",";
//         }else {
//            photos+=photo[j];
//         }
//      }
//      
//      return photos;
//   }
//   
//   //���Ͼ��ε� ���ִ¸޼ҵ�
//   public String upload(MultipartFile[] files,HttpServletRequest req, GroupNoticeVo groupNoticeVo) {
//      
//     String agent = req.getHeader("User-Agent");
//      String realPath=null;
//      
//      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if(agent.indexOf("Mac")!=-1) {
//         realPath=req.getSession().getServletContext().getRealPath("/resources/upload");
//      }else {
//         realPath=req.getSession().getServletContext().getRealPath("\\resources\\upload");
//      }
//      
//      //������ ���鰪 ����ְ� ,�������� �����ְ� io�۾�
//      int i=0;
//      String photoName= "";
//      for(MultipartFile multi : files) {
//         if(multi.getOriginalFilename().isEmpty()) {
//            i++;
//            continue;
//         }
//         String filenames =multi.getOriginalFilename();
//         String rename=System.currentTimeMillis()+"_"+filenames;
//         
//         if(i!=files.length-1) {
//            photoName+=rename+",";
//         }else {
//            photoName+=rename;
//         }
//         File file = null;
//         //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//         if(agent.indexOf("Mac")!=-1) {
//            file = new File(realPath+"/"+rename);
//         }else {
//            file = new File(realPath+"\\"+rename);
//         }
//         System.out.println(file.toString());
//         try {
//            multi.transferTo(file);
//         } catch (IllegalStateException e) {
//            e.printStackTrace();
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
//         i++;
//      }
//      
//      //������ ,�� ó��
//      String[] photo=null;
//      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if(agent.indexOf("Mac")!=-1) {
//         photo=photoName.split(",");
//      }else {
//         photo=photoName.split("\\,");
//      }
//      String photos="";
//      for(int j=0; j<photo.length; j++) {
//         if(j!=photo.length-1) {
//            photos+=photo[j]+",";
//         }else {
//            photos+=photo[j];
//         }
//      }
//      
//      return photos;
//   }
//   
//   //���Ͼ��ε� ���ִ¸޼ҵ�
//   public String upload(MultipartFile[] files,HttpServletRequest req, ReportListVo reportListVo) {
//      
//     String agent = req.getHeader("User-Agent");
//      String realPath=null;
//      
//      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if(agent.indexOf("Mac")!=-1) {
//         realPath=req.getSession().getServletContext().getRealPath("/resources/upload");
//      }else {
//         realPath=req.getSession().getServletContext().getRealPath("\\resources\\upload");
//      }
//      
//      //������ ���鰪 ����ְ� ,�������� �����ְ� io�۾�
//      int i=0;
//      String photoName= "";
//      for(MultipartFile multi : files) {
//         if(multi.getOriginalFilename().isEmpty()) {
//            i++;
//            continue;
//         }
//         String filenames =multi.getOriginalFilename();
//         String rename=System.currentTimeMillis()+"_"+filenames;
//         
//         if(i!=files.length-1) {
//            photoName+=rename+",";
//         }else {
//            photoName+=rename;
//         }
//         File file = null;
//         //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//         if(agent.indexOf("Mac")!=-1) {
//            file = new File(realPath+"/"+rename);
//         }else {
//            file = new File(realPath+"\\"+rename);
//         }
//         System.out.println(file.toString());
//         try {
//            multi.transferTo(file);
//         } catch (IllegalStateException e) {
//            e.printStackTrace();
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
//         i++;
//      }
//      
//      //������ ,�� ó��
//      String[] photo=null;
//      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//      if(agent.indexOf("Mac")!=-1) {
//         photo=photoName.split(",");
//      }else {
//         photo=photoName.split("\\,");
//      }
//      String photos="";
//      for(int j=0; j<photo.length; j++) {
//         if(j!=photo.length-1) {
//            photos+=photo[j]+",";
//         }else {
//            photos+=photo[j];
//         }
//      }
//      
//      return photos;
//   }
//
//   
//  
// //����� ��û
//   public String upload(MultipartFile[] files, HttpServletRequest req, UpdateWaitVo updateWaitVo) {
//	   
//	     String agent = req.getHeader("User-Agent");
//	      String realPath=null;
//	      
//	      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//	      if(agent.indexOf("Mac")!=-1) {
//	         realPath=req.getSession().getServletContext().getRealPath("/resources/upload");
//	      }else {
//	         realPath=req.getSession().getServletContext().getRealPath("\\resources\\upload");
//	      }
//	      
//	      //������ ���鰪 ����ְ� ,�������� �����ְ� io�۾�
//	      int i=0;
//	      String photoName= "";
//	      for(MultipartFile multi : files) {
//	         if(multi.getOriginalFilename().isEmpty()) {
//	            i++;
//	            continue;
//	         }
//	         String filenames =multi.getOriginalFilename();
//	         String rename=System.currentTimeMillis()+"_"+filenames;
//	         
//	         if(i!=files.length-1) {
//	            photoName+=rename+",";
//	         }else {
//	            photoName+=rename;
//	         }
//	         File file = null;
//	         //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//	         if(agent.indexOf("Mac")!=-1) {
//	            file = new File(realPath+"/"+rename);
//	         }else {
//	            file = new File(realPath+"\\"+rename);
//	         }
//	         System.out.println(file.toString());
//	         try {
//	            multi.transferTo(file);
//	         } catch (IllegalStateException e) {
//	            e.printStackTrace();
//	         } catch (IOException e) {
//	            e.printStackTrace();
//	         }
//	         i++;
//	      }
//	      
//	      //������ ,�� ó��
//	      String[] photo=null;
//	      //���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
//	      if(agent.indexOf("Mac")!=-1) {
//	         photo=photoName.split(",");
//	      }else {
//	         photo=photoName.split("\\,");
//	      }
//	      String photos="";
//	      for(int j=0; j<photo.length; j++) {
//	         if(j!=photo.length-1) {
//	            photos+=photo[j]+",";
//	         }else {
//	            photos+=photo[j];
//	         }
//	      }
//	      
//	      return photos;
//   }
//   
}