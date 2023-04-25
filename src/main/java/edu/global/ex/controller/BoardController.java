 package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.page.Criteria;
import edu.global.ex.page.PageVO;
import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.GradeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j //로그
@Controller
@RequestMapping("/jboard/*")
@RequiredArgsConstructor
public class BoardController {
	
	@Autowired
	private BoardService boardService; // BoardService boardService = new BoardServiceImpl()
	
	@GetMapping("/list")
	public String view_list(Model model) {
		log.info("view_list()..");
		
		model.addAttribute("boards",boardService.getList());
		
		return "/board/list";
	}
	
	//http://localhost:8282/list2
	//list2?pageNum=5&amount=10">1</a>
	@GetMapping("/list2")
	public String list2(Criteria cri, Model model) {
		log.info("list2() ..");
		log.info("list2() Criteria " + cri);		
		
		model.addAttribute("boards",boardService.getList(cri));
		
		//페이징을 위한 처리
		int total = boardService.getTotal();
		log.info("total" + total);			
		
		model.addAttribute("pageMaker", new PageVO(cri, total));	
		
		return "/board/list2";
	}
	
	
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO,Model model) {
		log.info("content_view()..");
		
		int bid = boardVO.getBid();
		
		boardVO = boardService.get(bid);		
		model.addAttribute("content_view",boardVO);
		
		return "/board/content_view";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO,Model model) {
		
		log.info("modify()..");		
		int rn = boardService.modify(boardVO);		
		
		log.info("modify() .. result number::" + rn);
	
		return "redirect:list";
	}
	//delete?bid=${content_view.bid}
	@GetMapping("/delete")
	public String delete(BoardVO boardVO,Model model) {
		
		log.info("delete()..");		
		int rn = boardService.remove(boardVO);		
		
		log.info("modify() .. result number::" + rn);
	
		return "redirect:list";
	}
	
	@GetMapping("/write_view")
	public String write_view() {
	
		return "/board/write_view";// /board/write_view.jsp로 가라는 뜻
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		
		log.info("write()..");		
		int rn = boardService.register(boardVO);		
	
		return "redirect:list";
	}
	
	//http://localhost:8282/jboard/reply_view?bid=43
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO,Model model) {
		
		log.info("reply_view()..");		
		
		model.addAttribute("reply_view", boardService.get(boardVO.getBid()));	
	
		return "/board/reply_view";
	}
	
	//http://localhost:8282/jboard/reply
	@PostMapping("/reply")
	public String reply(BoardVO boardVO) {
		
		log.info("reply()..");		
		
		//boardService.registerReply(boardVO);
		
		return "redirect:list"; //로직 수행한 후 list로 redirect해준다.
	}
	

	
}
