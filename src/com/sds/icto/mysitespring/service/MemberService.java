package com.sds.icto.mysitespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysitespring.domain.MemberVo;
import com.sds.icto.mysitespring.repository.MemberDao;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;

	public void joinUser(MemberVo vo) {

		memberDao.insert(vo);

	}

	public MemberVo authUser(MemberVo vo) {
		MemberVo membervo = memberDao.getMember(vo);
		return membervo;
	}

}
