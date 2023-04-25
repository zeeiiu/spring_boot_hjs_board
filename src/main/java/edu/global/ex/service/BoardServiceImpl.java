package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.global.ex.mapper.BoardMapper;
import edu.global.ex.page.Criteria;
import edu.global.ex.repository.BoardDAO;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.GradeVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private final BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList()..");		
		
		//System.out.println("서비스단에서 " + gradeVO);
		
		return mapper.getList();
	}

	@Override
	public BoardVO get(int bid) {		
		log.info("get(int bid)..");		
		return mapper.read(bid);
	}

	@Override
	public int modify(BoardVO board) {
		log.info("modify()..");
		
		return mapper.update(board);
	}

	@Override
	public int remove(BoardVO board) {
		log.info("remove()..");
		
		return mapper.delete(board);
	}

	@Override
	public int register(BoardVO board) {
		log.info("register()..");
		
		return mapper.insert(board);
	}

	@Transactional
	@Override
	public void registerReply(BoardVO board) {
		log.info("registerReply() ..");
		
		mapper.updateShape(board);//답글의 위치를 먼저 잡아준 후
		mapper.insertReply(board);//답글을 등록한다.
	}

	@Override
	public int getTotal() {
		log.info("getTotal()..");
		
		return mapper.getTotalCount();
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("getList(Criteria criteria)");
		
		return  mapper.getListWithPaging(criteria);
	}


}
