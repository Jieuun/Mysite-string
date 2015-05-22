package com.sds.icto.mysitespring.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysitespring.domain.GuestbookVo;
import com.sds.icto.mysitespring.exception.GuestbookDaoException;

@Repository
public class GuestbookDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public void add(GuestbookVo vo) {
		sqlMapClientTemplate.insert("guestbook.insert", vo);

	}

	public List<GuestbookVo> fetchList() {

		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		list = sqlMapClientTemplate.queryForList("guestbook.list");

		return list;
	}

	public void delete(GuestbookVo vo) {
		sqlMapClientTemplate.delete("guestbook.delete", vo);

	}

}
