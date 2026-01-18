package com.ps.facade.one;

import com.ps.facade.one.email.Email;
import com.ps.facade.one.email.EmailFacade;
import com.ps.facade.one.email.Mailer;
import com.ps.facade.one.email.Stationary;
import com.ps.facade.one.email.StationaryFactory;
import com.ps.facade.one.email.Template;
import com.ps.facade.one.email.Template.TemplateType;
import com.ps.facade.one.email.TemplateFactory;

public class Client {

	public static void main(String[] args) {
		Order order = new Order("101", 99.99);

		boolean result = sendOrderEmailWithoutFacade(order);
		System.out.println("Order Email " + (result ? "sent!" : "NOT sent..."));
		result = EmailFacade.sendOrderEmailWithxFacade(order);
		System.out.println("Order Email " + (result ? "sent!" : "NOT sent..."));

	}

	private static boolean sendOrderEmailWithoutFacade(Order order) {
		Template template = TemplateFactory.createTemplateFor(TemplateType.Email);
		Stationary stationary = StationaryFactory.createStationary();
		Email email = Email.getBuilder().withTemplate(template).withStationary(stationary).forObject(order).build();
		Mailer mailer = Mailer.getMailer();
		return mailer.send(email);
	}

}
