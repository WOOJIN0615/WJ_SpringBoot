package com.woojin.app.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woojin.app.board.BoardVO;

@SpringBootTest
class QnaDAOTest {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Test
	void testAdd() throws Exception {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setBoardContents("contents1");
		qnaVO.setUserName("user1");
		qnaVO.setBoardTitle("title1");
		int result = qnaDAO.add(qnaVO);
		qnaDAO.refUpdate(qnaVO);
	}

}
