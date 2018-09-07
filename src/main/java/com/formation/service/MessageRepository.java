package com.formation.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message> findByExpediteur(String fromUser);

	List<Message> findByMessage();

	List<Message> findByDestinataire(String toUser);

	List<Message> findByDestinataireAndHeureBetween(String toUser, LocalDate date1, LocalDate date2);
}
