package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationCTX.xml");
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationANNOTATION.xml");
		BoardService boardService = ctx.getBean("boardService",BoardService.class);
		
		BoardDTO board = new BoardDTO();
		board.setTitle("임시제목");
		board.setWriter("홍길동");
		board.setContent("임시내용 :........");
		
		//boardService.insertBoard(board);
	
		
		List<BoardDTO> boardList = boardService.getBoardList(board);
		for ( BoardDTO dto: boardList){
			System.out.println("board : " + dto.toString());
		}
		ctx.close();
	}

}
