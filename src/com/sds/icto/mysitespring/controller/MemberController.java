package com.sds.icto.mysitespring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sds.icto.mysitespring.domain.MemberVo;
import com.sds.icto.mysitespring.repository.MemberDao;
import com.sds.icto.mysitespring.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberDao memberDao;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm() {

		return "member/joinform";
	}

	// Service 호출
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute MemberVo vo) {
		memberDao.insert(vo);
		return "redirect:/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {

		return "member/loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberVo vo, HttpSession session) {
		MemberVo membervo = null;
		membervo = memberDao.getMember(vo);
		// 로그인 실패
		if (membervo == null) {
			return "redirect:/member/login?result=fail";
		}

		session.setAttribute("authMember", membervo);
		return "redirect:/index";

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authMember");
		session.invalidate();
		return "redirect:/index";

	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String EditForm() {

		return "member/editform";
	}

	
}
