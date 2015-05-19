package com.sds.icto.mysitespring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sds.icto.mysitespring.service.GuestbookService;
import com.sds.icto.mysitespring.domain.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	GuestbookService guestbookservice;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(Model model) {
		List<GuestbookVo> list = guestbookservice.showBook();
		model.addAttribute("list", list);

		return "guestbook/list";

	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "guestbook/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVo vo) {
		guestbookservice.addBook(vo);
		return "redirect:/guestbook/list";

	}

	@RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo) {
		guestbookservice.deleteBook(vo);
		return "redirect:/guestbook/list";
	}

}
