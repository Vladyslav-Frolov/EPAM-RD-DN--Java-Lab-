package com.epam.hw3.controller.command.commands.authorization;

import com.epam.hw3.Path;
import com.epam.hw3.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Go to the login conform.
 */
public class LoginPageCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(LoginPageCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Command starts");




        LOGGER.debug("Command finished");
        request.setAttribute("path", Path.PAGE_LOGIN);
        return Path.PAGE_LOGIN;
    }

}