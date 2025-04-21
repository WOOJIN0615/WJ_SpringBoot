package com.woojin.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.board.BoardFileVO;
import com.woojin.app.board.BoardService;
import com.woojin.app.board.BoardVO;
import com.woojin.app.files.FileManager;
import com.woojin.app.home.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${menu.board.qna.name}")
	private String kind;
	
	@Value("${app.files.base}")
	private String path;

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getTotalCount(pager);
		System.out.println(totalCount);
		pager.make(totalCount);
		pager.makeNum();
		List<BoardVO> ar = qnaDAO.getList(pager);
		return ar;
	}

	@Override
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		boardVO = qnaDAO.getDetail(boardVO);
		return boardVO;
	}

	@Override
	public int add(BoardVO boardVO, MultipartFile[] attaches) throws Exception {		
		int result = qnaDAO.add(boardVO);
		//파일을 HDD에 저장
		if (attaches != null) {
			for (MultipartFile attach : attaches) {
				if (attach.isEmpty()) {
					continue;
				}
				
				String fileName=fileManager.fileSave(attach, path.concat(kind));
				BoardFileVO boardFileVO = new BoardFileVO();
				
				boardFileVO.setFileName(fileName);
				boardFileVO.setOldName(attach.getOriginalFilename());
				boardFileVO.setBoardNum(boardVO.getBoardNum());
				
				qnaDAO.addFile(boardFileVO);
			}
		}
		
		//저장된 파일명을 DB에 저장
		
		return result;
	}

	@Override
	public int update(BoardVO boardVO) throws Exception {
			int result = qnaDAO.update(boardVO);
		return result;
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
			int result = qnaDAO.delete(boardVO);
		return result;
	}
	
	
}
