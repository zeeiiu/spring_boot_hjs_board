package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.global.ex.mapper.DeptMapper;
import edu.global.ex.page.Criteria;
import edu.global.ex.repository.BoardDAO;
import edu.global.ex.repository.EmpDAO;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.DeptVO;
import edu.global.ex.vo.EmpDeptVO;
import edu.global.ex.vo.EmpVO;
import edu.global.ex.vo.GradeVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private final EmpDAO dao;
	
	@Autowired 
	private final DeptMapper deptMapper;
	
	@Override
	public List<EmpVO> getList() {
		log.info("getList()..");
		
		return dao.empSelect();
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDeptVO> getEmpDeptOneVOList() {
		
		return deptMapper.getEmpDeptOneVOList();
	}

	@Override
	public List<DeptVO> getEmpDeptList() {
		
		return deptMapper.getEmpDeptList();
	}

}
