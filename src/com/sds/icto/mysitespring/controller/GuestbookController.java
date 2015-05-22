package com.sds.icto.mysitespring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sds.icto.mysitespring.repository.GuestbookDao;
import com.sds.icto.mysitespring.service.GuestbookService;
import com.sds.icto.mysitespring.domain.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	GuestbookDao guestbookdao;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookdao.fetchList();
		model.addAttribute("list", list);
		return "guestbook/index";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVo vo) {
		guestbookdao.add(vo);
		return "redirect:/guestbook/index";

	}

	@RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}

	@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo) {
		guestbookdao.delete(vo);
		return "redirect:/guestbook/index";
	}

}
