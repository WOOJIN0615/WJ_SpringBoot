package com.woojin.app.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woojin.app.board.BoardDAO;
import com.woojin.app.board.BoardVO;

@Mapper
public interface QnaDAO extends BoardDAO{
	
	public int test(List<BoardVO> ar) throws Exception;
	
	public void updateHits(QnaVO qnaVO) throws Exception;
	
	public int refUpdate(QnaVO qnaVO) throws Exception;
	
}
