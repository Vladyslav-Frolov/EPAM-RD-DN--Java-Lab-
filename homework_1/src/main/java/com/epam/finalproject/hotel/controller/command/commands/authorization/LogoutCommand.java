package com.epam.finalproject.hotel.controller.command.commands.authorization;

import com.epam.finalproject.hotel.Path;
import com.epam.finalproject.hotel.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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