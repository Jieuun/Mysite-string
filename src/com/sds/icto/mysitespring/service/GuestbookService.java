package com.sds.icto.mysitespring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sds.icto.mysitespring.domain.GuestbookVo;
import com.sds.icto.mysitespring.repository.GuestbookDao;

@Service
public class GuestbookService {

	@Autowired
	GuestbookDao guestbookDao;

	public void addBook(GuestbookVo vo) {

		guestbookDao.add(vo);

	}

	public List<GuestbookVo> showBook() {
		return guestbookDao.fetchList();

	}
	
	
	public void deleteBook(GuestbookVo vo){
		guestbookDao.delete(vo);
	}

}
