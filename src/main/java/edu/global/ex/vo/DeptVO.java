package edu.global.ex.vo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeptVO {
	private String deptno; // 부서번호
	private String dname; // 부서이름
	private String loc; // 지역
	
	List<EmpVO> empList;
}
