package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public void insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		/*
		System.out.println(dto.getSeq());
		if (dto.getSeq() == 0){
			throw new IllegalArgumentException("0번 글은 등록할수 없습니다!");
		}
		*/
		boardDao.insertBoard(dto);
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDao.updateBoard(dto);
	}

	@Override
	public void deleteBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDao.deleteBoard(dto);
	}

	@Override
	public BoardDTO getBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return boardDao.getBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		// TODO Auto-generated method stub
		return boardDao.getBoardList(dto);
	}

}
