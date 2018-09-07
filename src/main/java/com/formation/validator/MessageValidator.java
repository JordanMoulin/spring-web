package com.formation.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formation.model.Message;

public class MessageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Message.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "expediteur", "required", "L'expéditeur est obligatoire");
		ValidationUtils.rejectIfEmpty(errors, "destinataire", "required", "Le destinataire est obligatoire");
		ValidationUtils.rejectIfEmpty(errors, "message", "required", "Le message est obligatoire");

		Message message = (Message) target;
		if (!StringUtils.isBlank(message.getExpediteur()) && !StringUtils.isBlank(message.getDestinataire())
				&& !StringUtils.isBlank(message.getMessage())) {
			if (Character.isLowerCase(message.getExpediteur().charAt(0))) {
				errors.rejectValue("expediteur", "", null, "Vous devez commencer par une majuscule");
			}
			if (Character.isLowerCase(message.getDestinataire().charAt(0))) {
				errors.rejectValue("destinataire", "", null, "Vous devez commencer par une majuscule");
			}
		}
	}
}
