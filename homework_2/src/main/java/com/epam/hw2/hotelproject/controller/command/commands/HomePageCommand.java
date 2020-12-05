package com.epam.hw2.hotelproject.controller.command.commands;

import com.epam.hw2.hotelproject.Path;
import com.epam.hw2.hotelproject.controller.command.Command;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Go to the home page.
 */

@Component
public class HomePageCommand extends Command {

	private static final Logger LOGGER = Logger.getLogger(HomePageCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		LOGGER.debug("Command starts");
		


		LOGGER.debug("Command finished");
		return Path.PAGE_HOME;
	}

}