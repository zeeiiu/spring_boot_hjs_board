package edu.global.ex.service;

import java.util.List;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();//리스트 메소드
	public BoardVO get(int bno);//글보기 메소드
	int modify(BoardVO board); //글수정
	int remove(BoardVO board); //글삭제
	int register(BoardVO board); //글작성
	void registerReply(BoardVO boardVO); //댓글쓰기
	
	//페이징
	int getTotal();
	public List<BoardVO> getList(Criteria criteria);//리스트 메소드
	
	
}
