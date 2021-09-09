package edu.bit.juti.vo;



import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductVO {
	
	
//	PRODUCT_ID    NOT NULL NUMBER(20)   
//	PRODUCT_NAME  NOT NULL VARCHAR2(20) 
//	PRODUCT_PRICE NOT NULL NUMBER(10)   
//	PRODUCT_IMAGE          VARCHAR2(50) 
//	CATEGORY_ID   NOT NULL NUMBER(20)   
//	PRODUCT_STOCK          NUMBER(20)  
//	PRODUCT_DATE           DATE 
	
	
	
		
	private int product_id;                  //��ǰ ��ȣ(PK)
	private String product_name;             //��ǰ�̸�
	private int product_price;               //��ǰ����
	private String product_image;            //��ǰ�̹��� ���
	private int category_id;                  //ī�װ� ��ȣ(Fk)
	private int product_stock;               //��ǰ����
	private Date product_date;               //��ǰ��ϳ�¥
	
	private List<FileVO> fileList;
	



	

	
}
