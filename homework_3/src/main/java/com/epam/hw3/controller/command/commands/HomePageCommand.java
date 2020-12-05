package com.epam.hw3.controller.command.commands;

import com.epam.hw3.Path;
import com.epam.hw3.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Go to the home page.
 */
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