package com.woojin.app.board.notice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woojin.app.board.BoardVO;

@SpringBootTest
class NoticeDAOTest {
	
	@Autowired
	private NoticeDAO dao;

	@Test
	void testAdd() throws Exception {
		BoardVO boardVO = new BoardVO();
		for (int i=0; i<50; i++) {
			boardVO.setBoardTitle("title"+i);
			boardVO.setBoardContents("contents"+i);
			boardVO.setUsername("test");
			int result = dao.add(boardVO);
		}
	}

}
