package com.formation.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.formation.model.Message;
import com.formation.validator.MessageValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

	@GetMapping("/messages")
	public ModelAndView directWithMessage() {
		ModelAndView modelAndView = new ModelAndView();
		List<?> messages = template.getForObject("http://localhost:8080/service/admin/messages/", List.class);
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
		List<Message> messages = template.getForObject("http://localhost:8080/service/admin/messages/", List.class);
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
}
