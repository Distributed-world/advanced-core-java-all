package com.ps.facade.one.email;

import com.ps.facade.one.Order;
import com.ps.facade.one.email.Template.TemplateType;

//Facade provides simple methods for client to use
public class EmailFacade {
	public static boolean sendOrderEmailWithxFacade(Order order) {
		Template template = TemplateFactory.createTemplateFor(TemplateType.Email);
		Stationary stationary = StationaryFactory.createStationary();
		Email email = Email.getBuilder()
					  .withTemplate(template)
					  .withStationary(stationary)
					  .forObject(order)
					  .build();
		Mailer mailer = Mailer.getMailer();
		return mailer.send(email);
	}
}
