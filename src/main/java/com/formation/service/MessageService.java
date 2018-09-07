package com.formation.service;

import java.time.LocalDate;
import java.util.List;

import com.formation.model.Message;

public interface MessageService {

	void send(MessageDto message);

	void edit(MessageDto editedMsg);

	void delete(String fromUser, String toUser);

	List<Message> findAllMessages();

	List<MessageDto> findMessageSendToAUserADay(String toUser, LocalDate day);

	List<MessageDto> findAllMessageFromUser(String fromUser);
}