package com.woojin.app.board.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woojin.app.board.BoardDAO;
import com.woojin.app.board.BoardVO;

@Mapper
public interface NoticeDAO extends BoardDAO{
	
	public int test(List<BoardVO> ar) throws Exception;
	
	public void updateHits(NoticeVO noticeVO) throws Exception;
	
}
