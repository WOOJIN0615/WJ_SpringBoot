package com.woojin.app.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.woojin.app.board.BoardVO;

@SpringBootTest
@Transactional
class QnaDAOTest {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Test
	@Rollback(true)
	void testAdd() throws Exception {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setBoardContents("contents1");
		qnaVO.setUserName("user2");
		qnaVO.setBoardTitle("title2");
		int result = qnaDAO.add(qnaVO);
		qnaDAO.refUpdate(qnaVO);
	}

}
