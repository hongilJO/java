package com.springbook.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserDTO;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserServiceImpl;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private UserService userService;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("TITLE", "TITLE");
		conditionMap.put("CONTENT", "CONTENT");
		return conditionMap;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserDTO user) {
		System.out.println("로그인 화면으로 이동");
		user.setId("test");
		user.setPassword("test123");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserDTO user, HttpSession session) {
		// TODO Auto-generated method stub
		// 사용자 입력 정보 추출
		System.out.println("로그인 인증 처리");
		if(user.getId() == null || user.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 됩니다.");
		}
		UserDTO dto = userService.getUser(user);
		// 화면 네비게이션
		if (dto != null) {
			session.setAttribute("username", dto.getName());
			return "redirect:getBoardList.do";
		} else {
			return "redirect:login.jsp";
		}
	}

	@RequestMapping(value = "getBoardList")
	public String getBoardList(
			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword, BoardDTO board,
			Model model) {
		// TODO Auto-generated method stub
		// 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// DB 연동 처리
		if (condition != null) {
			board.setSearchCondition(condition);
		} else {
			board.setSearchCondition("TITLE");
		}
		if (condition != null) {
			board.setSearchKeyword(keyword);
		} else {
			board.setSearchKeyword("");
		}
		List<BoardDTO> boardList = boardService.getBoardList(board);

		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}

	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardDTO dto, Model model) {
		// TODO Auto-generated method stub
		System.out.println("글 상세 조회 기능");

		// 1. 검색할 게시글 번호 추출
		BoardDTO board = boardService.getBoard(dto);
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}

	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardDTO board) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		System.out.println("글 등록이 되었습니다.");
		
		MultipartFile uploadFile = board.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("/Users/jhi/eclipse-workspace/BoardWebSpringMVC/upload/"+fileName));
		}
		
		boardService.insertBoard(board);
		return "redirect:getBoardList.do";
	}

	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardDTO board) {
		// TODO Auto-generated method stub
		System.out.println("글 수정이 되었습니다.");
		System.out.println(board.getWriter());
		boardService.updateBoard(board);
		return "redirect:getBoardList.do";
	}

	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		System.out.println("글 삭제가 되었습니다.");

		boardService.deleteBoard(board);
		return "redirect:getBoardList.do";
	}

	@RequestMapping(value = "/logout.do")
	public String handleRequest(HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("로그아웃 되었습니다.");

		session.invalidate();

		return "login.jsp";
	}
}
