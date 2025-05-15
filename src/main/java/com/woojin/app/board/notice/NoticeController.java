package com.woojin.app.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.board.BoardVO;
import com.woojin.app.home.util.Pager;
import com.woojin.app.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
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
	
	//@GetMapping("")
	@GetMapping("/notices")
	public Map<String, Object> getList(Pager pager, Model model)throws Exception{
		pager.setKind("k1");
		List<BoardVO> ar = noticeService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		//?
		Map<String, Object> map = new HashMap<>();
		map.put("ar", ar);
		map.put("pager", pager);
		
		return map;
	}
	
	//@GetMapping("detail")
	@GetMapping("/notices/{page}")
	public BoardVO getDetail(@PathVariable(name = "page") Long page)throws Exception{
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardNum(page);
		
		boardVO = noticeService.getDetail(boardVO);
		
		return boardVO;
	}
	
	
	
	@PostMapping("/notices")
	public int add(NoticeVO noticeVO, @RequestParam(name = "attaches") MultipartFile[] attaches)throws Exception{

		
		
		//noticeVO.setUserName(userVO.getUsername());
		
		int result = noticeService.add(noticeVO, attaches);
		
	
		
		return result;
	}
	
	@DeleteMapping("/notices/{boardNum}")
	public int delete(@PathVariable(name = "boardNum") Long boardNum) {
		log.info("DeleteNum : {}", boardNum);
		
		return 1;
	}
	
	
	@PatchMapping("/notices")
	public int update(NoticeVO noticeVO, @RequestParam(name = "attaches") MultipartFile[] attaches)throws Exception{

		for(MultipartFile m : attaches) {
			log.info(m.getOriginalFilename());
		}
		
		//noticeVO.setUserName(userVO.getUsername());
		
		//int result = noticeService.add(noticeVO, attaches);
		
	
		
		return 0;//result;
	}
	



	@GetMapping("list")
	public Map<String, Object> getList(Model model, Pager pager) throws Exception{
		
		List<BoardVO> ar = noticeService.getList(pager);
		
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("ar", ar);
		map.put("pager", pager);
		
		return map;
	}
	
	@GetMapping("detail")
	public BoardVO getDetail(Model model, BoardVO boardVO) throws Exception{
		boardVO = noticeService.getDetail(boardVO);
		model.addAttribute("dto", boardVO);
		
		return boardVO;
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
	
	@ExceptionHandler(exception = NullPointerException.class)
	public String exceptionHandler() {
		System.out.println("Notice Exception");
			
		return "jsp 경로";
	}
	


}
