package com.connext.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.connext.pojo.Message;
import com.connext.service.MessageService;
import com.connext.service.impl.*;

@Controller
@RequestMapping("/messagelist")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	@Resource
	MessageServiceImpl messageImpl;
	
	@RequestMapping("/delete")
	public String delete(Integer id){
		this.messageService.delete(id);
		return "redirect:/messagelist/queryAll";
	}
	
	@RequestMapping("/queryAll")	
	public ModelAndView queryAll(){
		ModelAndView mv = new ModelAndView("messageList");
		List<Message> messageList=this.messageService.queryAll();
		mv.addObject("messageList", messageList);
		return mv;
	}
	
//	@RequestMapping("/modifyById")
//	public String updateById(@RequestBody Message message) {
//		this.messageService.updateById(message);
//		return "redirect:/messagelist/queryAll";
//	}
	
	@RequestMapping("/queryById")
	public String queryById(Integer id,Model model) {
		Message message=this.messageService.queryById(id);
		model.addAttribute("message", message);
		return "messageDetail";
	}
	
	@RequestMapping(value="/modifyById",method=RequestMethod.POST)
	@ResponseBody
	public String modifyById(@RequestParam(value="id",required=false)int id,@RequestParam(value="title",required=false)String title,@RequestParam(value="date",required=false)String date,@RequestParam(value="content",required=false)String content,HttpServletRequest request){
		final Message aa=new Message();
		aa.setId(id);
		aa.setTitle(title);
		SimpleDateFormat bb=new SimpleDateFormat("yyyy-MM-dd");
		try {
			aa.setDate(bb.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aa.setContent(content);
		messageImpl.updateById(aa);
		ArrayList<Message> messageList=messageImpl.queryAll();
		request.setAttribute("messageList",messageList);
		return "success";
	}
}
