package com.epam.finalproject.hotel.controller.command.commands;

import com.epam.finalproject.hotel.Path;
import com.epam.finalproject.hotel.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * No command.
 */
public class NoCommand extends Command {

	private static final Logger LOGGER = Logger.getLogger(NoCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		LOGGER.debug("Command starts");
		
		String errorMessage = "No such command";
		request.setAttribute("errorMessage", errorMessage);
		LOGGER.error("Set the request attribute: errorMessage --> " + errorMessage);

		LOGGER.debug("Command finished");
		return Path.PAGE_ERROR_PAGE;
	}

}