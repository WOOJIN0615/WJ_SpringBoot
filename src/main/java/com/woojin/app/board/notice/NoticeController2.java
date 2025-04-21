package com.woojin.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woojin.app.board.BoardVO;
import com.woojin.app.home.util.Pager;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping(value = "/notice1/*")
public class NoticeController2 {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping(value = "list")
	public String getList(BoardVO boardVO, Pager pager, Model model) throws Exception{
		
		List<BoardVO> ar = noticeService.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "/board/list;";
	}
	
	@GetMapping(value = "detail")
	public String getDetail(BoardVO boardVO, Model model) throws Exception{
		
		boardVO = noticeService.getDetail(boardVO);
		
		model.addAttribute("dto", boardVO);
		
		return "/board/detail?boardNum="+boardVO.getBoardNum();
	}
	
	@GetMapping(value = "add")
	public String add() throws Exception{
		return "/board/add";
	}
	
	@PostMapping(value = "add")
	public String add(BoardVO boardVO, Model model, HttpSession session) throws Exception{
		
		boardVO = (BoardVO)session.getAttribute("user");
		String userID = boardVO.getUserName();
		
		//로그인이 되어있는 상태
		if (!userID.equals(null)) {
			int result = noticeService.add(boardVO, null);
			return "redirect:./board/list";
		}else {
			//로그인 실패한 상태
			int result = 0;
			return "commons/result";
		}
	}
	
	@GetMapping(value = "update")
	public String update(BoardVO boardVO) throws Exception{
		noticeService.getDetail(boardVO);
		return "board/update";
	}
	
	@PostMapping(value = "update")
	public String update(BoardVO boardVO, Model model, HttpSession session) throws Exception{
		
		int result = noticeService.update(boardVO);
		
		return "redirect:./board/detail?boardNum="+boardVO.getBoardNum();
	}
	
	@GetMapping(value = "delete")
	public String delete() throws Exception{
		return "board/delete";
	}
}
