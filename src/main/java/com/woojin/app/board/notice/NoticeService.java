package com.woojin.app.board.notice;

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
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${menu.board.notice.name}")
	private String kind;
	
	@Value("${app.files.base}")
	private String path;

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getTotalCount(pager);
		System.out.println(totalCount);
		pager.make(totalCount);
		pager.makeNum();
		List<BoardVO> ar = noticeDAO.getList(pager);
		return ar;
	}

	@Override
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		boardVO = noticeDAO.getDetail(boardVO);
		return boardVO;
	}

	@Override
	public int add(BoardVO boardVO, MultipartFile[] attaches) throws Exception {		
		int result = noticeDAO.add(boardVO);
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
				
				noticeDAO.addFile(boardFileVO);
			}
		}
		
		//저장된 파일명을 DB에 저장
		
		return result;
	}

	@Override
	public int update(BoardVO boardVO) throws Exception {
			int result = noticeDAO.update(boardVO);
		return result;
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
			int result = noticeDAO.delete(boardVO);
		return result;
	}
	
	
}
