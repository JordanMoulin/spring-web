package com.formation.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.formation.model.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	@PersistenceContext
	private EntityManager em;

	public void save(Message message) {
		em.persist(message);
	}

	public void delete(String user) {

	}

	public void modify(Message oldMessage, String newContent, LocalDateTime newEventTime) {

	}
}
