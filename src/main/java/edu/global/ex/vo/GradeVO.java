package edu.global.ex.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Component 
public class GradeVO {
	private int kor;
	private int eng;
	private int math;
	
	public GradeVO() {
		this.kor = 85;
		this.eng = 76;
		this.math = 76;		
	}
}
