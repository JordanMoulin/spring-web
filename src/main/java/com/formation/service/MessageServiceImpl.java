package com.formation.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.MessageDao;
import com.formation.model.Message;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao dao;

	@Autowired
	private MessageRepository repo;

	private List<Message> messages = new ArrayList<Message>();
	private Boolean init = true;

	public void initilisationList() {
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
		init = false;
	}

	@Override
	public void send(MessageDto message) {
		Message newMessage = new Message();
		newMessage.setDestinataire(message.getFromUser());
		newMessage.setExpediteur(message.getToUser());
		newMessage.setMessage(message.getContent());
		dao.save(newMessage);
	}

	@Override
	public void edit(MessageDto editedMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String fromUser, String toUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Message> findAllMessages() {
		if (init) {
			initilisationList();
		}
		return messages;
	}

	@Override
	public List<MessageDto> findMessageSendToAUserADay(String toUser, LocalDate day) {
		List<Message> messages = repo.findByDestinataireAndHeureBetween(toUser, day, LocalDate.now());
		List<MessageDto> messagesDto = new ArrayList<MessageDto>();
		for (Message message : messages) {
			messagesDto.add(fromMessageToMessageDto(message));
			System.out.println(fromMessageToMessageDto(message));
		}
		return messagesDto;
	}

	@Override
	public List<MessageDto> findAllMessageFromUser(String fromUser) {
		List<Message> messages = repo.findByExpediteur(fromUser);
		List<MessageDto> messagesDto = new ArrayList<MessageDto>();
		for (Message message : messages) {
			messagesDto.add(fromMessageToMessageDto(message));
			System.out.println(fromMessageToMessageDto(message));
		}
		return messagesDto;
	}

	/**
	 * Transforme un Message en MessageDto
	 * 
	 * @param message
	 * @return MessageDto
	 */
	public MessageDto fromMessageToMessageDto(Message message) {
		MessageDto newMessageDto = new MessageDto();
		newMessageDto.setFromUser(message.getExpediteur());
		newMessageDto.setToUser(message.getDestinataire());
		newMessageDto.setContent(message.getMessage());
		newMessageDto.setEventTime(message.getHeure());
		return newMessageDto;
	}
}
