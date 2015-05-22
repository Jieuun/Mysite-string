package com.sds.icto.mysitespring.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysitespring.domain.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	// 글 입력
	public void insert(BoardVo vo) {
		sqlMapClientTemplate.insert("board.insert", vo);

	}

	// 글 리스트 불러오기
	public List<BoardVo> fetchList() {
		List<BoardVo> list = new ArrayList<BoardVo>();
		list = sqlMapClientTemplate.queryForList("board.list");
		return list;
	}

	// no받아서 글 삭제
	public void delete(BoardVo vo) {
		sqlMapClientTemplate.delete("board.delete", vo);
	}

	// 글 상세 페이지
	public BoardVo showBoard(Long no) {

		BoardVo boardVo = new BoardVo();
		boardVo = (BoardVo) sqlMapClientTemplate.queryForObject("board.show",
				no);

		return boardVo;
	}

	// 글 수정
	public void updateBoard(BoardVo vo) {

		sqlMapClientTemplate.update("board.edit", vo);
	}

	public void UpdateViewcnt(BoardVo vo) {

		sqlMapClientTemplate.update("board.updateViewcnt", vo);
	}

	public BoardVo View(Long no) {

		BoardVo boardVo = (BoardVo) sqlMapClientTemplate.queryForObject(
				"board.view", no);
		return boardVo;
	}

}
