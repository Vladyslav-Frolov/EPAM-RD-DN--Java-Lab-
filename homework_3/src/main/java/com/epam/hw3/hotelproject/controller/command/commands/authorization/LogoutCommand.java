package com.epam.hw3.hotelproject.controller.command.commands.authorization;

import com.epam.hw3.hotelproject.Path;
import com.epam.hw3.hotelproject.controller.command.Command;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LogoutCommand extends Command {


	private static final Logger LOGGER = Logger.getLogger(LogoutCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		LOGGER.debug("Command starts");


		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		request.getSession().setAttribute("lang", request.getServletContext().getInitParameter("language"));
		request.getSession().setAttribute("path", "login");


		LOGGER.debug("Command finished");
		return Path.PAGE_LOGIN;
	}

}