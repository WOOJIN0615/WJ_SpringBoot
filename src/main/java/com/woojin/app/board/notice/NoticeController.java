package com.woojin.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.board.BoardVO;
import com.woojin.app.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Value("${menu.board.notice.name}")
	private String name;
	
	@ModelAttribute("kind")
	public String getName() throws Exception{
		return this.name;
	}
	
	@GetMapping("list")
	public String getList(Model model, Pager pager) throws Exception{
		
		List<BoardVO> ar = noticeService.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "/board/list";
	}
	
	@GetMapping("detail")
	public String getDetail(Model model, BoardVO boardVO) throws Exception{
		boardVO = noticeService.getDetail(boardVO);
		model.addAttribute("dto", boardVO);
		
		return "board/detail";
	}
	
	@PostMapping("add")
	public String add(Model model, BoardVO boardVO,@RequestParam(name = "attaches") MultipartFile[] attaches) throws Exception{
		int result = noticeService.add(boardVO, attaches);
		
		model.addAttribute("vo", boardVO);
		
		return "redirect:./list";
	}
	
	@GetMapping("add")
	public String add() throws Exception{
		return "board/add";
	}
	
	@PostMapping("update")
	public String update(BoardVO boardVO) throws Exception{
		int result = noticeService.update(boardVO);
		return "redirect:./detail?boardNum="+boardVO.getBoardNum();
	}
	
	@GetMapping("update")
	public String update(Model model, BoardVO boardVO) throws Exception{
		boardVO = noticeService.getDetail(boardVO);
		model.addAttribute("dto", boardVO);
		return "board/update";
	}
	
	@GetMapping("delete")
	public String delete(Model model, BoardVO boardVO) throws Exception{
		int result = noticeService.delete(boardVO);
		String path="";
		String s = "삭제 실패";
		if (result > 0) {
			s="삭제 성공";
			path = "list";
		}
		model.addAttribute("path", path);
		model.addAttribute("result", s);
		
		return "commons/result";
	}
	


}
