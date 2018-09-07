package com.formation.dao;

import java.time.LocalDateTime;

import com.formation.model.Message;

public interface MessageDao {
	public void save(Message message);

	public void delete(String user);

	public void modify(Message oldMessage, String newContent, LocalDateTime newEventTime);
}
