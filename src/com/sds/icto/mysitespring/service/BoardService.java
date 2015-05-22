package com.sds.icto.mysitespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysitespring.domain.BoardVo;
import com.sds.icto.mysitespring.repository.BoardDao;

@Service
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	public BoardVo showBoard(Long no){
		BoardVo boardvo = boardDao.showBoard(no);
		return boardvo;
		
	}
	
	public void boardUpdateViewcnt(BoardVo vo){
		boardDao.UpdateViewcnt(vo);
	}
	
	public BoardVo boardView(Long no){
		BoardVo boardvo = boardDao.View(no);
		return boardvo;
	}
	
	public void boardUpdate(BoardVo vo){
		boardDao.updateBoard(vo);
	}
	
	public void deleteBoard(BoardVo vo){
		boardDao.delete(vo);
	}
	
	

}
