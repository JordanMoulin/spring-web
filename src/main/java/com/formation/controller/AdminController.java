package com.formation.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formation.model.Message;
import com.formation.validator.MessageValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private List<Message> messages = new ArrayList<Message>();

	@GetMapping("/messages")
	public ModelAndView directWithMessage() {
		ModelAndView modelAndView = new ModelAndView();

		Message message1 = new Message();
		message1.setExpediteur("Arthur");
		message1.setDestinataire("Perceval");
		message1.setHeure(LocalDateTime.now());
		message1.setMessage("Bande d'idiots");

		Message message2 = new Message();
		message2.setExpediteur("Perceval");
		message2.setDestinataire("Arthur");
		message2.setHeure(LocalDateTime.now());
		message2.setMessage("C'est pas faux !");

		messages.add(message1);
		messages.add(message2);

		modelAndView.addObject("msg", messages);
		modelAndView.setViewName("list");
		return modelAndView;
	}

	@RequestMapping(value = "/messages/new", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("create_message", "message", new Message());
	}

	@RequestMapping(value = "/messages/new", method = RequestMethod.POST)
	public ModelAndView submit(@Validated @ModelAttribute("message") Message message, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return new ModelAndView("create_message");
		}
		model.addAttribute("expediteur", message.getExpediteur());
		model.addAttribute("destinataire", message.getDestinataire());
		model.addAttribute("message", message.getMessage());
		Message message1 = new Message();
		message1.setDestinataire(message.getDestinataire());
		message1.setExpediteur(message.getExpediteur());
		message1.setMessage(message.getMessage());
		message1.setHeure(LocalDateTime.now());
		messages.add(message1);
		return new ModelAndView("list", "msg", messages);
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new MessageValidator());

	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
