package com.formation.model;

import java.time.LocalDateTime;

public class Message {

	private String expediteur;
	private String destinataire;
	private String message;
	private LocalDateTime heure;

	public String getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getHeure() {
		return heure;
	}

	public void setHeure(LocalDateTime heure) {
		this.heure = heure;
	}

}
