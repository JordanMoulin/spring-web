package com.formation.controller.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.model.Message;
import com.formation.service.MessageService;
import com.formation.service.MessageServiceImpl;

@RestController
@RequestMapping("/admin")
public class BenderController {
	private MessageService serv = new MessageServiceImpl();

	@RequestMapping(value = "/messages", produces = { "application/JSON" }, method = RequestMethod.GET)
	public List<Message> findAllMessages() {
		return serv.findAllMessages();
	}
}
