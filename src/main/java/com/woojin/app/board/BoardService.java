package com.woojin.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.home.util.Pager;

public interface BoardService {
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public BoardVO getDetail(BoardVO boardVO) throws Exception;
	
	public int add(BoardVO boardVO, MultipartFile[] attaches) throws Exception;
	
	public int update(BoardVO boardVO) throws Exception;
	
	public int delete(BoardVO boardVO) throws Exception;
}
