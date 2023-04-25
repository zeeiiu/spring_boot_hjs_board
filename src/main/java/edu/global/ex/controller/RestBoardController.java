package edu.global.ex.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.global.ex.page.Criteria;
import edu.global.ex.page.PageVO;
import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.GradeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그
@RequestMapping("/rboard/*")
@RequiredArgsConstructor
@RestController // 기존의 컨트롤러 문법과는 완전히 달라짐
public class RestBoardController {

	@Autowired
	private BoardService boardService; // BoardService boardService = new BoardServiceImpl()

	@GetMapping("/")
	public String rboard() {
		return "<h1>이제는 restful 이당</h1>";
	}

	@GetMapping("/list")
	public List<BoardVO> list() {
		log.info("list()..");

		return boardService.getList();
	}

	@GetMapping("/{bid}")
	public BoardVO rest_content_view(BoardVO boardVO) {
		log.info("rest_content_view()..");

		return boardService.get(boardVO.getBid());
	}

	// /rboard/1054
//	@DeleteMapping("/{bid}")
//	public int rest_delete(BoardVO boardVO) {
//		log.info("rest_delete().."); 
//		
//		return boardService.remove(boardVO);
//	}

	@DeleteMapping("/{bid}")
	public ResponseEntity<String> rest_delete(BoardVO boardVO, Model model) {

		ResponseEntity<String> entity = null;
		log.info("rest_delete..");

		try {
			int rn = boardService.remove(boardVO);
			// 삭제가 성공하면 성공 상태메시지 저장
			log.info("delete 넘어온 숫자:::::" + rn);

			entity = new ResponseEntity<>(String.valueOf(rn), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// 댓글 삭제가 실패하면 실패 상태메시지 저장
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		// 삭제 처리 HTTP 상태 메시지 리턴
		return entity;
	}

	// @RequestBody : json을 자바 객체로 변환하는 애너테이션. http프로토콜 body안에 있는 객체로 변환
	@PutMapping("/{bid}")
	public int rest_update_view(@RequestBody BoardVO boardVO) {
		log.info("rest_content_view()..");

		return boardService.modify(boardVO);
	}

}
