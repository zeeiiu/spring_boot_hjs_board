package edu.global.ex.service;

import java.util.List;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.DeptVO;
import edu.global.ex.vo.EmpDeptVO;
import edu.global.ex.vo.EmpVO;

public interface EmpService {
	public List<EmpVO> getList();

	// 페이징
	int getTotal();
	public List<BoardVO> getList(Criteria criteria);// 리스트 메소드
	
	//1:N 처리
	public List<EmpDeptVO> getEmpDeptOneVOList();
	public List<DeptVO> getEmpDeptList();
}
