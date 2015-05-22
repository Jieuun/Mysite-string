package com.sds.icto.mysitespring.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysitespring.domain.MemberVo;


@Repository
public class MemberDao {
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public void insert(MemberVo vo) {
		sqlMapClientTemplate.insert("member.insert", vo);
	}

	public MemberVo getMember(MemberVo vo) {

		MemberVo memberVo = new MemberVo();
		memberVo = 
				 (MemberVo) sqlMapClientTemplate.queryForObject("member.getInfo",vo);
		
		return memberVo;
	}

	
}
