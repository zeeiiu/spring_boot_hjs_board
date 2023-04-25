package edu.global.ex.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	@Select("select * from mvc_board order by bGroup desc, bStep asc")
	public List<BoardVO> getList();
	
	public BoardVO read(int bid);//파라미터는 url로 넘어오는 bid값을 의미
	public int update(BoardVO board);//글수정
	public int delete(BoardVO board);//글삭제
	public int insert(BoardVO board);//글작성
	
	//답글관련
	void updateShape(BoardVO board); //답글위치
	void insertReply(BoardVO board); //답글등록
	
	//paging 관련
	int getTotalCount();	
	public List<BoardVO> getListWithPaging(Criteria cri);
}
