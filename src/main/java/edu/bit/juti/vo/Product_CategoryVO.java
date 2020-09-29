package edu.bit.juti.vo;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product_CategoryVO {
	
	private int category_id;                  //카테고리 번호(pk)
	private String category_name;             //카테고리 이름

		
}
