package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	void insertBoard(BoardDTO dto);
	void updateBoard(BoardDTO dto);
	void deleteBoard(BoardDTO dto);
	BoardDTO getBoard(BoardDTO board);
	List<BoardDTO> getBoardList(BoardDTO board);
}

