package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.page.Criteria;
import edu.global.ex.page.PageVO;
import edu.global.ex.service.BoardService;
import edu.global.ex.service.EmpService;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.GradeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("/emp/*")
@RequiredArgsConstructor
public class EmpController {
	
	@Autowired
	private final EmpService empService ; // BoardService boardService = new BoardServiceImpl()
	
	@GetMapping("/list")
	public String view_list( Model model) {
		log.info("view_list()..");
		
		model.addAttribute("emps",empService.getList());
		
		return "/emp/emp_list";
	}
	
	@GetMapping("/list2")
	public String view_list2(Criteria cri,Model model) {
		log.info("view_list2()..");
		
		model.addAttribute("emps",empService.getList());
		
		//페이징을 위한 처리
		int total = empService.getTotal();
		log.info("total" + total);			
				
		model.addAttribute("pageMaker", new PageVO(cri, total));	
				
				
		return "/emp/emp_list2";
	}
	
	@GetMapping("/dept1")
	public String dept1() {
		log.info("dept1()..");
		
		System.out.println(empService.getEmpDeptOneVOList());
				
		return "/emp/emp_list2";
	}
	
	@GetMapping("/dept2")
	public String dept2(Model model) {
		log.info("dept2()..");
		
		System.out.println(empService.getEmpDeptList());
		model.addAttribute("empDeptList", empService.getEmpDeptList());
		
		return "/emp/empDept";
	}
	
}
