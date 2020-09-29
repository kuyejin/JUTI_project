package edu.bit.juti.vo;



import java.sql.Date;

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
	
	
	
		
	private int product_id;                  //상품 번호(PK)
	private String product_name;             //상품이름
	private int product_price;               //상품가격
	private String product_image;            //상품이미지 경로
	private int category_id;                  //카테고리 번호(Fk)
	private int product_stock;               //상품수량
	private Date product_date;               //상품등록날짜
	



	

	
}
