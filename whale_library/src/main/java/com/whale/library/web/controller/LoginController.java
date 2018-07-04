package com.whale.library.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * LoginController.java –
 *
 * @author miseongShin
 * @version 1.0 /2018. 7. 4.
 * @see
 */
@Controller
public class LoginController {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(final Locale locale, final Model model) {

		final Date date = new Date();
		final DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		final String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "customer/login";
	}

}
